import { useEffect, useState } from 'react';
import { ToastContainer, toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";

import api from '../../services/api';
import { Table } from './styles';

interface Cartao {
    id: number;
    numero: string;
    nome: string;
    vencimento: string;
    cvv: number;
}

interface Response {
    content: Cartao[];
    totalPages: number;
    totalElements: number;
    size: number;
    empty: boolean;
  }
  
  interface Cartao {
    id: number;
    numero: string;
    nome: string;
    vencimento: string;
    cvv: number;
  }

export function Cartoes() {

    const [response, setResponse] = useState<Response>();  
    const [page, setPage] = useState<number>(0);

    useEffect(() => {
        api.defaults.headers.common['Authorization'] = localStorage.getItem("token")
    
        const url = `/pagamento?page=${page}&linesPerPage=3`;
    
        api.get<Response>(url)
        .then(res => {
          setResponse(res.data);
    
        }).catch((err) => {
          toast.error("Erro ao consultar cartões.");
        });
    }, [page]);

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
                { response?.content ? response?.content.map(cartao => 
                    <tr>
                        <td>{ cartao.numero }</td>
                        <td>{ cartao.vencimento }</td>
                        <td>{ cartao.cvv }</td>
                    </tr>                    
                ) : (                    
                    <div>
                        sem cartoes
                    </div>
                )}
            </tbody>
            <tfoot>
                {
                    response?.size && response?.size > 0 ? (
                        
                        <h1>q</h1>
                        
                    ) : (
                        <h2>qe</h2>
                    )
                }
            </tfoot>
        </Table>
    )
}