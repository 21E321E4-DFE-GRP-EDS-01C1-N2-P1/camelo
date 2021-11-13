import { Product, Header, Footer } from "./styles";

import notFound from "../../assets/not-found.jpg";
import { ButtonCart } from "../ButtonCart";

interface ProductHeaderProps {
  name: string;
  image?: string;
  price: string;
  promotionPrice: string;
  promotion: number;
}

export function ProductHeader({
  name,
  image,
  price,
  promotionPrice,
  promotion,
}: ProductHeaderProps) {
  return (
    <Product style={{ backgroundImage: `url(${image ? image : notFound})` }}>
      <Header>
        <h3>{name}</h3>
        <div>
          <p className="price">{price}</p>
          <p className="promotion">{promotion}% Off</p>
        </div>
      </Header>
      <Footer>
        <p className="total">{promotionPrice}</p>
        <ButtonCart />
      </Footer>
    </Product>
  );
}
