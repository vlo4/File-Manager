import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.model.XWPFHeaderFooterPolicy;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFFooter;
import org.apache.poi.xwpf.usermodel.XWPFHeader;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.util.List;

public class WordRead {
public WordRead(String Wordfilename){
String contentswordheader="";
String contentswordcenter="";
String contentswordfooter="";
try (FileInputStream fileInputStream = new FileInputStream("C:\\Users\\user\\Desktop\\filemanager\\"+Wordfilename)) {

XWPFDocument docxFile = new XWPFDocument(OPCPackage.open(fileInputStream));
XWPFHeaderFooterPolicy headerFooterPolicy = new XWPFHeaderFooterPolicy(docxFile);

// считываем верхний колонтитул (херед документа)
XWPFHeader docHeader = headerFooterPolicy.getDefaultHeader();
contentswordheader=docHeader.getText();

// печатаем содержимое всех параграфов документа в консоль
List<XWPFParagraph> paragraphs = docxFile.getParagraphs();
for (XWPFParagraph p : paragraphs) {
contentswordcenter=p.getText();
}
// считываем нижний колонтитул (футер документа)
XWPFFooter docFooter = headerFooterPolicy.getDefaultFooter();
contentswordfooter=docFooter.getText();

} catch (Exception ex) {
contentswordheader="";
contentswordcenter="";
contentswordfooter="";
}
JFrame WordFrame = new JFrame();
JLabel WordLabelheader = new JLabel(contentswordheader);
JLabel WordLabelcenter = new JLabel(contentswordcenter);
JLabel WordLabelfooter = new JLabel(contentswordfooter);

JPanel WordPanel=new JPanel();
WordPanel.setLayout(new GridLayout(0,1));
WordPanel.add(WordLabelheader);
WordPanel.add(WordLabelcenter);
WordPanel.add(WordLabelfooter);

WordFrame.add(WordPanel, BorderLayout.NORTH);
WordFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
WordFrame.setTitle(Wordfilename);
WordFrame.pack();
WordFrame.setVisible(true);
WordFrame.setSize(600, 300);
}
}
