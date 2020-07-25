package ca.sheridancollege.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import ca.sheridancollege.beans.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {
	Student findById(int id);

	List<Student> findByName(String name);

	
	
}
