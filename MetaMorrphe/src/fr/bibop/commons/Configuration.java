package fr.bibop.commons;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;


public class Configuration {

	
	/**
	 * Load the structured XML configuration file.
	 * 
	 * XML configuration file need to be define like that :
	 * 
	 * <BaseObject>
	 * 		<objectField></objectField>
	 * 		<Object>
	 * 			<objectField></objectField>
	 * 			<objectField></objectField>
	 * 		</Object>
	 * 		<Object>
	 * 			<objectField></objectField>
	 * 			<objectField></objectField>
	 * 		</Object>
	 * 		...
	 * 		<AnotherObject1>
	 * 			<objectField></objectField>
	 * 			<AnotherObject2>
	 * 				<objectField></objectField>
	 * 				<objectField></objectField>
	 * 			</AnotherObject2>
	 * 		</AnotherObject1>
	 * 	
	 * 	- BaseObject need to be set.
	 *  - setter need to define for all objectField
	 *  - The first letter of objectField is a lower case
	 *  - The first letter of Object is a higher case 
	 *  - Object can be nested :
	 *  	- Remind that getter and setter must be define for all Objects.
	 *  	- fields can be set for any Objects.
	 * 
	 * @param file : the configuration file name
	 * @param baseObject : the pending Caller instance
	 * @throws XMLStreamException
	 * @throws IOException 
	 */

	public static void parseConfiguration(String file, Object baseObject) throws XMLStreamException, IOException {
		
		XMLInputFactory xmlif = XMLInputFactory.newInstance();
		xmlif.setProperty( XMLInputFactory.IS_SUPPORTING_EXTERNAL_ENTITIES,	Boolean.FALSE );
		FileInputStream fin = new FileInputStream(file);
		XMLStreamReader xmlr = xmlif.createXMLStreamReader(fin);
					
		Object currentObject 	= baseObject;
		ArrayList<Object> heap 	= new ArrayList<Object>();
		heap.add(baseObject);
		
		Method mth;
		String key = null, value = null;
		boolean init = false;
		Class<?>[] cl = new Class<?>[1];
		cl[0] = String.class;
		
		while (xmlr.hasNext()) {
			switch (xmlr.next()) {
			
			// start element, skip root element and store node name
			case XMLStreamReader.START_ELEMENT:
				if (init) {
					key = xmlr.getLocalName();
					
					// Class descriptor
					if (key.substring(0, 1).equals(key.substring(0, 1).toUpperCase())) {
						try {	
							// save current into previous
							if(key.toUpperCase().startsWith("ADD")){
								mth = currentObject.getClass().getDeclaredMethod(
										key.substring(0, 1).toLowerCase() + key.substring(1, key.length()));
								currentObject = mth.invoke(currentObject);
								heap.add(currentObject);
							}else{
								mth = currentObject.getClass().getDeclaredMethod("get" + key);
								currentObject = mth.invoke(currentObject);
								heap.add(currentObject);
							}
						} catch (Exception e) {
							
							Log.error(Log.displayError(e));
						}
						key = null;
					} 
					
				}
				init = true;
				break;
				
			// end element, call the POJO setter
			case XMLStreamReader.END_ELEMENT:
				
				if (key != null) {
					try {
						
						mth = currentObject.getClass().getDeclaredMethod(key, cl);
						mth.invoke(currentObject, value);
					
					} catch (NoSuchMethodException e){
						
						// try to get Inheriot Methods
						Class<? extends Object> clazz = currentObject.getClass();
							
						while(clazz.getSuperclass()!=null){ // we don't want to process Object.class
							try{	
								clazz = clazz.getSuperclass();
								mth = clazz.getDeclaredMethod(key, cl);
								mth.invoke(currentObject, value);
								
								break; //Method found
								
							}catch(NoSuchMethodException ex){
								// Not an error
							}catch (Exception ex) {
								
								Log.error(Log.displayError(e));
							}
						}
												
					} catch (Exception e) {
						
						Log.error(Log.displayError(e));
					}
				}else {
					// Go back one object
					if(heap.size() > 1) {
						currentObject = heap.get( heap.size() -2);
						heap.remove(heap.size() - 1);
					}
				}
					
				key = null;
				value = null;
				break;
				
			// text node, save value for later setter call
			case XMLStreamReader.CDATA:
				case XMLStreamReader.CHARACTERS:
				if (key != null) {
					value = xmlr.getText();
				}
				break;
			}
		}
		
//		 close XMLStreamReader and related FileInputStream
		xmlr.close();
		fin.close();
	}
}
