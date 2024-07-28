package com.example.springboot_keycloak_admin_client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KeycloakController {

    @Autowired
    private KeycloakService keycloakService;

    @GetMapping("/update-password-policy")
    public String updatePasswordPolicy() {
    	String policy = "length(8) and digits(4) and notUsername() and passwordHistory(5) and forceExpiredPasswordChange(30)";
        keycloakService.updatePasswordPolicy(policy);
        return "Password policy updated to: " + policy;
    }
}
