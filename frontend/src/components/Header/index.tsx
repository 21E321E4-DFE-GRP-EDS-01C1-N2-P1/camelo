import { FiUser, FiShoppingCart, FiLogOut } from "react-icons/fi";
import { Link } from "react-router-dom";

import logoImg from "../../assets/logo.svg";
import { useProfile } from "../../hooks/UseProfile";

import { 
    Container, 
    Content, 
    NavigationArea, 
    ProfileArea,
    NavigationButton
} from "./styles";

export function Header() {
    const { signOut } = useProfile();

    return (
        <Container>
            <Content>
                <ProfileArea>                
                    <NavigationButton>
                        <Link to="/profile"> 
                            <FiUser size={15}/>
                            <span>Profile</span>
                        </Link>
                    </NavigationButton>

                    <NavigationButton>
                        <Link to="/cart">
                            <FiShoppingCart size={15}/>
                            <span>Items</span>
                        </Link>
                    </NavigationButton>                                                        
                </ProfileArea>

                <NavigationArea>
                    <img src={logoImg} alt="logo img" title="logo img"/>

                    <nav>
                        <ul>
                            <li><Link to="">home</Link></li>
                        </ul>
                        <input type="text" placeholder="Buscar produto"/>
                        <button>Buscar</button>
                        <FiLogOut size={22} onClick={signOut}/>
                    </nav>
                </NavigationArea>
            </Content>
        </Container>
    );
}