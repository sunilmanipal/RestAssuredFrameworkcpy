package Utility;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Payloadconvertor {
	//Basically to convert the body in to string 
	public static String generatepayloadString(String filename) throws IOException
	{
		//i want is the file name 
		String filepath = "D:\\Rest Assured -API\\Framework\\resource\\" + filename;
		//if you give this to someother his fiel path is different so we do this
		//String filepath = System.getProperty("uder.dir") + \\resource\\" + filename;
		return new String(Files.readAllBytes(Paths.get(filepath)));
	}

}
