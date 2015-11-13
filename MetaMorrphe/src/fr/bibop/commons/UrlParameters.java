package fr.bibop.commons;

public class UrlParameters {
	
	public static final String PROTOCOLE_FTP = "ftp";
	public static final String PROTOCOLE_FTPIS = "ftpis";
	public static final String PROTOCOLE_FTPES = "ftpes";
	public static final String PROTOCOLE_SFTP = "sftp";
	public static final String PROTOCOLE_JMS = "jms";
		
	private String protocole = null;
	private String user = null;
	private byte[] pass = null;
	private String host = null;
	private int port = 0;
	private String chemin;
	
	private String additionElements = null;
	/**
	 * @return the protocole
	 */
	public String getProtocole() {
		return protocole;
	}
	
	/**
	 * @param protocole the protocole to set
	 */
	public void setProtocole(String protocole) {
		this.protocole = protocole;
	}
	
	/**
	 * @return the user
	 */
	public String getUser() {
		return user;
	}
	
	/**
	 * @param user the user to set
	 */
	public void setUser(String user) {
		this.user = user;
	}
	
	/**
	 * @return the pass
	 */
	public byte[] getPass() {
		return pass;
	}
	
	/**
	 * @param pass the pass to set
	 */
	public void setPass(String pass) {
		this.pass = pass.getBytes();
	}
	
	/**
	 * @return the host
	 */
	public String getHost() {
		return host;
	}
	
	/**
	 * @param host the host to set
	 */
	public void setHost(String host) {
		this.host = host;
	}
	
	/**
	 * @return the port
	 */
	public int getPort() {
		return port;
	}
	
	/**
	 * @param port the port to set
	 */
	public void setPort(String port) {
		this.port = Integer.parseInt(port);
	}
	
	/**
	 * @return the chemin
	 */
	public String getChemin() {
		return chemin;
	}
	
	/**
	 * @param chemin the chemin to set
	 */
	public void setChemin(String chemin) {
		this.chemin = chemin;
	}
	
	/**
	 * @return the additionElements
	 */
	public String getAdditionElements() {
		return additionElements;
	}
	
	/**
	 * @param additionElements the additionElements to set
	 */
	public void setAdditionElements(String additionElements) {
		this.additionElements = additionElements;
	}
	
	
	
	public String toString(){
		//TODO
		String retStr = "";
		
		return retStr;
	}
	
}
