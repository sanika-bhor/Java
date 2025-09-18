// import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class pr_10_key_pressevent extends JFrame implements KeyListener
{
    JTextField t1;
    JLabel l1;
    pr_10_key_pressevent()
    {
        // Font f1=new Font("times new roman",Font.BOLD|Font.ITALIC,25);
        setLayout(null);
         t1=new JTextField();
         t1.setBounds(150, 100, 200, 50);
         t1.addKeyListener(this);
        //  t1.setFont(f1);
         add(t1);

         l1=new JLabel("");
         l1.setBounds(150, 250, 200, 50);
        //  l1.setFont(f1);
         add(l1);

    }
    public void keyPressed(KeyEvent ke)
    {
        l1.setText("......key Pressed....");
    }
    public void keyTyped(KeyEvent ke)
    {

    }
    public void keyReleased(KeyEvent ke)
    {

    }
    public static void main(String[] args) {
        pr_10_key_pressevent p1=new pr_10_key_pressevent();
        p1.setSize(500, 500);
        p1.setTitle("key press event");
        p1.setVisible(true);
    }
}