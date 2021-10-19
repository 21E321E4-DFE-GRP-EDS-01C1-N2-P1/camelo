import {Footer} from "../../components/Footer";
import {Header} from "../../components/Header";
import {Dashboard} from "../../components/Dashboard";

export default function Home() {
    return (
        <>
            <Header/>
            <h1>Hello Home</h1>
            <Dashboard/>
            <Footer/>
        </>
    );
}