package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 文件操作工具类
 * 
 * @author wuyue
 *
 */
public class FileUtils {
	// 从一个输入文件拷贝到输出文件
	public static File copyFile(String fileOutName, File fileSource)
			throws IOException {
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
}
