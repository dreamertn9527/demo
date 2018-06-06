package dreamertn9527.top.design.proxy.custom;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 代码生成、编译、动态加载
 * @author tangniannian
 *
 */
public class SelfClassLoader extends ClassLoader{

	private File baseDir;
	
	public SelfClassLoader() {
		String basePath = SelfClassLoader.class.getResource("").getPath();
		this.baseDir = new File(basePath);
	}
	
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		String className = SelfClassLoader.class.getPackage().getName()+"."+name;
		if(baseDir != null){
			File classFile = new File(baseDir, name.replaceAll("\\.", "/")+".class");
			if(classFile.exists()){
				FileInputStream in = null;
				ByteArrayOutputStream out = null;
				try {
					in = new FileInputStream(classFile);
					out = new ByteArrayOutputStream();
					byte[] buff = new byte[1024];
					int len;
					while((len = in.read(buff)) != -1){
						out.write(buff, 0, len);
					}
					
					return defineClass(className, out.toByteArray(), 0, out.size());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					if(in != null){
						try {
							in.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					if(out != null){
						try {
							out.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
				}
				classFile.delete();
				
				
			}
		}
		return null;
	}
}
