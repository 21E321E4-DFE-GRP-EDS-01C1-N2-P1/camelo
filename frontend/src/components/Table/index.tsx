import { useEffect, useState } from 'react';

import { 
    PTable,
    Pagination,
    PaginationButton,
    PaginationItem,
} from './styles';

export function Table() {

    const [total, setTotal] = useState(0);
    const [limite, setLimite] = useState(5);
    const [pages, setPages] = useState<number[]>([]);
    const [currentPage, setCurrentPage] = useState(1);

    useEffect(() => {
        setTotal(20);
        const totalPages = 10;

        const arrayPages = [];
        for (let index = 1; index <= totalPages; index++) {
            arrayPages.push(index);
        }
        setPages(arrayPages);
        
    }, [])

    return (
        <>
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
                    <tr key={1}>
                        <td>
                            <button>x</button>
                        </td>
                        
                        <td>
                            <div>
                                <img 
                                    src="https://static.dafiti.com.br/p/Nike-T%C3%AAnis-Nike-Wmns-Revolution-5-Preto-0154-6507015-1-zoom.jpg" 
                                    alt="tenis" />

                                <label>Nike Boladão</label>
                            </div>                           
                        </td>

                        <td>100.00</td>
                        <td>2</td>
                        <td>200.00</td>
                    </tr>

                    <tr key={2}>
                        <td>
                            <button>x</button>
                        </td>
                        
                        <td>
                            <div>
                                <img 
                                    src="https://static.dafiti.com.br/p/Nike-T%C3%AAnis-Nike-Wmns-Revolution-5-Preto-0154-6507015-1-zoom.jpg" 
                                    alt="tenis" />

                                <label>Nike Boladão</label>
                            </div>                           
                        </td>

                        <td>100.00</td>
                        <td>2</td>
                        <td>200.00</td>
                    </tr>
                </tbody>
            </PTable>
            <Pagination>                    
                <PaginationButton>
                    <PaginationItem>{"<"}</PaginationItem>
                    
                    {pages.map(page => (
                        <PaginationItem 
                            key={page}
                            onClick={() => setCurrentPage(page)}>
                            {page}
                        </PaginationItem>
                    ))}
                    
                    <PaginationItem>{">"}</PaginationItem>
                </PaginationButton>                
            </Pagination>
        </>
    )
}