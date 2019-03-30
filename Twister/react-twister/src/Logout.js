import React from 'react'

class Logout extends React.Component{
    constructor(props){
        super(props)
        this.state={
            logout: props.logout,
            log: "no"
        }
    }
    render(){
        return (
            <div>
                <button onClick={()=> this.setState(prevStat =>{ return {etat:!prevStat.etat, log:this.state.etat?"yes":"no"}})}>Logout:{this.state.log}</button>
            </div>
        )
    }
}
export default Logout