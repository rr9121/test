package class2;

public class VariableDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 123456789;
		long l = 1234l;
		float f = 1.25f;
		double d = 3.25d;
		byte b = 127;
		System.out.println("a :"+a);
		System.out.println("b :"+ b);
		b =(byte) a;
		System.out.println("a :"+b + " " + l + " " + f+ " "+d);
	}

}
