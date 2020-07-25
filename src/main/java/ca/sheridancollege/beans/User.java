package ca.sheridancollege.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String username;
	private String encryptedpassword;
	private Byte enabled;
	
	public User(Long id, String username, String encryptedpassword, Byte enabled) {
	
		this.username = username;
		this.encryptedpassword = encryptedpassword;
		enabled = 1;
	}
	
	@ManyToMany(cascade=CascadeType.ALL,
				fetch = FetchType.EAGER)
	List<Role> roles = new ArrayList<Role>();
	
	
	
}
