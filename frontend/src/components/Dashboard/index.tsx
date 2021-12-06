import { Link } from "react-router-dom";

import { ProductHeader } from "../ProductHeader";
import { useProducts } from "../../hooks/UseProducts";
import { Products } from "../Products";

import price  from '../../assets/price.svg';
import shipping  from '../../assets/shipping.svg';
import support  from '../../assets/support.svg';


import { 
  DashboardHeader, 
  DashboardMain, 
  Container, 
  PlataformInfo,
  PlataformInfoItem,
} from "./styles";

export function Dashboard() {
  const { products, productsOnSale } = useProducts();

  return (
    <Container>
      <DashboardHeader>
        {productsOnSale.map((product) => (
          <Link to={`/productDetails/${product.id}`} key={product.id}>
            <ProductHeader
              key={product.id}
              name={product.nome}
              image={product.url}
              price={product.priceFormatted}
              promotionPrice={product.promotionPriceFormatted}
              promotion={Number(product.desconto)}
            />
          </Link>
        ))}
      </DashboardHeader>

      <h2>BEST SELLER</h2>

      <DashboardMain>
        {products.map((product) => (
          <Link to={`/productDetails/${product.id}`} key={product.id}>
            <Products
              name={product.nome}
              image={product.url}
              promotionPrice={product.promotionPriceFormatted}
              price={product.priceFormatted}
              promotion={product.desconto}
            />
          </Link>
        ))}
      </DashboardMain>

      <PlataformInfo>
        <PlataformInfoItem>
          <img src={shipping} alt="free_shipping" title="free_shipping" />
          <h3>FREE SHIPPING</h3>
          <label>Lorem ipsum dolor sit, amet consectetur adipisicing elit.</label>
        </PlataformInfoItem>

        <PlataformInfoItem>
          <img src={price} alt="free_shipping" title="free_shipping"/>
          <h3>100% REFUND</h3>
          <label>Lorem ipsum dolor sit, amet consectetur adipisicing elit.</label>
        </PlataformInfoItem>

        <PlataformInfoItem>
          <img src={support} alt="free_shipping" title="free_shipping"/>
          <h3>SUPPORT 24/7</h3>
          <label>Lorem ipsum dolor sit, amet consectetur adipisicing elit.</label>
        </PlataformInfoItem>        
      </PlataformInfo>
    </Container>
  );
}
