import java.util.Scanner;

public class Player {

    private int healthy, damage, money;
    private  int realHealth;
    private String name, cName;
    private Inventory inventory;



    public Player(String name) {

        this.name = name;
        this.inventory = new Inventory();



    }

    public void selectCha() {



        switch (chaMenu()) {

            case 1:
                // Mage is selected
                initCharacter("Mage", 23, 7, 1,23);

                break;

            case 2:
                // Knight is selected
                initCharacter("Knight", 35, 4, 4,33);

                break;
            case 3:
                // Rogue is selected
                initCharacter("Rogue", 25, 9, 6,25);
                setcName("Rogue");

                break;

            default:

                setcName("Knight");
                setDamage(4);
                setHealthy(33);
                setMoney(11);
                break;
        }
        System.out.println("Selected character stats are...");
        System.out.println("Character: " + getcName() + "\t Damage: " + getDamage() + "\t Health: " + getHealthy() + "\t Money: " + getMoney());

    }

    public int totalDamage(){


        return this.inventory.getDamage() + this.getDamage();
    }

    public void initCharacter(String cName, int healthy, int damage, int money, int realHealth) {
        setcName(cName);
        setHealthy(healthy);
        setDamage(damage);
        setMoney(money);
        setRealHealth(realHealth);


    }


    public int chaMenu() {

        Scanner scanner = new Scanner(System.in);

        int getNum;

        System.out.println("Please select a character.");
        System.out.println("1-Character:  Mage \t     Damage = 7, Health = 23, Money: 15");
        System.out.println("2-Character:  Knight \t Damage = 4, Health = 33, Money: 11");
        System.out.println("3-Character:  Rogue \t Damage = 9, Health = 25, Money: 18");


        getNum = scanner.nextInt();

        while (getNum > 3 || getNum < 1) {


            System.out.println("Please select a character.");
            getNum = scanner.nextInt();


        }

        return getNum;


    }


    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getHealthy() {
        return healthy;
    }

    public void setHealthy(int healthy) {
        this.healthy = healthy;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public void setRealHealth(int realHealth) {
        this.realHealth = realHealth;
    }

    public int getRealHealth() {
        return realHealth;
    }
}
