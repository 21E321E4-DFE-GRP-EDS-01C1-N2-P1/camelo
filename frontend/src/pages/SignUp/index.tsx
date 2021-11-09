import { Container, Content, Form } from "./styles";
import { Link } from "react-router-dom";

import LogoImg from "../../assets/logo.svg";
import { FormEvent, useState } from "react";
import api from "../../services/api";

interface User {
  username: string;
  email: string;
  password: string;
}

export default function SignUp() {
  const [name, setName] = useState('');
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');

  async function handleCreateAccount(e: FormEvent) {
    e.preventDefault();

    await api.post('/user', {
      name,
      email,
      password
    }).then(response => {
      console.log(response.status);
    }).catch((err) => {
      console.log(err.response.status)
    });
  }

  return (
    <Container>
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
