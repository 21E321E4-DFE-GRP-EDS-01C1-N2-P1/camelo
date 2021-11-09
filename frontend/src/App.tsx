import { BrowserRouter, Router } from "react-router-dom";
import { GlobalStyle } from "./styles/global";

import Routes from "./routes";
import history from "./history";
import {ProductsProvider} from "./hooks/UseProducts";

function App() {
  return (
    <ProductsProvider>
      <Router history={history}>
        <Routes />
      </Router>
      <GlobalStyle />
    </ProductsProvider>
  );
}

export default App;