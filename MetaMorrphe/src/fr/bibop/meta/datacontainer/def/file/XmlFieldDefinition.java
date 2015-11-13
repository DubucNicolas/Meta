package fr.bibop.meta.datacontainer.def.file;

public class XmlFieldDefinition {

	String tagName = null;
	String value = null;
	String mapping = null;
	String setSourceTag =  null;
	int setColumnCount;
	
	public String getTagName() {
		return tagName;
	}
	
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	
	/**
	 * @return the mapping
	 */
	public String getMapping() {
		return mapping;
	}

	/**
	 * @param mapping the mapping to set
	 */
	public void setMapping(String mapping) {
		this.mapping = mapping;
	}

	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	
}
