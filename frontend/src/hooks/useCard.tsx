import { createContext, ReactNode, useState } from "react";
import { Card } from "../types";

interface CardsProviderProps {
  children: ReactNode;
}

interface CardsContextData {
  cards: Card[]; 
}

const CardContext = createContext<CardsContextData>({} as CardsContextData);

export function CardsProvider({ children }: CardsProviderProps) {
  const [cards, setCards] = useState<Card[]>([]);

  return (
    <CardContext.Provider value={{ cards }}>
      {children}
    </CardContext.Provider>
  );
}