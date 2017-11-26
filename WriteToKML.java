import java.io.File;
import java.io.FileNotFoundException;


import java.util.List;

import de.micromata.opengis.kml.v_2_2_0.Document;
import de.micromata.opengis.kml.v_2_2_0.Kml;
import de.micromata.opengis.kml.v_2_2_0.Placemark;

public class WriteToKML 
{
	public  void createKMLFile(List<Row> list){
		   Kml l =new Kml();
		   Document doc=l.createAndSetDocument();
		   
		for (int i = 0; i < list.size(); i++) {
			
			for (int j = 0; j < list.get(i).getElement().size(); j++) {
//insert wifi by wifi from the final list
		Placemark p = doc.createAndAddPlacemark();
				p.createAndSetTimeStamp().withWhen(list.get(i).getHead().getTime().replace(' ','T'));
				p.withDescription("Ssid: "+list.get(i).getElement().get(j).getSsid()+"\nSignal:   "+list.get(i).getElement().get(j).getSignal()+"\nChanal:   "+list.get(i).getElement().get(j).getChanal()+"\nMac:   "+list.get(i).getElement().get(j).getMac()
				+"\nTime and Date:   "+list.get(i).getHead().getTime()+"\nID:   "+list.get(i).getHead().getID()).withName(list.get(i).getElement().get(j).getSsid()).withOpen(Boolean.TRUE).createAndSetPoint().addToCoordinates(
						Double.parseDouble(list.get(i).getHead().getLon()),Double.parseDouble(list.get(i).getHead().getLat()));
		}}
		if(list.size()>0){
		try {
			l.marshal(new File("final.kml"));//write to kml file
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		else
			System.out.println("there is no wifi to create kml file");
		}

	
	

}
