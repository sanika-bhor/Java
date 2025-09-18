import java.awt.*;
public class Grid_layout extends Frame
{
    pr_3_1_grid()
    {
        GridLayout g1 =new GridLayout(3, 2,10,10);
        setLayout(g1);
        Button b1 = new Button("button1");
        Button b2 = new Button("button2");
        Button b3 = new Button("button3");
        Button b4 = new Button("button4");
        Button b5 = new Button("button5");

        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);
    }
    public static void main(String[] args)
    {
        Grid_layout p1 =new Grid_layout();
        p1.setSize(500, 500);
        p1.setTitle("grid layout");
        p1.setVisible(true);
    }
}
