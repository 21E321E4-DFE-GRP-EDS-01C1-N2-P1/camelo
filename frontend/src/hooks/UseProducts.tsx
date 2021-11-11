import { ReactNode, createContext, useState, useContext, useEffect } from "react";

import { Product } from "../types";

// import produtoHeader1 from "../assets/bolsa.png";
// import produtoHeader2 from "../assets/tenis1.png";
// import produtoHeader3 from "../assets/tenis2.png";

import api from "../services/api";

interface ProductsProviderProps {
    children: ReactNode;
}

interface ProductsContextData {
    products: Product[];
    productsOnSale: Product[];
}

const ProductsContext = createContext<ProductsContextData>({} as ProductsContextData);

export function ProductsProvider({ children }: ProductsProviderProps) {
    const [productsOnSale, setProductsOnSale] = useState<Product[]>([]);

    const [products, setProducts] = useState<Product[]>([]);

    useEffect(() => {
        api.get("/produtos/promocao").then(response => setProductsOnSale(response.data));

        api.get("/produtos/categorizado").then(response => setProducts(response.data));
    }, []);

    return (
        <ProductsContext.Provider value={{ products, productsOnSale }}>
            {children}
        </ProductsContext.Provider>
    );
}

export function useProducts(): ProductsContextData {
    return useContext(ProductsContext);
}

        // {id: Math.random(), nome: "FS - QUILTED MAXI CROSS BAG", url: produtoHeader1, preco: 534.33, desconto: 50}, //promotionPrice: 299.43
        // {id: Math.random(), nome: "FS - QUILTED MAXI CROSS BAG", url: produtoHeader2, preco: 534.33, desconto: 299.43},
        // {id: Math.random(), nome: "FS - QUILTED MAXI CROSS BAG", url: produtoHeader3, preco: 534.33, desconto: 299.43},
        // {id: Math.random(), nome: "FS - QUILTED MAXI CROSS BAG", url: produtoHeader1, preco: 534.33, desconto: 299.43},
        // {id: Math.random(), nome: "FS - QUILTED MAXI CROSS BAG", url: produtoHeader2, preco: 534.33, desconto: 299.43},
        // {id: Math.random(), nome: "FS - QUILTED MAXI CROSS BAG", url: produtoHeader3, preco: 534.33, desconto: 299.43},