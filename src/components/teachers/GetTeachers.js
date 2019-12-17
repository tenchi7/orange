import React, {Component} from 'react'
import { Link } from 'react-router-dom'

class GetTeachers extends Component {

    constructor(props) {
        super(props)
        this.state = {
            loading: false,
            teachers: []
        }
    }

    componentDidMount() {
        this.setState({ loading: true })
        fetch('http://localhost:8090/teachers',
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
                    teachers: data
                })
        })
    }

    updateCategory = (id) => {
        this.props.history.push("/teacher/update/" + this.props.match.params.id);
    }

    render() {
        const loading = this.state.loading && "loading..."
        const heading = ["Code", "First name", "Last name", ""];

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
                        this.state.teachers.map(teacher =>
                            <tr key = {teacher.id}>
                                <td>{teacher.code}</td>
                                <td>{teacher.firstName}</td>
                                <td>{teacher.lastName}</td>
                                <td><button className="btn2" onClick={this.updateCategory}>Update</button></td>
                            </tr>
                        )}
                    </tbody>
                </table>
                <button className="btn1">
                    <Link to="/teachers/add">Add new Teacher</Link>
                </button>
            </div>          
        )
    }
}

export default GetTeachers