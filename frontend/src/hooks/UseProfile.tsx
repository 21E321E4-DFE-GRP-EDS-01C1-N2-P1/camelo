import { createContext, ReactNode, useContext, useState } from "react";
import jwt_decode from "jwt-decode";
import { toast } from 'react-toastify';

import api from "../services/api";
import history from "../history";

interface User {
  name?: string;
  email: string;
  password: string;
  endereco?: string;
  cep?: string;
  bairro?: string;
  cidade?: string;
}

interface Jwt {
  id: number;
  name: string;
  email: string;
}

interface Authorization {
  sub: Jwt
}

interface UserProviderProps {
  children: ReactNode;
}

interface UserContextData {
  user: User;  
  createUser: (user: User) => Promise<void>;
  updateUser: (user: User) => Promise<void>;
  signIn: (user: User) => Promise<void>;
  recovery: (email: string) => Promise<boolean>;
  signOut: () => void;
  
}

export const UserContext = createContext<UserContextData>({} as UserContextData);

export function UserProvider({ children }: UserProviderProps) {
  const [user, setUser] = useState<User>({} as User);
  // eslint-disable-next-line
  const [logedIn, setLogedIn] = useState(false);

  async function createUser(user: User) {
    await api.post('/user', user)
    .then(response => {
      const newUser = response.config.data;
      setUser(JSON.parse(newUser));
      toast.success("Usuário cadastrado com sucesso");
      history.push('/');

    }).catch((err) => {
      toast.error("Erro ao cadastrar usuário");
    });
  }

  async function recovery(email: string): Promise<boolean> {
    await api.post('/auth/forgot', {
      "email": email
    })
    .then(response => {
      toast.success("Email de recuperação enviado com sucesso");
    }).catch((err) => {
      toast.error("Erro ao recuperar senha");
    })
    return false;
  }

  async function updateUser(user: User) {

    api.defaults.headers.common['Authorization'] = localStorage.getItem("token")

    await api.put('/user', user)
    .then(response => {
      
      const newValue = {
        name: user.name,
        email: user.email,
        endereco: user.endereco,
        cep: user.cep,
        bairro: user.bairro,
        cidade: user.cidade
      }

      toast.success('Dados atualizado com sucesso');
      const json = JSON.stringify(newValue)
      localStorage.setItem("@usuario", json)
    }).catch((err) => {
      toast.error("Erro ao atualizar daddos do usuário");
    });
  }

  async function signIn(user: User) {
    await api.post('/login', user)
    .then(response => {
        setLogedIn(true);

        const { authorization } = response.headers;
        const [, token_jwt] = authorization.split(" ");      

        const token = String(jwt_decode<Authorization>(token_jwt).sub)

        var jsonToken = JSON.parse(token)
        
        const newValue = {
          name: jsonToken.name,
          email: jsonToken.email,
          endereco: jsonToken.endereco,
          cep: jsonToken.cep,
          bairro: jsonToken.bairro,
          cidade: jsonToken.cidade
        }

        const json = JSON.stringify(newValue)
        localStorage.setItem("@usuario", json)
        localStorage.setItem('token', authorization);

        history.push('/home');
    }).catch(err => {
        toast.error("Usuário ou senha incorretos");
        localStorage.removeItem('token');
    });
  }

  function signOut() {
    setLogedIn(false);
    localStorage.removeItem('token');
    history.push('/');
  }

  return (
    <UserContext.Provider value={{ 
      user,
      recovery,       
      createUser, 
      signIn, 
      signOut, 
      updateUser,      
    }}>

      {children}
    </UserContext.Provider>
  );
}

export function useProfile() {
  return useContext(UserContext);
}