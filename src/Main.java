import java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);
        System.out.println("Welcome to the arena!");
        Unit marth = new Unit();
        Unit lucina = new Unit("Lucina","Lord",1,100,10,3,20,80,5,5);
        System.out.println("What is your fighter's name?");
        String name = scan.nextLine();
        System.out.println("What weapon do you want?\n(1 = Sword, 2 = Lance, 3 = Axe)");
        int weapon = scan.nextInt();
        Unit[] enemyList = new Unit[10];

        for(int i = 0;i<enemyList.length;i++){
            enemyList[i] = new Unit("Fighter","Fighter",1,25,7,3,1,70,5,5);
        }


        Unit un1 = new Unit(name,"Fighter",weapon,25,7,3,1,70,5,5);
        Unit en1 = new Unit("Fighter","Fighter",1,25,5,3,1,70,5,5);

        System.out.println(un1);


        int run = 1;
        int battles = 1;
        while(run == 1){
            int j = 0;
            System.out.println();
            System.out.println("Battle " + battles);
            System.out.println();
            for (int i = 1; i <= 20; i++){
                if(un1.isAlive()&& enemyList[j].isAlive()){
                    System.out.println("turn "+i);
                    System.out.println();
                    System.out.println(enemyList[j].attack(un1));
                    if(un1.isAlive()&& enemyList[j].isAlive())
                        System.out.println(un1.attack(enemyList[j]));
                    System.out.println();
                }
            }
            if (un1.isAlive() && ! enemyList[j].isAlive()){
                System.out.println(un1.getName() + " has won!!");
                System.out.println(un1.lvlUp());
            } else if (!un1.isAlive() &&  enemyList[j].isAlive()){
                System.out.println( enemyList[j].getName() + " has won");
                System.out.println("You lost on battle "+battles);
                break;
            }
            System.out.println("fight again? (1 = yes / 0 = no)");
            battles ++;
            run = scan.nextInt();
            scan.nextLine();
            j++;
        }


    }
}