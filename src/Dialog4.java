import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.TreeSet;
import javax.swing.*;
public class Dialog4 extends JFrame {
    int k =0;
    TreeSet<String> states = new TreeSet<String>();
    JTextField fld = new JTextField();
    JTextField fld2 = new JTextField();
    JTextArea fld3 = new JTextArea(1, 3);
    JButton btn2 = new JButton("Друк");
    JLabel lbl = new JLabel(" ");
    JLabel lbl1 = new JLabel(" ");
    JLabel lbl2 = new JLabel(" ");
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JPanel panel4 = new JPanel();
    JPanel panel5 = new JPanel();

    Dialog4() {
        super("Слухачі (listeners) полів та кнопок");
        try {

            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName())
            ;
        }
        catch(Exception e) {
        }

        fld.setColumns(20);
        fld2.setColumns(20);

        setSize(400, 190);
        Container c = getContentPane();
        //panel1.add(lbl, BorderLayout.NORTH);
        lbl1.setText("Прізвище:             ");
        panel1.add(lbl1, BorderLayout.NORTH);
        panel1.add(fld, BorderLayout.CENTER);
        lbl.setText("Телефон:");
        lbl2.setText("Кількість записів:");
        panel2.add(lbl2, BorderLayout.NORTH);
        panel2.add(fld2, BorderLayout.CENTER);
        panel3.add(btn2, BorderLayout.CENTER);

        panel4.setLayout(new GridLayout(3, 1));
        panel4.add(panel1);
        panel4.add(panel2);
        panel4.add(panel3);
        panel5.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel5.add(lbl);
        panel5.add(fld3);
        c.add(panel4, BorderLayout.NORTH);
        c.add(panel5, BorderLayout.SOUTH);
        fld2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                fld3.setText(null);
                states.add(fld.getText());
                states.add(fld2.getText());
                fld.setText(null);
                fld2.setText(null);
                k++;
                fld3.append(Integer.toString(k));

            }
        });
        btn2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                TreeSet<String> stat =states;
                int n =states.size();
               for (int i=0;i<n;i++){
                  if (i%2==0||i==0){
                      String element =stat.pollFirst();
                      System.out.print("Prisvushe : "+element+" ");
                  }else {

                      String element =stat.pollFirst();
                      System.out.print("Telefon : "+ element);

                      System.out.println(" ");
                  }

               }


            }
        });
        WindowListener wndCloser = new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        };
        addWindowListener(wndCloser);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Dialog4();
    }
}