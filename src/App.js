import React, { Component, Fragment } from 'react';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom';
import './App.css';
import GetStudents from './components/students/GetStudents';
import GetTeachers from './components/teachers/GetTeachers';
import Login2 from './components/common/Login2';
import NotFound from './components/common/NotFound';
import Header from './components/common/Header';
import Footer from './components/common/Footer';
import ChooseSubject from './components/teachers/ChooseSubject';
import Grading from './components/teachers/Grading';
import AddStudent from './components/students/AddStudent';
import AddTeacher from './components/teachers/AddTeacher';
import SchoolClasses from './components/teachers/SchoolClasses';
import UpdateTeacher from './components/teachers/UpdateTeacher';

class App extends Component {

  render() {
    return (
      <Router>
      <Fragment>
          <Header />
          <br />
          <Switch>
              <Route exact path = "/login" component = {Login2} />
              <Route exact path = "/teacher/subjects" component = {ChooseSubject} />
              <Route exact path = "/teachers" component = {GetTeachers} />
              <Route exact path = "/teachers/add" component = {AddTeacher} />
              <Route exact path = "/teacher/update/:id" component = {UpdateTeacher} />
              <Route exact path = "/teacher/subject" component = {SchoolClasses} />
              <Route exact path = "/grading" component = {Grading} />              
              <Route exact path = "/students" component = {GetStudents} />
              <Route exact path = "/students/add" component = {AddStudent} />           
              <Route component = {NotFound} />
          </Switch>
          <br />
          <Footer />
      </Fragment>
    </Router>
    )
  }
}

export default App;
