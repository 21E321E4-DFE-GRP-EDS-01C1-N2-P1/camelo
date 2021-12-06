import { Router } from "react-router-dom";
import { GlobalStyle } from "./styles/global";
import Modal from "react-modal";

import Routes from "./routes";
import history from "./history";
import { ProductsProvider } from "./hooks/UseProducts";
import { UserProvider } from "./hooks/UseProfile";
import { ModalProvider } from "./hooks/useModal";
import { CardsProvider } from "./hooks/useCard";
import { CartProvider } from "./hooks/useCart";
import { FavoritesProvider } from "./hooks/useFavorites";
import { CheckoutProvider } from './hooks/useCheckout';

Modal.setAppElement("#root");

function App() {
  return (
    <UserProvider>
      <ProductsProvider>
        <CartProvider>
          <FavoritesProvider>
          <ModalProvider>
            <CardsProvider>
              <CheckoutProvider>
                <Router history={history}>
                  <Routes />
                </Router>
                <GlobalStyle />
              </CheckoutProvider>
            </CardsProvider>
          </ModalProvider>
          </FavoritesProvider>
        </CartProvider>
      </ProductsProvider>
    </UserProvider>
  );
}

export default App;
