package mypackage.controller;

import javax.persistence.Entity;
import javax.persistence.Id;

// We need to map this class with the database table
// Now JPA knows we need to create a table named Topic
@Entity
public class Topic {
	
		// These become the columns in the table
		// Tells JPA that this member variable also serves as the primary key of the table
		@Id
		private String id;
		private String name;
		private String profession;
		
		
		public String getId() {
			return id;
		}

		public Topic() {}
		
		// Each instance of the Topic class goes as rows in the table
		public Topic(String id, String name, String profession) {
			super();
			this.id = id;
			this.name = name;
			this.profession = profession;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getProfession() {
			return profession;
		}

		public void setProfession(String profession) {
			this.profession = profession;
		}
}
