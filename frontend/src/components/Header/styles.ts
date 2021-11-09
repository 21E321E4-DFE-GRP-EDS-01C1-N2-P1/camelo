import styled from 'styled-components';

export const Container = styled.header`
  background: var(--background);

  .bannerArea > img {
    width: 100%;
  }
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

  nav {
    display: flex;
    align-items: center;

    input {
      margin: 0 1rem;
    }

    a {
      color: var(--blue);
    }

    svg {
      margin-left: .7rem;
      cursor: pointer;
      transition: filter 0.2s;

      &:hover {
        filter: opacity(0.6);
      }
    }
  }

  a {
    color: var(--text);
    text-decoration: none;
    text-transform: uppercase;
    font-size: 1.2rem;
    font-weight: 600;
  }

  input {
    padding: .5rem 1.5rem;
    height: 2.5rem;
    border-radius: 0.25rem;
    background: var(--gray-light);
    border: 1px solid #d7d7d7;

  }

  button {
    padding: 0 1.5rem;
    height: 2.5rem;
    background: var(--blue);
    color: var(--background);
    border: 0;
    border-radius: 0.25rem;
    font-size: 1rem;
    transition: filter 0.2s;

    &:hover {
      filter: opacity(0.9);
    }
  }
`;