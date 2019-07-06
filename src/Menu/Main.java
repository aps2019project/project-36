package Menu;

import Shop.Shop;

import java.io.IOException;

public class Main {


    public static ClientInfo clientInfo;

    public static void main(String[] args) throws IOException {
        Shop shop=new Shop();
        Menu.makeAllAccounts ();
        clientInfo = new ClientInfo();
        clientInfo.setShop(shop);
        Graphics.graphics(args);
    }

    /*public static void main(String[] args) {

        Graphics.graphics(args);
    }*/

}