import Modal from "react-modal";
import { Container, Row } from "./styles";
import closeImg from "../../assets/close.svg";
import { useState } from "react";
import Cards from 'react-credit-cards';

interface NewCardModalProps {
  isOpen: boolean;
  onRequestClose: () => void;
}

type Focused = "name" | "number" | "expiry" | "cvc";

export function NewCardModal({ isOpen, onRequestClose }: NewCardModalProps) {
  const [number, setNumber] = useState('');
  const [name, setName] = useState('');
  const [expiry, setExpiry] = useState('');
  const [cvc, setCvc] = useState('');
  const [focus, setFocus] = useState<Focused | undefined>(undefined);

  function handleChangeFocus(e: React.ChangeEvent<HTMLInputElement>) {
    setFocus(e.target.name as Focused);
  }

  return (
    <Modal
      isOpen={isOpen}
      onRequestClose={onRequestClose}
      overlayClassName="react-modal-overlay"
      className="react-modal-content"
    >
      <button type="button" onClick={onRequestClose} className="react-modal-close">
        <img src={closeImg} alt="Fechar" />
      </button>
      <Container>
        <h2>Cadastrar Cartão</h2>

        <Cards
          cvc={cvc}
          expiry={expiry}
          focused={focus}
          name={name}
          number={number}
        />

        <input
          className="first-input"
          placeholder="Número"
          name="number"
          value={number}
          onFocus={handleChangeFocus}
          onChange={e => setNumber(e.target.value)}
        />

        <input
          placeholder="Nome"
          name="name"
          value={name}
          onFocus={handleChangeFocus}
          onChange={e => setName(e.target.value)}
        />

        <Row>
          <input
            placeholder="Validade"
            name="expiry"
            value={expiry}
            onFocus={handleChangeFocus}
            onChange={e => setExpiry(e.target.value)}
          />

          <input
            placeholder="CVC"
            name="cvc"
            value={cvc}
            onFocus={handleChangeFocus}
            onChange={e => setCvc(e.target.value)}
          />
        </Row>
        <button type="submit">Salvar</button>
      </Container>
    </Modal>
  );
}
