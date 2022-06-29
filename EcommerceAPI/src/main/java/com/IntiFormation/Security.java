package com.IntiFormation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.IntiFormation.jwtConfig.RequestFilter;

@EnableWebSecurity
public class Security extends WebSecurityConfigurerAdapter{
	
	@Autowired
	UserDetailsService userdetailservice;
	
	@Autowired
	private RequestFilter jwtrequestfilter;
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(userdetailservice);
	}
	
	
	@Bean
	public BCryptPasswordEncoder  passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	
	@Override
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManager();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable()
		.authorizeRequests().antMatchers("/authenticate").permitAll()

		.antMatchers(HttpMethod.OPTIONS,"/**").permitAll()
		.antMatchers("/utilisateurs/**").permitAll()
		.antMatchers("/inscription/**").permitAll()
		
		.antMatchers("/authentification/**").permitAll()
		.antMatchers("/GestionProduit/produitName/**").permitAll()
		.antMatchers("/GestionProduit/Produit/**").permitAll()
	
		
		.antMatchers("/imageproduit/**").permitAll()
		.antMatchers("/GestionCategorie/afficher/**").permitAll()
		.antMatchers("/produits/**").permitAll()
		.antMatchers("/GestionProduit/produitIdCat/**").permitAll()
		.antMatchers("/GestionProduit/afficherP/**").permitAll()

		.antMatchers("/**").hasAuthority("admin")

		.anyRequest().authenticated()
		.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and().addFilterBefore(jwtrequestfilter, UsernamePasswordAuthenticationFilter.class);
		

		
	}

}
