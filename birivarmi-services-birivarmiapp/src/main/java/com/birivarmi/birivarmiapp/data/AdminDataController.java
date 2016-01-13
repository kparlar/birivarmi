package com.birivarmi.birivarmiapp.data;


import java.util.Date;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.birivarmi.birivarmiapp.model.Admin;
import com.birivarmi.birivarmiapp.repository.AdminRepository;
import com.birivarmi.birivarmiapp.util.BirivarmiConstantsUtil;




//@CrossOrigin(origins = "http://*/", maxAge = 3600)
@Controller
@RequestMapping("/birivarmi/birivarmiapp/data/v1/admin")
public class AdminDataController {

	@Autowired
	private AdminRepository adminRepository;
	
	
	@RequestMapping(method= RequestMethod.PUT)
	public ResponseEntity<Admin> createOrUpdateAdmin(
			@RequestParam(value="updaterId", required = false) Long updaterId,
			@RequestParam(value="email", required = true) String email, 
			@RequestParam(value="name", required = true) String name,
			@RequestParam(value="surname", required = true ) String surname,
			@RequestParam(value="username", required = true) String username,
			@RequestParam(value="password", required = true) String password,
			@RequestParam(value="newPassword", required = false) String newPassword){
		Admin admin = adminRepository.getAdminByEmail(email);
		Date today = new Date(System.currentTimeMillis());
		if(admin == null){
			Admin updater = null;
			if(updaterId !=null){
				updater = adminRepository.findOne(updaterId);
			}else{
				//do nothing.
			}
			admin = new Admin();
			admin.setEmail(email);
			admin.setLastLogin(today);
			admin.setLoginTry(0);
			admin.setName(surname);
			admin.setPassword(BCrypt.hashpw(password, BCrypt.gensalt()));
			admin.setReqistrationDate(today);
			admin.setSurname(surname);
			admin.setUsername(username);
			
			admin.setUpdaterId(updater);
			admin.setUpdateDate(today);
			admin.setUpdateStatus(BirivarmiConstantsUtil.UPDATE_STATUS_INSERT);
			
			adminRepository.save(admin);
			if(admin.getUpdaterId() == null){
				admin.setUpdaterId(admin);
				adminRepository.save(admin);
			}else{
				//do nothing.
			}
			return new ResponseEntity<Admin>(admin, HttpStatus.OK);
			
		}else{
			if(password!=null && 
					BCrypt.checkpw(password, admin.getPassword())){
				boolean isUpdated = false;
				if(name !=null){
					admin.setName(name);
					isUpdated = true;
				}else{
					//do nothing.
				}
				
				if(surname !=null){
					admin.setSurname(surname);
					isUpdated = true;
				}else{
					//do nothing.
				}
				
				if(username !=null){
					admin.setUsername(username);
					isUpdated = true;
				}else{
					//do nothing.
				}
				
				if(newPassword!=null){
					admin.setPassword(newPassword);
					isUpdated = true;
				}else{
					//do nothing.
				}
				
				if(isUpdated){
					admin.setUpdateDate(today);
					admin.setUpdateStatus(BirivarmiConstantsUtil.UPDATE_STATUS_INSERT);
					adminRepository.save(admin);	
				}else{
					
				}
				return new ResponseEntity<Admin>(admin, HttpStatus.OK);
			}else{
				return new ResponseEntity<Admin>(admin, HttpStatus.BAD_REQUEST);
			}
		}
	}
}
