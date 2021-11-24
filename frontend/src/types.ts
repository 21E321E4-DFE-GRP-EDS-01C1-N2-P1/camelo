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

export interface ProductDetailsProps {
  id?: number;
  nome?: string;
  url?: string;
  preco?: number;
  desconto?: number;
  categorias?: CategoryDetailsProps[];
}

export interface CategoryDetailsProps {
  id: number;
  descricao: string;
}

export interface ProductFormatted extends ProductDetailsProps {
  priceFormatted: string;
  promotionPriceFormatted: string;
  quantidade?: number;
}