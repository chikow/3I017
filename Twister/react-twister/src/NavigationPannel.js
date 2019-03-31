
import React from 'react'
import Login from './Login'
import Logout from './Logout'
import signUp from "./NotUsedComponent/Signup";
class NavigationPannel extends React.Component{
    constructor(props){
        super(props)
            this.state = {
                user:props.user,
                status:props.user.statee,
                login:props.user.login,
                logout:props.user.logout
                }
    }
    render() {
        const connected=this.state.status
        return (
            <div>
                <nav>
                    {connected? "true":"false"}
                    {connected?<Logout logout={this.props.logout}/>:<Login login={this.props.login}/>}
                </nav>
            </div>
        )
    }
}
export default NavigationPannel