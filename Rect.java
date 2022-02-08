import java.awt.*;

public class Rect{
	public int upperLeftX = 0;
	public int upperLeftY = 0;
	public int lowerRightX = 0;
	public int lowerRightY = 0;

public Rect(int ulx,int uly, int lrx, int lry){
	upperLeftX = ulx;
	upperLeftY = uly;
	lowerRightX = lrx;
	lowerRightY = lry;
}

public void moveTo(int x,int y){
	int width = lowerRightX - upperLeftX;
	int height = lowerRightY - upperLeftY;
	upperLeftX = x;
	upperLeftY = y;
	lowerRightX = upperLeftX+width;
	lowerRightY = upperLeftY+height;
}
public void draw(Graphics g){
	g.setColor(Color.blue);
	int width = lowerRightX - upperLeftX;
	int height = lowerRightY - upperLeftY;
	g.drawRect(upperLeftX,upperLeftY,width,height);
}
public boolean includes(int x, int y){
	if ((upperLeftX<x)&&(lowerRightX>x)) 
		if ((upperLeftY<y)&&(lowerRightY>y)) 
			return true;
		return false;	
}
	
}