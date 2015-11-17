package class2;

public class HelloWorld {

	int users;
	static int messages;
	
	public static void main(String[] args) {
		int count = 10;
		HelloWorld obj = new HelloWorld();
		obj.users = 5;
		HelloWorld.messages = 15;
		System.out.println("Hello World "+ obj.users +" "+count+" "+HelloWorld.messages);
	}
}
