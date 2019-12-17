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
public class TeacherSubjectClassEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Version
	private Integer version = 1;

	@JsonManagedReference
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "teacherSubject")
	private TeacherSubjectEntity teacherSubject;

	@JsonManagedReference
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "schoolClass")
	private SchoolClassEntity schoolClass;

	@JsonBackReference
	@OneToMany(mappedBy = "tsc")
	private List<GradingEntity> grading;

	public TeacherSubjectClassEntity() {
		super();
	}

	public TeacherSubjectClassEntity(TeacherSubjectEntity teacherSubject, SchoolClassEntity schoolClass) {
		super();
		this.teacherSubject = teacherSubject;
		this.schoolClass = schoolClass;
	}

	public TeacherSubjectClassEntity(Integer id, TeacherSubjectEntity teacherSubject, SchoolClassEntity schoolClass) {
		super();
		this.id = id;
		this.teacherSubject = teacherSubject;
		this.schoolClass = schoolClass;
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

	public TeacherSubjectEntity getTeacherSubject() {
		return teacherSubject;
	}

	public void setTeacherSubject(TeacherSubjectEntity teacherSubject) {
		this.teacherSubject = teacherSubject;
	}

	public SchoolClassEntity getSchoolClass() {
		return schoolClass;
	}

	public void setSchoolClass(SchoolClassEntity schoolClass) {
		this.schoolClass = schoolClass;
	}

	public List<GradingEntity> getGrading() {
		return grading;
	}

	public void setGrading(List<GradingEntity> grading) {
		this.grading = grading;
	}

}
