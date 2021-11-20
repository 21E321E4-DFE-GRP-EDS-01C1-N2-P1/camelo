export interface Product {
  id: number;
  nome: string;
  url: string;
  preco: number;
  desconto?: number;
}

export interface Cartao {
  id: number;
  numero: string;
  nome: string;
  vencimento: string;
  cvv: number;
}