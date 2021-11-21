import { FormEvent, useEffect, useState } from "react";
import { ToastContainer, toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";

import { 
  Card, 
  CardArea, 
  Container 
} from "./styles";

import { Footer } from "../../components/Footer";
import { Header } from "../../components/Header";
import { HeaderMobile } from "../../components/HeaderMobile";
import { ButtonCard } from "../../components/ButtonCard";
import { NewCardModal } from "../../components/NewCardModal";
import { Cartoes } from '../../components/Cartoes';

import { useProfile } from "../../hooks/UseProfile";
import { useModal } from "../../hooks/useModal";

export function Profile() {

  const { updateUser } = useProfile();
  const { isNewModalOpen, handleOpenNewModal, handleCloseNewModal } = useModal();
  const [email, setEmail] = useState("");
  const [name, setName] = useState("");
  const [endereco, setEndereco] = useState("");
  const [cep, setCep] = useState("");
  const [bairro, setBairro] = useState("");
  const [cidade, setCidade] = useState("");
  
  useEffect(() => {
    const json = localStorage.getItem("@usuario")!!;
    const usuario = JSON.parse(json);

    setEmail(usuario.email);
    setName(usuario.name);
    setEndereco(usuario.endereco);
    setCep(usuario.cep);
    setCidade(usuario.cidade);
    setBairro(usuario.bairro);
  }, []);

  async function handleUpdateAccount(e: FormEvent) {
    e.preventDefault();

    if (!name || !endereco || !cep || !bairro || !cidade) {
      toast.warning("Preencha todos os campos para continuar");
    } else {
      await updateUser({
        email,
        password: "",
        bairro,
        cep,
        cidade,
        endereco,
        name,
      });
    }
  }

  return (
    <>
      <ToastContainer
        autoClose={5000}
        hideProgressBar={false}
        newestOnTop={false}
        closeOnClick
        rtl={false}
        pauseOnFocusLoss
        draggable
        pauseOnHover />

      <Header />
      <HeaderMobile />
      <Container>
        <Card>
          <h2>Editar Perfil</h2>
          <form>
            <div className="row">
              <div className="column">
                <label>Nome</label>
                <input
                  type="text"
                  placeholder="Informe seu nome"
                  value={name}
                  onChange={(e) => setName(e.target.value)}
                />
              </div>

              <div className="column">
                <label>Email</label>
                <input
                  type="email"
                  placeholder="Informe seu email"
                  value={email}
                  disabled
                />
              </div>
            </div>

            <div className="row">
              <div className="column">
                <label>Cep</label>
                <input
                  type="text"
                  placeholder="Informe seu cep"
                  value={cep}
                  onChange={(e) => setCep(e.target.value)}
                />
              </div>

              <div className="column">
                <label>Bairro</label>
                <input
                  type="text"
                  placeholder="Informe seu bairro"
                  value={bairro}
                  onChange={(e) => setBairro(e.target.value)}
                />
              </div>

              <div className="column">
                <label>Cidade</label>
                <input
                  type="text"
                  placeholder="Informe sua cidade"
                  value={cidade}
                  onChange={(e) => setCidade(e.target.value)}
                />
              </div>
            </div>
            <div className="column">
              <label>Endereço</label>
              <input
                type="text"
                placeholder="Informe seu endereço"
                value={endereco}
                onChange={(e) => setEndereco(e.target.value)}
              />
            </div>
            <div className="buttonProfile">
              <button type="submit" onClick={handleUpdateAccount}>
                Editar Perfil
              </button>
            </div>
          </form>
        </Card>

        <h2>Meus cartões</h2>
        <ButtonCard onOpen={handleOpenNewModal} />
        <NewCardModal        
          isOpen={isNewModalOpen}
          onRequestClose={handleCloseNewModal} />
        
        <CardArea>
          <Cartoes />
        </CardArea>

      </Container>
      <Footer />
    </>
  );
}
