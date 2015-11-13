package fr.bibop.meta;

import java.io.File;

import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.RollingFileAppender;

import fr.bibop.commons.Log;
import fr.bibop.meta.datacontainer.DataContainer;
import fr.bibop.meta.datacontainer.FileDataContainer;

public class MetaMorpheLauncher {

	// Logging properties
	public final static String 	LOG_PATTERN_LAYOUT		= "%d{yyyyMMdd.HH:mm:ss.SSS} [%p][%m]%n";
	public final static String 	LOG_MAX_FILES_SIZE		= "10MB";
	public final static int 	LOG_MAX_NB_FILES		= 5;
	
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		
		boolean debug = true;
		String[] localArgs = null;
		
		if (debug) {
			// testing purpose only
			localArgs = new String[2];
			
			// configuration file
			localArgs[0] = "Conf.xml";
			
			// log file
			localArgs[1] = "meta.log";

		} else {
			if (args.length < 2) {
				System.err.println("Required parameters is missing");
				System.exit(1);
			} else {
				String[] strs = new String[2];
				strs[0] = args[0];
				strs[1] = args[1];
				localArgs = strs;
			}
		}		
		
		// setup LOG4J rolling file appender
		Logger logger = Logger.getLogger("remote");
		PatternLayout patternLayout = new PatternLayout(LOG_PATTERN_LAYOUT);
		RollingFileAppender appender = new RollingFileAppender(patternLayout,localArgs[1], true);
		appender.setMaxBackupIndex(LOG_MAX_NB_FILES);
		appender.setMaxFileSize(LOG_MAX_FILES_SIZE);
		logger.addAppender(appender);

		// setup Log class
		Log.setup(logger);		

		MetaMorphe meta = new MetaMorphe(localArgs[0]);
		
		//TODO: Automatically manage type of dataContainer and associataed DataCOntainerDefinition : Use DireFileWatcher ... View LTA code
		
		DataContainer source = new FileDataContainer(new File("ressources/in/Clients.flat.csv").getAbsolutePath(), "flat_file_input", "flat_file_input");
		DataContainer destination = new FileDataContainer(new File("ressources/in/Clients.unflat.xml").getAbsolutePath(), "file_xml", "xml_file_output");
				
		meta.transformDataSource(source,
				destination);
		
	}
}
