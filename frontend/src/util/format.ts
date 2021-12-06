export const { format: formatPrice } = new Intl.NumberFormat('pt-BR', {
  style: 'currency',
  currency: 'BRL',
});

export const { format: formatDate } = new Intl.DateTimeFormat('pt-BR');

export interface Order {
  produtos: OrderItem[];
  pagamento: Payment;
}

export interface OrderItem {
  id: number;
  qtd: number;
}

export interface Payment {
  nrCartao: string;
}