package fr.bibop.meta.datacontainer;

import java.util.HashMap;

public class BusinessObject {

	String id = null;
	public HashMap<String, BusinessObject> childs = new HashMap<String, BusinessObject>();
	HashMap<String, Object> fields = new HashMap<String,Object>();
	
	public BusinessObject(){
		this.id="root";
	}

	public BusinessObject(String id){
		this.id=id;
	}
	
	public HashMap<String, BusinessObject> getBos() {
		return childs;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void addField(String fieldKey, String value){
		fields.put(fieldKey, new String(value));
	}

	public BusinessObject addBusinessObject(String key) {
		
		BusinessObject bo = new BusinessObject(key);
		childs.put(key, bo);
		
		return bo; 
	}
}
