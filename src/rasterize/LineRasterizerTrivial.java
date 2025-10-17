package rasterize;

import model.Line;
import raster.RasterBufferedImage;

import java.awt.*;

public class LineRasterizerTrivial extends LineRasterizer {
    public LineRasterizerTrivial(RasterBufferedImage raster) {
        super(raster);
    }

    @Override
    public void rasterize(Line line) {
        
    }

    @Override
    public void rasterize(int x1, int y1, int x2, int y2) {

    }
}
