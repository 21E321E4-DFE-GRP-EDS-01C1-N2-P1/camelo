import React, { FormEvent, useEffect, useState } from "react";
import Modal from "react-modal";
import { toast } from "react-toastify";

import { Container } from "./styles";
import closeImg from "../../assets/close.svg";

import { useCart } from '../../hooks/useCart';
import { useCard } from '../../hooks/useCard';
import { useModal } from "../../hooks/useModal";
import { useCheckout } from '../../hooks/useCheckout';
import sucessImg from "../../assets/Success.svg";

import { Order, OrderItem } from '../../util/format'
import history from '../../history';

interface NewPaymentModalProps {
  isOpen: boolean;
  onRequestClose: () => void;
}

export function NewPaymentModal({ isOpen, onRequestClose }: NewPaymentModalProps) {
  const { cart } = useCart();
  const { response, loadCardsOffUser } = useCard();
  const { create } = useCheckout();
  const { handleOpenNewModal, isNewModalOpen, handleCloseNewModal } = useModal();

  const [ carregado, setCarregado ] = useState(false);
  const[payment, setPayment] = useState([]);
  const[card, steCard] = useState({});
  const[finished, setFinished] = useState(false);

  useEffect(() => {
    
    async function loadCards() {
      await loadCardsOffUser();
    }  

    if(!carregado) {
      loadCards();      
    }

    while(response === null) {
      setTimeout(() => {
        console.log("Carregando...");
      }, 1000);
    }

    setCarregado(true);
  }, [carregado, response, loadCardsOffUser, finished]);

  async function handleSubmit(e: FormEvent) {
    e.preventDefault();

    if (!payment) {
      toast.warning("O carrinho não pode estar vazio");
    } else {

    }

    if(!card) {
        console.log("Não tem cartão");
        toast.warning("Selecione um cartão");
    }  

    
    const order: Order = {      
      produtos: prepareOrder(),
      pagamento: {
        nrCartao: ""
      }
    };
      
    try {
      const response = await create( order);      
      setFinished(response);
      history.push("/home");
    } catch (err) {
      toast.error("Erro ao realizar o pedido");
    }
  }

  function prepareOrder() : OrderItem[] {
    const response:OrderItem[] = [];

    cart.forEach(item => {

      const orderItem:OrderItem = {
        id: item.id!!,
        "qtd": item.quantidade!!
      }
      response.push(orderItem);
    });

    return response;
  }

  function closeModal() {
    setFinished(false);
    onRequestClose();
  }

  return (
    <Modal
      isOpen={isOpen}
      onRequestClose={() => closeModal()}
      overlayClassName="react-modal-overlay"
      className="react-modal-content"
    >{finished ? 
      <>
        <button type="button" onClick={() => closeModal()} className="react-modal-close">
          <img src={closeImg} alt="Fechar" />
        </button>
        <Container>
          <div className="paymentSuccess">
            <h2>Pagamento finalizado com sucesso!</h2>
            <img src={sucessImg} alt="sucesso img" />
          </div>
        </Container> 
      </> 
      :
      <>
        <button type="button" onClick={() => closeModal()} className="react-modal-close">
          <img src={closeImg} alt="Fechar" />
        </button>
        <Container>
          <h2>Finalizar Pagamento</h2>

          <section className="AreaCartao">
            <p>{response?.content ? 'Escolha uma opção para pagamento:' : ''}</p>

              {response?.content ? 
                response?.content.map(cartao => (
                  <div key={cartao.id}>
                    <input id="card" type="radio" value={cartao.numero} />
                    <label htmlFor="card"> {`**** **** **** ${cartao.numero.slice(-4)}`}</label>
                  </div>
                )) : 
                (
                  <p>Cadastre uma forma de pagamento</p>
                )}
            <button type="submit" onClick={handleSubmit}>Comprar</button>
          </section>
        </Container> 
      </>
    }
      
    </Modal>
  );
}
