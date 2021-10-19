import { useEffect, useState } from "react";

import { Product } from "../../types";
import { formatPrice } from "../../util/format";
import { ProductHeader } from "../ProductHeader";
import { useProducts } from "../../hooks/UseProducts";

import { DashboardHeader, DashboardMain } from "./styles";
import { Products } from "../Products";

interface ProductFormatted extends Product {
    priceFormatted: string;
    promotionPriceFormatted: string;
}

export function Dashboard() {
    const { products, productsOnSale } = useProducts();
    const [ProductsOnSaleDTO, setProductsOnSaleDTO] = useState<ProductFormatted[]>([]);
    const [ProductsDTO, setProductsDTO] = useState<ProductFormatted[]>([]);

    useEffect(() => {
        const newProductOnSale = productsOnSale.map((product) => ({
            ...product,
            priceFormatted: formatPrice(product.price),
            promotionPriceFormatted: formatPrice(product.promotionPrice)
        }));

        const newProduct = products.map((product) => ({
            ...product,
            priceFormatted: formatPrice(product.price),
            promotionPriceFormatted: formatPrice(product.promotionPrice)
        }));
        setProductsOnSaleDTO(newProductOnSale);
        setProductsDTO(newProduct);
    }, [])

    return (
        <>
            <DashboardHeader>
                {ProductsOnSaleDTO.map(product => (
                    <ProductHeader
                        name={product.name}
                        image={product.img}
                        price={product.priceFormatted}
                        promotionPrice={product.promotionPriceFormatted}
                    />
                ))}
            </DashboardHeader>

            <DashboardMain>
                {ProductsDTO.map(product => (
                    <Products
                        name={product.name}
                        image={product.img}
                        price={product.priceFormatted}
                        promotionPrice={product.promotionPriceFormatted}
                    />
                ))}
            </DashboardMain>
        </>
    );
}