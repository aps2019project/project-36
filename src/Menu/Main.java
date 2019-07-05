package Menu;

import Shop.Shop;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Shop shop=new Shop();
        Menu.makeAllAccounts ();
        try {
            Graphics.graphics(args);
        } catch (IOException e) {
            e.printStackTrace ( );
        }
    }

    /*public static void main(String[] args) {

        Graphics.graphics(args);
    }*/

}