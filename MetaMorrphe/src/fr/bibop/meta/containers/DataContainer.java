package fr.bibop.meta.containers;

import java.util.ArrayList;

public class DataContainer {

	String type;
	String id;
	//DataContainerDefinition dcd;
	ArrayList<BusinessObject> bos = new ArrayList<BusinessObject>();

//	/**
//	 * @return the dcd
//	 */
//	public DataContainerDefinition getDcd() {
//		return dcd;
//	}
//	/**
//	 * @param dcd the dcd to set
//	 */
//	public void setDcd(DataContainerDefinition dcd) {
//		this.dcd = dcd;
//	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
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
	/**
	 * @return the bos
	 */
	public ArrayList<BusinessObject> getBos() {
		return bos;
	}
	/**
	 * @param bos the bos to set
	 */
	public void setBos(ArrayList<BusinessObject> bos) {
		this.bos = bos;
	}
	
	
}
