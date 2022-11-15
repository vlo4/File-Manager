import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import java.io.FileOutputStream;

public class CreateExcel {
public CreateExcel(String ExcelFileName,String ExcelSheetName, String ExcelFirstValue, String ExcelSecondValue) {
try{
String file="C:\\Users\\user\\Desktop\\filemanager\\"+ExcelFileName;
Workbook book=new HSSFWorkbook();
Sheet sheet=book.createSheet(ExcelSheetName);

// Нумерация начинается с нуля
Row row=sheet.createRow(0);

Cell one=row.createCell(0);
one.setCellValue(ExcelFirstValue);

Cell two=row.createCell(1);
two.setCellValue(ExcelSecondValue);

// Записываем всё в файл
book.write(new FileOutputStream(file));
book.close();}
catch (Exception e) {
e.printStackTrace();
}System.out.println("Успешно записан в файл");

}
}
