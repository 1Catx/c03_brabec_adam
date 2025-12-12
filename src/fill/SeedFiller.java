package fill;

import raster.Raster;

import java.util.OptionalInt;

public class SeedFiller implements Filler {
    private Raster raster;
    private int startX, startY;
    private int fillColor;
    private int backgroundColor;

    public SeedFiller(Raster raster, int startX, int startY, int fillColor) {
        this.raster = raster;
        this.startX = startX;
        this.startY = startY;
        this.fillColor = fillColor;

        // Nastavení barvy pozadí
        OptionalInt pixelColor = raster.getPixel(startX, startY);
        if (pixelColor.isPresent())
            this.backgroundColor = pixelColor.getAsInt();
    }

    @Override
    public void fill() {
        seedFill(startX, startY);
    }

    private void seedFill(int x, int y) {
        // get barvy
        OptionalInt pixelColor = raster.getPixel(x, y);
        if (pixelColor.isEmpty())
            return;

        // podmínka - zarážka
        if (pixelColor.getAsInt() != backgroundColor)
            return;

        // obarvím
        raster.setPixel(x, y, fillColor);

        // seedFill zavolám pro sousedy
        seedFill(x + 1, y);
        seedFill(x - 1, y);
        seedFill(x, y + 1);
        seedFill(x, y - 1);
    }
}
