package hexagonProjects;

import processing.core.*;
import java.lang.Math;

public class Main extends PApplet{
	public float[] hexagonCornerLocation (int[] centerXY, int size, int i, boolean isFlatTop) 
	{
		//// This function returns the integer XY coordinates
		// centerXY is an array with the X then Y values of the center in coordinates.
		// size is an integer value that determines the length of each side of the hexagon
		// i is the value for which corner it's referring to
		// isFlatTop is true if the Hexagon is horizontal.
		float angle_deg = 60 + i*60;
		if(isFlatTop == false) 
		{
			angle_deg = angle_deg + 30;
		}
		float angle_rad = PI / 180 * angle_deg;
		float[] returnCoords = {centerXY[0] + size * cos(angle_rad), centerXY[1] + size * sin(angle_rad)};
		return returnCoords;
	}
	public int colorFromString(String name)
	{
		int returnColor = color(0,0,0);
		switch(name) {
		case "blue":
			returnColor = color(121,150,195);
			break;
		case "black":
			returnColor = color(0,0,0);
			break;
		case "white":
			returnColor = color(255,255,255);
			break;
		case "red":
			returnColor = color(160,75,75);
			break;
		case "green":
			returnColor = color(62,109,71);
			break;
		}
		return returnColor;
	}
	public int[] floatArraytoInt(float[] inputArray)
	{
		//// Input an array comprised of floats, returns an array of integers
		// uses Math.round to round
		int[] returnArray = new int[inputArray.length];
		for(int i = 0; i < inputArray.length; i++)
		{
			returnArray[i] = Math.round(inputArray[i]);
		}
		return returnArray;
	}
	public void setAllColors(int color)
	{
		fill(color);
		stroke(color);
	}
    public void settings(){
        size(600,600);
    }
    public void setup(){
    	int color = colorFromString("red");
        setAllColors(color);
        strokeWeight(0);
    }
    public void hexagon(int[] centerXY, int size, boolean isFlatTop)
    {
    	float[][] corners = new float[2][7];
		float[] tempcoords;
		for(int i = 0; i < 7; i++)
		{
			tempcoords = hexagonCornerLocation(centerXY, size, i, isFlatTop);
			corners[0][i] = tempcoords[0];
			corners[1][i] = tempcoords[1];
		}
		for(int i = 0; i < 6; i++)
		{
			triangle(centerXY[0], centerXY[1], corners[0][i], corners[1][i], corners[0][i+1], corners[1][i+1]);
		}
    }
    public void draw(){
    	int[] center = {300, 300};
    	int size = 50;
    	boolean isFlatTop = false;
    	hexagon(center, size, isFlatTop);
    }
	
    public static void main(String[] args) {
        PApplet.main("hexagonProjects.Main");
    }
}