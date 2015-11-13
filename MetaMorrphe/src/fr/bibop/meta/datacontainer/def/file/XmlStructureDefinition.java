package fr.bibop.meta.datacontainer.def.file;

import java.util.ArrayList;

public class XmlStructureDefinition {

	ArrayList<XmlFieldDefinition> fieldDefinitions = new ArrayList<XmlFieldDefinition>();
	
	public XmlFieldDefinition addXmlFieldDefinition(){
		
		XmlFieldDefinition field = new XmlFieldDefinition();
		fieldDefinitions.add(field);
		return field;
	}
}
