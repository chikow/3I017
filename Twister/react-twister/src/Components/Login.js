import React from 'react'
import Signup from '../NotUsedComponent/Signup'
import Modalsignup from './Modalsignup'
import {FormControl, InputGroup, Form, Button} from "react-bootstrap";
import ModalPasswordForgot from "./ModalPasswordForgot";
import axios from "axios";
class Login extends React.Component{
    constructor(props){
        super(props)
        this.state = {
            signUp: false,
            passwordForgot: false,
            login:'',
            mdp:'',
            key:"",
        }
        this.handleClickSignUp = this.handleClickSignUp.bind(this)
        this.handleClickPasswordForgot=this.handleClickPasswordForgot.bind(this)
        this.handleChange=this.handleChange.bind(this)
        this.handleClickLogin=this.handleClickLogin(this)

    }


    handleSubmit = event => {
        event.preventDefault();
        const params={
            login:this.state.login,
            mdp:this.state.mdp,

        }
        axios.post(`http://localhost:8080/Twister/Login`,null, {params}).then(res => {
            console.log(res);
            console.log(res.data);
            console.log(res.data.key)
            if(res.data.hasOwnProperty('key')){
                this.setState({key:  res.data.key})
            }
        })
    }

    handleChange(){
        this.setState({
            login:this.login.value,
            mdp:this.mdp.value,

        })
    }
    handleClickSignUp(){
      this.setState(PrevState =>{
         return {
             signUp: !PrevState.signUp
         }
      })
    }
    handleClickPasswordForgot() {
        this.setState(PrevState => {
            return {
                passwordForgot: !PrevState.passwordForgot
            }
        })
    }
    handleClickLogin= ()=>
    {if(this.state.key!=="");
        {}
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
                            ref={(login) => { this.login = login }}
                            onChange={this.handleChange}
                        />
                    </InputGroup>
                    <div>
                        <label htmlFor="inputPassword5">Password</label>
                        <input type="password" id="inputPassword5" className="form-control" aria-describedby="passwordHelpBlock"
                               ref={(mdp) => { this.mdp = mdp }} onChange={this.handleChange}/>
                        <small id="passwordHelpBlock" className="form-text text-muted">
                        </small>
                    </div>
                    <Form.Group controlId="formBasicChecbox">
                        <Form.Check type="checkbox" label="Check me out" />
                    </Form.Group>

                    <Button variant="contained" type="submit" id="logbouton"
                            onClick={this.handleSubmit}
                            style={{'color': 'cadetblue'}}>
                        Connect
                    </Button>
                </div>


                    <div>
                        <div><Button variant="light" id="logbouton"  onClick={this.handleClickPasswordForgot} style={{'color': 'cadetblue'}} >Forgot password?</Button></div>
                        <Button variant="light" onClick={this.handleClickSignUp} id='logbouton' style={{'color': 'cadetblue'}}>Sign up here!</Button>
                       {this.state.signUp&&<Modalsignup show={true}/>}
                        {this.state.passwordForgot&&<ModalPasswordForgot show={true}/>}
                    </div>
            </div>

        )
    }
}
export default Login