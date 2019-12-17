package com.iktpreobuka.class_register_1.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.iktpreobuka.class_register_1.entities.SubjectEntity;
import com.iktpreobuka.class_register_1.entities.TeacherEntity;
import com.iktpreobuka.class_register_1.entities.TeacherSubjectEntity;

public interface TeacherSubjectRepository extends CrudRepository<TeacherSubjectEntity, Integer> {
	
	public TeacherSubjectEntity findByTeacherAndSubject(TeacherEntity teacher, SubjectEntity subject);
	
	public List<TeacherSubjectEntity> findByTeacher(TeacherEntity teacher);
	
	public List<SubjectEntity> findByTeacherId(Integer teacherId);

}
