import java.util.Scanner;

public abstract class BattleLocation extends Location {


    protected Obstacle obstacle;
    protected String award;

    public BattleLocation(Player player, String name, Obstacle obstacle, String award) {
        super(player);
        super.name = name;
        this.award = award;
        this.obstacle = obstacle;

    }

    // savaş başladığında ilk saldırıda hiçbir şey gerçekleşmiyor bunu düzelt.

    @Override
    public boolean getLocation() {

        System.out.println("You are here right now: " + this.name);
        Scanner scanner = new Scanner(System.in);

        int obsCount = obstacle.count();
        System.out.println("Be careful there are " + obsCount + " " + obstacle.getName());
        System.out.print("(F)ight or (E)scape: ");

        String select = scanner.nextLine();
        select = select.toUpperCase();
        if (select.matches("F")) {
            if (combat(obsCount)) {   // içeriye koyduğum boolean metod'u savaşta canlı dönerse yani true döndürür döngü devam eder eğer savaştan canlı çıkmazsa false döner öldün demektir

                if(this.award.matches("Food") && player.getInventory().isFood() == false){

                    System.out.println("you are cleaned this area: " + this.name);
                    System.out.println("You collected Food");
                    player.getInventory().setFood(true);

                }
                else if(this.award.matches("Water") && player.getInventory().isWater() == false){

                    System.out.println("you are cleaned this area: " + this.name);
                    System.out.println("You collected Water");
                    player.getInventory().setWater(true);

                }
                else if(this.award.matches("Firewood") && player.getInventory().isFirewood() == false){

                    System.out.println("you are cleaned this area: " + this.name);
                    System.out.println("You collected Firewood");
                    player.getInventory().setFirewood(true);

                }
                else{
                    System.out.println("you are cleaned this area: " + this.name);
                    System.out.println("you have collected all items");
                }



            }
            if(player.getHealthy() <= 0){
                System.out.println("You are dead");
                return false;
            }
            return true;
        }

        return true;
    }

    public boolean combat(int obstcount) {

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < obstcount; i++) {

            int defObsHealth = obstacle.getHealth(); // default health bar

            playerStats();
            EnemyStats();

            while (player.getHealthy() > 0 && obstacle.getHealth() > 0) {

                System.out.print("(A)ttack or (R)un away: ");

                String selcase = scanner.nextLine();
                selcase = selcase.toUpperCase();

                if (selcase.matches("A") && !selcase.isEmpty()) {

                    obstacle.setHealth(obstacle.getHealth() - player.totalDamage());

                    System.out.println("Foe was damaged, its health: " + obstacle.getHealth());



                    if (obstacle.getHealth() > 0) {



                        if(obstacle.getDamage() > player.getInventory().getArmor()){

                            player.setHealthy(player.getHealthy() - (obstacle.getDamage() - player.getInventory().getArmor()));
                        }
                       else{
                           player.setHealthy(player.getHealthy());
                        }
                        System.out.println("You were damaged, your health: " + player.getHealthy());

                    }

                } else {
                    break;
                }


            }
            if (obstacle.getHealth() <= 0 && player.getHealthy() > 0) {

                System.out.println("you slew a foe in this area");
                System.out.println("you get money: " + obstacle.getAward());
                player.setMoney(player.getMoney() + obstacle.getAward());
                System.out.println("your money: " + player.getMoney());
                obstacle.setHealth(defObsHealth);

            }
            else{
                return false;
            }
        }

        return true;
    }

    public void playerStats() {

        System.out.println("Player Values:\n---------------");
        System.out.println("Health: " + player.getHealthy());
        System.out.println("Damage: " + player.totalDamage());
        System.out.println("Money: " + player.getMoney());

        if (player.getInventory().getDamage() > 0) {
            System.out.println("Weapon Name: " + player.getInventory().getWeaponName());
        } else {
            System.out.println("Weapon Name: your fist");
        }
        if (player.getInventory().getArmor() > 0) {

            System.out.println("Armor name: " + player.getInventory().getArmorName());
        } else {
            System.out.println("You are naked");
        }

    }

    public void EnemyStats() {

        System.out.println(obstacle.getName() + " Values:\n-------------");
        System.out.println("Health: " + obstacle.getHealth());
        System.out.println("Damage: " + obstacle.getDamage());
        System.out.println("bounty: " + obstacle.getAward());
    }

}
