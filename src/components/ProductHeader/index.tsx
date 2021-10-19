import { Product, Header, Footer } from "./styles";

interface ProductHeaderProps {
    name: string;
    image: string;
    price: string;
    promotionPrice: string;
}

export function ProductHeader({ name,image, price, promotionPrice }: ProductHeaderProps) {
    return(
        <Product style={{ backgroundImage: `url(${image})` }}>
            <Header>
                <h3>{name}</h3>
                <div>
                    <p className="price">{price}</p>
                    <p className="promotion">24% Off</p>
                </div>
            </Header>
            <Footer>
                <p className="total">{promotionPrice}</p>
            </Footer>
        </Product>
    );
}