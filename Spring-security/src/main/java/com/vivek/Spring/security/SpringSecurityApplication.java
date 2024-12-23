package com.vivek.Spring.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityApplication.class, args);
	}

}
////
//The CSRF (Cross-Site Request Forgery) token is generated during the user's session to protect against CSRF attacks. Here's a breakdown of when it is generated and how it is used:
//
//When is the CSRF Token Generated?
//Session Initialization:
//
//A CSRF token is typically generated when a user session is created. For example:
//When the user logs into a web application.
//When a session starts for an anonymous user.
//It is a random, unique string tied to the user's session.
//On Page Rendering:
//
//If the application uses forms to submit data, the CSRF token is generated and sent along with the server response for the client (browser) to embed in forms.
//How is the CSRF Token Used?
//Embedding in Forms:
//
//The CSRF token is added as a hidden field in forms rendered by the server. For example:
//html
//Copy code
//<form method="POST" action="/submit">
//    <input type="hidden" name="csrf_token" value="123abc456def">
//    <input type="text" name="data" />
//    <button type="submit">Submit</button>
//</form>
//Alternatively, the CSRF token can be added to AJAX requests as part of the request header.
//Validation on Submission:
//
//When the user submits a form or sends a request, the CSRF token is included in the request (either in the body, as a hidden field, or in the headers for AJAX).
//The server validates the CSRF token by:
//Comparing the submitted token with the one stored in the user's session.
//Ensuring the token matches and is valid for the current user/session.
//Protection Against CSRF Attacks:
//
//If an attacker tries to forge a malicious request (e.g., via a third-party site), they cannot include the valid CSRF token since it is unique to the user's session and is unknown to the attacker.
//Without a valid CSRF token, the server rejects the request.

//If the server does not verify the origin of the request (e.g., using a CSRF token), the server will execute the action, believing it is a legitimate request from the user.
//Since attackers cannot guess or retrieve the token, they cannot forge requests on behalf of the user.