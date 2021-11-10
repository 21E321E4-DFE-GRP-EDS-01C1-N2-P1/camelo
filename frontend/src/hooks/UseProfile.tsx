import { createContext, ReactNode, useContext, useState } from "react";
import api from "../services/api";

import { toast } from 'react-toastify';
import history from "../history";

interface User {
  name?: string;
  email: string;
  password: string;
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
        localStorage.setItem('token', authorization);

        history.push('/home');
    }).catch(err => {
        if(err.response.status === 401) {
          toast.error("Usuário ou senha incorretos");
        }
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