import React from 'react'
import Signup from './NotUsedComponent/Signup'
import Modalsignup from './Modalsignup'
import {FormControl, InputGroup, Form, Button} from "react-bootstrap";
class Login extends React.Component{
    constructor(props){
        super(props)
        this.state = {
            signUp: false
        }
        this.handleClick = this.handleClick.bind(this)
    }

        //this.handleChange=this.handleChange.bind(this)


    //handleChange(login, password) {
      //  this.setState(prevState => {
        //        this.state.login = login
          //      this.state.password = password
            //}
        //)
    //}

    handleClick(){
      this.setState(PrevState =>{
         return {
             signUp: !PrevState.signUp
         }
      })
    }

    render(){
        return (
            <div >
                <div>
                    <InputGroup className="mb-3">
                        <InputGroup.Prepend>
                            <InputGroup.Text id="basic-addon1">@</InputGroup.Text>
                        </InputGroup.Prepend>
                        <FormControl
                            placeholder="Username"
                            aria-label="Username"
                            aria-describedby="basic-addon1"
                        />
                    </InputGroup>
                    <div>
                        <label htmlFor="inputPassword5">Password</label>
                        <input type="password" id="inputPassword5" className="form-control" aria-describedby="passwordHelpBlock"/>
                        <small id="passwordHelpBlock" className="form-text text-muted">
                        </small>
                    </div>
                    <Form.Group controlId="formBasicChecbox">
                        <Form.Check type="checkbox" label="Check me out" />
                    </Form.Group>

                    <Button variant="contained" type="submit" id="logbouton">
                        Submit
                    </Button>
                </div>


                    <div>
                        <div><input type="submit" value="Mot de passe oublié ?" id="logbouton"/></div>
                        <Button variant="light" onClick={this.handleClick} id="logbouton">Sign up here!</Button>
                        <span>{this.state.signUp&&<Modalsignup show={true}/>}</span>
                    </div>
            </div>

        )
    }
}
export default Login