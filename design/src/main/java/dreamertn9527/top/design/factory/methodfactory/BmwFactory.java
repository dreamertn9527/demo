package dreamertn9527.top.design.factory.methodfactory;


import dreamertn9527.top.design.factory.Bmw;
import dreamertn9527.top.design.factory.Car;

public class BmwFactory implements MethodFactory{

	@Override
	public Car getCar() {
		// TODO Auto-generated method stub
		return new Bmw();
	}

}
