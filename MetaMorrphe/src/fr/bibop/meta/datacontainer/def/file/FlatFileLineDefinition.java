package fr.bibop.meta.datacontainer.def.file;

import java.util.ArrayList;

public class FlatFileLineDefinition{

	String headerId = null;
	String object = null;
	int headerPosition;
	String buildNewBO = null;
	public ArrayList<FlatFileFieldDefinition> fields = new ArrayList<FlatFileFieldDefinition>();
		
	public String getHeaderId(){
		return headerId;
	}
	
	public void setHeaderId(String id){
		headerId = id;
	}

	public int getHeaderPosition() {
		return headerPosition;
	}

	public void setHeaderPosition(int headerPosition) {
		this.headerPosition = headerPosition;
	}
	
	public void setHeaderPosition(String headerPosition) {
		this.headerPosition = Integer.parseInt(headerPosition);
	}
	
	public FlatFileFieldDefinition addFlatFileFieldDefinition(){
		
		FlatFileFieldDefinition field = new FlatFileFieldDefinition();
		fields.add(field);
		
		return field;
	}

	public String getObject() {
		return object;
	}

	public void setObject(String object) {
		this.object = object;
	}

	public void setBuildNewBO(String buildNewBO) {
		this.buildNewBO = buildNewBO;
	}

	public String getBuildNewBO() {
		return buildNewBO;
	}
}
