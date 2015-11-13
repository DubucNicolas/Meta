package fr.bibop.meta.datacontainer.def;

/**
 * Data container define object than contains data. Can be file, JMS broker, databases  
 * 
 * 
 * @author NDU
 *
 */
public class DataContainerDefinition {
	
	public final static String TYPE_FILE_FLAT_FIXED_LENGHT = "file_flat_fixed_lenght";
	public final static String TYPE_FILE_FLAT_SEPARATOR_LENGHT = "file_flat_separator_lenght";
	public final static String TYPE_FILE_XML = "file_xml";
	public final static String TYPE_FILE_XLS = "file_xls";
	public final static String TYPE_FILE_XLSX = "file_xlsx";
	public final static String TYPE_DATABASE = "db";
	public final static String TYPE_JMS = "jms";
	
	private String dataContainerlType = null;
	private String id = null;
	
	public String getDataContainerlType() {
		return dataContainerlType;
	}

	public void setDataContainerlType(String dataContainerlType) {
		this.dataContainerlType = dataContainerlType;
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
