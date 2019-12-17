package com.iktpreobuka.class_register_1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iktpreobuka.class_register_1.entities.SubjectEntity;
import com.iktpreobuka.class_register_1.repositories.SubjectRepository;

@Service
public class SubjectServiceImpl implements SubjectService {
	
	@Autowired
	SubjectRepository subjectRepo;

	@Override
	public List<SubjectEntity> findAllSubjects() {
		
		return (List<SubjectEntity>) subjectRepo.findAll();
	}

	@Override
	public SubjectEntity findSubjectById(Integer id) {
		
		return subjectRepo.findById(id).get();
	}

	@Override
	public SubjectEntity saveSubject(SubjectEntity subject) {
		
		return subjectRepo.save(subject);
	}

	@Override
	public SubjectEntity updateSubjectById(Integer id, SubjectEntity updateSubject) {
		
		SubjectEntity subject = subjectRepo.findById(id).get();
		subject.setName(updateSubject.getName());
		
		return subject;
	}

	@Override
	public SubjectEntity deleteSubjectById(Integer id) {

		SubjectEntity subject = subjectRepo.findById(id).get();
		subjectRepo.deleteById(id);
		
		return subject;
	}
	


}
