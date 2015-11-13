package fr.bibop.meta.datacontainer.def.file;

import java.util.ArrayList;


public class XlsFileDefinition extends FileDefinition{

	private String separator = ";";
	ArrayList<XlsLineDefinition> linesDefinitions = new ArrayList<XlsLineDefinition>();
	
	public XlsFileDefinition(){
		super();
	}	
		
	public XlsLineDefinition addLineDefinition(){
		
		XlsLineDefinition line = new XlsLineDefinition();
		linesDefinitions.add(line);
	
		return line;
	}
	
	/**
	 * @return the separator
	 */
	public String getSeparator() {
		return separator;
	}

	/**
	 * @param separator the separator to set
	 */
	public void setSeparator(String separator) {
		this.separator = separator;
	}

	/**
	 * @return the linesDefinitions
	 */
	public ArrayList<XlsLineDefinition> getLinesDefinitions() {
		return linesDefinitions;
	}


	
	
	
	
}
