import React from 'react';
import SideBar from './SideBar'
import Twisters  from './Twist/Twisters'
class HomePage extends React.Component{
    constructor(props){
        super(props)
        this.state={
            isConnected:props.handle
        }
    }

    render(){
        return(
            <div>
                <div id="App">
                    <SideBar handle={this.props.handle}/>
                    <div id="page-wrap">
                    </div>
                </div>
                <div className="animate-Twister">
                <Twisters/>
                {this.state.isConnected?"":"On s'occupera de ça plus tard !!"}
                </div>


            </div>
        )
    }
}

export default HomePage