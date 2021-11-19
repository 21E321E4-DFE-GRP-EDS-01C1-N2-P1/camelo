import { createContext, ReactNode, useContext, useState } from "react";
import { Card } from "../types";

import { toast } from 'react-toastify';

import api from "../services/api";

interface CardsProviderProps {
  children: ReactNode;
}

interface CardsContextData {
  cards: Card[];
  save: (pagamento: Pagamento) => Promise<void>;
}

interface Pagamento {
  numero: string;
  nome: string;
  vencimento: string;
  cvv: string;
}

const CardContext = createContext<CardsContextData>({} as CardsContextData);

export function CardsProvider({ children }: CardsProviderProps) {
  const [cards, setCards] = useState<Card[]>([]);

  async function save(payment: Pagamento):Promise<void> {
    await api.post('/pagamento', payment)
    .then(response => {

        toast.success("Pagamento cadastrado com sucesso.");
    }).catch((err) => {
        toast.error("Erro ao cadastrar forma de pagamento");
    })
  }

  return (
    <CardContext.Provider value={{
        cards,
        save
    }}>
      {children}
    </CardContext.Provider>
  );
}

export function useCard() {
  return useContext(CardContext)
}