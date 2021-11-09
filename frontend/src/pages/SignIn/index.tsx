import { Container, Content, Form } from "./styles";
import { Link } from "react-router-dom";

import LogoImg from "../../assets/logo.svg";
import { FormEvent, useEffect, useState } from "react";
import api from "../../services/api";
import history from "../../history";

interface User {
  email: string;
  password: string;
  logedIn: boolean;
}

export default function SignIn() {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [logedIn, setLogedIn] = useState(false);

  useEffect(() => {
    const token = localStorage.getItem('token');
    if(token) {
      localStorage.setItem('token', token);
      setLogedIn(true);
    }
  }, []);

  async function handleSignIn(e: FormEvent) {
    e.preventDefault();

    await api.post('/login', {
      email,
      password
    }).then(response => {
      if (response.status === 200) {
        setLogedIn(true);
        const { authorization } = response.headers;
        localStorage.setItem('token', authorization);
        history.push('/home');
      }
      console.log(logedIn);
    }).catch(err => {
      if(err.response.status === 401) {
        alert('Usuário ou senha inválidos');
        localStorage.removeItem('token');
      }
    });
  }

  return (
    <Container>
      <Content>
        <div className="heading">
          <img src={LogoImg} alt="Logo Dashboard" />

          <h1>Login</h1>
        </div>

        <Form>
          <input type="email" id="email" placeholder="Email" onChange={e => setEmail(e.target.value)} />
          <input type="password" id="password" placeholder="Senha" onChange={e => setPassword(e.target.value)} />

          <button type="submit" onClick={handleSignIn}>Entrar</button>

          <div className="auth-footer">
            <p>Não tem acesso?</p>
            <Link to="/signup">Cadastre-se</Link>
          </div>
        </Form>
      </Content>
    </Container>
  );
}
