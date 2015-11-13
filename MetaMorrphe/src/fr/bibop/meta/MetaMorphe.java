package fr.bibop.meta;

import fr.bibop.commons.Configuration;
import fr.bibop.commons.Log;
import fr.bibop.meta.datacontainer.DataContainer;
import fr.bibop.meta.factory.DataContentBuilder;
import fr.bibop.meta.parser.DataContentParser;

public class MetaMorphe {

	String conf = null;
	int frequency = 2000;
	boolean run =  false;
	
	Context ctx = new Context();
	
	public MetaMorphe(String configuration) throws Exception {
		
		this.conf = configuration;
		Log.info("Compiling Configuration");
		Configuration.parseConfiguration(conf, ctx);
		
		Log.info("Configuration compiled");
		
	}

	public void transformDataSource(DataContainer source,
									DataContainer destination) throws Exception {
	
		// Compile source objets into business Objects
		DataContentParser parser = new DataContentParser(ctx);
		
		boolean ret = parser.compileSource(source, ctx.getDataContainerDefinition(source.getId()));
		org.mortbay.log.Log.info("Code retour : " + ret);
		// Report Business object to output data container 
		//TODO: Managed Output Data output and multiple output and transaction ... (JTA ??)
			// manage more than mapping : data conversion / transformation
		
		DataContentBuilder builder = new DataContentBuilder(ctx);
		
		builder.buildTarget(destination,
				ctx.getDataContainerDefinition(destination.getId())
				);
		
	}
}
