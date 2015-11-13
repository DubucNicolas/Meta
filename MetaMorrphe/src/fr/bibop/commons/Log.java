package fr.bibop.commons;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.log4j.Logger;

/**
 * LOG4J logging facade
 * @author JH. CONGIA
 *
 */
public class Log {

	public static Logger logger = null;
	
	public static void setup(Logger log) {
		logger = log;
	}
	
	public static void debug (Object message) {
		if (logger != null && logger.isDebugEnabled())
			logger.debug(message);
	}
	
	public static void info (Object message) {
		if (logger != null && logger.isInfoEnabled())
			logger.info(message);
	}

	public static void trace (Object message) {
		if (logger != null && logger.isTraceEnabled())
			logger.trace(message);
	}

	public static void warn (Object message) {
		if (logger != null)
			logger.warn(message);
	}
	
	public static void error (Object message) {
		if (logger != null)
			logger.error(message);
	}

	public static void fatal (Object message) {
		if (logger != null)
			logger.fatal(message);
	}

	/**
	 * Display error in a String object
	 * 
	 * @param e : the exception to be displayed
	 * @return String
	 */
	public static String displayError(Exception e) {
		
		StringWriter sw = new StringWriter();
		e.printStackTrace(new PrintWriter(sw));
		String ret_str = sw.toString();
		
		return ret_str;
	}
	
}
