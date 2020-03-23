import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingClass extends JFrame {

    JTextField jTextField=new JTextField(5);
    JButton addOne = new JButton("Add 1");
    JButton addTwo = new JButton("Add 2");
    JButton addThree = new JButton("Add 3");
    JButton clear = new JButton("Clear");
    
    Integer counter=0;
    
    SwingClass(){
        setTitle("Adder");
        Container container=getContentPane();
        container.setLayout(new FlowLayout());
        container.add(addOne);
        container.add(addTwo);
        container.add(addThree);
        container.add(clear);
        container.add(jTextField);
        setSize(400, 200);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        addOne.addActionListener(new AddOne());
        addTwo.addActionListener(new AddTwo());
        addThree.addActionListener(new AddThree());
        clear.addActionListener(new Clear());
        
    }
    
    class AddOne implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            counter+=1;
            jTextField.setText(counter.toString());
            jTextField.setBackground(Color.MAGENTA);
        }
        
    }
    
    class AddTwo implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            counter+=2;
            jTextField.setText(counter.toString());
            jTextField.setBackground(Color.YELLOW);
        }
        
    }
    
    class AddThree implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            counter+=3;
            jTextField.setText(counter.toString());
            jTextField.setBackground(Color.BLUE);
        }
        
    }
    class Clear implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            counter=0;
            jTextField.setText(counter.toString());
            jTextField.setBackground(Color.RED);
        }
        
    }
    
    public static void main(String[] arg) {
        JFrame frame = new SwingClass();
    }
    
}
