import React from 'react'

import Login from "./Login";
import logo from "../logo.png"
class LoginPage extends React.Component {
    constructor() {
        super()
        this.state={
            signUp: false
        }
    }


    render() {
        return (
            <div >
                <img className="logo" src={logo}/>
                <div className="Login-page"><Login/></div>
            </div>
        )
    }
}
export default LoginPage