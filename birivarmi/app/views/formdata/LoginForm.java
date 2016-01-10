package views.formdata;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.JsonNode;


import play.data.validation.ValidationError;
import play.i18n.Messages;

import play.libs.ws.*;
import scala.reflect.internal.Trees.This;
import play.libs.F.Promise;
import play.libs.F.Function;

public class LoginForm {
		Logger logger = LoggerFactory.getLogger(This.class);
	        public String email;
	        public String password;
	        
	       
	        
	       public boolean authenticate(){
//	    	   Promise<JsonNode> adminLoginService = WS.url("http://localhost:8088/birivarmi/birivarmiapp/app/v1/admin/").setContentType("application/x-www-form-urlencoded").post(String.format("email=%s&password=%s", "korayparlar@hotmail.com", "KORAY"))
//	 		    	  .map(response -> { return response.asJson();});
	     	Promise<JsonNode> adminLoginService2 = WS.url("http://localhost:8088/birivarmi/birivarmiapp/app/v1/admin/").setContentType("application/x-www-form-urlencoded").post(String.format("email=%s&password=%s", this.email, this.password))
	   	    	  .map(new Function<WSResponse, JsonNode>() {
	   	    		  public JsonNode apply(WSResponse response) {
	   	    			  JsonNode json = response.asJson();
	   	    			  if(json!=null){
	   	    				JsonNode jsonId = json.get("id");
	   	    				if(jsonId!=null){
	   	    					Long id = jsonId.longValue();
	   	    					logger.debug(String.format("Email: %s; Id:%d", email, id));
	   	    				}else{
	   	    					
	   	    				}
	   	    			  }else{
	   	    				  
	   	    			  }
	   	    			  
	   	    			  return json;
	   	    		  }
	   	    	  });
	     	
	     	
	    	   return true;
	       }
	       
//	       public List<ValidationError> validate() {
//
//	    	    List<ValidationError> errors = new ArrayList<ValidationError>();
//	    	    
//	    	    if (!authenticate(email, password)) {
//		              
//		              errors.add(new ValidationError("error", "Invalid user or password"));
//		              return errors;
//		        }else{
//		        	  return null;
//		        }
//	    	   
//	    	  }
	       public String validate() {
	    	    if (!authenticate()) {
		              return Messages.get("errors.invalidUserOrPassword");

		        }else{
		        	  return null;
		        }
	    	   
	    	  }

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
	       
	     
	    }

