import {Footer} from "../../components/Footer";
import {Header} from "../../components/Header";
import {Dashboard} from "../../components/Dashboard";
import { HeaderMobile } from "../../components/HeaderMobile";

export default function Home() {
    return (
        <>
            <Header/>
            <HeaderMobile />
            <Dashboard/>
            <Footer/>
        </>
    );
}