package project;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Shino extends Character { //ch5
    public String name = "Shino";
    public int hp = 550;
	public int atk = 30;

    public void Skill(Character mate, Character enemy){
        int num = Math.round(enemy.hp / 10);
        enemy.hp -= num;
        mate.hp += num;
        JFrame j = new JFrame();
        JOptionPane.showMessageDialog(j, "Shino 發動了技能：" + "吸取了" + enemy.name + "的10%血量給" + mate.name, "刀劍神域Online", 0);
    }
}
