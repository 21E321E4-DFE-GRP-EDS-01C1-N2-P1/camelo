import {Footer} from "../../components/Footer";
import {Header} from "../../components/Header";
import {Dashboard} from "../../components/Dashboard";
import { HeaderMobile } from "../../components/HeaderMobile";
import { Banner } from "../../components/Banner";
import { FooterDesktop } from "../../components/FooterDesktop";

export default function Home() {
    return (
        <>
            <Header/>
            <Banner/>
            <HeaderMobile />
            <Dashboard/>
            <FooterDesktop />
            <Footer/>
        </>
    );
}