import { Container, Content, Form } from "./styles";
import { Link } from "react-router-dom";

import LogoImg from "../../assets/logo.svg";

export default function SignUp() {
  return (
    <Container>
      <Content>
        <div className="heading">
          <img src={LogoImg} alt="Logo Dashboard" />

          <h1>Cadastro</h1>
        </div>

        <Form>
          <input type="text" id="user" placeholder="Usuário" />
          <input type="email" id="email" placeholder="Email" />
          <input type="password" id="password" placeholder="Senha" />

          <button type="submit">Cadastrar</button>

          <div className="auth-footer">
            <p>Já tem acesso?</p>
            <Link to="/">Faça login</Link>
          </div>
        </Form>
      </Content>
    </Container>
  );
}
