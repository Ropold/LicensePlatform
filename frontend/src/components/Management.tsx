
type ManagementProps = {
    user: string | undefined;
    language: string;
}

export default function Management(props: Readonly<ManagementProps>) {
    return(
        <>
            <h2>Management</h2>
            <p>User: {props.user}</p>
        </>
    )
}