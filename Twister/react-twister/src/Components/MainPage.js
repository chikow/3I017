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
            isConnected : true,
            currentePage: "HomePage"
        }
        this.getConnected = this.getConnected.bind(this)
        this.setLogout = this.setLogout.bind(this)
        this.setProfilePage=this.setProfilePage.bind(this);
    }

    getConnected(key) {
        this.setState( {
            isConnected: true,
            currentePage: "HomePage",
        })
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
            <Router>
            <div>
                <div style={{position:'absolute'}}>
                    <SearchAppBar home={this.getConnected}/>
                </div>

                <Route exact path='/' render={(props) => this.state.isConnected ?<HomePage profile={this.setProfilePage} logout={this.setLogout} home={this.getConnected}/> : <LoginPage/>} />


                <div  className="grid">
                    {this.state.isConnected && this.state.currentePage==="ProfilePage" && <ProfilePage/>}
                </div>
            </div>
            </Router>
        )
    }

}
export default MainPage

