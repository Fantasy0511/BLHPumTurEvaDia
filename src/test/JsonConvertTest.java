package test;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import dao.members.Member;

/**
 * 
 * @author wuyue
 */
// * jackson的Jsonconvert测试
// * java--》json json--》java
public class JsonConvertTest {

	public static void main(String[] args) throws IOException {
		Member member = new Member(1, "武越越", 25, "master");
		Member member2 = new Member(2, "万俊毅", 25, "front");
		List<Member> memberList = new ArrayList<>();
		memberList.add(member);
		memberList.add(member2);
		ObjectMapper oMapper = getDefaultObjectMapper();
		try {
			// object---json
			String string = oMapper.writeValueAsString(member);
			// List<object> -->json
			String string2 = oMapper.writeValueAsString(memberList);
			System.out.println(string2);

			// json--->object
			System.out.println(
					oMapper.readValue(string, Member.class).toString());

			// json--->list<object>
			System.out.println(oMapper
					.readValue(string2, new TypeReference<List<Member>>() {
					}).toString());
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static ObjectMapper getDefaultObjectMapper() {
		ObjectMapper objectMapper = new ObjectMapper();
		// 设置object为""或者为null均不序列化
		objectMapper.setSerializationInclusion(Include.NON_EMPTY);
		objectMapper.configure(JsonGenerator.Feature.ESCAPE_NON_ASCII, true);
		objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
		return objectMapper;
	}
}
