import { FiUser, FiShoppingCart } from "react-icons/fi";
import { Link } from "react-router-dom";
import { Container, Content, NavigationArea, ProfileArea } from "./styles";
import logoImg from "../../assets/logo.svg";
import { Banner } from "../Banner";

export function Header() {
  return (
    <Container>
      <Content>
        <ProfileArea>
          <section>
            <FiUser size={15} />
            <span>Profile</span>
          </section>

          <section>
            <FiShoppingCart size={15} />
            <span>Items</span>
          </section>
        </ProfileArea>

        <NavigationArea>
          <img src={logoImg} alt="logo img" title="logo img" />

          <nav>
            <ul>
              <li><Link to="">home</Link></li>
            </ul>
            <input type="text" placeholder="Buscar produto"/>
            <button>Buscar</button>
          </nav>
        </NavigationArea>
      </Content>

      <Banner />
    </Container>
  );
}