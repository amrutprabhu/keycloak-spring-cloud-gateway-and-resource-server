package com.amrut.prabhu.oauth2.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.client.oidc.web.server.logout.OidcClientInitiatedServerLogoutSuccessHandler;
import org.springframework.security.oauth2.client.registration.ReactiveClientRegistrationRepository;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.authentication.logout.ServerLogoutSuccessHandler;

@Configuration
public class SecurityConfig {

	@Bean
	public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http, ServerLogoutSuccessHandler handler) {
		http
				.authorizeExchange()
				.pathMatchers("/actuator/**", "/","/logout.html")
				.permitAll()
			.and()
				.authorizeExchange()
				.anyExchange()
				.authenticated()
			.and()
				.oauth2Login() // to redirect to oauth2 login page.
			.and()
				.logout()
				.logoutSuccessHandler(handler)
		;

		return http.build();
	}

	@Bean
	public ServerLogoutSuccessHandler keycloakLogoutSuccessHandler(ReactiveClientRegistrationRepository repository) {

        OidcClientInitiatedServerLogoutSuccessHandler oidcLogoutSuccessHandler =
                new OidcClientInitiatedServerLogoutSuccessHandler(repository);

        oidcLogoutSuccessHandler.setPostLogoutRedirectUri("{baseUrl}/logout.html");

        return oidcLogoutSuccessHandler;
    }
    
}