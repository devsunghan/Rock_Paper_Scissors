public class GawiBawiBo{
	public int com = 3;
	public int kekka = 3;

public GawiBawiBo(int a,int b){
	com = a;
	kekka = b;
}
	public void computer(){
		com = (int)(Math.random()*3);
	}
	public void shoubu(int you){
		if (you == com) {
			kekka = 1;
		}else if ((com-you ==1)||(com-you) == -2) {
			kekka = 0;
		}else if((com-you==2)||(com-you== -1)){
			kekka = 2;
		}else{
			kekka = 3;
		}
	}
}