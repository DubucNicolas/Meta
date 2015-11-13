package fr.bibop.meta.datacontainer.def.file;

import fr.bibop.meta.datacontainer.def.DataContainerDefinition;

public class FileDefinition extends DataContainerDefinition {
	
	private String nameRegexIdentifier = "not_defined";
	private String dataContainerlType = null;
	
	/**
	 * @return the nameRegexIdentifier
	 */
	public String getNameRegexIdentifier() {
		return nameRegexIdentifier;
	}

	/**
	 * @param nameRegexIdentifier the nameRegexIdentifier to set
	 */
	public void setNameRegexIdentifier(String nameRegexIdentifier) {
		this.nameRegexIdentifier = nameRegexIdentifier;
	}

	/**
	 * @return the dataContainerlType
	 */
	public String getDataContainerlType() {
		return dataContainerlType;
	}

	/**
	 * @param dataContainerlType the dataContainerlType to set
	 */
	public void setDataContainerlType(String dataContainerlType) {
		this.dataContainerlType = dataContainerlType;
	}
}
