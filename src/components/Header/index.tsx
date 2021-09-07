import { FiUser, FiShoppingCart } from "react-icons/fi";
import { Link } from "react-router-dom";
import { Container, Content, NavigationArea, ProfileArea } from "./styles";
import logoImg from "../../assets/logo.svg";

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
            <img src={logoImg} alt="logo img" />

          <nav>
            <ul>
              <li><Link to="">home</Link></li>
              <li><Link to="">pants</Link></li>
              <li><Link to="">sneakers</Link></li>
              <li><Link to="">t-shirts</Link></li>
            </ul>
          </nav>
        </NavigationArea>
      </Content>
    </Container>
  );
}