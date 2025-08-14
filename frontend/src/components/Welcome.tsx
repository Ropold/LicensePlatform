import welcomePic from "../assets/license-platform-logo.jpg"
import "./styles/Welcome.css";

type WelcomeProps = {
    language: string;
}

function getLanguageForWelcome(language: string): string {
    switch (language) {
        case "de": return "Willkommen";
        case "en": return "Welcome";
        case "pl": return "Witamy";
        case "es": return "Bienvenido";
        case "fr": return "Bienvenue";
        case "it": return "Benvenuto";
        case "cz": return "Vítejte";
        case "pt": return "Bem-vindo";
        case "hu": return "Üdvözöljük";
        case "nl": return "Velkommen";
        case "gr": return "Καλώς ήρθατε";
        case "ru": return "Добро пожаловать";
        default: return language;
    }
}

export default function Welcome(props: Readonly<WelcomeProps>) {

    return(
        <>
            <h2>License Platform</h2>
            <p>{getLanguageForWelcome(props.language)}</p>
            <div className="image-wrapper margin-top-20">
                <img
                    src={welcomePic}
                    alt="Welcome to License Platform"
                    className="logo-welcome"
                />
            </div>
        </>
    )
}