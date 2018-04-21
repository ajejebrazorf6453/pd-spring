package hello2;

import hello.MessageService;

public class MockMessageService implements MessageService {
	public String getMessage() {
		return "Hello World!";
	}
}