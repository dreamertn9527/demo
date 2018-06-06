package dreamertn9527.top.design.proxy.custom;

import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

/**
 * 生成代理对象的代码
 * @author tangniannian
 *
 */
public class SelfProxy {
	
	private static final String ln = "\r\n";

	public static Object newProxyInstance(SelfClassLoader loader, Class<?>[] interfaces,
										  SelfInvocatationHandler h){
		
		
		try {
			// 1. 生成源代码
			String proxySrc = generateSrc(interfaces);
			
			// 2. 讲生成的源代码输出到磁盘，保存为.java文件
			String filePath = SelfProxy.class.getResource("").getPath();
			File f = new File(filePath+"$Proxy0.java");
			System.out.println(filePath);
			
			FileWriter fw = new FileWriter(f);
			fw.write(proxySrc);
			fw.flush();
			fw.close();
			
			
			// 3. 编译源代码，并且生成.class文件
			JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
			StandardJavaFileManager manager = compiler.getStandardFileManager(null, null, null);
			Iterable iterable = manager.getJavaFileObjects(f);
			
			CompilationTask task = compiler.getTask(null, manager, null, null, null, iterable);
			task.call();
			manager.close();
			
			// 4. 将class文件生成的内容动态加载到jvm中
			
			// 5. 返回被代理后的代理对象
			Class proxyClass = loader.findClass("$Proxy0");
			Constructor c = proxyClass.getConstructor(SelfInvocatationHandler.class);
			f.delete();
			return c.newInstance(h);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	private static String generateSrc(Class<?>[] interfaces){
		StringBuilder src = new StringBuilder();
		src.append("package vip.proxy.custom;" + ln);
		src.append("import java.lang.reflect.Method;"+ln);
		src.append("public class $Proxy0 implements "+ interfaces[0].getName() + "{" + ln);
		
		
		// 构造方法的生成
		src.append("SelfInvocatationHandler h;" + ln);
		src.append("public $Proxy0(SelfInvocatationHandler h) {"+ ln);
		src.append("this.h = h;" + ln);
		src.append("}"+ln);
		
		/// 代理类中的方法生成
		for(Method method : interfaces[0].getMethods()){
			src.append("public "+method.getReturnType() + " "+ method.getName()+"(){"+ln);
			
			src.append("try {"+ln);
			src.append("Method m = "+ interfaces[0].getName()+".class.getMethod(\""+method.getName()+"\", new Class[]{});" + ln);
			src.append("this.h.invoke(this, m, null);"+ln);
			src.append("} catch(Throwable e) {"+ln);
			src.append("e.printStackTrace();");
			src.append("}"+ln);
			src.append("}"+ln);
		}
		src.append("}");
		
		return src.toString();
	}
}
