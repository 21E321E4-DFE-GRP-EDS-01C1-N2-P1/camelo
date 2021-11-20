import styled from "styled-components";

export const Table = styled.table`
    width: 100%;
    border-spacing: 0 0.5rem;
    border: 1px solid rgba(0,0,0,.125);
    border-radius: .5rem;
    box-shadow: 0 6px 10px -4px rgb(0 0 0 / 35%);

    th {
      color: #375F9A;
      font-weight: 600;
      padding: 1rem 2rem;
      text-align: center;
      line-height: 1.7rem;
    }

    td {
        padding: 1rem 2rem;
        border: 0;
        background: #fff;
        text-align: center;
        color: #8888;
        border-radius: 0.25rem;
    }

    tfoot {
      display: flex;      
    }

    tfoot tr {
      padding: 0 5px;

    }

    tfoot tr button {
      width: 15px;
      height: 30px;
      background: var(--blue-light);
      border: none;
      border-radius: 5px;
    }

`;