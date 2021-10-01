package com.bolsadeideas.springboot.app.models.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bolsadeideas.springboot.app.models.dao.IUsuarioDao;
import com.bolsadeideas.springboot.app.models.entity.Role;
import com.bolsadeideas.springboot.app.models.entity.Usuario;



@Service("jpaUserDetailsService")
public class JpaUserDetailsService implements UserDetailsService{ // interfaz de spring framework security 

	@Autowired
	private IUsuarioDao usuarioDao;
	
	//atributo para mostrar en la traza
	private Logger logger = LoggerFactory.getLogger(JpaUserDetailsService.class);
	
	@Override
	@Transactional(readOnly=true) // transactional de lectura solamente
	// cargar obtener el usuario a travez de su username
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		// obtenermos al usuario
        Usuario usuario = usuarioDao.findByUsername(username);
        
        if(usuario == null) { // si no esta el objeto usuario
        	logger.error("Error en el Login: no existe el usuario '" + username + "' en el sistema!");
        	throw new UsernameNotFoundException("Username: " + username + " no existe en el sistema!"); // clase de spring security
        }
        
        
        // obtener la lista de roles
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        
        // por cada rol del usuario obtenemos el rol
        for(Role role: usuario.getRoles()) {
        	logger.info("Role: ".concat(role.getAuthority()));//obyenemos la autority
        	authorities.add(new SimpleGrantedAuthority(role.getAuthority())); // agregamos la autority a la lista , el nombre del rol
        }
        
        if(authorities.isEmpty()) { // si no hay roles
        	logger.error("Error en el Login: Usuario '" + username + "' no tiene roles asignados!");
        	throw new UsernameNotFoundException("Error en el Login: usuario '" + username + "' no tiene roles asignados!");
        }
        
        
		return new User(usuario.getUsername(), usuario.getPassword(), usuario.getEnabled(), true, true, true, authorities);
	}

}
