package fr.bibop.commons.dao.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import fr.bibop.commons.DatabaseParameters;
import fr.bibop.commons.Log;
import fr.bibop.commons.dao.BibopConnectionManager;

import java.sql.Connection;

public class UnitTestConnectionManager {

	
	@BeforeClass
	public static void initTestConditions() {
		
		DatabaseParameters wmoParams = new DatabaseParameters();
		wmoParams.setDatabaseName("WMOLive");
		wmoParams.setEncrypted("false");
		wmoParams.setLogin("sa");
		wmoParams.setPassword("7977crk");
		wmoParams.setServerIp("10.64.84.80");
		wmoParams.setServerPort("1433");
		wmoParams.setServerProvider(BibopConnectionManager.SQL_SERVER_TYPE_SQL_SERVER);
		BibopConnectionManager.getInstance("WMOLive").initLtaConnectionManager(wmoParams);
		
//		
//		DatabaseParameters wmoParams = new DatabaseParameters();
//		wmoParams.setDatabaseName("WMOLive");
//		wmoParams.setEncrypted("false");
//		wmoParams.setLogin("sa");
//		wmoParams.setPassword("7977crk");
//		wmoParams.setServerIp("192.168.164.141");
//		wmoParams.setServerPort("1077");
//		wmoParams.setServerProvider(LtaConnectionManager.SQL_SERVER_TYPE_SQL_SERVER);
//		LtaConnectionManager.getInstance("WMOLive").initLtaConnectionManager(wmoParams);
//
//		DatabaseParameters ltaParams = new DatabaseParameters();
//		ltaParams.setDatabaseName("AutoLTA");
//		ltaParams.setEncrypted("false");
//		ltaParams.setLogin("sa");
//		ltaParams.setPassword("7977crk");
//		ltaParams.setServerIp("192.168.164.141");
//		ltaParams.setServerPort("1077");
//		ltaParams.setServerProvider(LtaConnectionManager.SQL_SERVER_TYPE_SQL_SERVER);
		
		BibopConnectionManager.getInstance("AutoLTA").initLtaConnectionManager(wmoParams);
	}
	
	@Test
	public void testWMOConnection() throws Exception{
		
		Connection con = null;
		try {
			con = BibopConnectionManager.getInstance("WMOLive").getConnection();
		} catch (Exception e) {
			throw new Exception("Cannot open WMO database :\n" + Log.displayError(e));
		}
		
		assertNotNull(con);
	}
	
	@Ignore
	public void testLTAConnection() throws Exception{
		
		Connection con = null;
		
		try {
			con = BibopConnectionManager.getInstance("AutoLTA").getConnection();
		} catch (Exception e) {
			throw new Exception("Cannot open LTA database :\n" + Log.displayError(e));
		}
		
		assertNotNull(con);
	}
}
