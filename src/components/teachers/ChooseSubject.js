import React, {Component} from "react"

class ChooseSubject extends Component {

    constructor(props) {
        super(props)
        this.state = {
            subjects: []
        }
    }

    componentDidMount() {
        this.setState({ loading: true })
        fetch(("http://localhost:8090/teachers/subjects/" + localStorage.getItem("id")),
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
                    subjects: data
                });
            });
    }

    render() {
        const loading = this.state.loading && "loading..."
        return (           
            <div className="osnovno">
                <h4>{loading}</h4>
                <table>
                    <thead>
                        <tr>                           
                            <th>code</th><th>subject</th>                           
                        </tr>
                    </thead>
                    <tbody>
                        {
                        this.state.subjects.map(subject =>
                            <tr key = {subject.code}>
                                <td>{subject.code}</td>
                                <td onClick={()=>this.props.history.push("/students")}>{subject.name}</td>
                            </tr>
                            )
                        }
                    </tbody>             
                </table>
            </div>
        )
    }

}

export default ChooseSubject