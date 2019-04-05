import React from 'react';
import SideBar from './SideBar'
import Twisters  from './Twisters'
import AddTwist from "../NotUsedComponent/AddTwist";
import {Button} from "react-bootstrap";
import SvgIcons from './IconPhoto'
import AddTwistModalVersion from "./AddTwistModalVersion";
class HomePage extends React.Component{
    constructor(props){
        super(props)
        this.state = {
            modalAddTwist:false,
            user:'Delpax'
        }
        this.OnAddTwist=this.OnAddTwist.bind(this)
    }
    OnAddTwist(){
        this.setState({
            addTwist:!this.state.addTwist
        });
    }
    render(){
        return(
            <div >
                <div id="App">
                    <SideBar Profile={this.props.Profile} Logout={this.props.Logout} home={this.props.home}/>
                    <div id="page-wrap">
                    </div>
                </div>
'
                <div className="grid">
                <div style={{"max-width": "700px","min-width": "100px", 'flex': '0 0 50%', 'flex-grow': '1'}}>
                    <button className="add-twister-div" onClick={()=> this.OnAddTwist()}>
                        <SvgIcons >
                            <circle/>
                        </SvgIcons>
                        <h5 Style={{'font-weight':'10%'}}>
                            Click me to add a twister!
                        </h5>
                        <div className="add-twist-icon">
                            {this.state.user.substr(0, 1)}
                        </div>
                    </button>
                    {this.state.addTwist?<AddTwistModalVersion modalAddTwist={this.state.addTwist}/>:''}
                    <div className="animate-Twister">
                    <Twisters/>
                    </div>
                </div>
                </div>

            </div>
        )
    }
}

export default HomePage