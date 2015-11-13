package fr.bibop.meta.datacontainer.def.file;

import java.util.ArrayList;

public class XmlFileDefinition extends FileDefinition{

	String xsd	= null;
	String version = "1.0";
	String encoding = "UTF-8";
	String rootTag = "root";
	String nameSpaceUri = null;

	ArrayList<XmlFieldDefinition> fields = new ArrayList<XmlFieldDefinition>();
	ArrayList<XmlStructureDefinition> structures = new ArrayList<XmlStructureDefinition>();
	
	public XmlFileDefinition(){
		super();
	}
	
	public XmlFieldDefinition addXmlFieldDefinition(){
		XmlFieldDefinition field = new XmlFieldDefinition();
		fields.add(field);
		return field;
	}
	
	public String getXsd() {
		return xsd;
	}

	public void setXsd(String xsd) {
		this.xsd = xsd;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getEncoding() {
		return encoding;
	}

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	public String getRootTag() {
		return rootTag;
	}

	public void setRootTag(String rootTag) {
		this.rootTag = rootTag;
	}

	public String getNameSpaceUri() {
		return nameSpaceUri;
	}

	public void setNameSpaceUri(String nameSpaceUri) {
		this.nameSpaceUri = nameSpaceUri;
	}
	
	public XmlStructureDefinition addXmlStructureDefinition(){
		XmlStructureDefinition structure = new XmlStructureDefinition();
		structures.add(structure);
		return structure;
	}
	
}
