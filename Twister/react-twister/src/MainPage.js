import React from 'react'
import NavigationPannel from './NavigationPannel'
import LoginPage from './LoginPage'
import HomePage from './HomePage'
import SearchAppBar from './Navbar'
import {Button} from "react-bootstrap";
class MainPage extends React.Component{
    constructor(){
        super()
        this.state = {
            isConnected : true,
            currentePage: "HomePage"
        }
        this.getConnected = this.getConnected.bind(this)
        this.setLogout = this.setLogout.bind(this)
        this.handleOnclickLogin=this.handleOnclickLogin(this);
    }

    getConnected() {
        this.setState( {
            isConnected: true
        })
    }
    setLogout () {
        this.setState({
            isConnected: false
        })
    }
    handleOnclickLogin(){
        this.setState(prevState=>{
            return{isConnected: !this.state.isConnected}
        });
    }

    render(){
        return (
            <div>
                <div>
                    <SearchAppBar />
                </div>
                <div>{!this.state.isConnected&&<LoginPage/>}</div>
                <div>{this.state.currentePage=="LoginPage"&&<LoginPage />}</div>
                <div>{this.state.isConnected&&<HomePage handle={this.handleOnclickLogin}/>}</div>

            </div>
        )
    }

}
function test(){
    this.getConnected();
}
export default MainPage