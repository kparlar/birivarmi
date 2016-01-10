package utility;



import java.util.logging.Logger;

import javax.xml.ws.Response;

import com.fasterxml.jackson.databind.JsonNode;


import play.libs.F.Function;
import play.libs.Json;
import play.libs.ws.*;
import play.mvc.*;

public class JsonFunctions {

//	public static Function<Response, JsonNode> responseToJson = new Function<Response, JsonNode>() {
//		public JsonNode apply(Response s){
//			return s.asJson();
//		}
//	};
	
	public static Function<JsonNode, Result> jsonToResult = new Function<JsonNode, Result>(){
		public Result apply(JsonNode s){
			return Results.ok(s);
		}
	};
	
//	public static Function<Throwable, JsonNode> fetchUserError = new Function(Throwable, JsonNode){
//		@Override
//		public JsonNode apply(Throwable t) throws Throwable{
//			//Logger.error("Failed to fetch Profile", t);
//			return Json.parse("{\"error\":\"failed to fetch the profile of user\"}");
//		}
//
//		@Override
//		public Object apply(Object arg0) throws Throwable {
//			// TODO Auto-generated method stub
//			return null;
//		}
//	};
	
	public static Function<JsonNode, String> findNextElement(final String path){
		return new Function<JsonNode, String>(){
			public String apply(JsonNode s){
				return s.findPath(path).asText();
			}
		};
	}
	
}
