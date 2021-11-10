import { Router } from "react-router-dom";
import { GlobalStyle } from "./styles/global";

import Routes from "./routes";
import history from "./history";
import {ProductsProvider} from "./hooks/UseProducts";
import { UserProvider } from "./hooks/UseProfile";

function App() {
  return (
    <UserProvider>
      <ProductsProvider>
        <Router history={history}>
          <Routes />
        </Router>
        <GlobalStyle />
      </ProductsProvider>
    </UserProvider>
  );
}

export default App;