import React from 'react'
import LoginPage from './LoginPage'
import HomePage from './HomePage'
import SearchAppBar from './Navbar'
import {BrowserRouter as Router, Redirect, Route} from 'react-router-dom'
import ProfilePage from "./Profile";
class MainPage extends React.Component{
    constructor(props){
        super(props)
        this.state = {
            user:"",
            isConnected : true,
            currentePage: "HomePage"
        }
        this.getConnected = this.getConnected.bind(this)
        this.setLogout = this.setLogout.bind(this)
        this.setProfilePage=this.setProfilePage.bind(this);
        this.setUser=this.setUser.bind(this)
    }
    setUser(value){
        this.setState({user:value})
        alert(this.state.user)
    }
    getConnected() {
        console.log(this.isConnected);
        this.setState( {
            isConnected: true,
            currentePage: "HomePage",
        })


        console.log(this.isConnected);
    }
    setLogout(){
        this.setState({
            isConnected: false,
            currentePage: "LoginPage"
        })
    }
    setProfilePage(){
        this.setState({
            isConnected: true,
            currentePage: "ProfilePage",

        })
    }

    render(){
        return (

            <div>
                <div style={{position:'absolute'}}>
                    <SearchAppBar home={this.getConnected}/>
                </div>

                {this.state.isConnected ?<HomePage profile={this.setProfilePage} logout={this.setLogout} home={this.getConnected} user={this.state.user}/> : <LoginPage connecte={()=>this.getConnected()} setUser={this.setUser}/>}


                <div  className="grid">
                    {this.state.isConnected && this.state.currentePage==="ProfilePage" && <ProfilePage/>}
                </div>
            </div>

        )
    }

}
export default MainPage

