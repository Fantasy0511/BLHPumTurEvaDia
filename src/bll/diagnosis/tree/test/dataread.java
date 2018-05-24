package bll.diagnosis.tree.test;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class dataread {

	public static List<Double> readTxtFile(String filePath){
		List<Double> datas=new ArrayList<Double>();
		try {
			String encoding="GBK";
			File file=new File(filePath);
			if(file.isFile() && file.exists()){ //判断文件是否存在
				InputStreamReader read = new InputStreamReader(
						new FileInputStream(file),encoding);//考虑到编码格式
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				while((lineTxt = bufferedReader.readLine()) != null){
//					System.out.println(lineTxt);
					datas.add(Double.valueOf(lineTxt));
				}
				read.close();
			}else{
				System.out.println("找不到指定的文件");
			}
		} catch (Exception e) {
			System.out.println("读取文件内容出错");
			e.printStackTrace();
		}
		return datas; 		
	}

	public static void main(String argv[]){
		String filePath = "C:\\workspace\\HMS.Web.NariAD\\src\\com\\nari\\faultdiagnosis\\testdata\\gov\\开机工况开度.txt";
		List<Double> datas=readTxtFile(filePath);		
		System.out.println(datas.size());
	}
}
