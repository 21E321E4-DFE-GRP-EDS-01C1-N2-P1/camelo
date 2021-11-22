import { Footer, FooterContato, FooterEmpresa, FooterSocial } from "./styles";
import logo from "../../assets/logo.svg";
import fb from "../../assets/facebook.svg";
import tt from "../../assets/twitter.svg";

export function FooterDesktop() {
  return (
    <>
      <Footer>
        <FooterEmpresa>
          <div>
            <h4>About Us</h4>
          </div>
          <p>
            O melhor e-commerce para comprar roupas.
          </p>
        </FooterEmpresa>

        <FooterSocial>
          <h4>Follow Us</h4>
          <p>
            Nos sigam nas redes sociais.
          </p>

          <div>
            <img src={fb} alt="facebook aplicação" />
            <img src={tt} alt="twitter aplicação" />
          </div>
        </FooterSocial>

        <FooterContato>
          <h4>Contact Us</h4>
          <p>
            Entre em contato <br/>
            camelo@gmail.com
          </p>
        </FooterContato>
      </Footer>
    </>
  );
}
