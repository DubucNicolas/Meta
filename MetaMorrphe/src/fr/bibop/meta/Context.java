package fr.bibop.meta;

import java.util.ArrayList;
import java.util.Iterator;

import fr.bibop.meta.datacontainer.def.DataContainerDefinition;
import fr.bibop.meta.datacontainer.def.Referential;
import fr.bibop.meta.datacontainer.def.file.FlatFileDefinition;
import fr.bibop.meta.datacontainer.def.file.XmlFileDefinition;
import fr.bibop.meta.minterface.MetaInterface;

/**
 * Exceution context for Meta Component
 * 
 * @author bibop
  */
public class Context {

	ArrayList<MetaInterface> metaInterfaces = new ArrayList< MetaInterface>();
	ArrayList<DataContainerDefinition> dataContainersDefinition = new ArrayList<DataContainerDefinition>();
	Referential referential = new Referential();
		
	public MetaInterface addMetaInterface(){
		
		MetaInterface mint = new MetaInterface();
		metaInterfaces.add(mint);
		
		return mint;
	}
		
	public DataContainerDefinition addXmlFileDefinition(){
		
		DataContainerDefinition dc = new XmlFileDefinition();
		dataContainersDefinition.add(dc);
		return dc;
	}
	
	public DataContainerDefinition addFlatFileDefinition(){
		
		DataContainerDefinition dc = new FlatFileDefinition();
		dataContainersDefinition.add(dc);
		return dc;
	}
		
	public DataContainerDefinition getDataContainerDefinition(String id){
		
		DataContainerDefinition dcc = null;
		Iterator<DataContainerDefinition> it = dataContainersDefinition.iterator();
		
		while(it.hasNext()){
			
			dcc = it.next();
			if(dcc.getId().equals(id)){
				return dcc;
			}
		}
		
		return dcc;
		
	}

	public DataContainerDefinition getDataContainer(String id){
		
		DataContainerDefinition dcd = null;
		Iterator<DataContainerDefinition> it = dataContainersDefinition.iterator();
		
		while(it.hasNext() 
				&& !(dcd=it.next()).getId().equals(id)
				){
			continue;
		}
		
		return dcd;
	}

	/**
	 * @return the referential
	 */
	public Referential getReferential() {
		return referential;
	}
}
