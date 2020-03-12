package ttaiit.blogspot.com;

import abstr.Node;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class VisualizeWindow extends JFrame {
    private JFrame jFrame;
    private JPanel canvas;
    private Map nodemap;
    private static VisualizeWindow instance;

    public static VisualizeWindow getInstance(World parentwindow){
        if (instance == null)
            instance = new VisualizeWindow(parentwindow);
        return instance;
    }

    public VisualizeWindow(World parentwindow){
        nodemap = parentwindow.getNodemap();
        jFrame = new JFrame();
    }


    public void visualize(){
        canvas = new JPanel(){
            @Override
            public void paint(Graphics graphics){
                int width;
                int height;
                int x;
                int y;
                Graphics2D uncolored = (Graphics2D) graphics.create();
                Graphics2D colored = (Graphics2D) graphics.create();
                Graphics2D pen = (Graphics2D) graphics.create();
                uncolored.setStroke(new BasicStroke(1));
                uncolored.setColor(Color.BLACK);
                colored.setStroke(new BasicStroke(1));
                colored.setColor(Color.RED);
                pen.setColor(Color.BLACK);
                for (Object obj : nodemap.values()){
                    Node node = (Node) obj;
                    if (node.getName().equals("root"))
                        continue;
                    width = node.getWidth();
                    height = node.getLength();
                    x = node.getCoordinate_x();
                    y = node.getCoordinate_y();
                    if (node.getType().equals("ItemContainer")) {
                        uncolored.drawRect(x, y, width, height);
                        pen.drawString(node.getName(), x+15, y+15);
                    }
                    else {
                        colored.fillRect(x, y, width, height);
                        pen.drawString(node.getName(), x+15, y+15);
                    }
                }
            }
        };
        jFrame.add(canvas);
        jFrame.setSize(500, 500);
        jFrame.setVisible(true);
    }

}
