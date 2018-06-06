package dreamertn9527.top.design.factory.methodfactory;

import dreamertn9527.top.design.factory.Audi;
import dreamertn9527.top.design.factory.Car;

public class AudiFactory implements MethodFactory{

	@Override
	public Car getCar() {
		// TODO Auto-generated method stub
		return new Audi();
	}

}
