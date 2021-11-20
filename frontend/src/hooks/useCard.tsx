import { createContext, ReactNode, useContext, useEffect, useState } from "react";
import { Cartao } from "../types";

import { toast } from 'react-toastify';

import api from "../services/api";

interface CardsProviderProps {
  children: ReactNode;
}

interface CardsContextData {
  response?: Response;
  items: number[];
  save: (pagamento: Pagamento) => Promise<void>;
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
  const [page, setPage] = useState<number>(0);
  const [items, setItems] = useState<number[]>([]);

  useEffect(() => {
    async function getCards() {
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
    getCards();
    renderTFooterPaginator();
  }, []);

  function renderTFooterPaginator() {
    if (response && response.totalPages > 0) {
      for(let i = 0; i < response.totalPages; i++) {
        setItems([i]);
        console.log(response.totalPages);
      }            
    }
  }

  async function save(payment: Pagamento):Promise<void> {
    api.defaults.headers.common['Authorization'] = localStorage.getItem("token")

    await api.post('pagamento', payment)
    .then(response => {
      // getCards();
      toast.success("Pagamento cadastrado com sucesso.");
    }).catch((err) => {
      toast.error("Erro ao cadastrar forma de pagamento");
    })
  }

  return (
    <CardContext.Provider value={{
      response,
      save,
      items
    }}>
      {children}
    </CardContext.Provider>
  );
}

export function useCard() {
  return useContext(CardContext)
}