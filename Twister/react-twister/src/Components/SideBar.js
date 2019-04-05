import React from 'react';

// sidebar.js
import { stack as Menu } from 'react-burger-menu';

export default class extends React.Component{
    constructor(props){
        super(props)

    }
    render() {
        const {home, Profile, Logout} = this.props
        return (
            <Menu>
                <a className="menu-item" href="/HomePage" onClick={home}>
                    Home Page
                </a>

                <a className="menu-item" href="#/Settings" onClick={Profile}>
                    Profile
                </a>


                <a className="menu-item" href="#/Settings" onClick={()=> alert("Settings")}>
                    Settings
                </a>
                <a className="menu-item" href="#/Settings">
                    About
                </a>
                <a className="menu-item" href="#/Settings" onClick={Logout}>
                    Logout
                </a>

            </Menu>
        );
    }
}
