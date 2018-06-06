package dreamertn9527.top.design.io.bio;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class InputStreamCopyCompared {
	
	static final private String readPath = "G:/download/test.ev4";
	
	static final private String writePath = "G:/download/test_copy.ev4";
	
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
//		// 字节流复制文件，复制方式：一次读取一个字符
//		stringFileCopy();
//		long endTime = System.currentTimeMillis();
//		System.out.println("字节流复制文件，复制方式：一次读取一个字符耗时：" + (endTime - startTime) + "毫秒复制成功");
//
//		startTime = System.currentTimeMillis();
//		// 使用高效缓冲区的字节流读取复制文件，复制方式：一次复制一个字符
//		bufferedInputStreamReader();
//		endTime = System.currentTimeMillis();
//		System.out.println("使用高效缓冲区的字节流读取复制文件，复制方式：一次复制一个字符耗时：" + (endTime - startTime) + "毫秒复制成功");
//
//		startTime = System.currentTimeMillis();
//		// 用高效缓冲区的字节流读取复制文件，复制方式：一次复制指定数量的字节
//		FileCopy();
//		endTime = System.currentTimeMillis();
//		System.out.println("字节流复制文件，复制方式：一次复制指定数量的字节耗时：" + (endTime - startTime) + "毫秒复制成功");

		startTime = System.currentTimeMillis();
		// 用高效缓冲区的字节流读取复制文件，复制方式：一次复制指定数量的字节
		bufferedInputStreamCopyFile();
		long endTime = System.currentTimeMillis();
		System.out.println("用高效缓冲区的字节流读取复制文件，复制方式：一次复制指定数量的字节耗时：" + (endTime - startTime) + "毫秒复制成功");
	}

	/**
	 * @描述：字节流复制文件，复制方式：一次读取一个字符 @创建时间：
	 */
	public static void stringFileCopy() {
		
		// 创建字节的输出、输出流
		InputStream inputStream = null;
		OutputStream outputStream = null;
		try {
			// 实例化字节输入、输出流
			inputStream = new FileInputStream(readPath);
			outputStream = new FileOutputStream(writePath);
			// 创建读取的字节ACSII码
			int len = -1;
			// 循环读取文件数据
			while ((len = inputStream.read()) != -1) {
				// 写入文件
				outputStream.write(len);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 如果输出、输入字节流有创建，则关闭，注意关闭顺序，先关输出流再关输入流
			try {
				if (outputStream != null)
					outputStream.close();
				if (inputStream != null)
					inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * @描述：字节流复制文件，复制方式：一次复制指定数量的字节 @创建时间：
	 */
	public static void FileCopy() {
		// 创建流对象
		InputStream inputStream = null;
		OutputStream stream = null;

		try {
			// 实例化流对象
			inputStream = new FileInputStream(readPath);
			stream = new FileOutputStream(writePath);
			// 接收读取的字节长度
			int len = -1;
			// 接收读取的字节
			byte[] bs = new byte[1024];
			// 循环读取字节
			while ((len = inputStream.read(bs)) != -1) {
				// 将读取的字节写入到文件中
				stream.write(bs, 0, len);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// 关闭输出流
				if (stream != null)
					stream.close();
				// 关闭输入流
				if (inputStream != null)
					inputStream.close();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}

	}

	/**
	 * @描述：用高效缓冲区的字节流读取复制文件，复制方式：一次复制指定数量的字节 @创建时间：
	 */
	public static void bufferedInputStreamCopyFile() {
		// 创建字节流对象
		InputStream inputStream = null;
		OutputStream outputStream = null;

		try {
			// 实例化高效缓冲区字节流的输入、输出对象
			inputStream = new BufferedInputStream(new FileInputStream(readPath));
			outputStream = new BufferedOutputStream(new FileOutputStream(writePath));
			// 每次读取的文件字节数量
			int len = -1;
			// 每次读取的文件字节数据
			byte[] bs = new byte[51200];
			// 循环读取文件，直至读到文件末尾
			while ((len = inputStream.read(bs)) != -1) {
				// 写入到文件
				outputStream.write(bs, 0, len);
			}
			// 清空缓冲区，将写入到文件中的数据保存
			outputStream.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// 关闭流
				if (outputStream != null)
					outputStream.close();
				if (inputStream != null)
					inputStream.close();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}
	}

	/**
	 * @描述：使用高效缓冲区的字节流读取复制文件，复制方式：一次复制一个字符 @创建时间：
	 */
	public static void bufferedInputStreamReader() {
		// 创建字节流对象
		InputStream inputStream = null;
		OutputStream outputStream = null;

		try {
			// 实例化高效缓冲区字节流的输入、输出对象
			inputStream = new BufferedInputStream(new FileInputStream(readPath));
			outputStream = new BufferedOutputStream(new FileOutputStream(writePath));

			// 读取的字节ACSII码
			int val = -1;

			// 循环读取文件，直至读到文件末尾
			while ((val = inputStream.read()) != -1) {
				// 写入到文件
				outputStream.write(val);
			}
			// 清空缓冲区，将写入到文件中的数据保存
			outputStream.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// 关闭流
				if (outputStream != null)
					outputStream.close();
				if (inputStream != null)
					inputStream.close();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}

	}

}
