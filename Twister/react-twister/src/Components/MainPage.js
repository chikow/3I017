import React from 'react'
import LoginPage from './LoginPage'
import HomePage from './HomePage'
import SearchAppBar from './Navbar'
import {Button} from "react-bootstrap";
import ProfilePage from "./Profile";
class MainPage extends React.Component{
    constructor(){
        super()
        this.state = {
            isConnected : false,
            currentePage: "LoginPage"
        }
        this.getConnected = this.getConnected.bind(this)
        this.setLogout = this.setLogout.bind(this)
        this.setProfilePage=this.setProfilePage.bind(this);
    }

    getConnected() {
        this.setState( {
            isConnected: false,
            currentePage: "HomePage"
        })
    }
    setLogout () {
        this.setState({
            isConnected: false,
            currentePage: "LoginPage"
        })
    }
    setProfilePage(){
        this.setState({
            isConnected: true,
            currenctPage: "ProfilePage"

        })
    }

    render(){
        return (
            <div>
                <div>
                    <SearchAppBar home={this.getConnected}/>
                </div>
                {!this.state.isConnected&&<LoginPage/>}

                {this.state.isConnected && this.state.currentePage==="HomePage" &&<HomePage Profile={this.setProfilePage} Logout={this.setLogout} home={this.getConnected}/>}
                <div  className="grid">
                    {this.state.isConnected && this.state.currentePage==="ProfilePage" && <ProfilePage/>}
                </div>
            </div>
        )
    }

}
function test(){
    this.getConnected();
}
export default MainPage