import { FormEvent, useState } from "react";
import { Link } from "react-router-dom";
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

import LogoImg from "../../assets/logo.svg";
import { useProfile } from "../../hooks/UseProfile";

import { Container, Content, Form } from "./styles";

export default function SignUp() {
  const { createUser } = useProfile();

  const [name, setName] = useState('');
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');

  async function handleCreateAccount(e: FormEvent) {
    e.preventDefault();

    if(!email || !password || !name) {
      toast.error('Preencha todos os campos para continuar');
    } else {
      await createUser({ name, email, password });
    } 
  }

  return (
    <Container>
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
      <Content>
        <div className="heading">
          <img src={LogoImg} alt="Logo Dashboard" />

          <h1>Cadastro</h1>
        </div>

        <Form>
          <input type="text" id="username" placeholder="Usuário" onChange={e => setName(e.target.value)} />
          <input type="email" id="email" placeholder="Email" onChange={e => setEmail(e.target.value)} />
          <input type="password" id="password" placeholder="Senha" onChange={e => setPassword(e.target.value)} />

          <button type="submit" onClick={handleCreateAccount}>Cadastrar</button>

          <div className="auth-footer">
            <p>Já tem acesso?</p>
            <Link to="/">Faça login</Link>
          </div>
        </Form>
      </Content>
    </Container>
  );
}
