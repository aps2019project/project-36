package Menu;

import Shop.Shop;

import java.io.IOException;

public class Main {


    public static ClientInfo clientInfo;

    public static void main(String[] args) throws IOException {
        Menu.makeAllAccounts ();
        clientInfo = new ClientInfo();
        clientInfo.setShop(Server.shop);
        Graphics.graphics(args);
    }

    /*public static void main(String[] args) {

        Graphics.graphics(args);
    }*/

}