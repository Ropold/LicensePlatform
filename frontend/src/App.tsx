import {useEffect, useState} from 'react'
import './App.css'
import NavBar from "./components/NavBar.tsx";
import {Route, Routes} from "react-router-dom";
import Footer from "./components/Footer.tsx";
import NotFound from "./components/NotFound.tsx";
import Welcome from "./components/Welcome.tsx";
import ProtectedRoute from "./components/ProtectedRoute.tsx";
import Profile from "./components/Profile.tsx";
import Management from "./components/Management.tsx";
import axios from "axios";
import type {UserDetails} from "./components/model/UserDetailsModel.ts";

export default function App() {
    const [user, setUser] = useState<string>("anonymousUser");
    const [userDetails, setUserDetails] = useState<UserDetails | null>(null);

    const [language, setLanguage] = useState<string>("de");


    function getUser() {
        axios.get("/api/users/me")
            .then((response) => {
                setUser(response.data.toString());
            })
            .catch((error) => {
                console.error(error);
                setUser("anonymousUser");
            });
    }

    function getUserDetails() {
        axios.get("/api/users/me/details")
            .then((response) => {
                setUserDetails(response.data as UserDetails);
            })
            .catch((error) => {
                console.error(error);
                setUserDetails(null);
            });
    }


    useEffect(() => {
        getUser();
    }, []);

    useEffect(() => {
        if(user !== "anonymousUser"){
            getUserDetails();
        }
    }, [user]);


  return (
    <>
        <NavBar user={user} getUser={getUser} getUserDetails={getUserDetails} language={language} setLanguage={setLanguage}/>
        <Routes>
            <Route path="*" element={<NotFound />} />
            <Route path="/" element={<Welcome language={language}/>}/>
            <Route element={<ProtectedRoute user={user}/>}>
                <Route path="/management" element={<Management user={user} language={language} />} />
                <Route path="/profile/*" element={<Profile user={user} userDetails={userDetails} language={language} />} />
            </Route>
        </Routes>
        <Footer/>
    </>
  )
}
