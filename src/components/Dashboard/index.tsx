import {useEffect, useState} from "react";

import { Product } from "../../types";
import { formatPrice } from "../../util/format";
import { ProductHeader } from "../ProductHeader";
import {useProducts } from "../../hooks/UseProducts";

import { DashboardHeader } from "./styles";

interface ProductFormatted extends Product {
    priceFormatted: string;
    promotionPriceFormatted: string;
}

export function Dashboard() {
    const { products } = useProducts();
    const [ProductsDTO, setProductsDTO] = useState<ProductFormatted[]>([]);

    useEffect(() => {
        const newProduct = products.map((product) => ({
            ...product,
            priceFormatted: formatPrice(product.price),
            promotionPriceFormatted: formatPrice(product.promotionPrice)
        }));
        setProductsDTO(newProduct);
    }, [])

    return (
        <DashboardHeader>
            {ProductsDTO.map(product => (
                <ProductHeader
                    name={product.name}
                    image={product.img}
                    price={product.priceFormatted}
                    promotionPrice={product.promotionPriceFormatted}
                />
            ))}
        </DashboardHeader>
    );
}