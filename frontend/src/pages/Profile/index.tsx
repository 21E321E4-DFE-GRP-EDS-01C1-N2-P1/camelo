import { Footer } from "../../components/Footer";
import { Header } from "../../components/Header";
import { HeaderMobile } from "../../components/HeaderMobile";
import { Card, Container } from "./styles";

export function Profile() {
  return (
    <>
      <Header />
      <HeaderMobile />
      <Container>
        <Card>
          <h2>Editar Perfil</h2>
          <form>
            <div className="row">
              <div className="column">
                <label>Usuário</label>
                <input type="text" placeholder="Informe seu nome" />
              </div>

              <div className="column">
                <label>Email</label>
                <input type="email" placeholder="Informe seu email" />
              </div>
            </div>

            <div className="column">
              <label>Endereço</label>
              <input type="text" placeholder="Informe seu endereço" />
            </div>
            <div className="row">
              <div className="column">
                <label>Cep</label>
                <input type="text" placeholder="Informe seu cep" />
              </div>

              <div className="column">
                <label>Bairro</label>
                <input type="text" placeholder="Informe seu bairro" />
              </div>

              <div className="column">
                <label>Cidade</label>
                <input type="text" placeholder="Informe sua cidade" />
              </div>
            </div>
            <div className="buttonProfile">
              <button>
                Editar Perfil
              </button>
            </div>
          </form>
        </Card>

        <Card>
          <h2>Meus cartões</h2>
        </Card>
      </Container>
      <Footer />
    </>
  );
}
