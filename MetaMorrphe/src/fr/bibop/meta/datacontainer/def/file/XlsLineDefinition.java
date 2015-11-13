package fr.bibop.meta.datacontainer.def.file;

import java.util.ArrayList;

public class XlsLineDefinition {
	private String id = null;
	
	ArrayList<XlsFieldDefinition> fields = new ArrayList<XlsFieldDefinition>();
	
	public XlsFieldDefinition addXlsFieldDefinition(){
		XlsFieldDefinition field = new XlsFieldDefinition();
		fields.add(field);
		return field;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return the fields
	 */
	public ArrayList<XlsFieldDefinition> getFields() {
		return fields;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	
	
}
