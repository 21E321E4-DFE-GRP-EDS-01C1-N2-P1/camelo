import styled from "styled-components";

export const Container = styled.div`
  display: flex;
  flex-direction: column;  
  align-items: center;

  h2 {
    text-align: center;
    margin: 2rem;
  }
  text-align: center;

`;

export const DashboardMain = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;
  flex-wrap: wrap;
`;

export const DashboardHeader = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;
  flex-wrap: wrap;
  
  @media(min-width: 720px) {
    margin-top: -8rem;
  }
`;

export const PlataformInfo = styled.div`
  display: flex;
  flex-direction: row;
  align-items: center;
  margin-top: 50px;
  margin-bottom: 50px;

  img {
    width: 50px;
    height: 50px;
  }

`;

export const PlataformInfoItem = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  max-width: 250px;
`;

export const Footer = styled.div`
  display: flex;
  flex-direction: row;
  padding-top: 100px;
  align-content: center;
  align-self: center;
  
  width: 100%;
  height: 500px;
  background: var(--blue-light);
`;

export const FooterEmpresa = styled.div`
  display: flex;
  flex-direction: column;
  width: 200px;
  align-items: center;

  label {
    text-align: center;
  }

  div {
    display: flex;
    align-items: center;

    img {
      width: 50px;
      height: 50px;
    }
  }
`;

export const FooterSocial = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  width: 250px;

  div {
    display: flex;

    img {
      padding: 0 20px;
    }
  }
`;

export const FooterContato = styled.div`
  display: flex;
  flex-direction: column;
  width: 250px;
`;