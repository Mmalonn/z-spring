package edu.curso.java.spring.zspring;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@SuppressWarnings("deprecation")
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurityConfig {

	@Bean
	public UserDetailsService jdbcUserDetailsService(DataSource dataSource) {
		 JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
		return users;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
	//los datos de los usuarios se leen directamente de una tabla, que es tambien donde se almacenan cuando se da de alta uno nuevo,
	//pero solo es posible crear desde el front end usuarios con el rol general, los de admin directamente con la tabla
	//a su vez estan quitados todos los botones de edicion, alta y eliminacion de los objetos a los usuarios generales, solo se le permite ver
	//la aplicacion completa la ven los admin
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
				form.failureUrl("/?error=true");
				form.defaultSuccessUrl("/trabajos/lista");
			}).httpBasic().and().csrf().disable()
			.logout().logoutUrl("/logout").logoutSuccessUrl("/")
			.invalidateHttpSession(true)
			.deleteCookies("JSESSIONID");

		return http.build();
	}
}
