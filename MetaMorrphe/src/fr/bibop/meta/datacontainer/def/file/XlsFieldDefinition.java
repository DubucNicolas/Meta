package fr.bibop.meta.datacontainer.def.file;

public class XlsFieldDefinition {

	// Champ de la table LtaProductConfig : Ex col 2 : id = orderStartDate !
	private String id = null;
	private int column;
	
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @return the column
	 */
	public int getColumn() {
		return column;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @param column the column to set
	 */
	public void setColumn(int column) {
		this.column = column;
	}

	
}