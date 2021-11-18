import styled from "styled-components";
import 'react-credit-cards/es/styles-compiled.css';

export const Container = styled.form`
  h2 { 
    color: var(--text);
    font-size: 1.5rem;
    margin-bottom: 2rem;
  }

  .first-input {
    margin-top: 2rem;
  }

  input {
    width: 100%;
    padding: 0 1.5rem;
    height: 2.6rem; 
    border-radius: 0.25rem;
    background: #FCFDFE;
    border: 1px solid #ced4da;
    font-weight: normal;

    &::placeholder {
      color: var(--gray-dark);
    }

    &:focus {
      outline: 1px solid var(--blue);
    }

    & + input {
      margin-top: 1rem;
    }
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
`;

export const Row = styled.form`
  margin: 1rem 0;
  display: grid;
  grid-template-columns: repeat(2, 1fr);
  gap: 0.5rem;

  input:last-of-type {
    margin: 0;
  }
`;