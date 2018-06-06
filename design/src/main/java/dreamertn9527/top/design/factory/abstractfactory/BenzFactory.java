package dreamertn9527.top.design.factory.abstractfactory;


import dreamertn9527.top.design.factory.Benz;
import dreamertn9527.top.design.factory.Car;

public class BenzFactory extends AbstractFactory{

	@Override
	public Car getCar() {
		// TODO Auto-generated method stub
		return new Benz();
	}

}
