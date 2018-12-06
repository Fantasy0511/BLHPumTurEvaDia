package blh.action.predict;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import util.PathUtil;

/**
 * 读取data文件下prdId.json文件
 * @author tiandiwei
 *
 */
public class PredictIdUtil {
	
	public Integer getJsonID(String item ,String unito) throws JsonProcessingException, IOException {
		/*File json =new File("E:\\eclipse\\eclipse-workspace\\git\\BLHPumTurEvaDia\\WebContent\\data\\predictNum\\preId.json");*/
		File json =new File(PathUtil.getWebRealBasePath()+"/data/predictNum/preId.json");
		ObjectMapper mapper=new ObjectMapper();
		JsonNode rootNode = mapper.readTree(json);  
		int nodeId = rootNode.path(item).findPath(unito).asInt();
		return nodeId;
	}
	
	public static void main(String[] args) throws JsonProcessingException, IOException {
		PredictIdUtil aIdUtil=new PredictIdUtil();
		System.out.println(aIdUtil.getJsonID("B14B", "1"));
	}
	

}
