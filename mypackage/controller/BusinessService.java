package mypackage.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// In spirng, a business service class is particularly a singleton class. When the application starts, the spring creates and instance
// of this service and keeps this instance in memory and register it. We can have other services/controllers which can depend on this. 
// We will declare that in each controller that we need that service and the spring will inject the instance to these different 
// classes.
// We do this by creating a private variable in the controller class.
// ** As we will make changes to this list so it is handy to have it has a separate list.
// This annotation marks this class as spring business service

// Now we need BusinessService to connect to the database. We need a data service for that.
@Service
public class BusinessService {
	
	// We need to get TopicRepository instance in this BusinessService so that we can make calls to topic repository from here
	// This gets an spring instance into the service class
	@Autowired
	private TopicRepository topicRepository;
	
	// This list is immutable so we do this to edit this list.
	/*private static List<Topic> data = new ArrayList<Topic>(Arrays.asList(
			new Topic("1","eesh","software engineer"),
			new Topic("2","hitesh","robotics engineer"),
			new Topic("3","rishabh","software engineer"),
			new Topic("4","akash","electronics engineer")));*/
	
	public List<Topic> getAllTopics(){
		
		//This method connects to the database, run a query to get all topics, convert each of those rows into topic instances and
		// get them back
		// We have to convert this iterable into a list
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll()
		.forEach(topics::add);
		return topics;
	}

	// Just used to filter the data stream and get the variable and call get function on it.
	public  Topic getTopic(String id) {	
		//return data.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		
		 //Optional<Topic> object = ;
		 return topicRepository.findById(id).get();
	}

	// Adds the new topic in the list
	public void postTopic(Topic topic) {
		if(topic == null) {
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		}
		topicRepository.save(topic);
		
	}

	public void updateTopic(String id, Topic topic) {
		// topic instance has id itself
		// if instance does not exists, it inserts
		topicRepository.save(topic);
		
	}

	public void deleteTopic(String id) {
		topicRepository.deleteById(id); 	
	}
}
