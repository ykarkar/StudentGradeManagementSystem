package ca.sheridancollege.Repositories;

import org.springframework.data.repository.CrudRepository;

import ca.sheridancollege.beans.User;

public interface UserRepository extends CrudRepository<User, Long> {

	User findByUsername(String username);
	
}
