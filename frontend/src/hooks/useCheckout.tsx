import React, { useContext } from "react";
import { toast } from 'react-toastify';

import { createContext } from "react";
import api from "../services/api";
import { Order } from "../util/format";


interface CheckoutProviderProps {
    children: React.ReactNode;
}

interface CheckoutContextData {
    create: (order: Order) => Promise<boolean>;
}

export const CheckoutContext = createContext<CheckoutContextData>({} as CheckoutContextData);

export function CheckoutProvider({ children} : CheckoutProviderProps) {

    async function create(order: Order): Promise<boolean> {
        let sucess = false;

        api.defaults.headers.common['Authorization'] = localStorage.getItem("token")        
        await api.post('/checkout/', order)
        .then(response => {
            sucess = true;
            localStorage.removeItem('@cart');
        }).catch((err) => {
            toast.error('Erro ao realizar o pagamento, tente novamente mais tarde.');
        })
        

        return sucess;
    }

    return (
        <CheckoutContext.Provider value={{
            create
        }}>
            {children}
        </CheckoutContext.Provider>
    )
}

export function useCheckout() {
    return useContext(CheckoutContext);
}