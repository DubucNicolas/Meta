package fr.bibop.meta.containers;

import java.util.HashMap;

public class BusinessObject {
	
	public HashMap<String, Object> objects = new HashMap<String, Object>();
	public String id = null;
	
	public BusinessObject(){
	}
	
	public BusinessObject(String id){
		this.id = id;
	}
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	public void addField(String id, String value, BusinessObject bo){
		
		//TODO Type manadgement !!!
			//TODO plus conversion ??
		
		Object obj = new String(value);
		objects.put(id, obj);
		
	}
	
	public Object addBusinessObject(String id){
		
		BusinessObject bo = new BusinessObject(id);
		bo.setId(id);
		objects.put(id, bo);
		
		return bo;
	}
}
