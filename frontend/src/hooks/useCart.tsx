import { createContext, ReactNode, useContext, useEffect, useState } from "react";
import { toast } from "react-toastify";
import { ProductFormatted } from "../types";

interface CartProviderProps {
  children: ReactNode;
}

interface CartContextData {
  cart: ProductFormatted[]; 
  handleAddProduct: (product: ProductFormatted, quantity: number) => void;
  handleRemoveProduct: (productId: number) => void;
}

const CartContext = createContext<CartContextData>({} as CartContextData);

export function CartProvider({ children }: CartProviderProps) {
  const [cart, setCart] = useState<ProductFormatted[]>([]);

  useEffect(() => {
    const storagedCart = localStorage.getItem("@cart");
    setCart(storagedCart ? JSON.parse(storagedCart) : []);
  }, []);

  function handleAddProduct(productParam: ProductFormatted, quantity: number) {
    try {
      const updatedCart = [...cart];
      const productExists = updatedCart.find(product => product.id === productParam.id);

      if(productExists) {
        toast.error('Produto já adicionado ao carrinho');
      } else {
        const newProduct = {
          ...productParam,
          quantidade: quantity
        }
        updatedCart.push(newProduct);
        setCart(updatedCart);
        localStorage.setItem('@cart', JSON.stringify(updatedCart));
        toast.success('Produto adicionado ao carrinho');
      }
    } catch {
      toast.error('Erro na adição do produto');
    }
  }

  function handleRemoveProduct(productId: number) {
    try {
      const updatedCart = [...cart];
      const productIndex = updatedCart.findIndex(product => product.id === productId);

      if(productIndex >= 0) {
        updatedCart.splice(productIndex, 1);
        setCart(updatedCart);
        localStorage.setItem('@cart', JSON.stringify(updatedCart));
      } else {
        throw Error();
      }
    } catch {
      toast.error('Erro na remoção do produto');
    }
  };


  return (
      <CartContext.Provider value={{ cart, handleAddProduct, handleRemoveProduct }}>
          {children}
      </CartContext.Provider>
  );
}

export function useCart(): CartContextData {
  return useContext(CartContext);
}