package mypackage.controller;

import org.springframework.data.repository.CrudRepository;

// It is my data service for doing all the CRUD operations
// The spring data jpa will be providing the class and we would be having an interface that uses the implementation which comes with
// spring data jpa
// spring data jpa comes with common repository and it contains logic for any entity class. Only the type of the entity class changes
// rest methods are same.
// We will get all the common methods and dont need to implement them and all we need to do is to implement special methods that we 
// need like search topics by text
// Crud repository is a generic repository and so we need to give it the details like entity class we are working with and the type of
//id which the entity class has 
public interface TopicRepository extends CrudRepository<Topic, String>{
	  

}
