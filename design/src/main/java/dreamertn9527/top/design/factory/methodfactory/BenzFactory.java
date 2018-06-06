package dreamertn9527.top.design.factory.methodfactory;

import dreamertn9527.top.design.factory.Benz;
import dreamertn9527.top.design.factory.Car;

public class BenzFactory implements MethodFactory{

	@Override
	public Car getCar() {
		// TODO Auto-generated method stub
		return new Benz();
	}

}
