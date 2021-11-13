import styled from "styled-components";

export const Product = styled.div`
  background-size: cover;
  background-position: center;
  height: 20rem;
  width: 20rem;
  border-radius: .3rem;
  
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: space-between;
  padding: 1rem;
  margin: 1rem;
`;

export const Header = styled.div`
  div {
    display: flex;
    
    p {
      text-decoration: line-through;
      color: var(--text);
      font-weight: bold;
      font-size: 1.1rem;
      
      & + p {
        margin-left: 1rem;
        text-decoration: none;
        color: var(--red);
        font-weight: bold;
      }
    }
  }
`;

export const Footer = styled.div`
    display: flex;
    flex-direction: column;
    align-items: center;


  p {
    font-weight: bold;
    color: var(--text2);
    font-size: 1.4rem;
  }
`;