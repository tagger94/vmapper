import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import ai_ga.*; 
import megamu.mesh.*; 
import quickhull3d.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class vmapper extends PApplet {

public void setup() {
    Parameter p = new Parameter();
    float[][] points = new float[p.cellCount][2];

    

    p.x = width;
    p.y = height;

    for (int i = 0; i < p.cellCount; i++) {
        points[i][0] = random(0, p.x);
        points[i][1] = random(0, p.y);
    }

    Voronoi myVoronoi = new Voronoi(points);

    MPolygon[] myRegions = myVoronoi.getRegions();

    for (int i = 0; i < myRegions.length; i++) {
        // an array of points
        float[][] regionCoordinates = myRegions[i].getCoords();

        fill(255, 0, 0);
        myRegions[i].draw(this); // draw this shape
    }

    float[][] myEdges = myVoronoi.getEdges();

    for (int i = 0; i < myEdges.length; i++) {
        float startX = myEdges[i][0];
        float startY = myEdges[i][1];
        float endX = myEdges[i][2];
        float endY = myEdges[i][3];
        line(startX, startY, endX, endY);
    }
}

public void draw() {
}
  public void settings() {  size(1600, 900); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "vmapper" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
