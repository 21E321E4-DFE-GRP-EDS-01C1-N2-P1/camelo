import styled from "styled-components";

export const Container = styled.div`
    display: flex;
    flex-direction: column;
    align-items: center;

    .cartEmpty {
        margin-top: 2rem;
    }
`;

export const CheckOut = styled.div`
    display: flex;
    margin-top: 2rem;

    @media(pointer: coarse) {
        flex-direction: column;
    }
`;

export const Cupom = styled.div`
    @media(pointer: coarse) {
        display: flex;
        flex-direction: column;
    }

    input {
        background: #FCFDFE;
        border: 1px solid #ced4da;
        box-sizing: border-box;
        border-radius: .5rem;
        height: 2.6rem;
        padding: 1rem;

        &::placeholder {
        color: var(--gray-dark);
        }

        &:focus {
        outline: 1px solid var(--blue);
        }
    }

    @media(pointer: fine)  {
        button {
            margin: 0 .5rem;
        }
    }

    @media(pointer: coarse)  {
        input, button {
            margin-bottom: 1rem;
        }
    }

    button {
      border: 1px solid #DFE0EB;
      background: var(--blue-off);
      border-radius: .5rem;
      color: var(--background);
      font-weight: bold;
      font-size: 1rem;
      padding: .5rem 2rem;
      transition: filter 0.2s;
  
      &:hover {
        filter: opacity(0.9);
      }
    }
`;

export const Summary = styled.div`
    width: 300px;
    
    table {
        width: 100%;
    }

    th {
        text-align: left;
    }

    td {
        text-align: right;
    }

    button {
        width: 100%;
        border: 1px solid #DFE0EB;
        background: var(--blue-off);
        border-radius: .5rem;
        color: var(--background);
        font-weight: bold;
        font-size: 1rem;
        padding: .5rem 2rem;
        transition: filter 0.2s;
  
        &:hover {
            filter: opacity(0.9);
        }
    }
`;