import java.awt.*;

public class Card extends Rect{
	final public static int cardWidth = 100;
	final public static int cardHeight = 120;
	final public static int Bawi = 0;
	final public static int Gawi = 1;
	final public static int Bo = 2;
	public int GawiBawi = 3;

	public Card(int xv,int yv,int gv){
		super(xv, yv, xv+cardWidth, yv+cardHeight);
		GawiBawi = gv; 
	}

	public void draw(Graphics g){
		String names[] = {"グー","チョキ","パー","Random"};
		g.clearRect(upperLeftX,upperLeftY,cardWidth,cardHeight);
		super.draw(g);
		if (GawiBawi == Bawi) {
			g.drawString(names[0],upperLeftX+45,upperLeftY+60);
		}else if (GawiBawi == Gawi) {
			g.drawString(names[1],upperLeftX+25,upperLeftY+60);
		}else if (GawiBawi == Bo){
			g.drawString(names[2],upperLeftX+20,upperLeftY+60);
		}else if(GawiBawi == 3){
			g.drawString(names[3],upperLeftX+30,upperLeftY+60);
		}else{

		}
	}

}