package fr.bibop.meta.parser;

import fr.bibop.commons.Log;
import fr.bibop.meta.Context;
import fr.bibop.meta.datacontainer.DataContainer;
import fr.bibop.meta.datacontainer.def.DataContainerDefinition;

public class DataContentParser {
	
	Context ctx = null;
	
	public DataContentParser(Context context){
		
		ctx = context;
		
	}

	public boolean compileSource(DataContainer source, DataContainerDefinition dcDef){
		
		boolean ret = false;
		
		if(dcDef.getDataContainerlType().equals(DataContainerDefinition.TYPE_FILE_FLAT_FIXED_LENGHT)){
			
			FlatFileParser ffp = new FlatFileParser(ctx);
			ret= ffp.parse(source, dcDef);
			
		}else if(dcDef.getDataContainerlType().equals(DataContainerDefinition.TYPE_FILE_FLAT_SEPARATOR_LENGHT)){
			
			FlatFileParser ffp = new FlatFileParser(ctx);
			ret = ffp.parse(source, dcDef);
			
		}else if(dcDef.getDataContainerlType().equals(DataContainerDefinition.TYPE_FILE_XML)){
			
		}else{
			Log.error("(toBusinessObject) : Type not supported for now : '" + dcDef.getDataContainerlType() + "'"); 
		}
		
		return ret;
	}
	
}
