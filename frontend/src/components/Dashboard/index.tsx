import { Link } from "react-router-dom";

import { ProductHeader } from "../ProductHeader";
import { useProducts } from "../../hooks/UseProducts";
import { Products } from "../Products";

import price  from '../../assets/price.svg';
import shipping  from '../../assets/shipping.svg';
import support  from '../../assets/support.svg';
import logo from '../../assets/logo.svg';
import fb from '../../assets/facebook.svg';
import tt from '../../assets/twitter.svg';

import { 
  DashboardHeader, 
  DashboardMain, 
  Container, 
  PlataformInfo,
  PlataformInfoItem,
  Footer,
  FooterEmpresa,
  FooterSocial,
  FooterContato
} from "./styles";

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
          <Link to={`/productDetails/${product.id}`}>
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

      <PlataformInfo>
        <PlataformInfoItem>
          <img src={shipping} alt="free_shipping" />
          <h3>FREE SHIPPING</h3>
          <label>Lorem ipsum dolor sit, amet consectetur adipisicing elit.</label>
        </PlataformInfoItem>

        <PlataformInfoItem>
          <img src={price} alt="free_shipping" />
          <h3>100% REFUND</h3>
          <label>Lorem ipsum dolor sit, amet consectetur adipisicing elit.</label>
        </PlataformInfoItem>

        <PlataformInfoItem>
          <img src={support} alt="free_shipping" />
          <h3>SUPPORT 24/7</h3>
          <label>Lorem ipsum dolor sit, amet consectetur adipisicing elit.</label>
        </PlataformInfoItem>        
      </PlataformInfo>

      <Footer>

        <FooterEmpresa>
          <div>
            <img src={logo} alt="logo aplicacao" />
            <h4>Camelo</h4>
          </div>
          <label>Lorem ipsum dolor sit amet consectetur adipisicing elit.</label>
        </FooterEmpresa>

        <FooterSocial>
          <h4>Follow Us</h4>
          <label>Lorem ipsum dolor sit amet consectetur adipisicing elit.</label>

          <div>
            <img src={fb} alt="facebook aplicação" />
            <img src={tt} alt="twitter aplicação" />
          </div>
        </FooterSocial>

        <FooterContato>
          <h4>Contact Us</h4>
          <label>Lorem ipsum dolor sit amet consectetur adipisicing elit.</label>
        </FooterContato>

      </Footer>
    </Container>

  );
}
