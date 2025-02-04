package com.example.OAuthSecurity;

import java.net.Authenticator;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@GetMapping("/")
	public String name(Authentication authentication) {
		System.out.println(authentication);
		System.out.println(authentication.getPrincipal());
		return "hello world google!";
	}
}


//Name: [104478973198223337280], Granted Authorities: [[OIDC_USER, SCOPE_https://www.googleapis.com/auth/userinfo.email, SCOPE_https://www.googleapis.com/auth/userinfo.profile, SCOPE_openid]], User Attributes: [{at_hash=EAzRA9XNs2GquIAGU4ZWBQ, sub=104478973198223337280, email_verified=true, iss=https://accounts.google.com, given_name=Boss, nonce=d8ix5yZ9lBFBJFXixoOWrwsEz2mcV-fw6bOOy4HGZm4, picture=https://lh3.googleusercontent.com/a/ACg8ocLLXy69oJ6gDPT_GYop2OLdxGzNaywyKEritMvagsSWpwbgqek=s96-c, aud=[945731166397-mq0av3anaqbqr2sk68l86ng8s74qca1l.apps.googleusercontent.com], azp=945731166397-mq0av3anaqbqr2sk68l86ng8s74qca1l.apps.googleusercontent.com, name=Boss, exp=2025-02-03T07:57:42Z, iat=2025-02-03T06:57:42Z, email=hp409985@gmail.com}]
