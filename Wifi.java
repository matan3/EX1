
public class Wifi {
	String  mac,ssid,chanal,signal;
	public Wifi(String  mac,String ssid,String chanal,String signal){
		this.mac =mac;
		this.ssid = ssid;
		this.chanal=chanal;
		this.signal = signal;
	}
	public String getMac() {
		return this.mac;
	}
	public String getSsid() {
		return this.ssid;
	}
	public String getChanal() {
		return this.chanal;
	}
	public String getSignal() {
		return this.signal;
	}
	public void setMac(String mac) {
		this.mac = mac;
	}
	public void setSsid(String ssid) {
		this.ssid = ssid;
	}
	public void setChanal(String chanal) {
		this.chanal = chanal;
	}
	public void setSignal(String signal) {
		this.signal = signal;
	}
}
