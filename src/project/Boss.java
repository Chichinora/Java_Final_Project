package project;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Boss extends Character {
    public String name = "The Boss: Heathcliff";
    public int hp = 2500;
    public int atk = 80;
	public int dfs = 20;
    //public int cd = 5;
    public int status = 2;

    public void Skill(Character ch){
        ch.status = 2;
        JFrame j = new JFrame();
        JOptionPane.showMessageDialog(j, "Boss 發動了技能：騙人的吧！\n" + ch.name + "成為boss傀儡一回合", "刀劍神域Online", 0);
    }
    public void ResetCD() {
        this.cd = 5;
    }
}