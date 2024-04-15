package com.backend.elearning.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.backend.elearning.models.User;


@Repository
public interface RegisterRepository extends JpaRepository<User, Long> {

	@Query(value = "SELECT username FROM users WHERE username = ?1", nativeQuery = true)
	String findByUsername(String username);
	
	@Query(value = "SELECT pass FROM users WHERE username = ?1", nativeQuery = true)
	String findByPassword(String username);

	@Query(value = "SELECT user_id FROM users WHERE username = ?1", nativeQuery = true)
	String findUserId(String username);


	@Query(value = "select first_name from users where username = ?1", nativeQuery = true)
	String findFirstName(String userName);
	
	@Query(value = "select last_name from users where username = ?1", nativeQuery = true)
	String findLastName(String userName);

	@Query(value = "select email from users where username = ?1", nativeQuery = true)
	String findMailByUserName(String userName);
//	
	@Query(value = "select role_role_id from users where username = ?1", nativeQuery = true)
	Integer findRoleIdbyUsername(String userName);

	@Query(value = "select name from Role where role_id = (select role_role_id from users where username = ?1)", nativeQuery = true)
	String findRoleNamebyUsername(String userName);

	@Query(value = "SELECT * FROM users", nativeQuery = true)
	public List<String> findAllUsers();

	
	@Query(value = "SELECT count(*) FROM users where role_role_id=?1", nativeQuery = true)
	public String getUserCount(Integer id);

	
	
}
