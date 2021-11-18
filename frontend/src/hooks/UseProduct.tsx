import { createContext, ReactNode, useContext, useState } from "react";

import api from "../services/api";

interface Product {
    id?: number;
    nome?: string;
    url?: string;
    preco?: number;
    desconto?: number;
    categorias?: Category[];
}

interface Category {
    id: number;
    descricao: string;
}

interface ProductContextData {
    addProductInLocalStorage:(id: number) => Promise<void>;
}

interface ProductProviderProps {
    children: ReactNode;
}

export const ProductContext = createContext<ProductContextData>({} as ProductContextData);

export function ProductProvider({ children }: ProductProviderProps) {
    
    async function addProductInLocalStorage(id: number): Promise<void> {
        
    }

    return (
        <ProductContext.Provider value={{
            addProductInLocalStorage,
        }}>
            {children}
        </ProductContext.Provider>
    );    
}

export function useProduct() {
    return useContext(ProductContext);
}