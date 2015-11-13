package fr.bibop.meta.datacontainer;

public class FileDataContainer extends DataContainer {
	
	String path = null;
	String type = null;
	
	public FileDataContainer(String path, String type, String id){
	
		super(id);
		this.path=path;
		this.type=type;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
