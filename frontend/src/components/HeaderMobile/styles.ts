import styled from 'styled-components';

export const Container = styled.div`
  @media(min-width: 720px) {
      display: none;
  }

  background: var(--blue);
  margin: 0 auto;
  padding: 2rem;
`;

export const NavigationArea = styled.div`
  display: flex;
  align-items: center;
  justify-content: space-between;

  nav {
    display: flex;
    align-items: center;

    input {
      margin: 0 1rem;
    }

    svg {
      margin-left: .7rem;
      cursor: pointer;
      transition: filter 0.2s;
      color: white;

      &:hover {
        filter: opacity(0.6);
      }
    }
  }
`;