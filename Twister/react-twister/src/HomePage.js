import React from 'react';
import SideBar from './SideBar'
import Twisters  from './Twist/Twisters'
import AddTwist from "./Twist/AddTwist";
import {Button} from "react-bootstrap";
class HomePage extends React.Component{
    constructor(props){
        super(props)

    }

    render(){
        return(
            <div >
                <div id="App">
                    <SideBar handle={this.props.handle}/>
                    <div id="page-wrap">
                    </div>
                </div>
'
                <div className="grid">
                <div style={{"max-width": "550px","min-width": "100px", 'flex': '0 0 50%', 'flex-grow': '1'}}>
                    <div >
                        <AddTwist/>
                    </div>
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