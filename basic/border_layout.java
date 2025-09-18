import java.awt.*;

public class pr_3_2_border extends Frame {
    pr_3_2_border() {
        BorderLayout bl1 = new BorderLayout(3, 3);
        setLayout(bl1);

        Button b1 = new Button("east");
        Button b2 = new Button("west");
        Button b3 = new Button("north");
        Button b4 = new Button("south");
        Button b5 = new Button("center");

        add(b1, BorderLayout.EAST);
        add(b2, BorderLayout.WEST);
        add(b3, BorderLayout.NORTH);
        add(b4, BorderLayout.SOUTH);
        add(b5, BorderLayout.CENTER);

    }

    public static void main(String[] args) {
        pr_3_2_border b1 = new pr_3_2_border();
        b1.setSize(500, 500);
        b1.setVisible(true);
        b1.setTitle("borderlayout");
    }
}
