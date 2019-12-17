package com.iktpreobuka.class_register_1.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class TeacherSubjectEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Version
	private Integer version = 1;
	
	@JsonManagedReference
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "teacher")
	private TeacherEntity teacher;
	
	@JsonManagedReference
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "subject")
	private SubjectEntity subject;
	
	@JsonBackReference
	@OneToMany(mappedBy = "teacherSubject")
	private List<TeacherSubjectClassEntity> tsc;

	public TeacherSubjectEntity() {
		super();
	}
	
	public TeacherSubjectEntity(TeacherEntity teacher, SubjectEntity subject) {
		super();
		this.teacher = teacher;
		this.subject = subject;
	}

	public TeacherSubjectEntity(Integer id, TeacherEntity teacher, SubjectEntity subject,
			List<TeacherSubjectClassEntity> tsc) {
		super();
		this.id = id;
		this.teacher = teacher;
		this.subject = subject;
		this.tsc = tsc;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public TeacherEntity getTeacher() {
		return teacher;
	}

	public void setTeacher(TeacherEntity teacher) {
		this.teacher = teacher;
	}

	public SubjectEntity getSubject() {
		return subject;
	}

	public void setSubject(SubjectEntity subject) {
		this.subject = subject;
	}

	public List<TeacherSubjectClassEntity> getTsc() {
		return tsc;
	}

	public void setTsc(List<TeacherSubjectClassEntity> tsc) {
		this.tsc = tsc;
	}

}
