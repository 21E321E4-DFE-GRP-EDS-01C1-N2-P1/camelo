import { useCart } from "../../hooks/useCart";

import { PTable, Container } from "./styles";

export function Table() {
  const { cart, handleRemoveProduct } = useCart();

  return (
    <Container>
      <h3>Produtos no Carrinho</h3>

      <PTable>
        <thead>
          <tr>
            <th>#</th>
            <th>Produto</th>
            <th>Preço</th>
            <th>Qtd</th>
            <th>Total</th>
          </tr>
        </thead>
        <tbody>
          {cart?.map((produto) => (
            <tr key={produto.id}>
              <td>
                <button onClick={() => handleRemoveProduct(Number(produto.id))}>x</button>
              </td>
              <td>
                <div>
                  <img src={produto.url} alt="foto produto" />
                  <label>{produto.nome}</label>
                </div>
              </td>
              <td>{produto.promotionPriceFormatted}</td>
              <td>{produto.quantidade}</td>
              <td>{produto.promotionPriceFormatted}</td>
            </tr>
          ))}
        </tbody>
      </PTable>
    </Container>
  );
}
