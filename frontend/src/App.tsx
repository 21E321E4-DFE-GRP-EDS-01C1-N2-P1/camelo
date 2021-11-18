import { Router } from "react-router-dom";
import { GlobalStyle } from "./styles/global";
import Modal from 'react-modal';

import Routes from "./routes";
import history from "./history";
import { ProductsProvider } from "./hooks/UseProducts";
import { UserProvider } from "./hooks/UseProfile";
import { ModalProvider } from "./hooks/useModal";

Modal.setAppElement('#root');

function App() {
  return (
    <UserProvider>
      <ProductsProvider>
        <ModalProvider>
          <Router history={history}>
            <Routes />
          </Router>
          <GlobalStyle />
        </ModalProvider>
      </ProductsProvider>
    </UserProvider>
  );
}

export default App;
