import styled from "styled-components";

export const Container = styled.div`
  width: 100vw;
  height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
  background-color: var(--blue);
`;

export const Content = styled.div`
  max-width: 400px;
  width: 100%;
  margin: 0 1rem;
  padding: 2rem;
  border: 1px solid #DFE0EB;
  background: var(--background);
  border-radius: .5rem;

  .heading {
    text-align: center;

    p {
      margin: 1rem 0 2rem;
    }

    h1 {
      margin-bottom: 1rem;
    }
  }

  h1 {
    color: var(--text);
  }
  
  p {
    color: var(--gray-dark);
  }
`;

export const Form = styled.form`
  display: flex;
  flex-direction: column;

  input {
    background: #FCFDFE;
    border: 1px solid #F0F1F7;
    box-sizing: border-box;
    border-radius: .5rem;
    height: 2.6rem;
    padding: 1rem;
    
    & + input {
      margin-top: 1rem;
    }

    &::placeholder {
      color: var(--gray-dark);
    }

    &:focus {
      outline: 1px solid var(--blue);
    }
  }

  button {
    border: 1px solid #DFE0EB;
    background: var(--blue);
    border-radius: .5rem;
    height: 2.6rem;
    color: var(--background);
    font-weight: bold;
    margin: 2rem 0;
    font-size: 1rem;
    transition: filter 0.2s;

    &:hover {
      filter: opacity(0.9);
    }
  }

  .auth-footer {
    display: flex;
    align-items: center;
    justify-content: center;

    a {
      margin-left: .5rem;
      color: var(--blue);
      font-weight: bolder;
      text-decoration: none;
    }
  }
`;