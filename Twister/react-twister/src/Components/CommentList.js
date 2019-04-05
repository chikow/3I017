import React, { Component } from 'react';
import PropTypes from 'prop-types';
import Comment from "./Comments";
import {Button} from "react-bootstrap";
import {Card, CardBody, Collapse} from "reactstrap";



class CommentList extends Component {


    constructor(props) {
        super(props)

        this.state={
            commentList:this.props.comments,

        }

        // Binding functions to `this`

    }


    render() {
        const{commentList}=this.state
        return (
            <React.Fragment>
                <Button color="info" onClick={()=>this.setState({collapse:!this.state.collapse})} style={{ marginBottom: '1rem'}}>show comments</Button>
                <Collapse isOpen={this.state.collapse}>
                    <CardBody className="list-comment-button">
                        <Card>
                            <Comment comments={this.state.commentList}/>
                            <Comment comments={this.state.commentList}/>
                        </Card>
                    </CardBody>
                </Collapse>

            </React.Fragment>


        );
    }


}

export default CommentList;

CommentList.propTypes={
    commentList: PropTypes.arrayOf(PropTypes.String)
}