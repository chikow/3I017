import React, { Component } from 'react';
import { Collapse, Button, CardBody, Card } from 'reactstrap';
import IconButton from "./Twisters";
import {Media} from "react-bootstrap";
import DeleteIcon from '@material-ui/icons/Delete';
import Grid from "@material-ui/core/Grid";
import Avatar from "@material-ui/core/Avatar";
export default class Comment extends Component {
    constructor(props) {
        super(props);

        this.state = {
            collapse: this.props.collapse,
            comments: this.props.comments,
            login: 'Neel'
    };
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
        return (
        <div>
            <Card>
                <div style={{'marginTop':'10px'}}>
                    <Grid container justify="flex-start" alignItems="center" >
                        <Avatar style={avatarStyle}>{this.state.login.substr(0, 1)}</Avatar>
                        {this.state.comments}
                    </Grid>
                </div>

                <div className="DeleteButton" >
                    <DeleteIcon  onClick={()=>alert("Click")} />
                </div>

            </Card>
        </div>
        );
    }
}

