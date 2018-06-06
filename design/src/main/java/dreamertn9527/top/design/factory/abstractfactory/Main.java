package dreamertn9527.top.design.factory.abstractfactory;


public class Main {
	public static void main(String[] args) {
		DefaultFactory factory = new DefaultFactory();
		System.out.println(factory.getCar("Bmw").getName());
		
		System.out.println(factory.getCar().getName());
	}
}
