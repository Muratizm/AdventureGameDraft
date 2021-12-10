public class SafeHouse extends NormalLocation{


    public SafeHouse(Player player) {
        super(player, "Safe Zone");
    }

    @Override
    public boolean getLocation() {



            if(player.getInventory().isFirewood() && player.getInventory().isWater() && player.getInventory().isFood() ){

                System.out.println("Congratulations, " + player.getName() + " You won the Game!");
                         return false;
            }
          else{


                this.player.setHealthy(getPlayer().getRealHealth());
                System.out.println("You are in safe house right now.");
                System.out.println("You have been healed...");


                return true;
            }



    }
}
