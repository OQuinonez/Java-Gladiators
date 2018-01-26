import java.util.Random;

public class Gladiator {

    public String name;
    public Integer health;
    public Integer rage;
    public Integer damageHigh;
    public Integer damageLow;
    Random rand = new Random();

    public Gladiator(String name, Integer health, Integer rage, Integer damageHigh, Integer damageLow){
        this.name = name;
        this.health = health;
        this.rage = rage;
        this.damageHigh = damageHigh;
        this.damageLow = damageLow;
    }

    public void attack(Gladiator defender){
        int  hit = rand.nextInt(this.damageHigh) + this.damageLow;
        int luck = rand.nextInt(100) + 1;
        if( luck <= this.rage){
            defender.health -= (hit * 2);
            this.rage = 0;
        }
        else{
            this.rage += 15;
            defender.health -= hit;
        }
    }

    public  void heal(){
        if (this.rage >= 10){
            if (this.health.equals(100)){
                this.health = 100;
            }else {
                this.health += 5;
            }
            if (this.rage.equals(0)){
                this.rage = 0;
            }else {
                this.rage -= 10;
            }
        }
    }

}
