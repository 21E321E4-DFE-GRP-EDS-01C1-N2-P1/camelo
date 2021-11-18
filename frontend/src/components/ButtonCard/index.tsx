import { FiCreditCard } from "react-icons/fi";
import { Button } from "./styles";

interface ButtonProps {
  onOpen: () => void;
}

export function ButtonCard({ onOpen }: ButtonProps) {

  return (
    <Button onClick={onOpen}>
      <FiCreditCard />
      Adicionar
    </Button>
  );
}
