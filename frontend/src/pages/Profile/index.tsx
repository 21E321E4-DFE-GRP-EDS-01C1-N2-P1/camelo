import { useEffect, useState } from "react";
import { Footer } from "../../components/Footer";
import { Header } from "../../components/Header";
import { HeaderMobile } from "../../components/HeaderMobile";
import { Card, Container } from "./styles";

interface Usuario {
  id: number;
  name: string;
  email: string;
}


export function Profile() {

  const [usuario, setUsuario] = useState<Usuario>();

  function converter(json:string):Usuario{

    const value = JSON.parse(json, (key, value) => {
      if (typeof value === 'string') {
        return value;
      }
      return value;
    });

    const retorno:Usuario = {
      id: value.id,
      name: value.name,
      email: value.email
    }

    return retorno;
  }

  useEffect(() => {
    
    const json = localStorage.getItem('@usuario')!!
    const json_ = JSON.parse(json);
    
    const usuarioLocalizado = converter(json_)
    setUsuario(usuarioLocalizado)
  }, [])

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
                <input type="text" placeholder="Informe seu nome" value={usuario?.name}/>
              </div>

              <div className="column">
                <label>Email</label>
                <input type="email" placeholder="Informe seu email" value={usuario?.email}/>
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
