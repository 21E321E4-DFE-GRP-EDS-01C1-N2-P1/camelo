export interface Product {
  id: number;
  nome: string;
  url: string;
  preco: number;
  desconto?: number;
}

export interface Card {
  id: number;
  name: string;
  number: string;
  expiry: string;
  cvv: string;
}