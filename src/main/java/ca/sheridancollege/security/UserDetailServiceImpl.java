package ca.sheridancollege.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import ca.sheridancollege.beans.Role;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	private ca.sheridancollege.Repositories.UserRepository userRepo;
	
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		
		ca.sheridancollege.beans.User user = userRepo.findByUsername(username);
		
		if(user == null) {
			
			System.out.println("User " +username + "not Found");
			throw new UsernameNotFoundException("User " + username+ "Not found" ) ;
			
		}
		
		List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
		for(Role role : user.getRoles()) {
			grantList.add(new SimpleGrantedAuthority(role.getRolename()));
			
		}
		UserDetails userDetails = (UserDetails)
				new User(user.getUsername(), user.getEncryptedpassword(), grantList);
		
		return userDetails;
	}

}
