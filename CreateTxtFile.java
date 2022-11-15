import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreateTxtFile {
public CreateTxtFile(String TXTfilename,String TXTfilefill) {
int noOfLines = 10000;
// пишем в файл с помощью FileWriter
writeUsingFileWriter(TXTfilefill,TXTfilename);
}

// пишем в файл с помощью FileWriter
private static void writeUsingFileWriter(String data, String TXTfilename) {
File file = new File("C:\\Users\\user\\Desktop\\filemanager\\"+TXTfilename);
FileWriter fr = null;
try {
fr = new FileWriter(file);
fr.write(data);
} catch (IOException e) {
e.printStackTrace();
} finally {
try {
fr.close();
} catch (IOException e) {
e.printStackTrace();
}
}
}
}
