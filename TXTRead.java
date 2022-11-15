import org.apache.commons.io.FileUtils;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class TXTRead {
public TXTRead(String TXTfilename) {

String contents="";
String fileName = "C:\\Users\\user\\Desktop\\filemanager\\" + TXTfilename;
try{
contents = readUsingApacheCommonsIO(fileName);}
catch(IOException ie) {
contents="";
}

JFrame TXTFrame = new JFrame();
JLabel TXTLabel = new JLabel(contents);
TXTFrame.add(TXTLabel, BorderLayout.NORTH);
TXTFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
TXTFrame.setTitle(TXTfilename);
TXTFrame.pack();
TXTFrame.setVisible(true);
TXTFrame.setSize(600, 300);
}
private String readUsingApacheCommonsIO(String fileName) throws IOException {
return FileUtils.readFileToString(new File(fileName), StandardCharsets.UTF_8);
}
}
