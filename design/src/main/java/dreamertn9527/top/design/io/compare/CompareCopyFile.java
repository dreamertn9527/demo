package dreamertn9527.top.design.io.compare;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.CountDownLatch;

public class CompareCopyFile {

	// 文件地址以及文件名称
	static final private String readPath = "G:/download/test";

	// 文件复制地址
	static final private String writePath = "G:/download/test_copy";

	// 每次buffer读取的文件字节
	static final private int byteCount = 512000;

	public static void main(String[] args) throws InterruptedException {
		long start = System.currentTimeMillis();
		final CountDownLatch count = new CountDownLatch(2);
		

		new Thread(new Runnable() {

			@Override
			public void run() {
				// 用高效缓冲区的字节流读取复制文件，复制方式：一次复制指定数量的字节
				long startTime = System.currentTimeMillis();
				bufferedInputStreamCopyFile();
				long endTime = System.currentTimeMillis();
				System.out.println("用高效缓冲区的字节流读取复制文件，复制方式：一次复制指定数量的字节耗时：" + (endTime - startTime) + "毫秒复制成功");
				count.countDown();
			}
		}).start();

		new Thread(new Runnable() {

			@Override
			public void run() {
				long startTime = System.currentTimeMillis();
				bufferChannelCopyFile();
				long endTime = System.currentTimeMillis();
				System.out.println("用bufferChannle复制文件耗时：" + (endTime - startTime) + "毫秒复制成功");
				count.countDown();
			}
		}).start();

		count.await();
		long end = System.currentTimeMillis();

		System.out.println("总共耗时---" + (end - start) + "毫秒");

	}

	/**
	 * BIO缓冲流方式
	 * 
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
			byte[] bs = new byte[byteCount];
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
	 * NIO方式复制
	 */
	public static void bufferChannelCopyFile() {
		// 获取输入流
		FileInputStream input = null;
		FileOutputStream output = null;

		try {
			input = new FileInputStream(readPath);

			output = new FileOutputStream(writePath + "2");

			// 创建通道
			FileChannel inChannel = input.getChannel();

			// 创建通道
			FileChannel outChannel = output.getChannel();

			// 创建buffer
			ByteBuffer buffer = ByteBuffer.allocate(byteCount);

			while (true) {
				// 清空缓冲区，使其处于可接受字节状态
				buffer.clear();
				// 从文件输入流通道里读取数据，大小取决于缓冲区大小，以及文件剩余字节大小
				int i = inChannel.read(buffer);

				// 反转缓冲区，使其处于可写入通道状态
				buffer.flip();

				// 把缓冲区数据写入文件输出流通道
				outChannel.write(buffer);

				// 如果返回值为-1表示已读取完毕
				if (i == -1) {
					break;
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				input.close();
				output.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
