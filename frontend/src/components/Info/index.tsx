
import { Container } from './styles';

interface Props {
    breadCrumbs?: string[]
}

export default function Info({ breadCrumbs }: Props) {
    return (
        <Container>
            <li>
                { breadCrumbs ? (
                    <>
                        { breadCrumbs.map(breadCrumb => (
                            <ul key={Math.random()}>{breadCrumb}</ul>
                        ))}                        
                    </>
                ): (
                    "Cuco"
                )}
            </li>
        </Container>
    )
}