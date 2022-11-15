import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CSVRead {
public CSVRead(String CSVFileName){
String one="";
try {
Scanner sc = new Scanner(new File("C:\\Users\\user\\Desktop\\filemanager\\"+CSVFileName));
sc.useDelimiter(","); //sets the delimiter pattern
while (sc.hasNext()) //returns a boolean value
{
one+=sc.next()+" "; //find and returns the next complete token from this scanner
}
sc.close(); //closes the scanner
}catch (Exception e) {
one="";
}

JFrame WordFrame = new JFrame();
JLabel ExcelLabelfirstcell = new JLabel(one);

JPanel ExcelPanel=new JPanel();
ExcelPanel.setLayout(new GridLayout(0,1));
ExcelPanel.add(ExcelLabelfirstcell);

WordFrame.add(ExcelPanel, BorderLayout.NORTH);
WordFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
WordFrame.setTitle(CSVFileName);
WordFrame.pack();
WordFrame.setVisible(true);
WordFrame.setSize(600, 300);
}
}
