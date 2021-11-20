import { Product } from "./styles";

import notFound from "../../assets/not-found.jpg";

interface ProductProps {
    name: string;
    image?: string;
    price: string;
    promotionPrice: string;
    promotion?: number;
}

export function Products({ name, image, price, promotionPrice, promotion }: ProductProps) {
    return (
        <>
            <Product>
                <img src={image ? image : notFound} alt="foto produto"/>
                <p className="title">{name}</p>
                <div>
                    <p className={`${!promotion ? '' : 'promocao'}`}>{price}</p>
                    <p className="desconto">{!promotion ? '' : promotion + '% off'}</p>
                    <p>{!promotion ? '' : promotionPrice}</p>
                </div>
            </Product>
        </>
    );
}