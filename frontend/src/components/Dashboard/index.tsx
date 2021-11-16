import { ProductHeader } from "../ProductHeader";
import { useProducts } from "../../hooks/UseProducts";

import { DashboardHeader, DashboardMain, Container } from "./styles";
import { Products } from "../Products";
import { Link } from "react-router-dom";

export function Dashboard() {
  const { products, productsOnSale } = useProducts();

  return (
    <Container>
      <DashboardHeader>
        {productsOnSale.map((product) => (
          <ProductHeader
            key={product.id}
            name={product.nome}
            image={product.url}
            price={product.priceFormatted}
            promotionPrice={product.promotionPriceFormatted}
            promotion={Number(product.desconto)}
          />
        ))}
      </DashboardHeader>

      <h2>BEST SELLER</h2>

      <DashboardMain>
        {products.map((product) => (
          <Link to={`/cart/${product.id}`}>
            <Products
              key={product.id}
              name={product.nome}
              image={product.url}
              promotionPrice={product.promotionPriceFormatted}
              price={product.priceFormatted}
              promotion={product.desconto}
            />
          </Link>
        ))}
      </DashboardMain>
    </Container>
  );
}
