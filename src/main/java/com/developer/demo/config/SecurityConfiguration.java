package com.developer.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    private CustomSuccessHandler successHandler;
    
    

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(this.passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/hrmanager").hasAnyAuthority("Human Resources Manager")
                .antMatchers("/employee").hasAnyAuthority("Employee")
                .antMatchers("/supervisor").hasAnyAuthority("Supervisor")
                .antMatchers( "/registeruser", "/register").permitAll()
                .antMatchers("/", "/login").permitAll()
                //.anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/login")
                //.defaultSuccessUrl("/homepage.html", true)
                .failureUrl("/login?error=true")
                .successHandler(successHandler)
                .usernameParameter("employeeNumber")
                .passwordParameter("password")
                // .failureHandler(authenticationFailureHandler())
                .and()
                .logout()
                .logoutUrl("/logout")
                //.deleteCookies("JSESSIONID")
                .logoutSuccessUrl("/login");
        //.logoutSuccessHandler(logoutSuccessHandler());

    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder;
    }
    /*
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
     */
}
