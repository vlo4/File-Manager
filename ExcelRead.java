import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;

import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;

import static org.apache.poi.hssf.usermodel.HSSFCell.*;

public class ExcelRead {
public ExcelRead(String ExcelFileName, String ExcelSheetName){
String firstcell="";
String secondcell="";
try{
String file="C:\\Users\\user\\Desktop\\filemanager\\"+ExcelFileName;
HSSFWorkbook myExcelBook = new HSSFWorkbook(new FileInputStream(file));
HSSFSheet myExcelSheet = myExcelBook.getSheet(ExcelSheetName);
HSSFRow row = myExcelSheet.getRow(0);

String one = row.getCell(0).getStringCellValue();
firstcell="first cell: " + one;

String two = row.getCell(1).getStringCellValue();
secondcell="second cell: " + two;

myExcelBook.close();
}catch (Exception e) {
firstcell="";
secondcell="";
}
JFrame WordFrame = new JFrame();
JLabel ExcelLabelfirstcell = new JLabel(firstcell);
JLabel ExcelLabelsecondcell = new JLabel(secondcell);

JPanel ExcelPanel=new JPanel();
ExcelPanel.setLayout(new GridLayout(0,1));
ExcelPanel.add(ExcelLabelfirstcell);
ExcelPanel.add(ExcelLabelsecondcell);

WordFrame.add(ExcelPanel, BorderLayout.NORTH);
WordFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
WordFrame.setTitle(ExcelFileName);
WordFrame.pack();
WordFrame.setVisible(true);
WordFrame.setSize(600, 300);
}}
