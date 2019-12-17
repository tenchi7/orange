package com.iktpreobuka.class_register_1.services;

import java.util.List;

import com.iktpreobuka.class_register_1.entities.SubjectEntity;

public interface SubjectService {
	
	public List<SubjectEntity> findAllSubjects();
	
	public SubjectEntity findSubjectById(Integer id);
	
	public SubjectEntity saveSubject(SubjectEntity subject);
	
	public SubjectEntity updateSubjectById(Integer id, SubjectEntity updateSubject);
	
	public SubjectEntity deleteSubjectById(Integer id);

}
