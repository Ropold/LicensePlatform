import type {UserDetails} from "./model/UserDetailsModel.ts";

type ProfileProps = {
    user: string | undefined;
    userDetails: UserDetails | null;
    language: string;
}

export default function Profile(props: Readonly<ProfileProps>) {
    return (
        <div>
            <h2>Profile</h2>
            <p>User: {props.user}</p>
        </div>
    );
}