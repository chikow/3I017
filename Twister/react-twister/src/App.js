import React, { Component } from 'react';
import './App.css';
import 'bootstrap/dist/css/bootstrap.css';
import MainPage from "./Components/MainPage";
import AddTwistModalVersion from "./Components/AddTwistModalVersion";
class App extends Component {
  render() {
    return (
      <div className="App">
        <MainPage/>
      </div>
    );
  }
}

export default App;
