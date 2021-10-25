import styled from "styled-components";

export const BannerArea = styled.div`
  background-size: cover;
  background-position: center;
  width: 100%;
  
  display: flex;
  align-items: center;
  justify-content: flex-start;

  h2 {
    font-weight: 700;
    font-size: 5rem;
    color: var(--background);
    margin: 13rem 9rem;
  }
`;