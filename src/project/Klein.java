package project;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Klein extends Character { //ch2
    public String name = "Klein";
    public int hp = 700;
    public int atk = 50;

    public void Skill(Character boss){ //dizzy
        boss.status = 0;
        JFrame j = new JFrame();
        if (this.status == 1)JOptionPane.showMessageDialog(j, "Klein 發動了技能：暈眩Boss一回合！", "刀劍神域Online", 0);
        else if (this.status == 2) JOptionPane.showMessageDialog(j, "Klein 發動了技能：暈眩玩家一回合！", "刀劍神域Online", 0);
    }
}