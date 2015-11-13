package fr.bibop.meta.datacontainer.def.file;

/**
 * POJO for a field on a flat file line.
 * @author Nicolas Dubuc
 *
 */
public class FlatFileFieldDefinition {

	private int position;
	private int lenght;
	private int column;
	private String id = null;
	private String mapping = null;
	private String outputFormat = null;
	
	public int getLenght() {
		return lenght;
	}

	public void setLenght(String lenght) {
		this.lenght = Integer.parseInt(lenght);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	public int getPostion() {
		return position;
	}
	
	public void setPosition(String position) {
		this.position = Integer.parseInt(position);
	}

	public String getOutputFormat() {
		return outputFormat;
	}

	public void setOutputFormat(String outputFormat) {
		this.outputFormat = outputFormat;
	}

	/**
	 * @return the column
	 */
	public int getColumn() {
		return column;
	}

	/**
	 * @param column the column to set
	 */
	public void setColumn(int column) {
		this.column = column;
	}
	/**
	 * @param column the column to set
	 */
	public void setColumn(String column) {
		this.column = Integer.parseInt(column);
	}

	public String getMapping() {
		return mapping;
	}

	public void setMapping(String mapping) {
		this.mapping = mapping;
	}
}
