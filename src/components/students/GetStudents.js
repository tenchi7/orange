import React, { Component } from 'react'
import { Link } from 'react-router-dom'


class GetStudents extends Component {
    constructor(props) {
        super(props)
        this.state = {
            loading: false,
            display: false,
            student: null,
            students: []
        }
    }

    componentDidMount() {
        this.setState({ loading: true })
        fetch('http://localhost:8090/students',
            {
                method: 'GET',
                headers: {
                    'Content-Type': 'application/json',
                    'Authorization': 'Basic ' + localStorage.getItem("user")
                }
            })
            .then(response => response.json())
            .then(data => {
                this.setState({
                    loading: false,
                    students: data
                })
        })
    }

    updateCategory = (id) => {
        this.props.history.push("updateStudent/"+id);
    }

    deleteCategory = (id) => {
        const requestOptions = {
            method: 'DELETE',
            headers: {
                'Content-Type': 'application/json',
                'Authorization': 'Basic '+localStorage.getItem("user")
            }
        };
        fetch('http://localhost:8090/students/' + id, requestOptions)
        .then(response => {
            if (response.ok) {
                response.json().then(data => 
                    this.setState({students: this.state.students.filter(student => student.id!==data.id)})
                );
            }else {
                response.text().then(message => alert(message))
            }
        })
        .catch(error => console.log(error))
    };



    render() {
        const heading = ["Code", "First name", "Last name", ""]
        const loading = this.state.loading && "loading..."

        return (
            <div className="osnovno">
            
                <h4>{loading}</h4>

                <table>
                    <thead>
                        <tr>
                            {
                            heading.map((item, index) =>
                            <th key = {index} > {item}</th> )
                            }
                        </tr>
                    </thead>
                    <tbody>
                        {
                        this.state.students.map(student =>
                            <tr key = {student.code}>
                                <td>{student.code}</td>
                                <td>{student.firstName}</td>
                                <td>{student.lastName}</td>
                                <td><button className="btn2" onClick={()=>this.props.history.push("/grading")}>Grade</button></td>
                            </tr>
                            )
                        }
                    </tbody>
                </table>           
                <button className="btn1">
                    <Link to="/students/add">Add new student</Link>
                </button>
            </div>
        )
    }
}

export default GetStudents;