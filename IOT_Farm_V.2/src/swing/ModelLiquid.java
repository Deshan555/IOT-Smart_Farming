package swing;

import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Area;
import java.awt.geom.CubicCurve2D;
import java.awt.geom.GeneralPath;

public class ModelLiquid {

    public Rectangle getSize() {
        return size;
    }

    public void setSize(Rectangle size) {
        this.size = size;
    }

    public ModelLiquid(Rectangle size) {
        this.size = size;
    }

    public ModelLiquid() {
    }

    private Rectangle size;

    public Shape createWaterStyle() {
        double width = size.getWidth();
        double heigh = size.getHeight();
        double space = width / 4;
        double x = size.getX();
        double y = size.getY();
        GeneralPath gp1 = new GeneralPath(new CubicCurve2D.Double(x, y + heigh, x + space, y + heigh, x + space, y, x + width / 2, y));
        gp1.lineTo(x + width / 2, y + heigh);
        GeneralPath gp2 = new GeneralPath(new CubicCurve2D.Double(x + width / 2, y, x + width - space, y, x + width - space, y + heigh, x + width, y + heigh));
        gp2.lineTo(x + width / 2, y + heigh);
        Area area = new Area(gp1);
        area.add(new Area(gp2));
        return area;
    }
}
