import React from 'react'
import {Button, Container, Media} from "react-bootstrap";
import {deepOrange} from "@material-ui/core/colors";
import Avatar from "@material-ui/core/Avatar";
import Grid from "@material-ui/core/Grid";
import twistersData from "./TwisterData"
import IconButton from "@material-ui/core/IconButton";
import DeleteIcon from '@material-ui/icons/Delete';


class Twisters extends React.Component{
    constructor(){
        super()
        this.state={
            twisterData: twistersData,
        }
    }

    render(){
        const avatarStyle = {
                margin: '10%',
                color: 'blue',
                backgroundColor: '',

        }
        const dateStyle = {
            color: 'grey',
            padding: '2px',
            fontSize: '65%'
        };
        const data = this.state.twisterData.map((twist, index) => <div key={index}>
            <Media className="MuiGrid-container-124" >
                <div >
                    <Grid container justify="center" alignItems="center" >
                        <Avatar style={avatarStyle}>{twist.login.substr(0, 1)}</Avatar>
                    </Grid>
                </div>
                <Media.Body >
                    <h5>
                        {twist.login}<br></br>
                        <span style={dateStyle}>{twist.date}</span>
                    </h5>

                    <p>
                        {twist.text}

                        <div className="DeleteButton">
                            <IconButton aria-label="Delete" >
                                <Button variant="secondary" size="small" color="secondary" onClick={()=>alert("Clicked!")}>
                                    Comment

                                </Button>
                                <DeleteIcon onClick={()=>{}} />
                            </IconButton>
                        </div>
                    </p>

                    <Media>
                        <div >
                            <Grid container justify="center" alignItems="center" >
                                <Avatar style={avatarStyle}>{twist.login.substr(0, 1)}</Avatar>
                            </Grid>
                        </div>
                        <Media.Body>
                            <h6>Media Heading</h6>
                            <p>
                                {twist.comments}
                                <div className="DeleteButton">
                                    <IconButton aria-label="Delete" >
                                        <DeleteIcon onClick={()=>{}} fontSize="small"/>
                                    </IconButton>
                                </div>
                            </p>
                        </Media.Body>
                    </Media>
                </Media.Body>
            </Media></div>)
        return(
          <div>
              <Container >
                  {data}
              </Container>
          </div>
        );
    }
}
export default Twisters