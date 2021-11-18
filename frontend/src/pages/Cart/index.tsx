import { useEffect, useState } from "react";
import { ToastContainer, toast } from 'react-toastify';


import api from "../../services/api";

import { Header } from "../../components/Header";
import { Container } from "../../components/Container";
import Info from "../../components/Info";
import {ProductDetail} from "../../components/ProductDetail";

interface Product {
  id?: number;
  nome?: string;
  url?: string;
  preco?: number;
  desconto?: number;
  categorias?: Category[];
}

interface Category {
  id: number;
  descricao: string;
}

export default function Cart({ ...props }) {

  const [produto, setProduto] = useState<Product>();
  const { id } = props.match.params;
  
  useEffect(() => {
    
    api.get<Product>(`/produtos/categorizado/${id}`)
    .then((response => {
      setProduto(response.data)
    })).catch((err) => {
      toast.error("Produto não localizado")
    });
    
        
  }, [id]);

  return (
    <>
      <ToastContainer
        autoClose={5000}
        hideProgressBar={false}
        newestOnTop={false}
        closeOnClick
        rtl={false}
        pauseOnFocusLoss
        draggable
        pauseOnHover
        />

      <Header page={"Produto"} />

      <Info breadCrumbs={[ "HOME", "HOT DEAL", "NIKE AIR MAX" ]} />

      <Container>
        <ProductDetail />
      </Container>      
    </>
  );
}