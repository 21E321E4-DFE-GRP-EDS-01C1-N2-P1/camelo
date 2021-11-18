import styled from "styled-components";

export const Container = styled.div`
    width: 100vw;
    height: 50px;
    display: flex;
    flex-direction: row;
    justify-content: center;
    align-items: center;
    background-color: #F6F7F8;

    li {
        display: flex;
        flex-direction: row;
        text-decoration: none;
    }

    ul {
        max-width: 150px;
        margin: 0 10px;
        color: var(--blue);        

        &:hover {
            transition: filter 0.2s;
            cursor: pointer;
        }
    }        

    ul:last-child {
        color: var(--gray-dark);
    }
`;