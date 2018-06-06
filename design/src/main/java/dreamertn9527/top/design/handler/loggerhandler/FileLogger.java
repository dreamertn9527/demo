package dreamertn9527.top.design.handler.loggerhandler;

public class FileLogger extends AbstractLogger {

	public FileLogger(int level){
		this.level = level;
	}

	protected void write(String message) {
		System.out.println("File::Logger: " + message);
	}

}
