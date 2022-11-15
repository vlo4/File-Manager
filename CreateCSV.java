import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CreateCSV {
public CreateCSV(String ExcelFileName,String ExcelFirstValue,String ExcelSecondValue){
Map<String, String> AUTHOR_BOOK_MAP = new HashMap<>() {
{
put("one:",ExcelFirstValue);
put("two:",ExcelSecondValue);
}
};
String[] HEADERS = { "one","two"};
try {
FileWriter out = new FileWriter("C:\\Users\\user\\Desktop\\filemanager\\"+ExcelFileName);
try (CSVPrinter printer = new CSVPrinter(out, CSVFormat.DEFAULT
.withHeader(HEADERS))) {
AUTHOR_BOOK_MAP.forEach((author, title) -> {
try {
printer.printRecord(author, title);
} catch (IOException e) {
throw new RuntimeException(e);
}
});
}
}catch (Exception e) {
e.printStackTrace();
}System.out.println("Успешно записан в файл");

}
}
