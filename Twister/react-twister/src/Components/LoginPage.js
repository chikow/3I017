import React from 'react'
import Login from "./Login"
import logo from "../logo.png"
class LoginPage extends React.Component {
    constructor(props) {
        super(props)
        this.state={
        }
    }


    render() {
        return (
            <div style={{'paddingTop': '60px'}}>
                <img className="logo" src={logo}/>
                <h1 style={{'paddingLeft':'675px', color:'cadetblue'}}> Welcome to Twister! </h1>
                <div className="Login-page">
                    <Login connecte={()=>this.props.connecte()} setUser={this.props.setUser}/>
                </div>
            </div>
        )
    }
}
export default LoginPage