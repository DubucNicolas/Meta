package fr.bibop.meta.parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import fr.bibop.commons.Log;
import fr.bibop.meta.Context;
import fr.bibop.meta.MetaFunctionnalExecption;
import fr.bibop.meta.MetaTechnicalException;
import fr.bibop.meta.datacontainer.BusinessObject;
import fr.bibop.meta.datacontainer.DataContainer;
import fr.bibop.meta.datacontainer.FileDataContainer;
import fr.bibop.meta.datacontainer.def.DataContainerDefinition;
import fr.bibop.meta.datacontainer.def.file.FlatFileDefinition;
import fr.bibop.meta.datacontainer.def.file.FlatFileFieldDefinition;
import fr.bibop.meta.datacontainer.def.file.FlatFileLineDefinition;

public class FlatFileParser extends AbstractFileParser {
	
	Context ctx = null;
	
	public FlatFileParser(Context context){
		ctx = context;
	}
	
	public boolean parse(DataContainer source, DataContainerDefinition dcDef) {
	
		BufferedReader br = null;
		FileDataContainer fdc = null;
		FlatFileDefinition ffd = null;
		boolean ret = false;
				
		try{
			// Test Type of Input Datas :
			try {
				fdc = (FileDataContainer)source;
			}catch(ClassCastException e){
				throw new IOException("Bad Type Exception for DataContainer object (" + source.getId() + ").");
			}
			
			// Test Type of Input Datas :
			try {
				ffd = (FlatFileDefinition)dcDef;			
				
			}catch(ClassCastException e){
				throw new IOException("Bad Type Exception for DataContainer object (FlatFileDefinition => " + source.getId() + ").");
			}
			
			// Read file and process compilation
			br = new BufferedReader(
					new FileReader(
							fdc.getPath()
						)
					);
			
			String line = null;
			
			int nbSkip = ffd.getHeaderSkipLines();
			int i = 0;
				
			// Separator format file processing :
			//TODO implement inherit ... extends Flat or Separated
				
			// Separated files / CSV files :
			if(dcDef.getDataContainerlType().equals(DataContainerDefinition.TYPE_FILE_FLAT_SEPARATOR_LENGHT)){
				
				HashMap<String,String> map = new HashMap<String,String>();
				BusinessObject base_bo = new BusinessObject("root");
				
				while((line=br.readLine())!=null) {
					if(++i > nbSkip){
						
						if(ffd.getLinesDefinitions().size() != 1){
							br.close();
							throw new MetaTechnicalException("<ContentOfDataContainer> MUST contain one and only one <AddFlatFileLineDefinition> flat.");
						}
						FlatFileLineDefinition line_def = ffd.getLinesDefinitions().get(0);
						String key = null;
						String value = null;
						String path = null;
												
						// Get fields values :
						String[] values = line.split(ffd.getSeparator());
						
						//for each field Definition :
						Iterator<FlatFileFieldDefinition> it_field = line_def.fields.iterator();
						
						while(it_field.hasNext()){
							FlatFileFieldDefinition field_def = it_field.next();

							if(field_def.getColumn() > 0 && field_def.getColumn() <= values.length){
								map.put(field_def.getId(), values[field_def.getColumn() - 1 ]);
								
								// Assign values to BuisnessObject
								key=field_def.getId();
								value=values[field_def.getColumn() - 1 ];
								path=field_def.getMapping();
								
						 	 if(line_def.getBuildNewBO() != null){
						 		String newBos = line_def.getBuildNewBO();
						 		String tmp=newBos;
						 		
						 		BusinessObject curr_bo = new BusinessObject();
						 		
						 		while(tmp.contains(";")){
						 			curr_bo = new BusinessObject(); 
						 		}
						 		
								assignValueToBo(curr_bo, key, value);
								
							}else{
								br.close();
								throw new MetaFunctionnalExecption("FlatFileDefinition : Incorrect Definition. FlatFileField '" + field_def.getId() + "' print to OutOfBound data.");
							}
						}
												
						// Retrieve Business Object conainer and fill it
// Always build a new business Object for CSV file						
//						if(line_def.getBuildNewBO()){
							source.getBos().add(base_bo);
							base_bo = new BusinessObject();
						}

					}
				} // while br has line
				
				
			}else if(ffd.getDataContainerlType().equals(DataContainerDefinition.TYPE_FILE_FLAT_FIXED_LENGHT)){
				
				
				
				
				br.close();
				throw new Exception(" TO BE treat !!");
			}else{
				br.close();
				throw new Exception("Bad format ...");
			}
			
			br.close();
			ret = true;
			
		} catch (Exception e) {
			try {
				ret = false;
				br.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			Log.error(Log.displayError(e));
		}	
		
		return ret;
	}
}
