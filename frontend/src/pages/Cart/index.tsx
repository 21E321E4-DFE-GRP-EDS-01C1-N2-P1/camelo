import { ToastContainer } from "react-toastify";
import { Header } from "../../components/Header";
import { HeaderMobile } from "../../components/HeaderMobile";

import { Table } from "../../components/Table";
import { CheckOut, Container, Cupom, Summary } from "./styles";
import Info from "../../components/Info";
import { FooterDesktop } from "../../components/FooterDesktop";
import { Footer } from "../../components/Footer";
import { useCart } from "../../hooks/useCart";

export default function Cart() {
  const { cart } = useCart();

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

      <Header />
      <HeaderMobile />
      <Info breadCrumbs={["HOME", "CARRINHO"]} />
      <Container>
        {cart.length > 0 ? <Table /> : <p>Carrinho Vazio</p>}
        <CheckOut>
          <Cupom>
            <input type="text" placeholder="Cupom" />
            <button>Incluir</button>
          </Cupom>
          <Summary>
            <table>
              <tbody>
                <tr>
                  <th>Subtotal</th>
                  <td>200.00</td>
                </tr>

                <tr>
                  <th>Frete</th>
                  <td>20.00</td>
                </tr>

                <tr>
                  <th>Cupom</th>
                  <td>Não</td>
                </tr>
              </tbody>
              <tfoot>
                <tr>
                  <th>TOTAL</th>
                  <td>220.00</td>
                </tr>
              </tfoot>
            </table>
            <button>Finalizar</button>
          </Summary>
        </CheckOut>
      </Container>
      <FooterDesktop />
      <Footer />
    </>
  );
}
