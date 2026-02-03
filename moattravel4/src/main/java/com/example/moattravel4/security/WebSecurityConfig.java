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
						.requestMatchers(
								"/css/**",
								"/images/**",
								"/js/**",
								"/storage/**",
								"/",
								"/signup/**",
								"/meeting_rooms", // 会議室一覧
								"/meeting_rooms/{id}", // 会議室詳細
								"/stripe/webhook", // StripeのWebhook

								//permitAllはすべてのユーザー

								"/favicon.ico", // ブラウザが自動リクエストするアイコン
								"/error" // エラーページ
						).permitAll()
						.requestMatchers("/admin/**").hasRole("ADMIN") // 管理者専用
						.anyRequest().authenticated() // それ以外はログイン必須
				)
				.formLogin((form) -> form
						.loginPage("/login") // ログインページのURL
						.loginProcessingUrl("/login") // ログインフォームの送信先URL
						.defaultSuccessUrl("/?loggedIn") // ログイン成功時のリダイレクト先URL
						.failureUrl("/login?error") // ログイン失敗時のリダイレクト先URL
						.permitAll())
				.logout((logout) -> logout
						.logoutSuccessUrl("/?loggedOut") // ログアウト時のリダイレクト先URL
						.permitAll())
				.csrf((csrf) -> csrf
						.ignoringRequestMatchers("/stripe/webhook") // StripeのWebhookはCSRFチェックを除外
				);

		return http.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}