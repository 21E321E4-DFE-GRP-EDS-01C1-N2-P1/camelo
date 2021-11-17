
import {
    Container,
    Spinner
} from './styles'

interface Props {
    enable: boolean;
}

export function Loader({ enable }: Props) {

    return enable ? (
        <Container>
            <Spinner />
        </Container>
    ) : (
        <>
        </>
    )
};