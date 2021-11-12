import { ReactNode, createContext, useState, useContext, useEffect } from "react";

import { Product } from "../types";

// import produtoHeader1 from "../assets/bolsa.png";
// import produtoHeader2 from "../assets/tenis1.png";
// import produtoHeader3 from "../assets/tenis2.png";

import api from "../services/api";
import { formatPrice } from "../util/format";

interface ProductsProviderProps {
    children: ReactNode;
}

interface ProductsContextData {
    products: ProductFormatted[];
    productsOnSale: ProductFormatted[];
}

interface ProductFormatted extends Product {
    priceFormatted: string;
    promotionPriceFormatted: string;
}

const ProductsContext = createContext<ProductsContextData>({} as ProductsContextData);

export function ProductsProvider({ children }: ProductsProviderProps) {
    const [productsOnSale, setProductsOnSale] = useState<ProductFormatted[]>([]);

    const [products, setProducts] = useState<ProductFormatted[]>([]);

    useEffect(() => {
        async function loadProducts() {
            const response = await api.get<ProductFormatted[]>('/produtos/categorizado');
            const responseOnSale = await api.get<ProductFormatted[]>('/produtos/promocao');
      
            const data = response.data.map(product => ({
              ...product,
              priceFormatted: formatPrice(product.preco),
              promotionPriceFormatted: formatPrice(product.preco - (product.preco * (Number(product.desconto) / 100)))
            }));            
            
            const dataOnSale = responseOnSale.data.map(product => ({
              ...product,
              priceFormatted: formatPrice(product.preco),
              promotionPriceFormatted: formatPrice(product.preco - (product.preco * (Number(product.desconto) / 100)))
            }));
      
            setProducts(data);
            setProductsOnSale(dataOnSale);
          }
      
          loadProducts();
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