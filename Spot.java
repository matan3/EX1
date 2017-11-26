
public class Spot 
{
	String ID;
	String time;
	String type;
	String mac;
	String ssid;
	String chanal;
	String lat;
	String lon;
	String alt;
	String signal;
	
	
public Spot(String line,String ID) {
	String[] temp = line.split(",");
	this.ID = ID;
	this.mac = temp[0];
	this.ssid = temp[1];
	this.time = temp[3];
	this.chanal=temp[4];
	this.signal = temp[5];
	this.lat = temp[6];
	this.lon = temp[7];
	this.alt = temp[8];
	this.type = temp[10];
	

}
/**
 * @return lat
 */
public String getLat() {
	return this.lat;
}

/**
 * @return lon
 */
public String getLon() {
	return this.lon;
}

/**
 * @return alt
 */
public String getAlt() {
	return this.alt;
}

/**
 * @return ID
 */
public String getID() {
	return this.ID;
}

/**
 * @return type
 */
public String getType() {
	return this.type;
}

/**
 * @return mac
 */
public String getMac() {
	return this.mac;
}

/**
 * @return SSID
 */
public String getSSID() {
	return this.ssid;
}

/**
 * @return chanal
 */
public String getchanal() {
	return this.chanal;
}

/**
 * @return time
 */
public String getTime() {
	return this.time;
}

/**
 * @return signal
 */
public String getSignal() {
	return this.signal;
}

public String toString() {
	return chanal + "," + time + "," + lat + "," + lon + "," + alt + "," + mac + "," + ssid + "," + ID + ","
			+ signal+ ","+ type;
}
}

