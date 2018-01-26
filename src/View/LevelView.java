package View;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;

public class LevelView extends JPanel {

    @Override
    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);

        drawLevel(graphics);
    }

    private void drawLevel(Graphics graphics){

        Graphics2D graphics2D = (Graphics2D) graphics;

        RenderingHints renderingHints =
                new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);

        renderingHints.put(RenderingHints.KEY_RENDERING,
                    RenderingHints.VALUE_RENDER_QUALITY);

        graphics2D.setRenderingHints(renderingHints);

        Dimension size = getSize();
        double width = size.getWidth();
        double height = size.getHeight();

        Ellipse2D ellipse2D = new Ellipse2D.Double(0, 0, 80, 130);
        graphics2D.setStroke(new BasicStroke(1));
        graphics2D.setColor(Color.BLUE);

        for(double degrees = 0; degrees < 360; degrees += 5){
            AffineTransform affineTransform
                    = AffineTransform.getTranslateInstance(width/2, height/2);
            affineTransform.rotate(Math.toRadians(degrees));
            graphics2D.draw(affineTransform.createTransformedShape(ellipse2D));
        }
    }

    public void notifyScoreChanged(int score){

    }

    public void notifyDataChanged(){

    }
}
