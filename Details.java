
public class Details {
	
	String count, time,  lat, lon, alt,  ID;
		
	public Details(String time,String lat,String lon,String alt,String ID,String count) {
		this.lat = lat;
		this.lon = lon;
		this.alt = alt;
		this.ID = ID;
		this.time = time;
		this.count = count;
	}
	public String getCount() {
		return this.count;
	}	
	public String getTime() {
		return this.time;
	}
	public String getLat() {
		return this.lat;
	}
	public String getLon() {
		return this.lon;
	}
	public String getAlt() {
		return this.alt;
	}
	public String getID() {
		return this.ID;
	}
	public void setTime(String time) {
		this.time = time;
	}
}
