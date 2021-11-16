
import {
    Spinner
} from './styles'

interface Props {
    enable: boolean;
}

export function Loader({ enable }: Props) {

    return enable ? (
        <Spinner />
    ) : (
        <>
        </>
    )
};