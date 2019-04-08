import React, { Component } from 'react';
import {Image, Navbar, Nav, Button, Row, Col} from "react-bootstrap";

import {Card} from "react-bootstrap";
import logo from "../logo.png";

class Profile extends Component {

    showTwists(){
        this.setState(
            {
                show:"twists"
            })
    }


    render() {
        return (
            <div>

               <h1> Profile page</h1>

            </div>
        );
    }
}

export default Profile;
