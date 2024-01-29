public class Unit{
    private String name;
    private String unitClass;
    private int weapon;
    private int hp;
    private int baseHp;
    private int atk;
    private int def;
    private int crit;
    private int hit;
    private int avo;
    private int spd;
    private static int hpGrowth = 100;
    private int atkGrowth;
    private int defGrowth;
    private int critGrowth;
    private int avoGrowth;
    private int hitGrowth;


    public Unit(String name, String unitClass, int weapon, int hp, int atk, int def, int crit,int hit, int avo, int spd){
        this.name = name;
        this.unitClass = unitClass;
        this.hp = hp;
        baseHp = hp;
        this.weapon = weapon;
        this.atk = atk;
        this.def = def;
        this.crit = crit;
        this.hit = hit;
        this.avo = avo;
        this.spd = spd;
        atkGrowth =(int)(Math.random()*30)+50;
        defGrowth =(int)(Math.random()*30)+50;
        critGrowth =(int)(Math.random()*30)+10;
        hitGrowth =(int)(Math.random()*20)+60;
        avoGrowth =(int)(Math.random()*50)+20;
    }

    public void setData(String name, String unitClass, int weapon, int hp, int atk, int def, int crit,int hit, int avo, int spd){
        this.name = name;
        this.unitClass = unitClass;
        this.hp = hp;
        baseHp = hp;
        this.weapon = weapon;
        this.atk = atk;
        this.def = def;
        this.crit = crit;
        this.hit = hit;
        this.avo = avo;
        this.spd = spd;
        atkGrowth =(int)(Math.random()*30)+50;
        defGrowth =(int)(Math.random()*30)+50;
        critGrowth =(int)(Math.random()*30)+10;
        hitGrowth =(int)(Math.random()*20)+60;
        avoGrowth =(int)(Math.random()*50)+20;
    }

    public Unit(){
        name = "Marth";
        unitClass = "Mercenary";
        hp = 50;
        baseHp = hp;
        weapon = 1;
        atk = 10;
        def = 7;
        crit = 5;
        hit = 100;
        avo = 10;
        spd = 5;
        atkGrowth =(int)(Math.random()*30)+50;
        defGrowth =(int)(Math.random()*30)+50;
        critGrowth =(int)(Math.random()*30)+10;
        hitGrowth =(int)(Math.random()*20)+50;
        avoGrowth =(int)(Math.random()*50)+20;
    }

    public String lvlUp(){
        String stuff = "";
        int prob = (int)(Math.random()*100);
        stuff += name + " has leveled up\n";
        if(prob<hpGrowth){
            baseHp += 1;
            hp = baseHp;
            stuff+= "hp +1\n";
        }
        if(prob<atkGrowth){
            atk+=1;
            stuff+= "atk +1\n";
        }
        if(prob<defGrowth){
            def+=1;
            stuff+= "def +1\n";
        }
        if(prob<critGrowth){
            crit+=1;
            stuff+= "crit +1\n";
        }
        if(prob<hitGrowth){
            hit+=5;
            stuff+= "hit +5\n";
        }
        if(prob<avoGrowth){
            avo+=5;
            stuff+= "avo +5\n";
        }
        return stuff;
    }

    public int getHp(){
        return hp;
    }

    public int getAtk(){
        return atk;
    }

    public int getDef(){
        return def;
    }

    public int getCrit(){
        return crit;
    }

    public int getHit(){
        return hit;
    }

    public int getAvo(){
        return avo;
    }

    public String getName(){
        return name;
    }

    public void takeDmg(int dmg){
        hp -= dmg;
    }

    private boolean ifCrit(){
        int prob = (int)(Math.random()*100);
        if(prob<=crit){
            return true;
        }else
            return false;
    }

    private String getWeapon(){
        String stuff = "";
        if(weapon==1){
            stuff = "Sword";
        }
        else if (weapon == 2){
            stuff = "Lance";
        }
        else if (weapon == 3){
            stuff = "Axe";
        }
        return stuff;
    }



    public boolean isAlive(){
        if(hp > 0){
            return true;
        }else
            return false;
    }

    public boolean ifHit(Unit enemy){
        int prob = (int)(Math.random()*100);
        int hitReal = hit - enemy.getAvo();
        if (prob < hitReal){
            return true;
        }else
            return false;
    }

    public String attack(Unit enemy){
        int dmg = atk - enemy.getDef();
        String stuff = "";
        stuff+= name+" attacked with " + getWeapon() +"!\n";
        if(ifHit(enemy)){
            if(ifCrit()){
                dmg = dmg*3;
                stuff+= "Critical Hit!\n";
            }
            if (enemy.getDef()>atk){
                dmg = 0;
            }else
                enemy.takeDmg(dmg);
            stuff += name + " did " + dmg + " dmg to " + enemy.getName() + "\n";
        } else {
            stuff+= "But it missed!\n";
        }
        if(enemy.isAlive()){
            stuff+=enemy.getName() + "'s hp is now " + enemy.getHp();
        } else {
            stuff+= enemy.getName() + " has died!";
        }
        return stuff;
    }

    public String toString(){
        String stuff = "";
        stuff+= "Name: "+name + "\n";
        stuff+= "Weapon: "+getWeapon() + "\n";
        stuff+= "Hp: "+hp + "\n";
        stuff+= "Atk: "+atk + "\n";
        stuff+= "Def: "+def + "\n";
        stuff+= "Crit: "+crit + "\n";
        stuff+= "Hit: "+hit + "\n";
        stuff+= "Avo: "+avo + "\n";
        stuff+= "Atk Growth: "+atkGrowth + "\n";
        stuff+= "Def Growth: "+defGrowth + "\n";
        stuff+= "Crit Growth: "+critGrowth + "\n";
        stuff+= "Hit Growth: "+hitGrowth + "\n";
        stuff+= "Avo Growth: "+avoGrowth + "\n";
        return stuff;
    }

}
