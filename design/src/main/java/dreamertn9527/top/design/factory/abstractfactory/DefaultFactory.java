package dreamertn9527.top.design.factory.abstractfactory;

import dreamertn9527.top.design.factory.*;

public class DefaultFactory extends AbstractFactory{

	private AudiFactory defaultFactory = new AudiFactory();
	@Override
	Car getCar() {
		// TODO Auto-generated method stub
		return defaultFactory.getCar();
	}

}
