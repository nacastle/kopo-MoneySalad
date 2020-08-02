package monSal;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class HandlerMapping { // property location 잡을때 한번만 호출될 예정
	
	private Map<String, Controller> mappings = null;
	

	public HandlerMapping(String propLoc) {
		
		mappings = new HashMap<String, Controller>();
		
//		훌륭한 프로그래머는 설정정보를 하드코드하지 않는다. 대신 그들은 이 정보를 소스코드 영역의 외부에
//		저장하므로서 시스템설정이 변경되었을때 시스템을 재 컴파일하는 것을 막는다. 자바플랫폼의 경우에 이러한
//		프로그램 설정은 전형적으로 프로퍼티(properties)파일에 저장된다. 스스로 자신만의 방법으로 디자인과
//		개발을 할 수 있지만 java.util.Properties 클래스는 프로그램의 설정정보를 헛고생하지않고 개발코드에
//		불러오거나 또는 설정정보에 새로운 정보를 추가, 저장 할 수 있다.
//
//		프로퍼티 파일은 일련의 키-값의 쌍들로 이루어지며 파일에 저장된다. 파일의 이름은 .properties로
//		끝난다. 
		Properties prop = new Properties();
		try {
			InputStream inStream = new 
					FileInputStream(propLoc); // 웹서버에서는 웹서버 위치로 경로를 설정해줘야
			prop.load(inStream); //  지정된 InputStream으로부터 목록을 읽어서 저장
			
			Set<Object> keys = prop.keySet(); // properties 파일에서 key만 뽑아내는
			for(Object key : keys) {
				String className = prop.getProperty(key.toString()); // 지정된 키의 값을 반환. 키를 못 찾으면 dafalutValue 반환
				
				Class<?> clz = Class.forName(className);
				mappings.put(key.toString(), (Controller)clz.newInstance());
			}
			 // properties 파일에서 value 뽑아내는
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
		
		
	
	}
	
	public Controller getController(String uri) {
		return mappings.get(uri);
	}
	
	/*
	 * public static void main(String[] args) throws Exception {
	 * 
	 * Class<?> clz = Class.forName("kopo.ListController"); ListController obj =
	 * (ListController)clz.newInstance(); System.out.println(obj+"ASd");
	 * 
	 * }
	 */	
	
	

}
