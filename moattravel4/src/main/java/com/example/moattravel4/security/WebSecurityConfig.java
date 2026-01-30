package com.example.moattravel4.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
				.authorizeHttpRequests((requests) -> requests
						.requestMatchers("/css/**", "/images/**", "/js/**", "/storage/**", "/").permitAll() // 誰でもアクセスOK
						.requestMatchers("/admin/**").hasRole("ADMIN") // 管理者のみアクセスOK
						.anyRequest().authenticated() // それ以外はログインが必要
				)
				.formLogin((form) -> form
						.loginPage("/login") // ログイン画面のURL
						.loginProcessingUrl("/login") // ログイン処理のパス
						.defaultSuccessUrl("/?loggedIn") // ログイン成功時のリダイレクト先
						.failureUrl("/login?error") // ログイン失敗時のリダイレクト先
						.permitAll())
				.logout((logout) -> logout
						.logoutSuccessUrl("/?loggedOut") // ログアウト時のリダイレクト先
						.permitAll());

		return http.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}