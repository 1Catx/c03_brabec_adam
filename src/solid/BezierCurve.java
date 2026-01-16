package solid;

import transforms.Col;
import transforms.Cubic;
import transforms.Point3D;

public class BezierCurve extends Solid {
    public BezierCurve(Point3D p0, Point3D p1, Point3D p2, Point3D p3) {
        //color = new Col(0xFF0000);

        Cubic c = new Cubic(Cubic.BEZIER, p0, p1, p2, p3);

        int samples = 50; // počet úseček v křivce, neboli kolik malých příměk použijeme k přebližnému vyklereslení hladké kčivky

        for (int i = 0; i <= samples; i++) {
            double t = i / (double) samples;
            Point3D p = c.compute(t); // vypočítá bod na křivce
            vb.add(p);
            if (i > 0) {
                ib.add(i - 1);
                ib.add(i);
            }
        }
    }
}
