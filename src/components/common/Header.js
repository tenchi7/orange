import React, { Component } from 'react';
import { Link, withRouter } from 'react-router-dom';

class Header extends Component {

    logout = () => {
        localStorage.clear(); 
        this.props.history.push("/login");
    }
    
    render() {

        return (
        <header>
                <img 
                    src="https://www.graphicsprings.com/filestorage/stencils/e035a4a8cbeb7f7df1182aef9751539a.png?width=500&height=500" 
                    alt="home" 
                    onClick={()=>this.props.history.push("/teachers")}/>       
            {
            localStorage.getItem("user") ? 

                <button className="btn1" onClick={this.logout}>Logout</button>                           
            :
                <button className="btn1">
                    <Link to="/login">Login</Link>        
                </button>
            }
        </header>
        )
    }
};

export default withRouter(Header);