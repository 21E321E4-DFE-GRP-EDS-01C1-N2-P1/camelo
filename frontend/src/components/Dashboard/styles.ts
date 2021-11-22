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