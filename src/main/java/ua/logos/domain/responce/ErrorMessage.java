package ua.logos.domain.responce;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ErrorMessage {
	   private String message;
	    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	    private LocalDateTime timestamp;

	    public ErrorMessage(String message) {
	        this.message = message;
	        this.timestamp = LocalDateTime.now();
	    }

}
