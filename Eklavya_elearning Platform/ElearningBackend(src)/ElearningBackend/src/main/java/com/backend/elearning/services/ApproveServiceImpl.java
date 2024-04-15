package com.backend.elearning.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.elearning.models.Approve;
import com.backend.elearning.repositories.ApproveRepository;

@Service
public class ApproveServiceImpl implements ApproveService {

	@Autowired ApproveRepository aprooveRepository; 
	
	@Override
	public List<Approve> getApproveListByUserID() {
		return aprooveRepository.findAll();
	}

}
