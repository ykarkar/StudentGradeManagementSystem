package ca.sheridancollege.Repositories;

import org.springframework.data.repository.CrudRepository;

import ca.sheridancollege.beans.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {
	public Role findByRolename(String rolename);
	
}
