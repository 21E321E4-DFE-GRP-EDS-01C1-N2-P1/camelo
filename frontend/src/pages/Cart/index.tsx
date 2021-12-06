import { toast, ToastContainer } from "react-toastify";
import { Header } from "../../components/Header";
import { HeaderMobile } from "../../components/HeaderMobile";

import { Table } from "../../components/Table";
import { CheckOut, Container, Cupom, Summary } from "./styles";
import Info from "../../components/Info";
import { FooterDesktop } from "../../components/FooterDesktop";
import { Footer } from "../../components/Footer";
import { useCart } from "../../hooks/useCart";
import { useEffect, useState } from "react";
import { formatPrice } from "../../util/format";
import { useModal } from "../../hooks/useModal";
import { NewPaymentModal } from "../../components/NewPaymentModal";

export default function Cart() {
  const { cart } = useCart();
  const { isNewModalOpen, handleOpenNewModal, handleCloseNewModal } = useModal();
  const [total, setTotal] = useState(0);
  let list: number[] = [];

  useEffect(() => {
    cart.map((item) => (list.push(item.total!)));
    var totalProduct = list.reduce((total, value) => total + value, 0);
    setTotal(totalProduct)

  // eslint-disable-next-line react-hooks/exhaustive-deps
  }, [cart]);

  function oppenModal() {

    if (cart.length === 0) {
      toast.error("Não há nenhum item no carrinho");
      return;
    }

    handleOpenNewModal();
  }


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
        {cart.length > 0 ? <Table /> : <p className="cartEmpty">Carrinho Vazio</p>}
        <CheckOut>          
          <Summary>
            <table>
              <tbody>
                <tr>
                  <th>Subtotal</th>
                  <td>{formatPrice(Number(total))}</td>
                </tr>

                <tr>
                  <th>Frete</th>
                  <td>GRÁTIS</td>
                </tr>
                
              </tbody>
              <tfoot>
                <tr>
                  <th>TOTAL</th>
                  <td>{formatPrice(Number(total))}</td>
                </tr>
              </tfoot>
            </table>
            <button onClick={oppenModal}>Finalizar</button>
            <NewPaymentModal        
              isOpen={isNewModalOpen}
              onRequestClose={handleCloseNewModal} />
          </Summary>
        </CheckOut>
      </Container>
      <FooterDesktop />
      <Footer />
    </>
  );
}
