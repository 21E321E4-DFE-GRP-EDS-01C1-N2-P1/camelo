import styled from 'styled-components';

export const Spinner = styled.div`
    border: 6px solid var(--gray-dark);
    border-top: 6px solid var(--background);
    border-radius: 50%;
    width: 50px;
    height: 50px;
    animation: spin 2s linear infinite;

    @keyframes spin {
        0% { transform: rotate(0deg); }
        100% { transform: rotate(360deg); }
    }
`;