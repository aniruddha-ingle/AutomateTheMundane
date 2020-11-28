import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class RedditLinkParser {
	
	public static void printStr(String str) {
		System.out.println(str);
	}
	public static void trimLinks() throws IOException {
		String fileName = "links1.txt"; 
		File file = new File(fileName);
		File outFile = new File("communityNames.txt");
		
		BufferedReader bfRead = new BufferedReader(new FileReader(file));
		BufferedWriter bfWrite = new BufferedWriter(new FileWriter(outFile, false));
		
		String line;
		String commName;
		
		while ((line = bfRead.readLine())!= null ){
			String trimmedLink = line.trim();
			String [] checkLink = trimmedLink.split(":");
			if (checkLink[0].equals("https")) {
				String [] linkParts = checkLink[1].split("/");
				commName = linkParts[linkParts.length-1];
				bfWrite.write(commName+"\n");
				//printStr(commName);
			}
			else if(line.equals("")) {
				commName = "";
				bfWrite.write(commName+"\n");
			}
			
		}
		bfRead.close();
		bfWrite.close();
	}
	public static void main(String [] args) throws IOException{
		trimLinks();
		printStr("Processing Complete!");
	}
}
