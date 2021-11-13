import styled from 'styled-components';

export const Container = styled.footer`
  background: var(--background);
  /* position:fixed; */
  bottom:0;
  width:100%;
`;

export const Content = styled.div`
  display: flex;
  align-items: center;
  justify-content: space-around;
  border-top: 1px solid #e9e9e9;
`;

export const MenuItem = styled.section`
  display: flex;
  flex-direction: column;
  align-items: center;
  padding: 1rem;

  a { 
    text-decoration: none;
  }
`;