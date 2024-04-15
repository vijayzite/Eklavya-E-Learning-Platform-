package com.backend.elearning.services;

import java.util.List;

import com.backend.elearning.models.Approve;

public interface ApproveService {

	public List<Approve> getApproveListByUserID();
	
}
