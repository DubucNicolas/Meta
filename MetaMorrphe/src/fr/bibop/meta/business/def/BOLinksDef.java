package fr.bibop.meta.business.def;

public class BOLinksDef {

	private String linked_bo_id = null;
	private boolean iterative = true;

	public String getLinked_bo_id() {
		return linked_bo_id;
	}

	public void setLinked_bo_id(String linked_bo_id) {
		this.linked_bo_id = linked_bo_id;
	}

	public boolean isIterative() {
		return iterative;
	}

	public void setIterative(boolean iterative) {
		this.iterative = iterative;
	}
	
	public void setIterative(String iterative) {
		this.iterative = Boolean.parseBoolean(iterative);
	}
}
