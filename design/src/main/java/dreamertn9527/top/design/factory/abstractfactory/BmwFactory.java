package dreamertn9527.top.design.factory.abstractfactory;

import dreamertn9527.top.design.factory.*;

public class BmwFactory extends AbstractFactory{

	@Override
	public Car getCar() {
		// TODO Auto-generated method stub
		return new Bmw();
	}

}
