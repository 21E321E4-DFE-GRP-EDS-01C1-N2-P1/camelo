import { useEffect, useState } from "react";
import { ProductFormatted } from "../../types";

import { PTable, Container } from "./styles";

export function Table() {
  const [cart, setCart] = useState<ProductFormatted[]>(() => {
    const storagedCart = localStorage.getItem("@cart");
    return storagedCart ? JSON.parse(storagedCart) : [];
  });

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
          {cart.map((produto) => (
            <tr key={produto.id}>
              <td>
                <button>x</button>
              </td>
              <td>
                <div>
                  <img src={produto.url} alt="foto produto" />
                  <label>{produto.nome}</label>
                </div>
              </td>
              <td>{produto.promotionPriceFormatted}</td>
              <td>2</td>
              <td>{produto.preco! * 2}</td>
            </tr>
          ))}
        </tbody>
      </PTable>
    </Container>
  );
}
