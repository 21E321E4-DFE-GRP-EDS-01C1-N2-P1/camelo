import styled from "styled-components";

export const Container = styled.form`
  h2 { 
    color: var(--text);
    font-size: 1.5rem;
    margin-bottom: 2rem;
  }

  button[type=submit] {
    width: 100%;
    padding: 0 1.5rem;
    height: 3rem;
    background: var(--blue);
    color: var(--background);
    border-radius: 0.25rem;
    border: 0;
    font-size: 1rem;
    margin-top: 1.5rem;
    font-weight: bold;
    transition: filter 0.2s;

    &:hover {
      filter: brightness(0.9);
    }
  }

  .paymentSuccess {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
  }
`;