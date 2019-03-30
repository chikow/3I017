import React from 'react';
import SideBar from './SideBar'
import Twisters  from './Twisters'
class HomePage extends React.Component{
    constructor(props){
        super(props)
        this.state={

        }
    }

    render(){
        return(
            <div>
                <div id="App">
                    <SideBar />
                    <div id="page-wrap">
                    </div>
                </div>
                <div className="animate-Twister">
                <Twisters/>
                    On s'occupera de ça plus tard !!
                </div>

            </div>
        )
    }
}

export default HomePage