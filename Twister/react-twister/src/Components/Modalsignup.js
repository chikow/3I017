import {Button, Modal} from "react-bootstrap";
import React from 'react'
class Modalsignup extends React.Component {
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
                        <Modal.Title>Welcome new member!</Modal.Title>
                    </Modal.Header>
                    <Modal.Body>
                        <form>
                            <div className="form-row">
                                <div className="col">
                                    <input type="text" className="form-control" placeholder="First name"/>
                                </div>
                                <div className="col">
                                    <input type="text" className="form-control" placeholder="Last name"/>
                                </div>
                            </div>
                            <div className="form-row">
                                <div className="form-group col-md-6">
                                    <label htmlFor="inputEmail4">Email</label>
                                    <input type="email" className="form-control" id="inputEmail4" placeholder="Email"/>
                                </div>
                                <div>
                                    <label htmlFor="inputPassword5">Password</label>
                                    <input type="password" id="inputPassword5" className="form-control" aria-describedby="passwordHelpBlock"/>
                                    <small id="passwordHelpBlock" className="form-text text-muted">
                                        Your password must be 8-20 characters long, contain letters and numbers, and must not
                                        contain spaces, special characters, or emoji.
                                    </small>
                                </div>
                            </div>
                            <div className="form-group">
                                <div className="form-check">
                                    <input className="form-check-input" type="checkbox" id="gridCheck"/>
                                    <label className="form-check-label" htmlFor="gridCheck">
                                        Check me out
                                    </label>
                                </div>
                            </div>
                            <button type="submit" className="btn btn-primary">Sign up</button>
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

export default Modalsignup;