import React, {Component} from 'react'
import { Link } from 'react-router-dom'

class SchoolClasses extends Component {
    constructor(props) {
        super(props)
        this.state = {
            loading: false,
            classes: [], 
            students: [],
            student: null
        }
    }

    componentDidMount() {
        this.setState({ loading: true })
        fetch('http://localhost:8090/students/class/2/',
        //localStorage.getItem("id") + '/teacher/' + this.props.match.params.subjectId + '/subject',
        // localStorage.getItem("id") + "/teacher/" + this.props.match.params.subjectId +"/subject",
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
                    schoolClasses: data
                })
        })
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
                        this.state.students.map(student =>
                            <tr key = {student.code} onClick={()=>this.props.history.push("/grading")}>
                                <td>{student.code}</td>
                                <td>{student.firstName}</td>
                                <td>{student.lastName}</td>
                            </tr>
                            )
                        }
                    </tbody>
                </table>
            </div>          
        )
    }
}

export default SchoolClasses