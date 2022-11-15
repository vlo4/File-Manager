import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.tree.*;

class Explorer extends JPanel implements ActionListener
{
JTextField jtf;
JTextArea jta;
JTree tree;
JButton refresh;
JButton CreateWord;
JButton CreateTXT;
JButton ReadWord;
JButton ReadTXT;

JTable jtb;
JScrollPane jsp;
JScrollPane jspTable;

String currDirectory=null;

final String[] colHeads={"File Name","SIZE(in Bytes)","Read Only","Hidden"};
String[][]data={{"","","","",""}};

Explorer(String path)
{

jtf=new JTextField();
jta=new JTextArea(5,30);
refresh=new JButton("Refresh");

JButton Create_excel=new JButton("Создать Excel файл");
Create_excel.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
JFrame ExcelCreateFrame = new JFrame();
JLabel ExcelName = new JLabel("Название файла");
JTextField ExcelNameField = new JTextField("");
JLabel ExcelSheetName = new JLabel("Название страницы файла");
JTextField ExcelSheetNameField = new JTextField("");
JLabel ExcelFirstValue = new JLabel("Значение первой ячейки");
JTextField ExcelFirstValueField = new JTextField("");
JLabel ExcelSecondValue = new JLabel("Значение второй ячейки");
JTextField ExcelSecondValueField = new JTextField("");

JButton Excelfind=new JButton("Создать файл");
Excelfind.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
String ExcelFileName = ExcelNameField.getText()+".xls";
String ExcelSheetName = ExcelSheetNameField.getText();
String ExcelFirstValue = ExcelFirstValueField.getText();
String ExcelSecondValue = ExcelSecondValueField.getText();
new CreateExcel(ExcelFileName,ExcelSheetName,ExcelFirstValue,ExcelSecondValue);
ExcelCreateFrame.setVisible(false);
}
});

JPanel ExcelPanel=new JPanel();
ExcelPanel.setLayout(new GridLayout(1,4));
ExcelPanel.add(ExcelName);
ExcelPanel.add(ExcelNameField);
ExcelPanel.add(ExcelSheetName);
ExcelPanel.add(ExcelSheetNameField);
ExcelPanel.add(ExcelFirstValue);
ExcelPanel.add( ExcelFirstValueField);
ExcelPanel.add(ExcelSecondValue);
ExcelPanel.add(ExcelSecondValueField);
ExcelPanel.add(Excelfind);

ExcelCreateFrame.add(ExcelPanel,BorderLayout.NORTH);
ExcelCreateFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
ExcelCreateFrame.setTitle("Создать Excel файл");
ExcelCreateFrame.pack();
ExcelCreateFrame.setVisible(true);
ExcelCreateFrame.setSize(1500, 300);
}
});

JButton Read_Excel=new JButton("Читать Excel файл");
Read_Excel.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
JFrame ExcelAsk = new JFrame();
JLabel ExcelName = new JLabel("Название файла");
JTextField ExcelNameField = new JTextField("");
JLabel ExcelSheetName = new JLabel("Название страницы файла");
JTextField ExcelSheetNameField = new JTextField("");

JButton ExcelFind=new JButton("Открыть файл");
ExcelFind.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
String ExcelFileName = ExcelNameField.getText()+".xls";
String ExcelSheetName = ExcelSheetNameField.getText();
new ExcelRead(ExcelFileName, ExcelSheetName);
}
});

JPanel ExcelPanel=new JPanel();
ExcelPanel.setLayout(new GridLayout(1,0));
ExcelPanel.add(ExcelName);
ExcelPanel.add(ExcelNameField);
ExcelPanel.add(ExcelSheetName);
ExcelPanel.add(ExcelSheetNameField);
ExcelPanel.add(ExcelFind);

ExcelAsk.add(ExcelPanel,BorderLayout.NORTH);
ExcelAsk.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
ExcelAsk.setTitle("Выберите Excel файл");
ExcelAsk.pack();
ExcelAsk.setVisible(true);
ExcelAsk.setSize(1000, 300);
}
});

