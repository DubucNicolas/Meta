package fr.bibop.meta.datacontainer;

import java.util.ArrayList;

public class DataContainer {

	ArrayList<BusinessObject> bos = new ArrayList<BusinessObject>();
	String id = null;
	
	DataContainer(String id){
		this.id=id;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public ArrayList<BusinessObject> getBos() {
		return bos;
	}
	
}
