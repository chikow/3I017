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
                <a className="menu-item" href="/">
                    Home Page
                </a>

                <a className="menu-item" href="#/Home">
                    Profile
                </a>

                <a className="menu-item" href="#/Settings">
                    Settings
                </a>
                <a className="menu-item" href="#/Settings">
                    About
                </a>
                <a className="menu-item" href="#/Settings" onClick={this.props.handle}>
                    Logout

                </a>

            </Menu>
        );
    }
}
