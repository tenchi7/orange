import React, { Component } from 'react'

class UpdateTeacher extends Component {
    constructor(props) {
        super(props)
        this.state = {
            teacher: null
        }
    }

    componentDidMount() {
        const currentUser = localStorage.getItem("user");
        if(currentUser) {
            const requestOptions = {
                method: 'GET',
                headers: {
                    'Content-Type': 'application/json',
                    'Authorization': 'Basic ' + localStorage.getItem("user")
                }
            };
            fetch("http://localhost:8090/teachers" + "/" + this.props.match.params.id, requestOptions)
            .then(response => response.json())
            .then(data => {
                this.setState({category: data})
            });
        }else {
            this.props.history.push("/login");
        }
    }

    handleInputChange = (event) => {
        const target = event.target;
        const name = target.name;
        
        this.setState({
            teacher: {...this.state.teacher, [name]: target.value}
        });
    }    
    
    handleSubmit = (event) => {
        const requestOptions = {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
                'Authorization': 'Basic ' + localStorage.getItem("user")
            },
            body: JSON.stringify({
                code: this.state.teacher.code,
                firstName: this.state.teacher.firstName,
                lastName: this.state.teacher.lastName
            })
        };
        
        fetch( 'http://localhost:8090/teachers' + '/' + this.state.teacher.id, requestOptions )
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
            {
                this.state.teacher && 
                <form onSubmit = {this.handleSubmit}>
                    <label>
                        Change teacher's data: <br />
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
            }             
            </div>
           
        )
    }
}

export default UpdateTeacher
