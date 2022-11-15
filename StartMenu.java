import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartMenu {
public StartMenu(){
JFrame StartFrame=new JFrame();

JButton StartButton=new JButton("Перейти в менеджер");
StartButton.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
new ExplorerTest("C:\\Users\\user\\Desktop\\filemanager");
}
});

JButton StartExitButton=new JButton("Выход");
StartExitButton.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
System.exit(0);
}
});

JPanel StartPanel=new JPanel();
StartPanel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
StartPanel.setLayout(new GridLayout(1,0));
StartPanel.add(StartButton);
StartPanel.add(StartExitButton);

StartFrame.add(StartPanel,BorderLayout.NORTH);
StartFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
StartFrame.setTitle("Меню");
StartFrame.pack();
StartFrame.setVisible(true);
StartFrame.setSize(600,300);
}
}
