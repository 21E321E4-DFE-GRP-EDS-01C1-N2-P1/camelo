import { useState } from "react";
import { ProductFormatted } from "../../types";
import { formatPrice } from "../../util/format";
import { ButtonCart } from "./styles";
import { Container } from "./styles";
import { FaHeart, FaWhatsapp } from "react-icons/fa";
import { useCart } from "../../hooks/useCart";
import { useFavorites } from "../../hooks/useFavorites";
import { FiShoppingCart } from "react-icons/fi";

interface ProductProps {
  produto: ProductFormatted;
}

export function Product({ produto }: ProductProps) {
  produto.promotionPriceFormatted = formatPrice(
    produto.preco! - produto.preco! * (Number(produto.desconto) / 100)
  );
  produto.priceFormatted = formatPrice(Number(produto.preco));

  
  const [count, setCount] = useState(1);
  const { handleAddProduct } = useCart();
  const { handleFavorite } = useFavorites();
  
  return (
    <Container>
      <img src={produto.url} alt="foto produto" />
      <section>
        <h2>{produto.nome}</h2>

        <div className="priceArea">
          <p>
            {!produto.promotionPriceFormatted
              ? ""
              : produto.promotionPriceFormatted}
          </p>
          <p
            className={`${!produto.promotionPriceFormatted ? "" : "promocao"}`}
          >
            {produto.desconto ? produto.priceFormatted : ""}
          </p>
          <p className="desconto">
            {!produto.desconto ? "" : produto.desconto + "% off"}
          </p>
        </div>

        <div className="categoria">
          {produto.categorias?.map((categoria) => (
            <span key={categoria.id}>Categoria: {categoria.descricao}</span>
          ))}
        </div>

        <div className="cart">
          <div className="quantidadeProduto">
            <button onClick={() => setCount(count - 1)} disabled={count <= 1}>
              -
            </button>
            <p>{count}</p>
            <button onClick={() => setCount(count + 1)}>+</button>
          </div>
          <div className="buttons">
            <ButtonCart onClick={() => handleAddProduct(produto, count)}>
              <FiShoppingCart />
              Adicionar
            </ButtonCart>
            <a
              href={`https://web.whatsapp.com/send?text=${window.location.href}`}
              target="_blank"
              rel="noreferrer"
            >
              <FaWhatsapp size={20} />
            </a>
            {/* {produto.favorited ? 
              <button
                className="favorited"
                onClick={() => handleFavorite(produto)}>
                <FiHeart size={25} />
              </button>
             :  */}
              <button 
                className="unfavorited" 
                onClick={() => handleFavorite(produto)}>
                <FaHeart size={25} />
              </button>
            {/*  } */}
            {/* <p>{produto.favorited ? 'favorito' : 'nao é favorito'}</p> */}
          </div>
        </div>
      </section>
    </Container>
  );
}
