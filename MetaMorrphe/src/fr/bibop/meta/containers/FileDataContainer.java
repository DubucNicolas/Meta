package fr.bibop.meta.containers;

public class FileDataContainer extends DataContainer {

	public FileDataContainer(String path, String type, String id){
		this.path = path;
		super.setType(type);
		super.setId(id);
	}
	
	String path = null;
	
	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}

	/**
	 * @param path the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}
	
	
}
