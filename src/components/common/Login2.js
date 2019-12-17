import React, {Component} from 'react'

class Login2 extends Component {

    constructor(props) {
        super(props);
        this.state = {
            username: "",
            password: "",
            errorMessage: ""
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
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                username: this.state.username,
                password: this.state.password
            })
        };

        fetch('http://localhost:8090/users/login', requestOptions)
        .then(response => {
            if (response.ok) {
                response.json().then(data =>  {
                    this.setState({errorMessage: ''})
                    localStorage.setItem("user", btoa(data.username + ":" + data.password));
                    localStorage.setItem("id", data.id);
                    localStorage.setItem("role", data.role);
                    localStorage.setItem("firstName", data.firstName);
                    localStorage.setItem("lastName", data.lastName);
                    
//                    localStorage.getItem(("role" === "Teacher")) ?
                    this.props.history.push("/teacher/subjects") 
//                    :
//                    this.props.history.push("/teachers")
                }); 
            } else {
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
                    <input 
                        name = "username"
                        placeholder = "username"
                        value = {this.state.username} 
                        onChange = {this.handleInputChange} />
                    <br />
                    <input 
                        name = "password"
                        type = "password"
                        placeholder = "password"
                        value = {this.state.password}
                        onChange = {this.handleInputChange} />
                    <br />
                    <button className="btn1">Submit</button>
                    <label className="error">{this.state.errorMessage}</label>
                </form>
            </div>
        )
    }
}

export default Login2;