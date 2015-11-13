package fr.bibop.meta.factory;

import fr.bibop.meta.Context;
import fr.bibop.meta.datacontainer.DataContainer;
import fr.bibop.meta.datacontainer.def.DataContainerDefinition;

public class DataContentBuilder {
	
	Context ctx = null;
	
	public DataContentBuilder(Context context){
		ctx = context;
	}
	
	public void buildTarget(DataContainer dest, DataContainerDefinition targetDefinition){
		
		// Builder
		
	}

}
