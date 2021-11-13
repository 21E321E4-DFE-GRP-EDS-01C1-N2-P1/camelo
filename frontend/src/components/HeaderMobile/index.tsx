import { FiLogOut } from "react-icons/fi";
import { Link } from "react-router-dom";
import logoImg from "../../assets/logo.svg";
import { useProfile } from "../../hooks/UseProfile";
import { Container, NavigationArea } from "./styles";

export function HeaderMobile() {
  const { signOut } = useProfile();

  return (
    <Container>
      <NavigationArea>
        <img src={logoImg} alt="logo img" title="logo img" />

        <nav>
          <FiLogOut size={22} onClick={signOut} />
        </nav>
      </NavigationArea>
    </Container>
  );
}
