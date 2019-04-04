import React from 'react'
import {Button, ButtonGroup, Container, Dropdown, Media} from "react-bootstrap";
import {deepOrange} from "@material-ui/core/colors";
import Avatar from "@material-ui/core/Avatar";

import twistersData from "../Twist/TwisterData"
import IconButton from "@material-ui/core/IconButton";

import EditIcon from '../NotUsedComponent/EditIcon'
import Comment from './Comments.js'
class Twisters extends React.Component{
    constructor(){
        super()
        this.state={
            twisterData: twistersData,
            listComments:[]
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
                <div style={{'padding-bottom': '0px', position: 'inherit'}}>

                    <Media className="Media">

                        <div style={{
                            padding: '16px',
                            'font-weight': '500',
                            'box-sizing': 'border-box',
                            position: 'relative',
                            'white-space': 'nowrap'
                        }}>

                            <div>
                                <div style={{'margin-right': '500px'}}>
                                    <grid>
                                        <Avatar style={avatarStyle}>
                                            {twist.login.substr(0, 1)}
                                        </Avatar>
                                    </grid>
                                </div>
                                <div style={{
                                    display: "inline-block",
                                    "vertical-align": 'top',
                                    "white-space": 'normal',
                                    "padding-right": "90px"
                                }}>
                                    <span style={{
                                        color: 'rgba(0, 0, 0, 0.87)',
                                        display: 'block',
                                        'font-size': '20px',
                                        'margin-left': '5px'
                                    }}>{twist.login}</span><br></br>
                                    <span style={{
                                        color: 'rgba(0, 0, 0, 0.54)',
                                        display: 'block',
                                        'font-size': '14px',
                                        'margin-top': '-20px'
                                    }}>{twist.date}</span>
                                </div>
                            </div>

                            <div style={{position: 'absolute', right: '18px', top: '8px'}}>
                                <div style={{
                                    display: 'block',
                                    position: 'absolute',
                                    top: '0px',
                                    right: '4px',
                                    'z-index': '0'
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
                                    <div style={{display: 'none'}}></div>
                                </div>
                            </div>
                            <div style={{
                                display: 'inline-block',
                                'vertical-align': 'none',
                                'white-space': 'normal',
                                'padding-right': '90px'
                            }}>
                                <p style={{
                                    padding: '10px',
                                    'font-size': '14px',
                                    color: 'rgba(0, 0, 0, 0.87)',
                                    'overflow-wrap': 'break-word'
                                }}>
                                    <span style={{'font-size': '20px'}}>
                                        {this.state.text}heeeeeeeeeeeeeeeeere
                                    </span>
                                </p>
                            </div>
                            <div className="list-comment-button">
                                {this.changeValue(twist.comments)}
                                {this.state.listComments.map((comment, index) => <div><Comment key={index} comments={comment.comments}/></div>)}
                                {this.state.listComments}
                                <Comment comments={twist.comments}/>
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