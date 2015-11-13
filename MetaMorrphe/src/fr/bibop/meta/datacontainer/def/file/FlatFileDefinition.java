package fr.bibop.meta.datacontainer.def.file;

import java.util.ArrayList;

import fr.bibop.meta.datacontainer.def.DataContainerDefinition;


public class FlatFileDefinition extends DataContainerDefinition {

	private String dataContainerlType = null;
	private String separator = null;
	private ArrayList<FlatFileLineDefinition> linesDefinitions = new ArrayList<FlatFileLineDefinition>();
	private int headerSkipLines = 0;

	public FlatFileDefinition(){
		super();
	}
	
	
	public FlatFileLineDefinition addFlatFileLineDefinition(){
		
		FlatFileLineDefinition lineDefinition = new FlatFileLineDefinition();
		linesDefinitions.add(lineDefinition);
		
		return lineDefinition;
	}

	public String getDataContainerlType() {
		return dataContainerlType;
	}

	public void setDataContainerlType(String type) {
		this.dataContainerlType = type;
	}

	public String getSeparator() {
		return separator;
	}

	public void setSeparator(String separator) {
		this.separator = separator;
	}

	public ArrayList<FlatFileLineDefinition> getLinesDefinitions() {
		return linesDefinitions;
	}

	/**
	 * @return the headerSippLines
	 */
	public int getHeaderSkipLines() {
		return headerSkipLines;
	}

	/**
	 * @param headerSippLines the headerSippLines to set
	 */
	public void setHeaderSkipLines(String headerSippLines) {
		this.headerSkipLines = Integer.parseInt(headerSippLines);
	}
}
