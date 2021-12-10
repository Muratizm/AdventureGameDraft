public abstract class NormalLocation extends Location {


    public NormalLocation(Player player, String name) {
        super(player);
        super.name = name;
    }

    @Override
    public boolean getLocation(){

        return true;
    }

}
