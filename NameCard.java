import java.awt.*;

public class NameCard extends Rect{
	final static public int Width = 50;
	final static public int Height = 20;
	public boolean sb;
	
	public NameCard(int xv,int yv){
		super(xv, yv, xv+Width, yv+Height);
	}
	public void draw(Graphics g){
		super.draw(g);
		if (sb == true) {
			g.drawString("次の相手を探しますか？",upperLeftX,upperLeftY+40);
		}else{
			g.drawString("再チャレンジしますか？",upperLeftX,upperLeftY+40);
		}
		
	}
}