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
        }
        this.OnAddTwist=this.OnAddTwist.bind(this)
    }
    OnAddTwist(){
        this.setState({
            addTwist:!this.state.addTwist,

        });
    }
    render(){
        return(
            <div >
                <div id="App">
                    <SideBar profile={this.props.profile} logout={this.props.logout} home={this.props.home}/>
                    <div id="page-wrap">
                    </div>
                </div>

'
                <div className="grid">
                <div style={{"maxWidth": "700px","minWidth": "100px", 'flex': '0 0 50%', 'flexGrow': '1'}}>
                    <button className="add-twister-div" onClick={()=> this.OnAddTwist()}>
                        <SvgIcons >
                            <circle/>
                        </SvgIcons>
                        <h5 style={{'fontWeight':'10%'}}>
                            Click me to add a twister!
                        </h5>
                        <div className="add-twist-icon">
                            {this.props.user.substr(0, 1)}
                        </div>
                    </button>
                    {this.state.addTwist?<AddTwistModalVersion modalAddTwist={this.state.addTwist} />:''}
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