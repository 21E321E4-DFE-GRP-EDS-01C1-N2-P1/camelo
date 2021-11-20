import "react-toastify/dist/ReactToastify.css";
import { useCard } from "../../hooks/useCard";

import { Table } from "./styles";

export function Cartoes() {
  const { response, items } = useCard();

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
            <button>{it + 1}</button>
          ))}
        </tr>
      </tfoot>
    </Table>
  );
}
