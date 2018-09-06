package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 文件操作工具类
 * 
 * @author wuyue
 *
 */
public class FileUtils {
	// FileStreams 实现从一个输入文件拷贝到工作环境下（相比较于FileChannel速度慢，且大小受限制）
	public static File copyFile(String fileOutName, File fileSource) throws IOException {
		File fileOut = new File(fileOutName);
		FileInputStream fileInputStream = new FileInputStream(fileSource);
		OutputStream outputStream = new FileOutputStream(fileOut);
		byte[] buffer = new byte[1024];
		while (true) {
			int ins = fileInputStream.read(buffer);
			if (ins == -1) {
				fileInputStream.close();
				outputStream.flush();
				outputStream.close();
				return fileOut;
			} else {
				outputStream.write(buffer);
			}
		}
	}

	// FileStreams 实现从一个输入文件拷贝到工作环境下（相比较于FileChannel速度慢，且大小受限制）
	public static File copyFile2(String fileOutName, File fileSource) throws IOException {
		File fileOut = new File(fileOutName);
		FileInputStream fileInputStream = new FileInputStream(fileSource);
		OutputStream outputStream = new FileOutputStream(fileOut);
		byte[] buffer = new byte[1024];
		int ins ;
		int bytesum=0;
		while ((ins = fileInputStream.read(buffer)) != -1){
				outputStream.write(buffer,0,ins);
		}
		fileInputStream.close();
		outputStream.flush();
		outputStream.close();
		return fileOut;
	}

	/*public static File copyFile1(String oldPath, File fileSource) throws IOException {
		int bytesum = 0;
		int byteread = 0;
		File oldfile = new File(oldPath);
		if (oldfile.exists()) { // 文件存在时
			InputStream inStream = new FileInputStream(oldPath); // 读入原文件
			FileOutputStream fs = new FileOutputStream(newPath);
			byte[] buffer = new byte[1444];
			int length;
			while ((byteread = inStream.read(buffer)) != -1) {
				bytesum += byteread; // 字节数 文件大小
				System.out.println(bytesum);
				fs.write(buffer, 0, byteread);
			}
			inStream.close();
		}
		return oldfile;
	}
*/
}
