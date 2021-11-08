import { Container, Content, Form } from "./styles";
import { Link } from "react-router-dom";

import LogoImg from "../../assets/logo.svg";

export default function SignIn() {
  return (
    <Container>
      <Content>
        <div className="heading">
          <img src={LogoImg} alt="Logo Dashboard" />

          <h1>Login</h1>
        </div>

        <Form>
          <input type="email" id="email" placeholder="Email" />
          <input type="password" id="password" placeholder="Senha" />

          <button type="submit">Entrar</button>

          <div className="auth-footer">
            <p>Não tem acesso?</p>
            <Link to="/signup">Cadastre-se</Link>
          </div>
        </Form>
      </Content>
    </Container>
  );
}
