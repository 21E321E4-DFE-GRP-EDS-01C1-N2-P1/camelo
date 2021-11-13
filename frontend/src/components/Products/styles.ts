import styled from "styled-components";

export const Product = styled.section`
  display: flex;
  flex-direction: column;
  align-items: center;
  border-radius: .3rem;
  border: 1px solid rgba(0, 0, 0, .125);
  margin: .8rem;
  text-align: center;

  img {
    height: 16rem;
    width: 18rem;
  }

  p {
    font-size: .8rem;
  }

  .title {
    font-weight: bold;
    margin-top: .5rem;
    font-size: 1rem;
  }

  div {
    display: flex;
    align-items: center;
    justify-content: center;
    padding: 0 1rem;

    p {
      font-size: 1rem;
      font-weight: bold;

      &:last-of-type {
        margin-left: 1rem;
      }
    }

    .promocao {
      margin-right: 1rem;
      text-decoration: line-through;
      color: var(--gray);
    }

    .desconto {
      color: var(--red);
    }
  }

  button {
    margin: .5rem 0 1rem;
  }
`;