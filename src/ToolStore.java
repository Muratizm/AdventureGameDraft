public class ToolStore extends NormalLocation {


    public ToolStore(Player player) {
        super(player, "Shop");
    }


    @Override
    public boolean getLocation() {


        System.out.println("Your currently money: " + player.getMoney());
        System.out.println("1- Weapons");
        System.out.println("2- Armors");
        System.out.println("3- Exit");

        int choose = scanner.nextInt();
        int selItemID;


        switch (choose) {

            case 1:

                selItemID = WeaponMenu();
                buyWeapon(selItemID);


                break;
            case 2:

                selItemID = armorMenu();
                buyArmor(selItemID);

                break;
            case 3:


                break;
            default:

                break;

        }


        return true;

    }


    public int WeaponMenu() {


        System.out.println("1. Broken sword < Price: 10 - Damage: 5");
        System.out.println("2. Rusty sword < Price: 13 - Damage: 6");
        System.out.println("3. Brand new sword < Price: 17 - Damage: 10");
        System.out.println("4. Exit");
        System.out.print("Select a weapon you want to buy: ");

        int selectWea = scanner.nextInt();


        return selectWea;


    }

    public void buyWeapon(int id) {

        int damage = 0, price = 0;
        String weaponN = null;

        if (id <= 4 && id > 0) {


            switch (id) {

                case 1:

                    weaponN = "Broken sword";
                    price = 10;
                    damage = 5;

                    break;
                case 2:

                    weaponN = "Rusty Sword";
                    price = 13;
                    damage = 6;

                    break;

                case 3:

                    weaponN = "Brand new Sword";
                    price = 17;
                    damage = 10;

                    break;

                case 4:

                    System.out.println("You have left.");

                    break;

                default:

                    System.out.println("invalid process!");
                    break;
            }

            if (price > 0) {

                if (player.getMoney() >= price) {

                    player.getInventory().setWeaponName(weaponN);
                    player.getInventory().setDamage(damage);
                    player.setMoney(player.getMoney() - price);
                } else {

                    System.out.println("You can't effort this");

                }
                System.out.println("you have bought a weapon!, your damage: " + player.totalDamage());
                System.out.println("remain money: " + player.getMoney());

            }

            System.out.println("remain money: " + player.getMoney());

        } else {

            System.out.println("invalid process!");
        }


    }

    public int armorMenu() {

        System.out.println("1. Light Armor < Price: 7 - defense: 3");
        System.out.println("2. Medium Armor < Price: 12 - defense: 5");
        System.out.println("3. Heavy Armor < Price: 14 - defense: 8");
        System.out.println("4. Exit");
        System.out.print("Select a armor you want to buy: ");

        int selectedArm = scanner.nextInt();
        return selectedArm;

    }

    public void buyArmor(int id) {

        int defense = 0, price = 0;
        String armorN = null;

        if (id > 0 && id <= 4) {

            switch (id) {

                case 1:

                    armorN = "Light Armor";
                    price = 7;
                    defense = 3;

                    break;

                case 2:

                    armorN = "Medium Armor";
                    price = 12;
                    defense = 5;
                    break;

                case 3:

                    armorN = "Heavy Armor";
                    price = 14;
                    defense = 8;
                    break;

                case 4:
                    System.out.println("You have left.");
                    break;

                default:

                    System.out.println("invalid process");

            }

            if (price > 0) {


                if (player.getMoney() >= price) {

                    System.out.println("you have bought an armor.");
                    this.player.setMoney(this.player.getMoney() - price);
                    this.player.getInventory().setArmorName(armorN);
                    this.player.getInventory().setArmor(defense);
                    System.out.println("your defense point: " + this.player.getInventory().getArmor());
                    System.out.println("remain money: " + this.player.getMoney());


                } else {

                    System.out.println("You can't effort this");

                }

            }


        }


    }
}
