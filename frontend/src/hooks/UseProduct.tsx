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
    getDetailProductById:(id: number) => Promise<Product>;
}

interface ProductProviderProps {
    children: ReactNode;
}

export const ProductContext = createContext<ProductContextData>({} as ProductContextData);

export function ProductProvider({ children }: ProductProviderProps) {
    
    async function getDetailProductById(id: number): Promise<Product> {
        

        return {
            categorias: undefined,
            desconto: undefined,
            id: undefined,
            nome: undefined,
            preco: undefined,
            url: undefined
        }
    }

    return (
        <ProductContext.Provider value={{
            getDetailProductById,
        }}>
            {children}
        </ProductContext.Provider>
    );    
}

export function useProduct() {
    return useContext(ProductContext);
}