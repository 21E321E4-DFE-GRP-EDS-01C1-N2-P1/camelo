
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
                            <ul>{breadCrumb}</ul>
                        ))}                        
                    </>
                ): (
                    "Cuco"
                )}
            </li>
        </Container>
    )
}