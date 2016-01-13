package com.birivarmi;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.birivarmi.birivarmiapp.BirivarmiServicesBirivarmiappApplication;
import com.birivarmi.birivarmiapp.model.Admin;
import com.birivarmi.birivarmiapp.repository.AdminRepository;
import com.birivarmi.util.TestConstants;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = BirivarmiServicesBirivarmiappApplication.class)
public class AdminDataControllerTest {
	@Autowired
	private AdminRepository adminRepository;
	
	@Test
	public void createOrUpdateAdmin_create() {
//		String url = String.format("%s:%s%s",TestConstants.BIRIVARMI_URL, TestConstants.BIRIVARMI_APP_PORT,
//				TestConstants.ADMIN_DATA_CONTROLLER_URL);
//		MultiValueMap<String, String> requestParams = new LinkedMultiValueMap<String, String>();
//		requestParams.add("email", "test@test.com");
//		requestParams.add("name", "test");
//		requestParams.add("surname","test");
//		requestParams.add("password","test");
//		ResponseEntity<Admin> entity = new TestRestTemplate().getForEntity(url, Admin.class, requestParams);
//		assertEquals(HttpStatus.OK, entity.getStatusCode());
		String url = String.format("%s:%s%s",TestConstants.BIRIVARMI_URL, TestConstants.BIRIVARMI_APP_PORT,
				TestConstants.ADMIN_DATA_CONTROLLER_URL);
		MultiValueMap<String, String> requestParams = new LinkedMultiValueMap<String, String>();
		requestParams.add("email", "test@test.com");
		requestParams.add("name", "test");
		requestParams.add("surname","test");
		requestParams.add("password","test");
		ResponseEntity<Admin> entity = new TestRestTemplate().exchange(url, HttpMethod.PUT, null, Admin.class, requestParams);
		assertEquals(HttpStatus.OK, entity.getStatusCode());
		adminRepository.delete(entity.getBody());
	}
	@Test
	public void createOrUpdateAdmin_update() {
		String url = String.format("%s:%s%s",TestConstants.BIRIVARMI_URL, TestConstants.BIRIVARMI_APP_PORT,
				TestConstants.ADMIN_DATA_CONTROLLER_URL);
		MultiValueMap<String, String> requestParams = new LinkedMultiValueMap<String, String>();
		requestParams.add("email", "test@test.com");
		requestParams.add("name", "test");
		requestParams.add("surname","test");
		requestParams.add("password","test");
		ResponseEntity<Admin> entity = new TestRestTemplate().exchange(url, HttpMethod.PUT, null, Admin.class, requestParams);
		assertEquals(HttpStatus.OK, entity.getStatusCode());
		adminRepository.delete(entity.getBody());
	}
	

}
