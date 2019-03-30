import React from 'react'
import {Container, Media} from "react-bootstrap";
import {deepOrange} from "@material-ui/core/colors";
import Avatar from "@material-ui/core/Avatar";
import Grid from "@material-ui/core/Grid";

const styles = {
    avatar: {
        margin: 10,
    },
    orangeAvatar: {
        margin: 10,
        color: '#fff',
        backgroundColor: deepOrange[500],
    }
}
class Twisters extends React.Component{
    constructor(){
        super()
    }

    render(){
        return(
          <div>
              <Container>
                  <div>
                      Ajouter ici la bare de partage twister!
                  </div>
              <Media className="MuiGrid-container-124" >
                  <div >
                    <Grid container justify="center" alignItems="center" >
                          <Avatar className={styles.orangeAvatar}>N</Avatar>
                    </Grid>
                  </div>
                  <Media.Body>
                      <h5>Media Heading</h5>
                      <p>
                          Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque
                          ante sollicitudin commodo. Cras purus odio, vestibulum in vulputate at,
                          tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla.
                          Donec lacinia congue felis in faucibus.
                      </p>
                      <h5>Media Heading</h5>
                      <p>
                          Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque
                          ante sollicitudin commodo. Cras purus odio, vestibulum in vulputate at,
                          tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla.
                          Donec lacinia congue felis in faucibus.
                      </p>
                      <h5>Media Heading</h5>
                      <p>
                          Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque
                          ante sollicitudin commodo. Cras purus odio, vestibulum in vulputate at,
                          tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla.
                          Donec lacinia congue felis in faucibus.
                      </p>
                      <h5>Media Heading</h5>
                      <p>
                          Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque
                          ante sollicitudin commodo. Cras purus odio, vestibulum in vulputate at,
                          tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla.
                          Donec lacinia congue felis in faucibus.
                      </p>
                      <h5>Media Heading</h5>
                      <p>
                          Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque
                          ante sollicitudin commodo. Cras purus odio, vestibulum in vulputate at,
                          tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla.
                          Donec lacinia congue felis in faucibus.
                      </p>
                      <h5>Media Heading</h5>
                      <p>
                          Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque
                          ante sollicitudin commodo. Cras purus odio, vestibulum in vulputate at,
                          tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla.
                          Donec lacinia congue felis in faucibus.
                      </p>
                      <h5>Media Heading</h5>
                      <p>
                          Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque
                          ante sollicitudin commodo. Cras purus odio, vestibulum in vulputate at,
                          tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla.
                          Donec lacinia congue felis in faucibus.
                      </p>
                      <Media>
                          <div >
                              <Grid container justify="center" alignItems="center" >
                                  <Avatar className={styles.orangeAvatar}>N</Avatar>
                              </Grid>
                          </div>
                          <Media.Body>
                              <h5>Media Heading</h5>
                              <p>
                                  Cras sit amet nibh libero, in gravida nulla. Nulla vel metus
                                  scelerisque ante sollicitudin commodo. Cras purus odio, vestibulum in
                                  vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi
                                  vulputate fringilla. Donec lacinia congue felis in faucibus.
                              </p>
                          </Media.Body>
                      </Media>
                  </Media.Body>
              </Media>
              </Container>
          </div>
        );
    }
}
export default Twisters