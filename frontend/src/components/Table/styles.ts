
import styled from "styled-components";

export const PTable = styled.table`
    width: 500px;
    border-collapse: collapse;
    background: var(--background);

    th {
        padding: 10px;
        background: var(--background);
        text-align: left;
    }

    tbody {
        

        tr {
            text-align: left;
            border-bottom: 1px solid var(--gray-light);

            button {
                border: none;
                width: 20px;
                height: 20px;
                background: #FF6875;                ;
                color: white;
                border-radius: 10%;
            }
        }

        td {
            padding: 10px;            

            div {
                display: flex;
                flex-direction: row;
                align-items: center;

                img {
                    width: 250px;
                    height: 100px;
                    margin: 0 10px;
                    border-radius: 5px;
                }

                label {
                    width: 100%;
                    font-weight: 700;
                }
            }

        }        
    }
`;

export const Pagination = styled.div`
    width: 100vw;
    display: flex;
    margin-top: 20px;    
`;

export const PaginationButton = styled.div`        
    
`;

export const PaginationItem = styled.button`
    margin: 0 10px;
    border: none;
    border-radius: 5px;
    width: 20px;
    height: 20px;
    
`;