
/*
 Name:Ashwin Shiv
 Roll No:181210013
 CSE 2nd Year
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MyFileHandling {

	public static Path currentWorkingDir = Paths.get("").toAbsolutePath();

	public static void readWriteByteStream() throws IOException {
		int i;
		File file = new File(currentWorkingDir + "/AshwinInputFile.txt");
		if (!file.exists()) {
			file.createNewFile();

		}

		FileInputStream fis = new FileInputStream(currentWorkingDir + "/AshwinInputFile.txt");
		FileOutputStream fos = new FileOutputStream(currentWorkingDir + "/myfileOutputByte.txt", true);

		do {
			i = fis.read();

			if (i != -1) {

				fos.write((char) i);

			}

		} while (i != -1);

		fis.close();
		fos.close();

	}

	public static void readWriteCharacterStream() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(currentWorkingDir + "/AshwinInputFile.txt"));
		BufferedWriter bw = new BufferedWriter(new FileWriter(currentWorkingDir + "/myfileOutputCharacter.txt", true));
		String s1;
		while ((s1 = br.readLine()) != null) {

			bw.write(s1 + "\n");

		}

		br.close();
		bw.close();

	}

	public static void main(String[] args) throws IOException {
		MyFileHandling.readWriteByteStream();
		MyFileHandling.readWriteCharacterStream();

	}
}
