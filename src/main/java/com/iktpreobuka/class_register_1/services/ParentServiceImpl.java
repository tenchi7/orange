package com.iktpreobuka.class_register_1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iktpreobuka.class_register_1.entities.ParentEntity;
import com.iktpreobuka.class_register_1.repositories.ParentRepository;

@Service
public class ParentServiceImpl implements ParentService {

	@Autowired
	private ParentRepository parentRepo;

	@Override
	public List<ParentEntity> findAllParents() {

		return (List<ParentEntity>) parentRepo.findAll();
	}

	@Override
	public ParentEntity findParentById(Integer id) {

		return parentRepo.findById(id).get();
	}

	@Override
	public ParentEntity findParentByEmail(String email) {

		return parentRepo.findByEmail(email);
	}

	@Override
	public ParentEntity saveParent(ParentEntity newParent) {

		ParentEntity parent = parentRepo.findByEmail(newParent.getEmail());

		if (parent == null) {
			parent = parentRepo.save(newParent);
		}

		return parent;
	}

	@Override
	public ParentEntity updateParentById(Integer id, ParentEntity updateParent) {

		ParentEntity parent = parentRepo.findById(id).get();
		parent.setFirstName(updateParent.getFirstName());
		parent.setLastName(updateParent.getLastName());
		parent.setEmail(updateParent.getEmail());
		parentRepo.save(parent);

		return parent;
	}

	@Override
	public ParentEntity deleteParentById(Integer id) {

		ParentEntity parent = parentRepo.findById(id).get();
		parentRepo.deleteById(id);

		return parent;
	}

}
