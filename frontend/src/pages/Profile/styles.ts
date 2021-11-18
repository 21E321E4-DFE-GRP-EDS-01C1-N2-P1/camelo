import styled from "styled-components";

export const Container = styled.div`
  @media(pointer: fine) {
    width: 100vw;
    height: 100vh;
  }

  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  background-color: #faf3ef;
`;

export const Card = styled.div`
  @media(pointer: coarse) {
    margin: 1rem;
  }

  border-radius: 12px;
  box-shadow: 0 6px 10px -4px rgb(0 0 0 / 15%);
  background-color: #fff;
  color: #252422;
  margin-bottom: 20px;
  border: 0;
  display: flex;
  flex-direction: column;
  background-color: #fff;
  border: 1px solid rgba(0,0,0,.125);
  border-radius: 0.25rem;
  padding: 2rem;

  form {
    display: flex;
    flex-direction: column;
  }

  .row {
    display: flex;
    align-items: center;
  }

  @media(max-width: 720px) {
    .row {
      display: flex;
      flex-direction: column;
      align-items: center;
      flex-wrap: wrap;
    }

    .buttonProfile {
      button {
        width: 100%;
      }
    }
  }

  @media(min-width: 720px) {
    .buttonProfile {
      button {
        padding: 0 2rem;
      }
    }
  }

  .column {
    display: flex;
    flex-direction: column;
    justify-content: center;
    margin: .5rem;
  }

  input {
    background: #FCFDFE;
    border: 1px solid #ced4da;
    box-sizing: border-box;
    border-radius: .5rem;
    height: 2.6rem;
    padding: 1rem;
    width: 100%;

    &::placeholder {
      color: var(--gray-dark);
    }

    &:focus {
      outline: 1px solid var(--blue);
    }
  }

  .buttonProfile {
    display: flex;
    justify-content: center;

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
  }
`;

export const CardArea = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;  
  flex-wrap: wrap;
  margin-bottom: 2rem;
`;