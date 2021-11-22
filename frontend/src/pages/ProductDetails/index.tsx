import { useEffect, useState } from "react";
import { ToastContainer, toast } from "react-toastify";

import api from "../../services/api";

import { Header } from "../../components/Header";
import Info from "../../components/Info";
import { Product } from "../../components/Product";
import { HeaderMobile } from "../../components/HeaderMobile";
import { Footer } from "../../components/Footer";
import { ProductFormatted } from "../../types";
import { FooterDesktop } from "../../components/FooterDesktop";
import { Container } from "./styles";

export default function ProductDetails({ ...props }) {
  const [produto, setProduto] = useState<ProductFormatted>({} as ProductFormatted);
  const { id } = props.match.params;

  useEffect(() => {
    api.get<ProductFormatted>(`/produtos/categorizado/${id}`)
      .then((response) => {
        setProduto(response.data);
      })
      .catch((err) => {
        toast.error("Produto não localizado");
      });
  }, [id]);

  return (
    <>
      <ToastContainer
        autoClose={5000}
        hideProgressBar={false}
        newestOnTop={false}
        closeOnClick
        rtl={false}
        pauseOnFocusLoss
        draggable
        pauseOnHover
      />

      <Header page={"Produto"} />
      <HeaderMobile />

      <Info breadCrumbs={["HOME", "HOT DEAL", "NIKE AIR MAX"]} />

      <Container>
        <Product produto={produto} />
      </Container>
      <FooterDesktop />
      <Footer />
    </>
  );
}
