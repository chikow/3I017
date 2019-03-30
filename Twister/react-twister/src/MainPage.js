import React from 'react'
import NavigationPannel from './NavigationPannel'
import LoginPage from './LoginPage'
import HomePage from './HomePage'
import SearchAppBar from './Navbar'
class MainPage extends React.Component{
    constructor(){
        super()
        this.state = {
            isConnected : false,
            currentePage: "HomePage"
        }
        this.getConnected = this.getConnected.bind(this)
        this.setLogout = this.setLogout.bind(this)
    }
    getConnected() {
        this.setState(()=> {
            return {isConnected: true}
        })
    }
    setLogout () {
        this.setState(()=> {
            return {isConnected: false}
        })
    }

    render(){
        return (
            <div>
                <div>
                    {<SearchAppBar/>}
                </div>
                <div>{this.state.currentePage=="LoginPage"&&<LoginPage/>}</div>
                <div>{this.state.currentePage=="HomePage"&&<HomePage/>}</div>

            </div>
        )
    }
}
export default MainPage