import Player.Player;
import Battle.BattleMenu;
import Shop.ShopMenu;

import java.util.Collection;
import java.util.Scanner;

public class Main
{
    static Player loggedInPlayer = new Player();
    public static void main( String[] args )
    {
        boolean x = true;
        Scanner scanner = new Scanner(System.in);
        StringBuilder option = new StringBuilder();
        Main.help();
        while(x){
            option.setLength(0);
            option.append(scanner.next());
            switch (option.toString().toLowerCase()){
                case "enter help":
                    Main.help();
                    break;
                case "enter exit":
                    x= false;
                    return;
                case "enter collection":
                    Collection.getOptions();
                    break;
                case "enter shop":
                    ShopMenu.getOptions();
                    break;
                case "enter battle":
                    BattleMenu.getOptions();
                    break;
                    default:
                        System.out.println("Option not found");
            }
        }
    }
    public static void help(){
        System.out.println("Help");
        System.out.println("Exit");
        System.out.println("Collection");
        System.out.println("Shop");
        System.out.println("Battle");
    }

}