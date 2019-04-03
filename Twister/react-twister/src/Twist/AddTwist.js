import React from 'react'
import SvgIcons from './IconPhoto'
class AddTwist extends React.Component{
    constructor(props){
        super(props)
            this.state = {
                user:"Delpax"
           }
    }



render(){
        return(
            <div>
            <div className="add-twister-div">
            <div>
                <span className="add-twister-span">
                    <div>
                        <div style={{"margin-left": "0px", padding: "20px 56px 20px 72px",position: "relative"}}>
                            <SvgIcons >
                                <circle >0</circle>
                            </SvgIcons>
                            <div className="add-twist-icon">
                                {this.state.user.substr(0, 1)}
                            </div>
                            <span style={{color: "rgb(189, 189, 189)", cursor: "text"}}>
                                <textarea className="add-twist-text-area"></textarea>
                            </span>
                        </div>
                    </div>
                </span>
            </div>
            </div>
            </div>
            )
    }

}

export default AddTwist