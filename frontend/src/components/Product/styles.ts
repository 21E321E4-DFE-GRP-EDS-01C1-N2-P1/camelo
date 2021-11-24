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
                    margin: 0 .5rem;
                }
            }

            .unfavorited {
                border: 0;
                background: transparent;
                display: flex;
                align-items: center;
                
                svg {
                    color: var(--red);
                }

            }

            .favorited {
                border: 0;
                background: transparent;
                display: flex;
                align-items: center;

                svg {
                    color: var(--text);
                }
            }
        }
    }
`;

export const ButtonCart = styled.button`
  display: flex;
  align-items: center;
  justify-content: center;
  padding: 0 1rem;
  height: 2rem;
  background: #3181FF;
  color: var(--background);
  border: 0;
  border-radius: 0.25rem;
  font-size: 1rem;
  transition: filter 0.2s;

  &:hover {
    filter: opacity(0.9);
  }

  svg {
    margin-right: 0.5rem;
  }
`;