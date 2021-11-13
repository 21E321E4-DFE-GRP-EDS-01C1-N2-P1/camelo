import styled from "styled-components";

export const Container = styled.div`
  h2 {
    text-align: center;
    margin: 2rem;
  }
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