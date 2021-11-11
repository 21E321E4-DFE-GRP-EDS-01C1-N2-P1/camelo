import { useEffect, useState } from "react";

import { Product } from "../../types";
import { formatPrice } from "../../util/format";
import { ProductHeader } from "../ProductHeader";
import { useProducts } from "../../hooks/UseProducts";

import { DashboardHeader, DashboardMain, Container } from "./styles";
import { Products } from "../Products";

// eslint-disable-next-line
import notFound from "../../assets/not-found.jpg";

interface ProductFormatted extends Product {
    priceFormatted: string;
    promotionPriceFormatted: string;
}

export function Dashboard() {
    const { products, productsOnSale } = useProducts();
    const [productsOnSaleDTO, setProductsOnSaleDTO] = useState<ProductFormatted[]>([]);
    const [productsDTO, setProductsDTO] = useState<ProductFormatted[]>([]);

    useEffect(() => {
        const newProductOnSale = productsOnSale.map(product => ({
            ...product,
            priceFormatted: formatPrice(product.preco),
            promotionPriceFormatted: formatPrice(product.preco - (product.preco * (Number(product.desconto) / 100)))
        }));

        const newProduct = products.map(product => ({
            ...product,
            priceFormatted: formatPrice(product.preco),
            promotionPriceFormatted: formatPrice(product.preco - (product.preco * (Number(product.desconto) / 100)))
        }));
        setProductsOnSaleDTO(newProductOnSale);
        setProductsDTO(newProduct);
        // eslint-disable-next-line
    }, []);

    return (
        <Container>
            <DashboardHeader>
                {productsOnSaleDTO.map(product => (
                    <ProductHeader
                        key={product.id}
                        name={product.nome}
                        // image={notFound}
                        price={product.priceFormatted}
                        promotionPrice={product.promotionPriceFormatted}
                        promotion={Number(product.desconto)}
                    />
                ))}
            </DashboardHeader>

            <h2>BEST SELLER</h2>

            <DashboardMain>
                {productsDTO.map(product => (
                    <Products
                        key={product.id}
                        name={product.nome}
                        // image={notFound}
                        promotionPrice={product.promotionPriceFormatted}
                        price={product.priceFormatted}
                    />
                ))}
            </DashboardMain>

            {/* <DashboardMain>
                {ProductsDTO.map(product => (
                    <Products
                        key={product.id}
                        name={product.nome}
                        image={""}
                        promotionPrice={product.promotionPriceFormatted}
                        price={product.priceFormatted}
                    />
                ))}
            </DashboardMain> */}
        </Container>
    );
}