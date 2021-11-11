import {Container, Product} from "./styles";

import notFound from "../../assets/not-found.jpg";

interface ProductProps {
    name: string;
    image?: string;
    price: string;
    promotionPrice: string;
}

export function Products({ name, image, price, promotionPrice }: ProductProps) {
    return (
        <Container>
            <Product>
                <img src={image ? image : notFound} alt=""/>
                <p className="title">{name}</p>
                <div>
                    <p>{promotionPrice}</p>
                    <p>{price}</p>
                </div>
            </Product>
        </Container>
    );
}