JButton Create_csv=new JButton("Создать CSV файл");
Create_csv.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
JFrame CSVCreateFrame = new JFrame();
JLabel CSVName = new JLabel("Название файла");
JTextField CSVNameField = new
JTextField("");
JLabel CSVFirstValue = new JLabel("Значение первой ячейки");
JTextField CSVFirstValueField = new JTextField("");
JLabel CSVSecondValue = new JLabel("Значение второй ячейки");
JTextField CSVSecondValueField = new JTextField("");

JButton CSVfind=new JButton("Создать файл");
CSVfind.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
String ExcelFileName = CSVNameField.getText()+".csv";
String ExcelFirstValue = CSVFirstValueField.getText();
String ExcelSecondValue = CSVSecondValueField.getText();
new CreateCSV(ExcelFileName,ExcelFirstValue,ExcelSecondValue);
CSVCreateFrame.setVisible(false);
}
});

JPanel CSVPanel=new JPanel();
CSVPanel.setLayout(new GridLayout(1,4));
CSVPanel.add(CSVName);
CSVPanel.add(CSVNameField);
CSVPanel.add(CSVFirstValue);
CSVPanel.add(CSVFirstValueField);
CSVPanel.add(CSVSecondValue);
CSVPanel.add(CSVSecondValueField);
CSVPanel.add(CSVfind);

CSVCreateFrame.add(CSVPanel,BorderLayout.NORTH);
CSVCreateFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
CSVCreateFrame.setTitle("Создать CSV файл");
CSVCreateFrame.pack();
CSVCreateFrame.setVisible(true);
CSVCreateFrame.setSize(1500, 300);
}
});

JButton Read_csv=new JButton("Читать CSV файл");
Read_csv.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
JFrame CSVAsk = new JFrame();
JLabel CSVName = new JLabel("Название файла");
JTextField CSVNameField = new JTextField("");

JButton CSVFind=new JButton("Открыть файл");
CSVFind.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
String CSVFileName = CSVNameField.getText()+".csv";
new CSVRead(CSVFileName);
}
});

JPanel CSVPanel=new JPanel();
CSVPanel.setLayout(new GridLayout(1,0));
CSVPanel.add(CSVName);
CSVPanel.add(CSVNameField);
CSVPanel.add(CSVFind);

CSVAsk.add(CSVPanel,BorderLayout.NORTH);
CSVAsk.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
CSVAsk.setTitle("Выберите CSV файл");
CSVAsk.pack();
CSVAsk.setVisible(true);
CSVAsk.setSize(1000, 300);
}
});


ReadWord=new JButton("Читать Word файл");
ReadWord.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
JFrame WordAsk = new JFrame();
JLabel WordName = new JLabel("Название файла");
JTextField WordNameField = new JTextField("");

JButton WordFind=new JButton("Открыть файл");
WordFind.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
String Wordfilename = WordNameField.getText()+".docx";
new WordRead(Wordfilename);
}
});

JPanel WordPanel=new JPanel();
WordPanel.setLayout(new GridLayout(1,0));
WordPanel.add(WordName);
WordPanel.add(WordNameField);
WordPanel.add(WordFind);

WordAsk.add(WordPanel,BorderLayout.NORTH);
WordAsk.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
WordAsk.setTitle("Выберите Word файл");
WordAsk.pack();
WordAsk.setVisible(true);
WordAsk.setSize(600, 300);
}
});


ReadTXT=new JButton("Читать TXT файл");
ReadTXT.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
JFrame TXTAsk = new JFrame();
JLabel TXTName = new JLabel("Название файла");
JTextField TXTNameField = new JTextField("");

JButton TXTfind=new JButton("Открыть файл");
TXTfind.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
String TXTfilename = TXTNameField.getText()+".txt";
new TXTRead(TXTfilename);
}
});

JPanel TXTPanel=new JPanel();
TXTPanel.setLayout(new GridLayout(1,0));
TXTPanel.add(TXTName);
TXTPanel.add(TXTNameField);
TXTPanel.add(TXTfind);

TXTAsk.add(TXTPanel,BorderLayout.NORTH);
TXTAsk.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
TXTAsk.setTitle("Выберите TXT файл");
TXTAsk.pack();
TXTAsk.setVisible(true);
TXTAsk.setSize(600, 300);
}
});


