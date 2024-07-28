package com.example.springboot_keycloak_admin_client;

import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.idm.RealmRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

	@Autowired
	private Keycloak keycloak;
	@Value("${keycloak.realm}")
    private String realm;
	
	
	@GetMapping("/update-password-policy1")
	public String test() {
		System.out.println("test().............." + realm);
		
		
//		UserResource userResource = null;
//
//		RealmResource realmResource = keycloak.realm(realm);
//		UsersResource usersResource = realmResource.users();
//		usersResource.userProfile().
		
		
		RealmRepresentation realmRepresentation = keycloak.realm(realm).toRepresentation();
        realmRepresentation.setPasswordPolicy("length(8) and digits(2) and notUsername()");
        keycloak.realm(realm).update(realmRepresentation);
		
		
		
		return "Hi";
	}
}
