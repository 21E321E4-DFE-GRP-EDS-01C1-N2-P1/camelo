import styled from 'styled-components';

export const Container = styled.header`
  background: var(--background);
`;

export const Content = styled.div`
  margin: 0 auto;
  padding: 2rem 6rem;
  display: flex;
  flex-direction: column;
`;

export const ProfileArea = styled.div`
  display: flex;
  align-items: center;
  justify-content: flex-end;
  margin-bottom: 1rem;

  section {
    display: flex;
    align-items: center;

    & + section {
      margin-left: 1rem;
    }

    span {
      margin-left: 1rem;
      font-size: .9rem;
    }

    svg {
      color: var(--text);
    }
  }
`;

export const NavigationArea = styled.div`
  display: flex;
  align-items: center;
  justify-content: space-between;

  ul { 
    display: flex;
    align-items: center;
    list-style-type: none;
  }

  li + li {
    margin-left: 5rem;
  }

  a {
    color: var(--text);
    text-decoration: none;
    text-transform: uppercase;
    font-size: 1.2rem;
    font-weight: 600;
  }
`;