package dreamertn9527.top.design.factory.simpleFactory;


import dreamertn9527.top.design.factory.Audi;
import dreamertn9527.top.design.factory.Benz;
import dreamertn9527.top.design.factory.Bmw;
import dreamertn9527.top.design.factory.Car;

public class SimpleFactory {

	public Car getCar(String carName){
		Car obj = null;
		carName = carName.toUpperCase();
		switch (carName) {
		case "BMW":
			obj = new Bmw();
			break;
		case "Audi":
		    obj = new Audi();
		    break;
		case "Benz":
			obj = new Benz();
			break;
		default:
			throw new RuntimeException("没有这个车车");
		}
		
		return obj;
	}
}
