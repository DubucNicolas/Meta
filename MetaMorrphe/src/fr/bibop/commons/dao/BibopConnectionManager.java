package fr.bibop.commons.dao;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;

import fr.bibop.commons.DatabaseParameters;
import fr.bibop.commons.Security;
import fr.bibop.commons.SecurityException;

public class BibopConnectionManager implements ConnectionManager {

	public final static String SQL_JDBC_SQL_SERVER_DRIVER		= "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	public final static String SQL_JDBC_ACCES_DRIVER			= "sun.jdbc.odbc.JdbcOdbcDriver";
	public final static String SQL_JDBC_POSTGRES_DRIVER			= "org.postgresql.Driver";
	
	public final static String SQL_SERVER_TYPE_SQL_SERVER		= "SQLServer";
	public final static String SQL_SERVER_TYPE_ACCES_MDB_FILE	= "AccesMbd";
	public final static String SQL_SERVER_TYPE_POSTGRES_SERVER	= "Postgres";
	
	private final static String DATABASE_SQLSERVER_URL		= "jdbc:sqlserver://";
    private final static String DATABASE_POSTGRES_URL		= "jdbc:postgresql://";
    private final static String DATABASE_ACCES_URL			= "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)}";

	private final static int	DEFAULT_TIMEOUT				= 5;
	
    private DatabaseParameters	databaseParameters			= null;
	private static 	HashMap<String, BibopConnectionManager> _instances_ = new HashMap<String, BibopConnectionManager>();
	private int loginTimeOut;
	
	public void initLtaConnectionManager(DatabaseParameters dbParams) {
		initLtaConnectionManager(dbParams, DEFAULT_TIMEOUT);
	}

	public void initLtaConnectionManager(DatabaseParameters dbParams, int loginTimeout) {
		this.databaseParameters = dbParams;
		this.loginTimeOut = loginTimeout;
		
	}
	
	public static BibopConnectionManager getInstance(String insnstanceName) {
		
		if(_instances_.get(insnstanceName) == null){
			synchronized(BibopConnectionManager.class){
				if(_instances_.get(insnstanceName) == null){
					_instances_.put(insnstanceName, new BibopConnectionManager());
				}
			}
		}		
		return _instances_.get(insnstanceName);
	}
    
    /**
     * build connection url depending to this.serverProvider
     * 
     * @return
     * @throws ClassNotFoundException
     */
     private static String getConnectionUrl(DatabaseParameters dbParams) throws ClassNotFoundException{
    	 
    	 if(dbParams.getServerProvider().equals(BibopConnectionManager.SQL_SERVER_TYPE_SQL_SERVER)) {
    		 
    		 Class.forName(BibopConnectionManager.SQL_JDBC_SQL_SERVER_DRIVER);
    		 return DATABASE_SQLSERVER_URL+dbParams.getServerHost()+":"+dbParams.getServerPort()+";databaseName="+dbParams.getDatabaseName();//+";selectMethod="+selectMethod+";";
    		 
    	 }else if(dbParams.getServerProvider().equals(BibopConnectionManager.SQL_SERVER_TYPE_ACCES_MDB_FILE)) {
    		 
    		 Class.forName(BibopConnectionManager.SQL_JDBC_ACCES_DRIVER);
    		 return DATABASE_ACCES_URL +";" + "DBQ=" + dbParams.getServerFile().trim() + ";READONLY=" + new Boolean(true) +"}";
    		 
    	 }else if(dbParams.getServerProvider().equals(BibopConnectionManager.SQL_SERVER_TYPE_POSTGRES_SERVER)){
    		 
    		 return DATABASE_POSTGRES_URL+dbParams.getServerHost()+":"+dbParams.getServerPort()+ File.separatorChar +dbParams.getDatabaseName(); 
    		 
    	 }else  {
    		 
    		 return null;
    	 }
	}
	
	/**
	* Retrieve an java.sql.Connection object
	* 
	* Note : set Auto committement to false (transaction mode)
	* 
	* @param DatabaseParameters object
	* @return Connection Object
	* 
	 * @throws SecurityException		if password cannot be properly decrypt
	 * @throws ClassNotFoundException	if driver cannot be Found
	 * @throws SQLException				if Connection Exception
	*/
	public Connection getConnection() throws SQLException, SecurityException, ClassNotFoundException  {
		
		return buildConnection(this.databaseParameters);
	}
	
	/**
	 * Build DAO connection request
	 * 
	 * 
	 * @param dbParams
	 * @return
	 * @throws SecurityException		if password cannot be properly decrypt
	 * @throws ClassNotFoundException	if driver cannot be Found
	 * @throws SQLException				if Connection Exception
	 * 
	 */
	private Connection buildConnection(DatabaseParameters dbParams) throws SQLException, ClassNotFoundException, SecurityException{
		
		Connection con = null;
		
		String pass = null;
		if(dbParams.getPassword() != null){
			if(dbParams.isEncrypted()) {
				pass = Security.decrypt(new String(dbParams.getPassword()));
			}else {
				pass = new String(dbParams.getPassword());
			}
		}
		String url = getConnectionUrl(dbParams);
		DriverManager.setLoginTimeout(this.loginTimeOut);
		con = DriverManager.getConnection(url, dbParams.getLogin(), pass);
		
		if(!dbParams.getServerProvider().equals(BibopConnectionManager.SQL_SERVER_TYPE_ACCES_MDB_FILE)){
			con.setAutoCommit(false);
		}else if(dbParams.getServerProvider().equals(BibopConnectionManager.SQL_JDBC_POSTGRES_DRIVER)){
			con.setAutoCommit(false);
		}
			
		return con;
	}
}
