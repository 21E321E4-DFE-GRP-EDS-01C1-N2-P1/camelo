import { Link } from "react-router-dom";

import { FiUser, FiShoppingCart, FiHome, FiHeart } from "react-icons/fi";
import { Container, Content, MenuItem } from "./styles";

export function Footer() {
  return (
    <Container>
      <Content>
        <MenuItem>
          <FiHome size={16} />
          <Link to="/home">Home</Link>
        </MenuItem>
        <MenuItem>
          <FiUser size={16} />
          <Link to="/profile">Profile</Link>
        </MenuItem>
        <MenuItem>
          <FiShoppingCart size={16} />
          <Link to="/cart">Cart</Link>
        </MenuItem>
        <MenuItem>
          <FiHeart size={16} />
          <Link to="/home">Favorites</Link>
        </MenuItem>
      </Content>
    </Container>
  );
}