import java.util.Scanner;

public class Game {

    Player player;
    Location location;


    public void signUp() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Adventure Game!");
        System.out.print("before beginning the game you have to choose your hero name: ");
        String getname = scanner.nextLine();
        player = new Player(getname);
        player.selectCha();
        start();
    }
    public void start(){


        while (true){


            Scanner scanner = new Scanner(System.in);

            System.out.println(" ");
            System.out.println("==============================================");
            System.out.println(" ");
            System.out.println("please select a place in order to do action: ");
            System.out.println("1- Your Safe Zone --> There is no foe here!");
            System.out.println("2- Cave --> a bit dangerous");
            System.out.println("3- Wood -->  average" );
            System.out.println("4- River --> Hard");
            System.out.println("5- Shop --> a place to buy something or sell ");
            System.out.print("the place you want to go: ");

            int place = scanner.nextInt();

            while (place < 0 || place > 5){
                System.out.print("Please select a valid place: ");
                place = scanner.nextInt();



            }

            switch (place){

                case 1:   // duruma göre location'nın içerisine bölgeleri dolduruyoruz ona göre olaylar gelişiyor

                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new Cave(player);
                    break;
                case 3:
                    location = new Forest(player);
                    break;
                case 4:
                    location = new River(player);
                    break;
                case 5:
                    location = new ToolStore(player);
                    break;

                default:
                    location = new SafeHouse(player);
                    break;
            }



            if(!location.getLocation()){

                System.out.println("Game over.");
                break;
            }
            else{

                continue;
            }


        }
    }
}
