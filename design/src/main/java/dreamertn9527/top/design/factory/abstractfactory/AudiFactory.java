package dreamertn9527.top.design.factory.abstractfactory;

import dreamertn9527.top.design.factory.Audi;
import dreamertn9527.top.design.factory.Car;

public class AudiFactory extends AbstractFactory{

	@Override
	public Car getCar() {
		// TODO Auto-generated method stub
		return new Audi();
	}

}
