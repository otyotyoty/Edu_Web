package kr.project;

import org.json.JSONArray;
import org.json.JSONObject;

public class Project01_B {
    
    public static void main(String[] args) {
        
        JSONArray stdClass = new JSONArray(); // [{객체},{객체},{객체}]
        
        JSONObject stdLee=new JSONObject(); //json 객체
        stdLee.put("name","이순신");
        stdLee.put("address","서울시 종로구 12-15");
        stdLee.put("phone","010-1234-5678");
        System.out.println("---------------student--------------");
        System.out.println(stdLee);
        stdClass.put(stdLee);
        
        JSONObject stdPark=new JSONObject();
		stdPark.put("name","박진영");
		stdPark.put("address","서울시 종로구");
		stdPark.put("phone","010-2234-5678");
		System.out.println("--------------student-------------");
		System.out.println(stdPark);
		stdClass.put(stdPark);
		System.out.println("--------------stdClass-------------");
		System.out.println(stdClass);
		System.out.println(stdClass.toString(2)); //들여쓰기 2칸
		
		System.out.println("--------------object-------------");
        
		JSONObject object=new JSONObject();
		object.put("stdInfo", stdClass); //stdInfo.address 이런 식으로 가져올 수 있다.
		System.out.println(object.toString(2));
		
    }
    
}