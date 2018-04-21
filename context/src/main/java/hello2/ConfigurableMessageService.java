package hello2;

import hello.MessageService;

public class ConfigurableMessageService implements MessageService {

	private String message= "Hello World!";

	public void setMessage(String message) {
		this.message = message;
	}


	public String getMessage() {
		return message;
	}
}