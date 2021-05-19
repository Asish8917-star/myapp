package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.MyModel;
import com.example.demo.repository.MyModelRepository;

@Service
public class MyService {
	@Autowired
	private MyModelRepository repo;
	
	public int saveImage(MyModel model) {
		try {
			repo.save(model);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	public MyModel getImage(Long id) {
		Optional findId=repo.findById(id);
		
		if(findId.isPresent()) {
			MyModel getImageDetails=(MyModel) findId.get();
			return getImageDetails;
		}
		else {
			return null;
		}
	}

}
