import {Button, Modal} from "react-bootstrap";
import React from 'react'



export default class ModalPasswordForgot extends React.Component {
    constructor(props) {
        super(props);

        this.handleShow = this.handleShow.bind(this);
        this.handleClose = this.handleClose.bind(this);

        this.state = {
            show: props.show,
        };
    }

    handleClose() {
        this.setState({ show: false });
    }

    handleShow() {
        this.setState({ show: true });
    }

    render() {
        return (
            <div>


                <Modal show={this.state.show} onHide={this.handleClose}>
                    <Modal.Header closeButton>
                        <Modal.Title>Password forgot</Modal.Title>
                    </Modal.Header>
                    <Modal.Body>
                        <form>
                            <span style={{'font-style':'italic', color:'cadetblue'}}>Merci d'indiquer l'adresse avec laquelle vous vous êtes inscrit. Un Email vous sera renvoyé. Vérifiez bien votre boite Spam si vous ne le recevez pas. En cas de complication, merci de nous contacter à l'adresse : twister.socialnetwork@gmail.com contactez nous.<br></br>   </span>
                            <div className="form-row">
                                <div className="col">
                                    <input type="text" className="form-control" placeholder="email"/>
                                </div>
                            </div>
                            <Button type="submit" className="btn-info">Valider</Button>
                        </form>
                    </Modal.Body>
                    <Modal.Footer>
                        <Button variant="secondary" onClick={this.handleClose}>
                            Close
                        </Button>
                    </Modal.Footer>
                </Modal>
            </div>
        )
    }
}
