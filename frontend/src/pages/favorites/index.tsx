import { Link } from "react-router-dom";
import { HeaderMobile } from "../../components/HeaderMobile";
import { Header } from "../../components/Header";
import { useFavorites } from "../../hooks/useFavorites";
import { Container, Product } from "./styles";
import notFound from "../../assets/not-found.jpg";
import { Footer } from "../../components/Footer";
import { FooterDesktop } from "../../components/FooterDesktop";

export function Favorites() {
  const { favorites, handleFavorite } = useFavorites();

  return (
    <>
      <HeaderMobile />
      <Header />
      <Container>
        {favorites.length > 0 ? (
          <section>
            {favorites.map((product) => (
              <Link to={`/productDetails/${product.id}`} key={product.id}>
                <Product>
                  <img src={product.url ? product.url : notFound} alt="foto produto" />
                  <p className="title">{product.nome}</p>
                  <div>
                    <p className={`${!product.desconto ? "" : "promocao"}`}>{product.priceFormatted}</p>
                    <p className="desconto">
                      {!product.desconto ? "" : product.desconto + "% off"}
                    </p>
                    <p>{!product.desconto ? "" : product.promotionPriceFormatted}</p>
                  </div>
                </Product>
              </Link>
            ))}
          </section>
        ) : (
          <h2>Não há favoritos</h2>
        )}
      </Container>
      <FooterDesktop />
      <Footer />
    </>
  );
}
