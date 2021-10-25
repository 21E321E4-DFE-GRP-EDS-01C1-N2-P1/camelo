import { BrowserRouter } from "react-router-dom";
import { GlobalStyle } from "./styles/global";

import Routes from "./routes";
import {ProductsProvider} from "./hooks/UseProducts";

function App() {
  return (
    <ProductsProvider>
      <BrowserRouter>
        <Routes />
      </BrowserRouter>
      <GlobalStyle />
    </ProductsProvider>
  );
}

export default App;