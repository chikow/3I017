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
        this.toggle = this.toggle.bind(this);
        this.state = {
            collapse: false,
            comments: this.props.comments,
            login: this.props.login
    };
    }

    toggle() {
        this.setState(state => ({ collapse: !state.collapse }));
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
                <Button color="primary" onClick={this.toggle} style={{ marginBottom: '1rem' }}>show comments</Button>
                <Collapse isOpen={this.state.collapse}>
                    <Card>
                        <CardBody className="list-comment-button">
                            {this.state.comments}
                        </CardBody>
                    </Card>
                </Collapse>
            </div>
        );
    }
}

