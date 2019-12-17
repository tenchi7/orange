import React, { Component } from 'react';

class AddTeacher extends Component {
    constructor(props) {
        super(props)
        this.state = {
            code: "",
            firstName: "",
            lastName: "",
            errorMessage: ""
        }
    }

    componentDidMount() {
        const currentUser = localStorage.getItem("user");
        if(!currentUser) {
            this.props.history.push("/login");
        }
    }

    handleInputChange = (event) => {
        const {name, value} = event.target
        this.setState({
            [name]: value
        })
    }

    handleSubmit = (event) => {
        const requestOptions = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                'Authorization': 'Basic ' + localStorage.getItem("user")
            },
            body: JSON.stringify({
                code: this.state.code,
                firstName: this.state.firstName,
                lastName: this.state.lastName,
            })
        };
        
        fetch('http://localhost:8090/teachers', requestOptions )
        .then(response => 
            {
                if(response.ok) {
                    response.json().then(data => {
                        this.setState({errorMessage: ''})
                        this.props.history.push("/teachers");
                    });
                }else {
                    response.text().then(message => this.setState({errorMessage: message}))
                }
            })
        .catch(error => console.log(error))
        event.preventDefault();
    };

    render() {
        return (
            <div className="osnovno">
                <form onSubmit = {this.handleSubmit}>
                    <label>
                        Student info: <br />
                        <input 
                            name = "code"
                            placeholder = "teacher's code"
                            value = {this.state.code} 
                            onChange = {this.handleInputChange} />
                        <br />
                        <input 
                            name = "firstName"
                            type = "text"
                            placeholder = "teacher's first name"
                            value = {this.state.firstName}
                            onChange = {this.handleInputChange} />
                        <br />
                        <input 
                            name = "lastName"
                            type = "text"
                            placeholder = "teacher's last name"
                            value = {this.state.lastName}
                            onChange = {this.handleInputChange} />
                        <br />
                    </label>
                    <button className="btn1">Submit</button>
                    <button className="btn1" onClick={()=>this.props.history.push("/teachers")}>Cancel</button>
                    <label className="error">{this.state.errorMessage}</label>
                </form>
            </div>
        )
    }
}

export default AddTeacher