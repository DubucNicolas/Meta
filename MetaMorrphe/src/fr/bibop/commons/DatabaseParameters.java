package fr.bibop.commons;

/**
 * Standard databae parameters
 * 
 * @author Nicolas Dubuc
 *
 */
public class DatabaseParameters {

	private String login 			= null;
	private String databaseName 	= null;
    private boolean encrypted		= false;
	private byte[] password 		= null;
	private String serverFile		= null;
	private String serverIp 		= null;
	private String serverPort 		= null;
	private String serverProvider	= null;
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getDatabaseName() {
		return databaseName;
	}
	
	public void setDatabaseName(String name) {
		this.databaseName = name;
	}
	
	public String getPassword() {
		return (password!=null ? new String(password) : null);
	}
	
	public void setPassword(String password) {
		this.password = (password!=null?password.getBytes():null);
	}
	
	public String getServerHost() {
		return serverIp;
	}
	
	public void setServerIp(String serverIp) {
		this.serverIp = serverIp;
	}
	
	public String getServerPort() {
		return serverPort;
	}
	
	public void setServerPort(String serverPort) {
		this.serverPort = serverPort;
	}

	public String getServerProvider() {
		return serverProvider;
	}

	public void setServerProvider(String serverProvider) {
		this.serverProvider = serverProvider;
	}

	public String getServerFile() {
		return serverFile;
	}

	public void setServerFile(String serverFile) {
		this.serverFile = serverFile;
	}

	public boolean isEncrypted() {
		return encrypted;
	}

	public void setEncrypted(String encrypted) {
		this.encrypted = Boolean.parseBoolean(encrypted);
	}
	
	
}
