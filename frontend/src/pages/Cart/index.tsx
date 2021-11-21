
import { ToastContainer, toast } from "react-toastify";
import { Header } from "../../components/Header";
import { HeaderMobile } from "../../components/HeaderMobile";

import { Container } from '../../components/Container';
import { Table } from "../../components/Table";
import { CheckOut, Summary } from "./styles";
import Info from "../../components/Info";

export default function Cart() {
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
                pauseOnHover />

            <Header />
            <HeaderMobile />
            <Info breadCrumbs={["HOME", "CARRINHO"]} />
            <Container>
                <Table />
                <CheckOut>
                    <Summary>
                        <input type="text" placeholder="Cupom"/>
                    </Summary>
                    <Summary>
                        <h4>Info</h4>

                        <table>
                            <tr>
                                <td>Subtotal</td>
                                <td>200.00</td>                                
                            </tr>

                            <tr>
                                <td>Frete</td>
                                <td>20.00</td>
                            </tr>

                            <tr>
                                <td>Cupom</td>
                                <td>Não</td>
                            </tr>
                        </table>

                        <hr />

                        <table>
                            <tr>
                                <td>TOTAL</td>
                                <td>220.00</td>
                            </tr>
                        </table>
                        
                        <button>Finalizar</button>
                    </Summary>
                </CheckOut>
            </Container>
        </>
    )
}