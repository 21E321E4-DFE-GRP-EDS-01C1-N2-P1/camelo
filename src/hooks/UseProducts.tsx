import { ReactNode, createContext, useState, useContext, useEffect } from "react";

import { Product } from "../types";

import produtoHeader1 from "../assets/bolsa.png";
import produtoHeader2 from "../assets/tenis1.png";
import produtoHeader3 from "../assets/tenis2.png";

interface ProductsProviderProps {
    children: ReactNode;
}

interface ProductsContextData {
    products: Product[];
    productsOnSale: Product[];
}

const ProductsContext = createContext<ProductsContextData>({} as ProductsContextData);

export function ProductsProvider({ children }: ProductsProviderProps) {
    const [productsOnSale, setProductsOnSale] = useState<Product[]>([
        {img: produtoHeader1, name: "FS - QUILTED MAXI CROSS BAG", price: 534.33, promotionPrice: 299.43},
        {img: produtoHeader2, name: "FS - Nike Air Max 270 React...", price: 534.33, promotionPrice: 299.43},
        {img: produtoHeader3, name: "FS - Nike Air Max 270 React...", price: 534.33, promotionPrice: 299.43},
    ]);

    const [products, setProducts] = useState<Product[]>([
        {img: produtoHeader1, name: "FS - QUILTED MAXI CROSS BAG", price: 534.33, promotionPrice: 299.43},
        {img: produtoHeader2, name: "FS - Nike Air Max 270 React...", price: 534.33, promotionPrice: 299.43},
        {img: produtoHeader3, name: "FS - Nike Air Max 270 React...", price: 534.33, promotionPrice: 299.43},
        {img: produtoHeader3, name: "FS - Nike Air Max 270 React...", price: 534.33, promotionPrice: 299.43},
        {img: produtoHeader3, name: "FS - Nike Air Max 270 React...", price: 534.33, promotionPrice: 299.43},
        {img: produtoHeader3, name: "FS - Nike Air Max 270 React...", price: 534.33, promotionPrice: 299.43},
    ]);

    return (
        <ProductsContext.Provider value={{ products, productsOnSale }}>
            {children}
        </ProductsContext.Provider>
    );
}

export function useProducts(): ProductsContextData {
    return useContext(ProductsContext);
}