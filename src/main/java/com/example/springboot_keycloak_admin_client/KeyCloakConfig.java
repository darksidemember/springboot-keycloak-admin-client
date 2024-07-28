package com.example.springboot_keycloak_admin_client;

import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KeyCloakConfig {
	
	@Value("${keycloak.auth-server-url}")
    private String authServerUrl;

    @Value("${keycloak.realm}")
    private String realm;

    @Value("${keycloak.client-id}")
    private String clientId;

    @Value("${keycloak.client-secret}")
    private String clientSecret;

    @Value("${keycloak.username}")
    private String username;
    
    @Value("${keycloak.password}")
    private String password;

//Working with the "propertyset2" in the application.properties
    @Bean
    public Keycloak keycloak() {
        return KeycloakBuilder.builder()
                .serverUrl(authServerUrl)
                .realm(realm)//MY_REALM
                .grantType(OAuth2Constants.PASSWORD)
                .clientId(clientId)//admin-cli
                .clientSecret(clientSecret)//secrete of admin-cli
                .username(username)//prageeth - user should have manage-realm permissions. (Use groups to assign permissions to users.)
                .password(password)//prageeth
                .build();
    }
    
    
////Working with the "propertyset1" in the application.properties
//  @Bean
//  public Keycloak keycloak() {
//      return KeycloakBuilder.builder()
//              .serverUrl(authServerUrl)
//              .realm("master")
//              .grantType(OAuth2Constants.PASSWORD)
//              .clientId(clientId)
//              .clientSecret(clientSecret)
//              .username("admin")
//              .password("admin")
//              .build();
//  }
}
