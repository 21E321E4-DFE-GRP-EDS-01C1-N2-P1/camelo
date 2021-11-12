import { ProductHeader } from "../ProductHeader";
import { useProducts } from "../../hooks/UseProducts";

import { DashboardHeader, DashboardMain, Container } from "./styles";
import { Products } from "../Products";

export function Dashboard() {
    const { products, productsOnSale } = useProducts();

    return (
        <Container>
            <DashboardHeader>
                {productsOnSale.map(product => (
                    <ProductHeader
                        key={product.id}
                        name={product.nome}
                        image={""}
                        price={product.priceFormatted}
                        promotionPrice={product.promotionPriceFormatted}
                        promotion={Number(product.desconto)}
                    />
                ))}
            </DashboardHeader>

            <h2>BEST SELLER</h2>

            <DashboardMain>
                {products.map(product => (
                    <Products
                        key={product.id}
                        name={product.nome}
                        image={""}
                        promotionPrice={product.promotionPriceFormatted}
                        price={product.priceFormatted}
                    />
                ))}
            </DashboardMain>
        </Container>
    );
}