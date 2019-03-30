import React from 'react';

// sidebar.js
import { stack as Menu } from 'react-burger-menu';

export default props => {
    return (
        <Menu>
            <a className="menu-item" href="/">
                Home Page
            </a>

            <a className="menu-item" href="/Home">
                Profile
            </a>

            <a className="menu-item" href="/Settings">
                Settings
            </a>
            <a className="menu-item" href="/Settings">
                About
            </a>

        </Menu>
    );
};
