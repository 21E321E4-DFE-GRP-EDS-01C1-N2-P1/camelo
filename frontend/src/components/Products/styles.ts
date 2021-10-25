import styled from "styled-components";

export const Container = styled.section`
  
`;

export const Product = styled.section`
  border-radius: .3rem;
  border: 1px solid rgba(0, 0, 0, .125);
  margin: .8rem;
  text-align: center;

  img {
    height: 12rem;
    width: 16rem;
  }

  p {
    font-size: .8rem;
  }

  .title {
    font-weight: bold;
    margin-top: .5rem;
  }

  div {
    display: flex;
    align-items: center;
    justify-content: center;
    padding: 0 1rem 1rem;

    p:first-of-type {
      margin-right: 1rem;
      font-weight: bold;
      color: var(--blue);
    }

    p:last-of-type {
      text-decoration: line-through;
      color: var(--gray);
    }
  }
`;