
class Cell implements MPolygon{
  public
    float x;
    float y;
    float z;
    Biome biome;

    Cell(MPolygon p) {
        x = 0;
        y = 0;
        z = 0;
        biome = new Biome();

        this.count = p.count();
        this.coords = p.getCoords()
    }
}