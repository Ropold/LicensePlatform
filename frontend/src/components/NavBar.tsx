import axios from "axios";
import {useNavigate} from "react-router-dom";
import "./styles/Buttons.css"
import headerLogo from "../assets/logo-bechtle-small.svg"
import "./styles/NavBar.css";

type NavBarProps = {
    user: string | undefined;
    getUser: () => void;
    getUserDetails: () => void;
    language: string;
    setLanguage: React.Dispatch<React.SetStateAction<string>>
}

export default function NavBar(props: Readonly<NavBarProps>) {


    const navigate = useNavigate();

    function loginWithGithub() {
        const host = window.location.host === "localhost:5173" ? "http://localhost:8080" : window.location.origin;
        window.open(host + "/oauth2/authorization/github", "_self");
    }

    function logoutFromGithub() {
        axios
            .post("/api/users/logout")
            .then(() => {
                props.getUser();
                props.getUserDetails();
                navigate("/");
            })
            .catch((error) => {
                console.error("Logout failed:", error);
            });
    }


    return (
        <nav className="navbar">
            <div
                className="clickable-header"
                id="clickable-header"
                onClick={() => {
                    navigate("/");
                }}
            >
                <img src={headerLogo} alt="Bechtle Small Logo" className="logo-image" />
                <h2 className="header-title">Home</h2>
            </div>

            {props.user !== "anonymousUser" ? (
                <>
                    <button className="button-group-button" onClick={() => navigate("/management")}>Management</button>
                    <button className="button-group-button" onClick={() => navigate("/profile")}>Profile</button>
                    <button className="button-group-button" onClick={logoutFromGithub}>Logout</button>
                </>
            ) : (
                <button className="button-group-button" onClick={loginWithGithub}>Login with GitHub</button>
            )}
        </nav>
    );
}