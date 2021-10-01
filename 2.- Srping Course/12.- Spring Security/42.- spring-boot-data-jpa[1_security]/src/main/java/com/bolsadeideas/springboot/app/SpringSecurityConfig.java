package com.bolsadeideas.springboot.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.bolsadeideas.springboot.app.auth.handler.LoginSuccessHandler;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private LoginSuccessHandler successHandler;
	
	@Override // para los permisos y configuracion de las rutas
	protected void configure(HttpSecurity http) throws Exception {

//		podemos asignar nuestras rutas publicas primero, css,js,images, listar = permitir a todos
		http.authorizeRequests().antMatchers("/", "/css/**", "/js/**", "/images/**", "/listar").permitAll()
		//rutas privadas, asignando roles
		.antMatchers("/ver/**").hasAnyRole("USER")// solo los usuarios pueden ver el detale de los clientes
		.antMatchers("/uploads/**").hasAnyRole("USER") 
		.antMatchers("/form/**").hasAnyRole("ADMIN")
		.antMatchers("/eliminar/**").hasAnyRole("ADMIN")
		.antMatchers("/factura/**").hasAnyRole("ADMIN")
		.anyRequest().authenticated()
		.and()
		    .formLogin() // con este metodo implementamos nuestro formato de login
		        .successHandler(successHandler) // inyectamos la instancia de la clase LoginSucces Handler
		        .loginPage("/login") //habilitamos la ruta de nuestro loggin en el controlador
		    .permitAll()
		.and()
		.logout().permitAll()
		.and() //y cuando cambia el metodo
		.exceptionHandling().accessDeniedPage("/error_403"); // pagina usada para permiso denegado

	}

	@Autowired // metodo para contruir los usuarios
	public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception
	{
		/*
		 * Deprecated
		 * UserBuilder users = User.withDefaultPasswordEncoder();
		 * */
		
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		
		//encryptacion de password
		UserBuilder users = User.builder().passwordEncoder(password -> {
											return encoder.encode(password);});
		
		
		//creacion de los usuarios
		build.inMemoryAuthentication()
		.withUser(users.username("admin").password("12345").roles("ADMIN", "USER"))
		.withUser(users.username("daniel").password("12345").roles("USER"));
	}
}
