import java.awt.*;

public class pr_3_no_on_button extends Frame {
    pr_3_no_on_button() {
        GridLayout g1 = new GridLayout(3, 3);
        setLayout(g1);
        Button b1[] = new Button[9];
        for (int i = 0; i < 9; i++) {
            b1[i] = new Button("button" + i);
            add(b1[i]);
        }
    }
    public static void main(String[] args) {
        pr_3_no_on_button p1 = new pr_3_no_on_button();
        p1.setSize(500, 500);
        p1.setTitle("grid layout");
        p1.setVisible(true);
    }
}
