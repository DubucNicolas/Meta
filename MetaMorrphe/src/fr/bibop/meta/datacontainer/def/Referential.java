package fr.bibop.meta.datacontainer.def;

import java.util.ArrayList;

import fr.bibop.meta.business.def.BusinessObjectDefinition;

public class Referential {

	String id = null;
	ArrayList<BusinessObjectDefinition> bodefs = new ArrayList< BusinessObjectDefinition>();
	
	public BusinessObjectDefinition addBusinessObjectDefinition(){
		
		BusinessObjectDefinition bo = new BusinessObjectDefinition();
		bodefs.add(bo);
		
		return bo;
	}

	/**
	 * @return the bodefs
	 */
	public ArrayList<BusinessObjectDefinition> getBodefs() {
		return bodefs;
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
}
