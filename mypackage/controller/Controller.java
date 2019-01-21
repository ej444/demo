package mypackage.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


// We have a running servlet controller but it does not do anything and thorows a error.
// We want a code to run on the servlet controller corresponding to a request. This is done by a controller.
// This controller has annotations which tell the spring what url we are mapping out code to and what should 
// happen if requests come to it.

// The web layer in the spring boot application leverages spring mvc.
// It lets us build server side code which maps to url and provides responses.
// THe reponses can be REST API response which is a JSON.

// This annotation is from spring mvc (web) and tells spring that this class acts as a REST controller
// This means that we can have methods in the class which map to url requests.

@RestController
public class Controller {
	
	// another spring mvc annotation
	// this method gets executed when there is a request to this url  **/hello
	@RequestMapping("/hello")
	public String response() {
		// Anything we return gets converted to a json and is sent back as a http response
		return ("Hello. How are you?");

    }
	
	// This tells that this variable has a dependency on BusinessService
	@Autowired
	private BusinessService businessService;
	
	@RequestMapping("/all")
	public List<Topic> getAll(){
		return businessService.getAllTopics();
	}
	
	// Path variable annotation tells that we are having a variable in the path
	@RequestMapping("/all/{id}")
	public Topic getTopic(@PathVariable String id){
		return BusinessService.getTopic(id);
	}
	
	// Map this method to any request which is POST on url /all
	@RequestMapping(method=RequestMethod.POST, value="/all")
	// RequestBody annotation tells spring that our request payload will contain an object of type Topic instance. It converts the 
	// payload to topic instance which we can use to add in our list.
	public void postTopic(@RequestBody Topic topic) {

		businessService.postTopic(topic);	
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/all/{id}")
	public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {
		businessService.updateTopic(id,topic);	
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/all/{id}")
	public void deleteTopic(@PathVariable String id) {
		businessService.deleteTopic(id);
	}
	
	
}








