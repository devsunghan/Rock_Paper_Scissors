import java.awt.*;

public class Shop extends Rect{
	public boolean open = false;
	public boolean start = false;
	//public int start = 0;
	public int gold = 0;
	public int exit = 0;
	public String gol = null;
	final public static int cardWidth = 60;
	final public static int cardHeight = 20; 

	public Shop(int xv,int yv,int e){
		super(xv, yv, xv+cardWidth, yv+cardHeight);
		exit = e;
	}

	public void draw(Graphics g){
		super.draw(g);
		if (exit == 1) {
			g.drawString("Shop",upperLeftX+12,upperLeftY+13);
		}else if(exit == 2){
			g.drawString("Exit",upperLeftX+12,upperLeftY+13);	
		}else if(exit == 0){
			g.drawString("gold",upperLeftX+15,upperLeftY+35);
			gol = String.valueOf(gold);
			g.drawString(gol,upperLeftX+20,upperLeftY+13);	

		}else if (exit == 3) {
			g.drawString(" スタート",upperLeftX+3,upperLeftY+13);
		}else if (exit == 4) {
			g.drawString("   説明",upperLeftX+3,upperLeftY+13);
		}
		
	}

}