CreateWord=new
JButton("Создать Word файл");
CreateWord.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
JFrame WordCreateFrame = new JFrame();
JLabel WordName = new JLabel("Название файла");
JTextField WordNameField = new JTextField("");
JLabel WordHeader = new JLabel("Хедер файла");
JTextField WordHeaderField = new JTextField("");
JLabel WordCenter = new JLabel("Параграфы файла");
JTextField WordCenterField = new JTextField("");
JLabel WordFooter = new JLabel("Футер файла");
JTextField WordFooterField = new JTextField("");

JButton Wordfind=new JButton("Создать файл");
Wordfind.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
String Wordfilename = WordNameField.getText()+".docx";
String Wordfileheader = WordHeaderField.getText();
String Wordfilecenter = WordCenterField.getText();
String Wordfilefooter = WordFooterField.getText();
new CreateWordFile(Wordfilename,Wordfileheader,Wordfilecenter,Wordfilefooter);
WordCreateFrame.setVisible(false);
}
});

JPanel WordPanel=new JPanel();
WordPanel.setLayout(new GridLayout(1,4));
WordPanel.add(WordName);
WordPanel.add(WordNameField);
WordPanel.add(WordHeader);
WordPanel.add(WordHeaderField);
WordPanel.add(WordCenter);
WordPanel.add(WordCenterField);
WordPanel.add(WordFooter);
WordPanel.add(WordFooterField);
WordPanel.add(Wordfind);

WordCreateFrame.add(WordPanel,BorderLayout.NORTH);
WordCreateFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
WordCreateFrame.setTitle("Создать Word файл");
WordCreateFrame.pack();
WordCreateFrame.setVisible(true);
WordCreateFrame.setSize(1000, 300);
}
});


CreateTXT=new JButton("Создать TXT файл");
CreateTXT.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
JFrame TXTCreateFrame = new JFrame();
JLabel TXTName = new JLabel("Название файла");
JTextField TXTNameField = new JTextField("");
JLabel TXTFill = new JLabel("Внутри файла");
JTextField TXTFillField = new JTextField("");

JButton TXTfind=new JButton("Создать файл");
TXTfind.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
String TXTfilename = TXTNameField.getText()+".txt";
String TXTfilefill = TXTFillField.getText();
new CreateTxtFile(TXTfilename,TXTfilefill);
TXTCreateFrame.setVisible(false);
}
});

JPanel TXTPanel=new JPanel();
TXTPanel.setLayout(new GridLayout(1,4));
TXTPanel.add(TXTName);
TXTPanel.add(TXTNameField);
TXTPanel.add(TXTFill);
TXTPanel.add(TXTFillField);
TXTPanel.add(TXTfind);

TXTCreateFrame.add(TXTPanel,BorderLayout.NORTH);
TXTCreateFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
TXTCreateFrame.setTitle("Создать TXT файл");
TXTCreateFrame.pack();
TXTCreateFrame.setVisible(true);
TXTCreateFrame.setSize(1000, 300);
}
});


File temp=new File(path);
DefaultMutableTreeNode top=createTree(temp);

//if(top!=null)

tree=new JTree(top);

jsp=new JScrollPane(tree);

final String[] colHeads={"File Name","SIZE(in Bytes)","Read Only","Hidden"};
String[][]data={{"","","","",""}};
jtb=new JTable(data, colHeads);
jspTable=new JScrollPane(jtb);



setLayout(new BorderLayout());
JPanel WorkPanel=new JPanel();
WorkPanel.setLayout(new GridLayout(1,0));
add(jtf,BorderLayout.NORTH);
add(jsp,BorderLayout.WEST);
add(jspTable,BorderLayout.CENTER);
WorkPanel.add(refresh);
WorkPanel.add(CreateWord);
WorkPanel.add(CreateTXT);
WorkPanel.add(Create_excel);
WorkPanel.add(Create_csv);
WorkPanel.add(ReadWord);
WorkPanel.add(ReadTXT);
WorkPanel.add(Read_Excel);
WorkPanel.add(Read_csv);
add(WorkPanel,BorderLayout.SOUTH);

