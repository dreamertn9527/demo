package dreamertn9527.top.design.factory.abstractfactory;


import dreamertn9527.top.design.factory.Car;

public abstract class AbstractFactory {
	abstract Car getCar();
	
	public Car getCar(String carName){
		Car obj = null;
		carName = carName.toUpperCase();
		switch (carName) {
		case "BMW":
			obj = new BmwFactory().getCar();
			break;
		case "Audi":
		    obj = new AudiFactory().getCar();
		    break;
		case "Benz":
			obj = new BenzFactory().getCar();
			break;
		default:
			throw new RuntimeException("没有这个车车");
		}
		
		return obj;
	}
}
