package com.example.springboot_keycloak_admin_client;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.idm.RealmRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class KeycloakService {

    @Autowired
    private Keycloak keycloak;
    @Value("${keycloak.realm}")
    private String realm;

    public void updatePasswordPolicy(String newPolicy) {
    	System.out.println("REALM.............." + realm);
        RealmRepresentation realmRepresentation = keycloak.realm(realm).toRepresentation();
        realmRepresentation.setPasswordPolicy(newPolicy);
        keycloak.realm(realm).update(realmRepresentation);
    }
}
