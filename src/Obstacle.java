import java.util.Random;

public class Obstacle {

    private int damage, award, health, maxNum;
    private String name;


    public Obstacle(int damage, int award, int health, int maxNum, String name) {
        this.damage = damage;
        this.award = award;
        this.health = health;
        this.maxNum = maxNum;
        this.name = name;
    }

    public int count(){


        Random random = new Random();

        int number = random.nextInt(this.maxNum) + 1;

        return number;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getAward() {
        return award;
    }

    public void setAward(int award) {
        this.award = award;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMaxNum() {
        return maxNum;
    }

    public void setMaxNum(int maxNum) {
        this.maxNum = maxNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
