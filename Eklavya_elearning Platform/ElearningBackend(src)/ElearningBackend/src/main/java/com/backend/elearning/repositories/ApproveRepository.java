package com.backend.elearning.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.backend.elearning.models.Approve;



@Repository
public interface ApproveRepository extends JpaRepository<Approve, Long>{

	@Query(value = "SELECT * FROM approve", nativeQuery = true)
	public List<Approve> recordsForAprroveList();

	@Query(value = "SELECT u_status FROM approve where user_id=?1", nativeQuery = true)
	public String findUserStatus(Long id);
	
}
