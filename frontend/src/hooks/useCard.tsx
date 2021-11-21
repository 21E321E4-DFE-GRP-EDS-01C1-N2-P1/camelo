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
  items: number[];
  save: (pagamento: Pagamento) => Promise<void>;
  loadCardsOffUser: () => Promise<void>;
  addPage: () => void;
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
  const [items, setItems] = useState<number[]>([]);

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

  function addPage():void {
    if (response !== null) {
      const totalPage = response?.totalPages;

      if (totalPage) {
        for (let i = 1; i <= totalPage; i++) {
          setItems([...items, i]);
        }
      }
    }
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
      addPage,
      save,
      items,
      loadCardsOffUser
    }}>
      {children}
    </CardContext.Provider>
  );
}

export function useCard() {
  return useContext(CardContext)
}
