import styled from "styled-components";

export const Footer = styled.div`
  display: flex;
  flex-direction: row;
  padding: 3rem;
  align-items: center;
  justify-content: center;
  flex-wrap: wrap;
  width: 100%;
  background: var(--blue-light);
  margin-top: 2rem;
`;

export const FooterEmpresa = styled.div`
  display: flex;
  flex-direction: column;
  width: 250px;
  align-items: center;
  justify-content: center;
  margin-bottom: 1.5rem;

  label {
    text-align: center;
  }

  div {
    display: flex;
    align-items: center;
  }
`;

export const FooterSocial = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  margin-bottom: 1.5rem;
  width: 250px;

  div {
    display: flex;

    img {
      padding: 0 .5rem;
    }
  }
`;

export const FooterContato = styled.div`
  display: flex;
  flex-direction: column;
  width: 250px;
  align-items: center;
  justify-content: center;
`;