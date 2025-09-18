import java.awt.*;
import java.applet.*;
public class pr_2_1_list extends Applet
{
    List l1;
   public void init()
    {
        Font f1=new Font("Times new roman", Font.BOLD|Font.ITALIC, 20);
         l1 =new List();
        
        l1.setFont(f1);
        //l1.setBounds(150, 150, 200, 200);
        l1.add("pune");
        l1.add("Awasari");
        l1.add("chakan");
        l1.add("manchar");
        l1.add("Mumbai");
        l1.add("nagpur");
        l1.add("khed");
        l1.add("nashik");
        l1.add("kolhapur");
        l1.add("peth");
        add(l1);

         Label l2 = new Label("select you city..");
         l2.setFont(f1);
         add(l2);
    }

}

/*<applet code="pr_2_1_list.class" width="500" height="500"></applet>*/
