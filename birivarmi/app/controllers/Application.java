package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import play.libs.F.Function;
import play.*;
import play.data.Form;
import play.libs.F.Promise;
import play.libs.Json;
import play.libs.ws.*;
import play.mvc.*;
import views.formdata.LoginForm;
import views.html.*;
import views.html.admin.*;


public class Application extends Controller {
	/**
	 * The index page of your application.
	 * @return the rendered index page of your application
	 */
    public Result index() {
    	//TODO put internationalization support for your application
        return ok(index.render("Welcome to (c)Birivarmi.com"));
    }
    
    public Result home() {
        return ok(home.render("Welcome to (c)Birivarmi.com"));
    }
    
    public Result adminHome() {
        return ok(adminhome.render());
    }
    
    public Result adminLogin(){
    	Form<LoginForm> loginForm = Form.form(LoginForm.class);
    	return ok(adminlogin.render("Welcome to (c)Birivarmi.com", loginForm));
    }
    
    public Result authenticateAdmin(){
        Form<LoginForm> loginForm = Form.form(LoginForm.class).bindFromRequest();
        if (loginForm.hasErrors()) {
            return badRequest(adminlogin.render("Welcome to (c)Birivarmi.com", loginForm));
        } else {
            session().clear();
            session("email", loginForm.get().email);
            return adminHome();
        }
    }
    public Result signup(){
    	return ok("Success!");
    }
    public Result post(){
    	 return badRequest(Application.buildJsonResponse("error", "No such post"));
    }
    public static ObjectNode buildJsonResponse(String type, String message) {
        ObjectNode wrapper = Json.newObject();
        ObjectNode msg = Json.newObject();
        msg.put("message", message);
        wrapper.put(type, msg);
        return wrapper;
      }
}
