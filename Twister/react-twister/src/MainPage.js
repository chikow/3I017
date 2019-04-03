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
            currentePage: ""
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
        this.setState({
            isConnected: false
        })
    }

    render(){
        return (
            <div>
                <div>
                    <SearchAppBar />
                </div>
                {!this.state.isConnected && <LoginPage/>}

                {this.state.isConnected && <HomePage handle={this.setLogout}/>}

            </div>
        )
    }

}
function test(){
    this.getConnected();
}
export default MainPage