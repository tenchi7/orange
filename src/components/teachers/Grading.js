import React, {Component} from "react"

class Grading extends Component {

    constructor(props) {
        super(props)
        this.state = {
            checked: false,
            mark: "",
            markType: ""
        }
    }

    handleChange = (event) => {
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
                mark: this.state.mark,
                markType: this.state.markType
            })
        };

        fetch('http://localhost:8090/grading', requestOptions)
            .then(response => {
            if (response.ok) {
                response.json().then(data =>  {
                this.setState({errorMessage: ""})
                this.props.history.push("/"); 
            }); 
            } else {
                response.text().then(message => this.setState({errorMessage: message}))
            }
            })
        .catch(error => console.log(error))
        event.preventDefault()
    }

    render() {
        return(
            <div>
                <form className="grading" onSubmit="handleSubmit">

                <label>Grade:
                    <br/>
                    <div className="ocene">
                        <label> 1
                            <input
                                type="radio"
                                name="grading"
                                value="1"
                                checked={this.state.checked === "1"}
                                onChange={this.handleChange}
                                />
                        </label>
                        <label> 2
                            <input
                                type="radio"
                                name="grading"
                                value="2"
                                checked={this.state.checked === "2"}
                                onChange={this.handleChange}
                                /> 
                            </label>
                        <label> 3
                            <input
                                    type="radio"
                                    name="grading"
                                    value="3"
                                    checked={this.state.checked === "3"}
                                    onChange={this.handleChange}
                                    />
                        </label>    
                        <label> 4
                            <input
                                    type="radio"
                                    name="grading"
                                    value="4"
                                    checked={this.state.checked === "4"}
                                    onChange={this.handleChange}
                                    />
                        </label>    
                        <label> 5
                            <input
                                    type="radio"
                                    name="grading"
                                    value="5"
                                    checked={this.state.checked === "5"}
                                    onChange={this.handleChange}
                                    />  
                        </label>
                        </div>                                
                    </label>
                    <br />
                    <br />
                    <label className="osnovno">Grade type:</label>
                    <br/>
                    <select
                        name="gradeType"
                        value={this.state.gradeType}
                        >
                        <option value="none">--please select grade type--</option>
                        <option value="written">Written exam</option>
                        <option value="oral">Oral exam</option>
                        <option value="other">other</option>
                    </select>
                    <br/>
                    <button className="btn1">Submit</button>
                    <button className="btn1" onClick={()=>this.props.history.push("/")}>Cancel</button>
                </form>
            </div>
        )
    }
}

export default Grading