import { Product } from "./styles";

interface ProductProps {
    name: string;
    image: string;
    price: string;
    promotionPrice: string;
}

export function Products({ name, image, price, promotionPrice }: ProductProps) {
    return (
        <div>
            <Product>
                <img src={image} alt=""/>
                <p className="title">{name}</p>
                <div>
                    <p>{price}</p>
                    <p>{promotionPrice}</p>
                </div>
            </Product>
        </div>
    );
}