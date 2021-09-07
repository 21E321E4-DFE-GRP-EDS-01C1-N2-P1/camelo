import { Link } from "react-router-dom";

import { FiUser, FiShoppingCart, FiHome, FiHeart } from "react-icons/fi";
import { Container, Content, MenuItem } from "./styles";

export function Footer() {
  return (
    <Container>
      <Content>
        <MenuItem>
          <FiHome size={16} />
          <Link to="">Home</Link>
        </MenuItem>
        <MenuItem>
          <FiUser size={16} />
          <Link to="">Profile</Link>
        </MenuItem>
        <MenuItem>
          <FiShoppingCart size={16} />
          <Link to="">Cart</Link>
        </MenuItem>
        <MenuItem>
          <FiHeart size={16} />
          <Link to="">Favorites</Link>
        </MenuItem>
      </Content>
    </Container>
  );
}