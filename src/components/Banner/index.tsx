import bannerImg from "../../assets/banner.svg";

import { BannerArea } from "./styles";

export function Banner() {
    return(
        <BannerArea style={{ backgroundImage: `url(${bannerImg})` }}>
            <h2>Super Flash Sale <br/> 50% off</h2>
        </BannerArea>
    );
}