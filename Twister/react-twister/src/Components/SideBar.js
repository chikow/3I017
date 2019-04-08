import React from 'react';

// sidebar.js
import { stack as Menu } from 'react-burger-menu';

export default class extends React.Component{
    constructor(props){
        super(props)

    }
    render() {

        return (
            <Menu>
                <a className="menu-item" style={{fontSize:'35px'}} href="#/HomePage" onClick={this.props.home}>
                    Home Page
                </a>

                <a className="menu-item" style={{fontSize:'35px'}}href="#/ProfilePage" onClick={this.props.profile}>
                    Profile
                </a>


                <a className="menu-item" style={{fontSize:'35px'}} href="#/Settings" onClick={()=> alert("Settings")}>
                    Settings
                </a>
                <a className="menu-item" style={{fontSize:'35px'}} href="#/Settings">
                    About
                </a>
                <a className="menu-item" style={{fontSize:'35px'}} href="#/Login" onClick={this.props.logout}>
                    Logout
                </a>

            </Menu>
        );
    }
}
