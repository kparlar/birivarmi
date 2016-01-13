package com.birivarmi.birivarmiapp.app;

import java.util.Date;

import org.apache.commons.lang.RandomStringUtils;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.birivarmi.birivarmiapp.model.Admin;
import com.birivarmi.birivarmiapp.repository.AdminRepository;
import com.birivarmi.birivarmiapp.util.BirivarmiConstantsUtil;
//@CrossOrigin(origins = "http://*/", maxAge = 3600)
@RestController
@RequestMapping("/birivarmi/birivarmiapp/app/v1/admin")
public class AdminAppController {

	@Autowired
	private AdminRepository adminRepository;
	
	
	@RequestMapping(method= RequestMethod.POST)
	public ResponseEntity<Admin> login(@RequestParam(value="email") String email, @RequestParam(value="password") String password){
		Admin admin = adminRepository.getAdminByEmail(email);
		if(admin!=null){
		 if (BCrypt.checkpw(password, admin.getPassword())) {
			 Date today = new Date();
				admin.setLastLogin(today);
				admin.setLoginTry(0);
				admin.setUpdateDate(today);
				admin.setUpdaterId(admin);
				admin.setUpdateStatus(BirivarmiConstantsUtil.UPDATE_STATUS_UPDATE);				
				admin.setAuthenticateKey(RandomStringUtils.randomAlphanumeric(20));
				adminRepository.save(admin);
				return new ResponseEntity<Admin>(admin, HttpStatus.OK);
		    } else {
		    	admin = null;
		    	return new ResponseEntity<Admin>(admin, HttpStatus.NOT_FOUND);
		    }
		}else{
			return new ResponseEntity<Admin>(admin, HttpStatus.NOT_FOUND);
		}
	}
	@RequestMapping(method= RequestMethod.GET, value="/isAuthenticated")
	public ResponseEntity<Admin> isAuthenticated(@RequestParam(value="email") String email, @RequestParam(value="authKey") String authKey){
		boolean isAuthenticated = adminRepository.isAuthenticated(email, authKey);
		Admin admin = null;
		if(isAuthenticated){
			admin = adminRepository.getAdminByEmail(email);
			return new ResponseEntity<Admin>(admin, HttpStatus.OK);		    
		}else{
			return new ResponseEntity<Admin>(admin, HttpStatus.NOT_FOUND);
		}
	}
}
