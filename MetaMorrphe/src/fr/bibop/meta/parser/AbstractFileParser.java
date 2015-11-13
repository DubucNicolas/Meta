package fr.bibop.meta.parser;

import java.util.ArrayList;

import fr.bibop.meta.datacontainer.BusinessObject;
import fr.bibop.meta.datacontainer.DataContainer;
import fr.bibop.meta.datacontainer.def.DataContainerDefinition;

public abstract class AbstractFileParser {

	/**
	 * file : input file to be parse
	 * bos  : Buisiness output Object to be filled
	 */
	public abstract boolean parse(DataContainer source_dc, DataContainerDefinition boDef); 
	
	public void assignValueToBo(BusinessObject bo, String path, String value) throws Exception {
		
		String key;
		String remain;
		
		remain=path;
		BusinessObject curr = bo;
		
		while(remain.contains(".")){ // Business Object reach and needed
			
			key=path.substring(0,path.indexOf("."));
			remain=path.substring(path.indexOf(".") + ".".length());
			
			Object child = bo.childs.get(key);
			if(child != null){
				curr = (BusinessObject)child;
			}else
				// test type returned
				curr = ((BusinessObject)bo).addBusinessObject(key);
		}
		
		// Field...
		curr.addField(remain, value);
		
	}
}
