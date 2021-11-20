import { ProductDetailsProps } from "../../types";
import { Container } from "./styles";

interface ProductProps {
  produto: ProductDetailsProps;
}

export function Product({ produto }: ProductProps) {
  return (
    <Container>
      <div>{produto.nome}</div>
    </Container>
  );
}
