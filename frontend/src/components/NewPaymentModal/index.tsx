import React, { FormEvent, useEffect, useState } from "react";
import Modal from "react-modal";
import { toast } from "react-toastify";

import { Container } from "./styles";
import closeImg from "../../assets/close.svg";

import { useCard } from '../../hooks/useCard';
import { useModal } from "../../hooks/useModal";

import sucessImg from "../../assets/Success.svg";

interface NewPaymentModalProps {
  isOpen: boolean;
  onRequestClose: () => void;
}

export function NewPaymentModal({ isOpen, onRequestClose }: NewPaymentModalProps) {
  
  const { response, loadCardsOffUser } = useCard();
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

    // if (!payment) {
    //   toast.warning("O carrinho não pode estar vazio");
    // }

    // if(!card) {
    //   toast.warning("Selecione um cartão");
    // }

    setFinished(true);
  }

  function test() {
    setFinished(false);
    onRequestClose();
  }

  return (
    <Modal
      isOpen={isOpen}
      onRequestClose={() => test()}
      overlayClassName="react-modal-overlay"
      className="react-modal-content"
    >{finished ? 
      <>
        <button type="button" onClick={() => test()} className="react-modal-close">
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
        <button type="button" onClick={() => test()} className="react-modal-close">
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
