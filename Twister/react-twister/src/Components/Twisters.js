import React from 'react'
import {Button, ButtonGroup, Container, Dropdown, Media} from "react-bootstrap";
import Avatar from "@material-ui/core/Avatar";
import twistersData from "../Twist/TwisterData"

import CommentList from "./CommentList";
class Twisters extends React.Component{
    constructor(){
        super()
        this.state={
            twisterData: twistersData,
            listComments:[],
            collapse:false
        }
        this.changeValue=this.changeValue.bind(this)
    }
    changeValue(comment) {
        this.setState(state => {
            const list = state.listComments.push(comment)
        })
    }



    render() {
        const avatarStyle = {
            margin: '0px 10px',
            color: 'blue',
            backgroundColor: '',

        }
        const dateStyle = {
            color: 'grey',
            padding: '2px',
            fontSize: '65%'
        };
        const data = this.state.twisterData.map((twist, index) =>
            <div key={index} className="twister-div-media">
                <div style={{'paddingBottom': '0px', position: 'inherit'}}>

                    <Media className="Media">

                        <div style={{
                            padding: '16px',
                            'fontWeight': '500',
                            'boxSizing': 'border-box',
                            position: 'relative',
                            'whiteSpace': 'nowrap'
                        }}>

                            <div>
                                <div style={{'marginRight': '500px'}}>
                                    <div>
                                        <Avatar style={avatarStyle}>
                                            {twist.login.substr(0, 1)}
                                        </Avatar>
                                    </div>
                                </div>
                                <div style={{
                                    display: "inline-block",
                                    verticalAlign: 'top',
                                    whiteSpace: 'normal',
                                    paddingRight: "90px"
                                }}>
                                    <span style={{
                                        color: 'rgba(0, 0, 0, 0.87)',
                                        display: 'block',
                                        fontSize: '20px',
                                        marginLeft: '5px'
                                    }}>{twist.login}</span><br></br>
                                    <span style={{
                                        color: 'rgba(0, 0, 0, 0.54)',
                                        display: 'block',
                                        'fontSize': '14px',
                                        'marginTop': '-20px'
                                    }}>{twist.date}</span>
                                </div>
                            </div>

                            <div style={{position: 'absolute', right: '18px', top: '8px'}}>
                                <div style={{
                                    display: 'block',
                                    position: 'absolute',
                                    top: '0px',
                                    right: '4px',
                                    zIndex: '0'
                                }}>
                                    <div>
                                        <div className="edit-twist-button-toggle">
                                            <Dropdown as={ButtonGroup}>
                                                <Dropdown.Toggle split variant="info" id="dropdown-split-basic"/>
                                                <Dropdown.Menu>
                                                    <Dropdown.Item hred="#/action-1">Action</Dropdown.Item>
                                                    <Dropdown.Item hred="#/action-2">Another action</Dropdown.Item>
                                                    <Dropdown.Item hred="#/action-3">Something else</Dropdown.Item>
                                                </Dropdown.Menu>
                                            </Dropdown>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div style={{
                                display: 'inline-block',
                                'verticalAlign': 'none',
                                'whiteSpace': 'normal',
                                'paddingRight': '90px'
                            }}>
                                <p style={{
                                    padding: '10px',
                                    'fontSize': '14px',
                                    color: 'rgba(0, 0, 0, 0.87)',
                                    'overflowWrap': 'break-word'
                                }}>
                                    <span style={{'fontSize': '20px'}}>
                                        {twist.text}
                                    </span>
                                </p>
                            </div>
                            <div className="list-comment-button">

                                <CommentList comments = {twist.comments}/>
                            </div>
                        </div>
                    </Media>

                </div>
            </div>)
        return (
            <div>
                <Container>
                    {data}
                </Container>
            </div>
        );
    }
}

export default Twisters