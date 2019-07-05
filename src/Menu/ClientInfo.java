package Menu;

import Player.Account;
import Shop.Shop;

import java.io.Serializable;

public class ClientInfo implements Serializable {

    Shop shop;
    Account account;
    String order;

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
