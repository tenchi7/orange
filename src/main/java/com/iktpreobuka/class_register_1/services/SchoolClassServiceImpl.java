package com.iktpreobuka.class_register_1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iktpreobuka.class_register_1.entities.SchoolClassEntity;
import com.iktpreobuka.class_register_1.repositories.SchoolClassRepository;

@Service
public class SchoolClassServiceImpl implements SchoolClassService {

	@Autowired
	private SchoolClassRepository classRepo;

	@Override
	public List<SchoolClassEntity> findAllSchoolClasses() {

		return (List<SchoolClassEntity>) classRepo.findAll();
	}

	@Override
	public SchoolClassEntity findSchoolClassById(Integer id) {

		return classRepo.findById(id).get();
	}

	@Override
	public SchoolClassEntity addNewSchoolClass(SchoolClassEntity schoolClass) {

		return classRepo.save(schoolClass);
	}

	@Override
	public SchoolClassEntity updateSchoolClassById(Integer id, SchoolClassEntity updateSchoolClass) {

		SchoolClassEntity schoolClass = classRepo.findById(id).get();
		schoolClass.setYear(updateSchoolClass.getYear());
		schoolClass.setSection(updateSchoolClass.getSection());

		return schoolClass;
	}

	@Override
	public SchoolClassEntity deleteSchoolClassById(Integer id) {

		SchoolClassEntity schoolClass = classRepo.findById(id).get();
		classRepo.deleteById(id);

		return schoolClass;
	}

}
