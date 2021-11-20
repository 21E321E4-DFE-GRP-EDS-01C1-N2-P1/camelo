import { FormEvent, useState } from "react";
import { Link } from "react-router-dom";
import { ToastContainer, toast } from 'react-toastify';

import LogoImg from "../../assets/logo.svg";

import { Container, Content, Form } from "./styles";
import { useProfile } from "../../hooks/UseProfile";

export default function SignIn() {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const { signIn } = useProfile();

  async function handleSignIn(e: FormEvent) {
    e.preventDefault();

    if(!email || !password) {
      toast.warning('Preencha todos os campos para continuar');
    } else {
      await signIn({ email, password });
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
        pauseOnHover />

      <Content>
        <div className="heading">
          <img src={LogoImg} alt="Logo Dashboard" />

          <h1>Login</h1>
        </div>

        <Form>
          <input 
            type="email" 
            id="email" 
            placeholder="Email" 
            onChange={e => setEmail(e.target.value)} />
          <input type="password" id="password" placeholder="Senha" onChange={e => setPassword(e.target.value)} />

          <button type="submit" onClick={handleSignIn}>Entrar</button>

          <div className="auth-footer">
            <p>Não tem acesso?</p>
            <Link to="/signup">Cadastre-se</Link>
          </div>

          <div className="recovery">            
            <Link to="/recovery">Recuperar acesso</Link>
          </div>
        </Form>
      </Content>
    </Container>
  );
}
