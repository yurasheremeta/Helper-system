package ua.logos.domain.request;

import org.aspectj.lang.annotation.DeclareAnnotation;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SignInRequest {
	
	  private String username;
	    private String password;


}
