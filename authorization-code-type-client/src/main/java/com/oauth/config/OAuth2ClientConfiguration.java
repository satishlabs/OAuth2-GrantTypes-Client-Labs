package com.oauth.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.AccessTokenProviderChain;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeAccessTokenProvider;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;
import org.springframework.security.oauth2.common.AuthenticationScheme;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

@Configuration
@EnableOAuth2Client
public class OAuth2ClientConfiguration {
	
	@Autowired
	private OAuth2ClientContext auth2ClientContext;
	
	@Bean
	public OAuth2ProtectedResourceDetails resourceDetails() {
		AuthorizationCodeResourceDetails resourceDetails = new AuthorizationCodeResourceDetails();
		
		resourceDetails.setClientId("oauth2server");
		resourceDetails.setTokenName("oauth_token");
		resourceDetails.setClientId("satishapp");
		resourceDetails.setClientSecret("satish123");
		resourceDetails.setGrantType("authorization_code");
		
		resourceDetails.setUserAuthorizationUri("http://localhost:12345/oauth/authorize");
		resourceDetails.setAccessTokenUri("http://localhost:12345/oauth/token");
		resourceDetails.setPreEstablishedRedirectUri(("http://localhost:5000/callback"));
		resourceDetails.setScope(Arrays.asList("read_profile"));
		resourceDetails.setUseCurrentUri(false);
		resourceDetails.setClientAuthenticationScheme(AuthenticationScheme.header);
		
		return resourceDetails;
	}
	
	@Bean
	public OAuth2RestTemplate oAuth2RestTemplate() {
		OAuth2RestTemplate template = new OAuth2RestTemplate(resourceDetails(), auth2ClientContext);
		
		AccessTokenProviderChain providerChain = new AccessTokenProviderChain(Arrays.asList(new AuthorizationCodeAccessTokenProvider()));
		
		template.setAccessTokenProvider(providerChain);
		
		return template;
	}
}
