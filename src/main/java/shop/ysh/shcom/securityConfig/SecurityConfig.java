package shop.ysh.shcom.securityConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests(auth -> {
			auth.antMatchers("/shcom/**").permitAll();
			auth.antMatchers("/admin/**").hasRole("ADMIN");
			auth.anyRequest().authenticated();
		});
			
		http.formLogin()
		.loginPage("/shcom/login") // 로그인 페이지
		.loginProcessingUrl("/login") // form action
		.defaultSuccessUrl("/shcom") // 성공 후 페이지
		.and()
		.logout()
		.logoutSuccessUrl("/shcom") // 성공 후 페이지
		.logoutUrl("/shcom/logout") // form url
		.and().csrf().disable();

		return http.build();
	}
}