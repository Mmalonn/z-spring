package edu.curso.java.spring.zspring;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;


@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurityConfig {

	@Bean
	public InMemoryUserDetailsManager userDetailsService() {
		UserDetails user1 = User.withDefaultPasswordEncoder().username("general").password("general").roles("USER")
				.build();

		UserDetails user2 = User.withDefaultPasswordEncoder().username("admin").password("admin")
				.roles("USER", "ADMIN").build();

		ArrayList<UserDetails> users = new ArrayList<UserDetails>();
		users.add(user1);
		users.add(user2);
		return new InMemoryUserDetailsManager(users);
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests()
			.antMatchers("/trabajos/**").authenticated()
			.antMatchers("/trabajadores/**").authenticated()
			.antMatchers("/materiales/**").authenticated()
			.antMatchers("/proveedores/**").authenticated()
			.antMatchers("/terminados**").authenticated().and()
			.formLogin(form -> {
				form.loginPage("/");
				form.loginProcessingUrl("/validar");
				form.failureUrl("/");
				form.defaultSuccessUrl("/trabajos/lista");
			}).httpBasic().and().csrf().disable();

		return http.build();
	}
}
