package fr.bibop.meta.business.def;

import java.util.ArrayList;

public class BusinessObjectDefinition {

	private String id = null;
	private ArrayList<BOFieldDef> fields = new ArrayList<BOFieldDef>();
	ArrayList<BusinessObjectDefinition> sub_bodefs = new ArrayList< BusinessObjectDefinition>(); 
	
	public BOFieldDef addFieldDefinition(){
		
		BOFieldDef bof = new BOFieldDef();
		fields.add(bof);
		return bof;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	ArrayList<BusinessObjectDefinition> bodefs = new ArrayList< BusinessObjectDefinition>();
	
	public BusinessObjectDefinition addBusinessObjectDefinition(){
		
		BusinessObjectDefinition bo = new BusinessObjectDefinition();
		bodefs.add(bo);
		
		return bo;
	}
}
