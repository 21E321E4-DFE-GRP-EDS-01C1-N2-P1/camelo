import { createContext, ReactNode, useContext, useState } from "react";
import api from "../services/api";

import jsonwebtoken from "jsonwebtoken";
import jwt_decode from "jwt-decode";


import { toast } from 'react-toastify';
import history from "../history";

interface User {
  name?: string;
  email: string;
  password: string;
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
  signIn: (user: User) => Promise<void>;
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

  async function signIn(user: User) {
    await api.post('/login', user)
    .then(response => {
        setLogedIn(true);

        const { authorization } = response.headers;
        const [, token_jwt] = authorization.split(" ");      

        const token = jwt_decode<Authorization>(token_jwt).sub
        const json = JSON.stringify(token);
        
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
    <UserContext.Provider value={{ user, createUser, signIn, signOut }}>
      {children}
    </UserContext.Provider>
  );
}

export function useProfile() {
  return useContext(UserContext);
}