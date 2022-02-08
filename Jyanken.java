import java.awt.*;
import java.io.*;
import java.awt.event.*;
import java.awt.image.*;

public class Jyanken extends Frame{
	public Card card[] = new Card[5];
	public Shop shop[] = new Shop[5];
	public Rect rect[] = new Rect[4];

	public GawiBawiBo f;
	public Hp yourHp;
	public Hp comsHp;
	public String YourHp;
	public String ComsHp;
	public NameCard next;
	public int hp = 6;
	public int delta = 1;
	public int x = 0;
	public int y = 0;

	public static void main(String[] args){
		Jyanken window = new Jyanken();
		window.setVisible(true);
	}
	public Jyanken(){

		setSize(800,800);
		setTitle("ある男の物語");
		MouseKeeper mouse = new MouseKeeper();
		addMouseListener(mouse);

		rect[0] = new Rect(150,200,300,350);
		rect[1] = new Rect(350,200,500,350);
		rect[2] = new Rect(550,200,700,350);
		rect[3] = new Rect(240,180,690,370);
		card[0] = new Card(200,200,0);
		card[1] = new Card(400,200,1);
		card[2] = new Card(600,200,2);
		card[3] = new Card(300,500,4);
		card[4] = new Card(500,500,3);
		shop[0] = new Shop(120,580,0);
		shop[1] = new Shop(120,530,1);
		shop[2] = new Shop(700,580,2);
		shop[3] = new Shop(420,400,3);
		shop[4] = new Shop(420,430,4);
		f = new GawiBawiBo(3,3);
		yourHp = new Hp(6,"you");
		comsHp = new Hp(3,"チェ・ホンマん");
		next = new NameCard(420,600);repaint();

		
				

		
		
		
	}
	private class MouseKeeper extends MouseAdapter{
		public void mousePressed(MouseEvent e){
			x = e.getX();
			y = e.getY();

	if (card[0].includes(x,y)) {
		card[3].GawiBawi = 0;

	}else if (card[1].includes(x,y)) {
		card[3].GawiBawi = 1;
	}else if (card[2].includes(x,y)) {
		card[3].GawiBawi = 2;
	}else{
		card[3].GawiBawi = 4;
		card[4].GawiBawi = 4;
		f.kekka = 4;
	}
	if (card[3].GawiBawi == 0 || card[3].GawiBawi == 1 || card[3].GawiBawi == 2) {
		
	
	f.computer();
	card[4].GawiBawi = f.com;
	f.shoubu(card[3].GawiBawi);
	}
	
	repaint();
		}
	}


  





	public void paint(Graphics g){


	if (shop[3].includes(x,y)) {
			shop[3].exit = 6;
		}else if (shop[4].includes(x,y)) {
			rect[3].draw(g);
			g.drawString("このゲームは、題名通り、最強になりたい男の物語であります。",250,200);
			g.drawString("強者とジャンケンをし、勝った方が負けた方をグローブをつけたまま、",250,220);
			g.drawString("一発殴ることが出来ます。 ",250,240);
			g.drawString("勝ったら100Gold、負けたら50Goldを貰い、Shopでアイテムを買い、",250,260);
			g.drawString("どんどん強くなり、勝つまでチャレンジすることが出来ます。",250,280);
			g.drawString("相手は5人います。頑張ってください。＾＾",250,300);
			

		}
		
	if (shop[3].exit == 3) {
		g.drawString("運否天賦で最強になりたい男の物語",340,90);
		g.drawString("ジャンケンで勝ったら、相手がチャンピオンでも殴れるぞ",300,110);
		shop[3].draw(g);
		shop[4].draw(g);

		

	}else{

	if (shop[1].includes(x,y)) {
		shop[1].open = true;
	}else if (shop[2].includes(x,y)) {
			shop[1].open = false;
			
		}

	if (shop[1].open == true) {
		rect[0].draw(g);
		rect[1].draw(g);
		rect[2].draw(g);
		g.drawString("ドーピング",215,275);
		g.drawString("最大Hpが1増加",205,295);
		g.drawString("200 gold",205,315);
		g.drawString("グローブのワタ抜き",390,275);
		g.drawString("攻撃力が1増加 (1回限定)",365,295);

		g.drawString("500 gold",405,315);
		if (rect[0].includes(x,y)) {
			if (shop[0].gold >= 200) {							
			yourHp.doping();
			shop[0].gold -= 200;
			}
		}else if (rect[1].includes(x,y)) {
			if (shop[0].gold >= 500) {							
			comsHp.damage += 1;
			shop[0].gold -= 500;
			}
			
		}



		shop[0].draw(g);
		shop[2].draw(g);



		
		
	}else{

	if (yourHp.Hp < 0) {
			yourHp.Hp += 1; 
	}else if (comsHp.Hp < 0) {
		comsHp.Hp += 1;
	}

	if (yourHp.Hp == 0) {
			next.sb = false;
			next.draw(g);
			repaint();
			
			if (next.includes(x,y)) {
				yourHp.Hp = yourHp.your_maxHp;
				comsHp.Hp = hp;	
				shop[0].gold += 50;
				repaint();
			}
		}



	if (comsHp.Hp == 0) {
			next.sb = true;
			next.draw(g);
			repaint();
			if (next.includes(x,y)) {
				yourHp.Hp = yourHp.your_maxHp;
				comsHp.challenger++;
				comsHp.Change();
				hp = comsHp.Hp;
				comsHp.Hp = hp;
				shop[0].gold += 100;
				repaint();
			}
		}

	if (f.kekka == 1) {
		g.drawString("引き分け",430,550);
	}else if(f.kekka == 0){
		g.drawString("勝ち",430,550);
		comsHp.maximum();
		comsHp.Attack();

	}else if(f.kekka == 2){
		g.drawString("負け",430,550);
		yourHp.Attack();
	}

	if (yourHp.Hp == 0) {
		g.drawString("負けたぞ",430,500);
	}else if (comsHp.Hp == 0) {
		g.drawString("勝ったぞ",430,500);
	}
		YourHp = String.valueOf(yourHp.Hp);
		ComsHp = String.valueOf(comsHp.Hp);
		card[0].draw(g);
		card[1].draw(g);
		card[2].draw(g);
		card[3].draw(g);
		card[4].draw(g);

		shop[0].draw(g);
		shop[1].draw(g);

	

		g.drawString("主人公",340,490);
		g.drawString(comsHp.Name,520,490);
		
		g.drawString("何を出すか、決めてください",400,150);
		g.drawString("結果",420,450);
		if ((yourHp.Hp) != 0 || (comsHp.Hp != 0)) {
		g.drawString(YourHp,340,650);
		g.drawString(ComsHp,540,650);	
		}else if (yourHp.Hp == 0) {
			g.drawString("今回は負けたな。",420,500);
			repaint();
		}else if (comsHp.Hp == 0) {
			g.drawString("よっしゃ！勝ったぞ！",420,500);
			next = new NameCard(420,600);
			repaint();
			if (next.includes(x,y)) {
				yourHp.Hp = hp;
				comsHp.Hp = hp+delta;
			}
		}

						}

						}

	}

}