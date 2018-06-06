package dreamertn9527.top.design.io.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileCopy {

	public static void main(String[] args) {
		try {
			
			long startTime = System.currentTimeMillis();
			
			// 获取资源文件的位置
			String resourcePath = new FileCopy().getClass().getResource("").getPath();
			
			String readPath = resourcePath+"/resource/read.txt";
			
			String writePath = resourcePath+"/resource/read_copy.txt";
						
			// 获取输入流
			FileInputStream input = new FileInputStream(readPath);
			
			FileOutputStream output = new FileOutputStream(writePath);
			
			// 创建通道
			FileChannel inChannel = input.getChannel();
			
			// 创建通道
			FileChannel outChannel = output.getChannel();
			
			// 创建buffer
			ByteBuffer buffer = ByteBuffer.allocate(1);

			while(true){
				// 清空缓冲区，使其处于可接受字节状态
	            buffer.clear();
	            // 从文件输入流通道里读取数据，大小取决于缓冲区大小，以及文件剩余字节大小
	            int i = inChannel.read(buffer);
	            // 如果返回值为-1表示已读取完毕
	            if(i == -1){
	                break;
	            }
	            
	            // 反转缓冲区，使其处于可写入通道状态
	            buffer.flip();
	            
	            // 把缓冲区数据写入文件输出流通道
	            outChannel.write(buffer);
			}
			input.close();
			output.close();
			
			long endTime = System.currentTimeMillis();
			
			System.out.println("花费时间---"+(endTime-startTime)+"ms");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
