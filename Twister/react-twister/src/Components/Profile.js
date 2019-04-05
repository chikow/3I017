import React, { Component } from 'react';
import {Image, Navbar, Nav, Button, Row, Col} from "react-bootstrap";

import {Card} from "react-bootstrap";
import logo from "../logo.png";

class Profile extends Component {

    constructor(props){

        super(props)

        this.state = {
            //show twists, show followers, show following
            show: "twists",

        }

        this.showFollowers = this.showFollowers.bind(this)
        this.showFollowing = this.showFollowing.bind(this)
        this.showTwists = this.showTwists.bind(this)

        //data examples
        this.comment={username:"mohMidou",
            fullname:"Jean Michel",
            text:'Fadila Boumendjel Chitour, parle des revendication en matière des droits des femmes : « il ne faut se laisser pieger, c’est une priorité (...) le code la famille est un instrument qui légitime la violence » \n',
            likeCounter:50,
            date:'2h'}

        this.commentList=[this.comment,this.comment,this.comment]


        this.twist={
            text:"hello, dadzda dazdadad dadzadadadad adada",
            date:"3h",
            username:"Laka1",
            fullname:"aeert eadad",
            commentList:this.commentList,
            likeCounter: 120,
            commentCounter:23,
        }

        this.twistList=[this.twist,this.twist,this.twist]

        //followers / following data
        this.follower={
            username:this.twist.username,
            fullname:this.twist.fullname,
        }
        this.followerList=[this.follower,this.follower,this.follower]
    }

    showFollowers(){
        this.setState(
            {
                show:"followers"
            })
    }

    showFollowing(){
        this.setState(
            {
                show:"following"
            })
    }

    showTwists(){
        this.setState(
            {
                show:"twists"
            })
    }


    render() {
        const {show} =this.state
        return (
            <div>

                <div >
                    <Image src={logo} />
                    <Navbar bg="light" expand="xs">
                        <Image src="/img/test.jpg"/>

                        <Row>
                            <Col>
                                <div >
                                    <Card.Link  href="#zada" onClick={this.showTwists}>Twists</Card.Link>
                                    <Card.Link  href="#eae" onClick={this.showTwists}>25</Card.Link>
                                </div>
                            </Col>

                            <Col>
                                <div >
                                    <Card.Link href="#zada" onClick={this.showFollowers}>Abonnés</Card.Link>
                                    <Card.Link  href="#eae" onClick={this.showFollowers}>25</Card.Link>
                                </div>
                            </Col>

                            <Col>
                                <div >
                                    <Card.Link  href="#zada" onClick={this.showFollowing}>Abonnements</Card.Link>
                                    <Card.Link  href="#eae" onClick={this.showFollowing}>25</Card.Link>
                                </div>
                            </Col>

                        </Row>



                        <Button >Modifier profil</Button>
                        <Button >S'abonner</Button>
                    </Navbar>
                </div>

                <Row >
                    <Col  md="6">



                    </Col>
                </Row>

            </div>
        );
    }
}

export default Profile;
