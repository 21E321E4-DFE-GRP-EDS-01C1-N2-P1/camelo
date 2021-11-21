import styled from "styled-components";

export const CheckOut = styled.div`
    width: 100vw;
    display: flex;
    margin-top: 50px;
`;

export const Cupom = styled.div`
`;

export const Summary = styled.div`
    min-width: 50%;
    display: flex;
    flex-direction: column;
    align-items: center;

    h4 {
        font-weight: 700;
    }

    table {
        width: 100%;
    }

    h5 {
        color: var(--gray-light)
    }

    button {
        width: 200px;
        height: 60px;
        border-radius: 5px;
        color: var(--background);
        font-size: 20px;
        border: none;
        background: var(--blue-off);
    }
`;