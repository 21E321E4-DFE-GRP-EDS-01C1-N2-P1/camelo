import { useEffect, useState } from "react";
import "react-toastify/dist/ReactToastify.css";
import { useCard } from "../../hooks/useCard";

import { Table } from "./styles";

export function Cartoes() {
  const { response, items, loadCardsOffUser, addPage } = useCard();
  const [ carregado, setCarregado ] = useState(false);

  useEffect(() => {
    
    async function loadCards() {
      await loadCardsOffUser();
    }  

    if(!carregado) {
      loadCards();      
    }

    while(response === null) {
      setTimeout(() => {
        console.log("Carregando...");
      }, 1000);
    }

    if (carregado && items.length === 0) {
      addPage();
    }
    
    setCarregado(true);
  }, [carregado, response, loadCardsOffUser, addPage, items.length]);

  if (carregado) {
    return (
      <Table>
        <thead>
          <tr>
            <th>Número</th>
            <th>vencimento</th>
            <th>cvv</th>
          </tr>
        </thead>
        <tbody>
          {response?.content ? (
            response?.content.map((cartao) => (
              <tr key={cartao.id}>
                <td>{cartao.numero}</td>
                <td>{cartao.vencimento}</td>
                <td>{cartao.cvv}</td>
              </tr>
            ))
          ) : (
            <tr>
                <td>sem cartoes</td>
            </tr>
          )}
        </tbody>
        <tfoot>
          <tr>
            {items.map((it) => (
              <button>{it}</button>
            ))}
          </tr>
        </tfoot>
      </Table>
    )
  } else {
    return (
      <h1>Carregando...</h1>
    )
  }
}
