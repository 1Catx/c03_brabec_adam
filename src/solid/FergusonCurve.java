package solid;

import transforms.Col;
import transforms.Cubic;
import transforms.Point3D;

public class FergusonCurve extends Solid {
    public FergusonCurve(Point3D p0, Point3D p1, Point3D p2, Point3D p3) {
        color = new Col(0x00FF00);

        Cubic cubic = new Cubic(Cubic.FERGUSON, p0, p1, p2, p3);

        int samples = 50;
        for (int i = 0; i <= samples; i++) {
            double t = i / (double) samples;
            Point3D p = cubic.compute(t);
            vb.add(p);
            if (i > 0) {
                ib.add(i - 1);
                ib.add(i);
            }
        }
    }
}
