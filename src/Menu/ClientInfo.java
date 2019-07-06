package Menu;

import Player.Account;
import Shop.Shop;

import java.io.Serializable;
import java.util.ArrayList;

public class ClientInfo implements Serializable {

    ArrayList<Account> accounts = new ArrayList<>();
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

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void addToAccounts(Account account) {
        accounts.add(account);
    }
}
