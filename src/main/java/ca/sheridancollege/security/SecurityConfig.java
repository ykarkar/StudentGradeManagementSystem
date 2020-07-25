package ca.sheridancollege.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	/*
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		auth.inMemoryAuthentication()
			.passwordEncoder(NoOpPasswordEncoder.getInstance())
			.withUser("Yash").password("123").roles("ADMIN","LULU")
			.and()
			.withUser("Bhanu").password("1234").roles("MEOW");	
		
		}
		*/
	@Autowired
	private LoginAccessDeniedHandler accessDeniedHandler;
	
	@Autowired
	private UserDetailServiceImpl userDetailService;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder());
	}
	

	
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.csrf().disable(); //this is a security that is for the access to h2-console
		http.headers().frameOptions().disable(); //
		http.authorizeRequests()
		
		
	
		
		//define URL's and who has access
		.antMatchers("/student/**").hasRole("STUDENT")
		.antMatchers("/professor/**").hasRole("PROF")
		.antMatchers("/").permitAll()
		.antMatchers("/h2-console/**").permitAll()
		.anyRequest().authenticated()
		//define custom login page
		.and()
		.formLogin()
			.loginPage("/login").permitAll()
		//define the logout
			.and()
			.logout()
				.invalidateHttpSession(true)
				.clearAuthentication(true)
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/login?logout").permitAll()
				//add an access denied Handler
				.and()
				.exceptionHandling()
				.accessDeniedHandler(accessDeniedHandler);
			
		
	}
	
	/*
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.inMemoryAuthentication()
			.passwordEncoder(NoOpPasswordEncoder.getInstance())
			.withUser("Yash").password("123").roles("STUDENT")
			.and()
			.withUser("Jon").password("123").roles("PROFESSOR")
			.and()
			.withUser("Payal").password("123").roles("STUDENT")
			.and()
			.withUser("Admin").password("123").roles("STUDENT","PROFESSOR");	
		
		}
		*/
}
 