import java.text.ParseException;

public class Main {

	public static void main(String[] args) throws ParseException {
		
		String dirPath = "C:/WifiFiles_Matala_Munche";
		String desPath = "C:/output2.csv";

		Q2 q2 = new Q2();          // read files from directory and write to file
		q2.ReadDir(dirPath,desPath);
		
		String srcPath = "C:/output2.csv";		
		Q3 q3 = new Q3();
		q3.ReadFile(srcPath);     // read file -> filter by time&ID&location -> filter by MAC -> write to kml
		
		
		
		
	}

}
