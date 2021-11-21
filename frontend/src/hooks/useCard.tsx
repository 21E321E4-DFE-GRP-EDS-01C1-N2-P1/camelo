import { createContext, ReactNode, useContext, useEffect, useState } from "react";
import { toast } from 'react-toastify';

import history from "../history";
import api from "../services/api";
import { Cartao } from "../types";

interface CardsProviderProps {
  children: ReactNode;
}

interface CardsContextData {
  response?: Response;
  save: (pagamento: Pagamento) => Promise<void>;
  loadCardsOffUser: () => Promise<void>;
}

interface Pagamento {
  numero: string;
  nome: string;
  vencimento: string;
  cvv: number;
}

interface Response {
  content: Cartao[];
  totalPages: number;
  totalElements: number;
  size: 0;
  empty: boolean;
}

const CardContext = createContext<CardsContextData>({} as CardsContextData);

export function CardsProvider({ children }: CardsProviderProps) {
  
  const [response, setResponse] = useState<Response>();  
  const [page,] = useState<number>(0);

  async function loadCardsOffUser(): Promise<void> {
    api.defaults.headers.common['Authorization'] = localStorage.getItem("token")

    const url = `/pagamento?page=${page}&linesPerPage=3`;

    await api.get<Response>(url)
    .then(res => {
      setResponse(res.data);         
    })
    .catch((err) => {
      toast.error("Erro ao consultar cartões.");
    });
  }

  async function save(payment: Pagamento):Promise<void> {
    api.defaults.headers.common['Authorization'] = localStorage.getItem("token")

    await api.post('pagamento', payment)
    .then(response => {
      history.push('/home');
      toast.success("Pagamento cadastrado com sucesso.");
    }).catch((err) => {
      toast.error("Erro ao cadastrar forma de pagamento");
    })
  }

  return (
    <CardContext.Provider value={{
      response,
      save,
      loadCardsOffUser
    }}>
      {children}
    </CardContext.Provider>
  );
}

export function useCard() {
  return useContext(CardContext)
}
