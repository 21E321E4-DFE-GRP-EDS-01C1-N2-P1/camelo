import styled from "styled-components";

export const Button = styled.button`
  display: flex;
  align-items: center;
  justify-content: center;
  padding: 0 1rem;
  height: 2rem;
  background: #3181FF;
  color: var(--background);
  border: 0;
  border-radius: 0.25rem;
  font-size: 1rem;
  transition: filter 0.2s;

  &:hover {
    filter: opacity(0.9);
  }

  svg {
    margin-right: 0.5rem;
  }
`;