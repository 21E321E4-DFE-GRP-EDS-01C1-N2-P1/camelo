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
    size: 0;
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
    const [items, setItems] = useState<number[]>([]);

    function renderTFooterPaginator() {
        var aux = []
        if (response && response.size > 0) {
            for(let i = 0; i < response.size; i++) {
                aux.push(i)
                setItems(aux)
            }            
        }
    }

    useEffect(() => {
        api.defaults.headers.common['Authorization'] = localStorage.getItem("token")
    
        const url = `/pagamento?page=${page}&linesPerPage=3`;
    
        api.get<Response>(url)
        .then(res => {
          setResponse(res.data);          
        }).catch((err) => {
          toast.error("Erro ao consultar cartões.");
        });

        renderTFooterPaginator();
    }, []);

    function teste(pagina:number) {
        console.log(`nova pagina ${pagina}`)
        api.defaults.headers.common['Authorization'] = localStorage.getItem("token")
    
        const url = `/pagamento?page=${pagina}&linesPerPage=3`;
    
        api.get<Response>(url)
        .then(res => {
          setResponse(res.data);          
        }).catch((err) => {
          toast.error("Erro ao consultar cartões.");
        });

        renderTFooterPaginator();
    }

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
                <tr>
                    {items.map(it => (
                        <button onClick={() => teste(it)}>{it + 1}</button> 
                    ))}
                </tr>
            </tfoot>
        </Table>
    )
}