import { useState } from "react";
import { ProductFormatted } from "../../types";
import { formatPrice } from "../../util/format";
import { ButtonCart } from "../ButtonCart";
import { Container } from "./styles";
import { FaWhatsapp } from "react-icons/fa";

interface ProductProps {
  produto: ProductFormatted;
}

export function Product({ produto }: ProductProps) {

  produto.promotionPriceFormatted = formatPrice(produto.preco! - (produto.preco! * (Number(produto.desconto) / 100)))
  produto.priceFormatted = formatPrice(Number(produto.preco))

  const [count, setCount] = useState(1);

  return (
    <Container>
        <img src={produto.url} alt="foto produto" />
        <section>
          <h2>{produto.nome}</h2>

          <div className="priceArea">
            <p>{!produto.promotionPriceFormatted ? "" : produto.promotionPriceFormatted}</p>
            <p className={`${!produto.promotionPriceFormatted ? "" : "promocao"}`}>{produto.desconto ? produto.priceFormatted : ""}</p>
            <p className="desconto">{!produto.desconto ? "" : produto.desconto + "% off"}</p>
          </div>

          <div className="categoria">
            {produto.categorias?.map((categoria) => (
              <span key={categoria.id}>Categoria: {categoria.descricao}</span>
            ))}
          </div>
        
        <div className="cart">
          <div className="quantidadeProduto">
            <button onClick={() => setCount(count - 1)}>-</button>
            <p>{count}</p>
            <button onClick={() => setCount(count + 1)}>+</button>
          </div>
          <div className="buttons">
            <ButtonCart />
            <a href={`https://web.whatsapp.com/send?text=${window.location.href}`} target="_blank" rel="noreferrer">
              <FaWhatsapp size={20} />
            </a>
          </div>
        </div>
        </section>
    </Container>
  );
}
