import java.awt.*;
import javax.swing.*;
public class pr_8_city_table extends JFrame
{
    pr_8_city_table()
    {
        setLayout(new FlowLayout());
        Container c1 =getContentPane();
    String cols[]={"city_name", "distance"};
    String data[][]={{"pune","80"},
                      {"latur","150"}};

    int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
    int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;

    
    JTable t1 = new JTable(data, cols);
    JScrollPane sp1 = new JScrollPane(t1, v, h);
    c1.add(sp1);
    }
    public static void main(String[] args) {
        pr_8_city_table p1=new pr_8_city_table();
        p1.setSize(500, 500);
        p1.setTitle("distance from manchar");
        p1.setVisible(true);
    }
}
