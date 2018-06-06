package dreamertn9527.top.design.timmer;


public class Main {

	public static void main(String[] args) {
		Test test = (Test) Timmer.getObject(Test.class);
		test.show();
	}
}

class Test{
	public void show(){
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
