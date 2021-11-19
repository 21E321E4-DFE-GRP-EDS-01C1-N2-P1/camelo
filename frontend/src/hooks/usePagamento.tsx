import { createContext, ReactNode, useContext } from "react";
import { toast } from 'react-toastify';

import api from "../services/api";

interface PagamentoProviderProps {
    children: ReactNode;
}

interface Pagamento {
    numero: string;
    nome: string;
    vencimento: string;
    cvv: string;
}

interface PagamentoContexData {
    save: (payment: Pagamento) => Promise<void>;
}

export const PagamentoContext = createContext<PagamentoContexData>({} as PagamentoContexData);

export function PagamentoProvider({ children }: PagamentoProviderProps) {

    async function save(payment: Pagamento) {
        await api.post('/pagamento', payment)
        .then(response => {

            toast.success("Pagamento cadastrado com sucesso.");
        }).catch((err) => {
            toast.error("Erro ao cadastrar forma de pagamento");
        })
    }


    return (
        <PagamentoContext.Provider value={{
            save
        }}>
            { children }
        </PagamentoContext.Provider>
    );
}

export function usePagamento() {
    return useContext(PagamentoContext);
}