package com.birivarmi.birivarmiapp.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.birivarmi.birivarmiapp.model.Admin;

public interface AdminRepository extends CrudRepository<Admin, Long>{
	
	@Query("Select admin from Admin admin where admin.email = ?1")
	public Admin getAdminByEmail(String email);
	
	@Query("Select admin from Admin admin "
			+ " where "
			+ " admin.email = ?1 and "
			+ " admin.password = ?2 ")
	public Admin getAdminByEmailAndPassword(String email, String password);
	
	@Query("Select case when count(admin)>1 then true else false end from Admin admin "
			+ " where "
			+ " admin.email = ?1 and "
			+ " admin.authenticateKey = ?2 ")
	public boolean isAuthenticated(String email, String authenticateKey);
}
