public class Hp{
	public String Name = null;
	public int damage = 1;
	public int Hp = 6;
	public int your_maxHp = 6;
	public int coms_maxHp = 0;
	public int challenger = 0;
	public Hp(int a,String n){
		Hp = a;
		Name = n;
		challenger = 0;
	}

	public void doping(){
		Hp = your_maxHp++;
	}

	public void maximum(){
		if (damage > 2) {
			damage = 2;
		}
	}

	public void Attack(){
		Hp -= damage;
	}
	
	public void Change(){
		if (challenger == 0) {
			Hp = 3;
			Name = "チェ・ホンマん";
			coms_maxHp = Hp;
		}else if (challenger == 1) {
			Hp = 5;
			Name = "アケボノ";
		}else if (challenger == 2) {
			Hp = 8;
			Name = "コナー・マグレガー";
			coms_maxHp = Hp;
		}else if (challenger == 3) {
			Hp = 14;
			Name = "マーク・ハント";
			coms_maxHp = Hp;
		}else if (challenger == 4) {
			Hp = 22;
			Name = "マイク・タイソン";
			coms_maxHp = Hp;
		}
	}
}
