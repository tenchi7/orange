import React, { Component } from 'react';

class AddStudent extends Component {
    constructor(props) {
        super(props)
        this.state = {
            code: "",
            firstName: "",
            lastName: "",
            parentDto: {
                code: "",
                firstName: "",
                lastName: "",
                email: ""
            },           
            schoolClassDto: {
                code: ""
            },
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
        let parentDto = {...this.state.parentDto}
        let schoolClassDto = {...this.state.schoolClassDto}
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
        
        fetch('http://localhost:8090/students', requestOptions )
        .then(response => 
            {
                if(response.ok) {
                    response.json().then(data => {
                        this.setState({errorMessage: ''})
                        this.props.history.push("/students");
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
                            placeholder = "student's code"
                            value = {this.state.code} 
                            onChange = {this.handleInputChange} />
                        <br />
                        <input 
                            name = "firstName"
                            type = "text"
                            placeholder = "student's first name"
                            value = {this.state.firstName}
                            onChange = {this.handleInputChange} />
                        <br />
                        <input 
                            name = "lastName"
                            type = "text"
                            placeholder = "student's last name"
                            value = {this.state.lastName}
                            onChange = {this.handleInputChange} />
                        <br />
                    </label>
                    <label>
                        Parent info: <br />
                        <input 
                            name = "parentCode"
                            placeholder = "parent's code"
                            value = {this.state.parentDto.code} 
                            onChange = {this.handleInputChange} />
                        <br />
                        <input 
                            name = "parentFirstName"
                            type = "text"
                            placeholder = "parent's first name"
                            value = {this.state.parentDto.firstName}
                            onChange = {this.handleInputChange} />
                        <br />
                        <input 
                            name = "parentLastName"
                            type = "text"
                            placeholder = "parent's last name"
                            value = {this.state.parentDto.lastName}
                            onChange = {this.handleInputChange} />
                        <br />
                        <input 
                            name = "email"
                            type = "email"
                            placeholder = "last name"
                            value = {this.state.parentDto.email}
                            onChange = {this.handleInputChange} />
                        <br />
                    </label>
                    <label>
                        Select school class: <br />
                        <select
                        name="schoolClass"
                        value={this.state.schoolClassDto.code}
                        >
                        <option value="none">--please select class--</option>
                        <option value="I1">I1</option>
                        <option value="I2">I2</option>
                        <option value="II1">II1</option>
                    </select>
                    <br/>
                    </label>
                    <br />
                    <button>Submit</button>
                    <button onClick={()=>this.props.history.push("/students")}>Cancel</button>
                    <label className="error">{this.state.errorMessage}</label>
                </form>
            </div>
        )
    }
}

export default AddStudent