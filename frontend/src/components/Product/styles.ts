import styled from "styled-components";


export const Container = styled.div`
    display: flex;

    @media(pointer: coarse) {
        flex-direction: column;
    }

    @media(pointer: fine) {
        section {
            margin: 1rem;
        }
    }

    img {
        height: 15rem;
        width: 15rem;
    }

    section {
        .priceArea {
            display: flex;
            
            p {
              font-size: 1rem;
              font-weight: bold;
            }
        
            .promocao {
              margin: 0 1rem;
              text-decoration: line-through;
              color: var(--gray);
            }
        
            .desconto {
              color: var(--red);
            }
        }

        .categoria {
            display: flex;
            flex-direction: column;
        }

        .cart {
            .quantidadeProduto {
                display: flex;
                margin-bottom: 1rem;
    
                p {
                    margin: 0 .3rem;
                }

                button {
                    border: 1px solid var(--gray);
                    padding: 0 .5rem;
                    border-radius: 3px;
                    background: var(--gray);
                    color: var(--text);
                    font-weight: bold;
                }
            }

            .buttons {
                display: flex;
                align-items: center;
                
                a {
                    background: #33af22;
                    display: flex;
                    padding: .5rem;
                    border-radius: 50%;
                    color: var(--background);
                    margin-left: .5rem;
                }
            }
        }
    }
`;