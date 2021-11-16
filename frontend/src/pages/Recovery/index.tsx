import { FormEvent, useState } from "react";
import { Link } from "react-router-dom";

import { ToastContainer, toast } from 'react-toastify';
import { 
    Container,
    Content,
    Form
} from "./styles";

import { useProfile } from "../../hooks/UseProfile";
import { Loader } from "../../components/Loader";

export default function Recovery() {

    const [email, setEmail] = useState('');
    const [enable, setEnable] = useState(false);
    const { recovery } = useProfile();

    async function handleRecovery(e: FormEvent) {
        e.preventDefault();

        if (!email) {
            toast.warning('Informe o e-mail de recuperação.');
            return;
        }
        
        setEnable(true);
        var response = await recovery(email)
        setEnable(response)
    }

    return (
        <Container>
            <ToastContainer
                autoClose={5000}
                hideProgressBar={false}
                newestOnTop={false}
                closeOnClick
                rtl={false}
                pauseOnFocusLoss
                draggable
                pauseOnHover />
                    
            <Content>
                <div className="heading">
                    <h2>Recuperação de senha</h2>
                    <Form>
                        <Loader enable={enable}/>
                        <input 
                            type="email" 
                            id="email" 
                            placeholder="E-mail de recuperação"                             
                            onChange={e => setEmail(e.target.value)} 
                            disabled={enable} />

                        <button 
                            type="submit"
                            disabled={enable}
                            onClick={handleRecovery}>
                                Recuperar
                        </button>

                        { !enable ? (
                            <div className="auth-footer">
                                <Link to="/">Retornar</Link>
                            </div>
                        ) : <></> }
                    </Form>
                </div>

            </Content>
        </Container>
    );
}