tree.addMouseListener(
new MouseAdapter()
{
public void mouseClicked(MouseEvent me)
{
doMouseClicked(me);
}
});
jtf.addActionListener(this);
refresh.addActionListener(this);
}

public void actionPerformed(ActionEvent ev)
{
File temp=new File(jtf.getText());
DefaultMutableTreeNode newtop=createTree(temp);
if(newtop!=null)
tree=new JTree(newtop);
remove(jsp);
jsp=new JScrollPane(tree);
setVisible(false);
add(jsp,BorderLayout.WEST);
tree.addMouseListener(
new MouseAdapter()
{
public void mouseClicked(MouseEvent me)
{
doMouseClicked(me);
}
});

setVisible(true);
}

DefaultMutableTreeNode createTree(File temp)
{
DefaultMutableTreeNode top=new DefaultMutableTreeNode(temp.getPath());
if(!(temp.exists() && temp.isDirectory()))
return top;

fillTree(top,temp.getPath());

return top;
}

void fillTree(DefaultMutableTreeNode root, String filename)
{
File temp=new File(filename);

if(!(temp.exists() && temp.isDirectory()))
return;
//System.out.println(filename);
File[] filelist=temp.listFiles();

for(int i=0; i<filelist.length; i++)
{
if(!filelist[i].isDirectory())
continue;
final DefaultMutableTreeNode tempDmtn=new DefaultMutableTreeNode(filelist[i].getName());
root.add(tempDmtn);
final String newfilename=new String(filename+"\\"+filelist[i].getName());
Thread t=new Thread()
{
public void run()
{
fillTree(tempDmtn,newfilename);
}//run
};//thread
if(t==null)
{System.out.println("no more thread allowed "+newfilename);return;}
t.start();
}//for
}//function

void doMouseClicked(MouseEvent me)
{
TreePath tp=tree.getPathForLocation(me.getX(),me.getY());
if(tp==null) return;
//jtf.setText(tp.toString());
String s=tp.toString();
s=s.replace("[","");
s=s.replace("]","");
s=s.replace(", ","\\");
//s=s.replace(" ","");
//int z=s.lastIndexOf("\"\\\"");
//s="\'"+s; s=s+"\'";
jtf.setText(s);
showFiles(s);
//java.util.StringTokenizer st=new java.util.StringTokenizer(s,",");
//jtf.setText(jtf.getText()+"="+s);

}

void showFiles(String filename)
{
File temp=new File(filename);
data=new String[][]{{"","","",""}};
remove(jspTable);
jtb=new JTable(data, colHeads);
jspTable=new JScrollPane(jtb);
setVisible(false);
add(jspTable,BorderLayout.CENTER);
setVisible(true);

if(!temp.exists()) return;
if(!temp.isDirectory()) return;

//System.out.println(filename);
File[] filelist=temp.listFiles();
int fileCounter=0;
data=new String[filelist.length][4];
for(int i=0; i<filelist.length; i++)
{
if(filelist[i].isDirectory())
continue;
data[fileCounter][0]=new String(filelist[i].getName());
data[fileCounter][1]=new String(filelist[i].length()+"");
data[fileCounter][2]=new String(!filelist[i].canWrite()+"");
data[fileCounter][3]=new String(filelist[i].isHidden()+"");
fileCounter++;
}//for

String dataTemp[][]=new String[fileCounter][4];
for(int k=0; k<fileCounter; k++)
dataTemp[k]=data[k];
data=dataTemp;

//System.out.println(data);
remove(jspTable);
jtb=new JTable(data, colHeads);
jspTable=new JScrollPane(jtb);
setVisible(false);
add(jspTable,BorderLayout.CENTER);
setVisible(true);
}

}

class ExplorerTest extends JFrame
{

ExplorerTest(String path)
{
super("Менеджер файлов");
add(new Explorer(path),"Center");
setDefaultCloseOperation(DISPOSE_ON_CLOSE);
setSize(1500,400);
setVisible(true);
}

public static void main(String[] args)
{
new StartMenu();
}
}
