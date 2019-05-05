package Battle;

import Player.Account;
import Player.Collection;
import Player.Player;

import java.util.ArrayList;
import java.util.Collections;

public class AccountMenu {
    public void save(){};
    public void exit(){
        return;
    }
    public Account login(String username, String password){
        for(int i = 0; i < Account.getAccounts().size(); i++){
            if(Account.getAccounts().get(i).getUsername().equals(username)){
                if (Account.getAccounts().get(i).getPassword().equals(password)){
                    return Account.getAccounts().get(i);
                }
                else {
                    System.out.println("invalid password");
                    return null;
                }
            }
        }
        return null;
    }

    public void createAccount(String username, String password){
        // checked in main
        Account newAccount = new Account();
        newAccount.setUsername(username);
        newAccount.setPassword(password);
        newAccount.setDaric();
        Account.addToAccounts(newAccount);
        newAccount.setNumberOfItemsOwned();
    }

    public void showLeaderboard(){
        ArrayList<Pair> ans = new ArrayList<Pair>();
        for(int i = 0; i < Account.getAccounts().size(); i++){
            Account account;
            account = Account.getAccounts().get(i);
            int cnt = 0;
            for (int j = 0; j < account.getMatchHistory().size(); j++){
                if (account.getMatchHistory().get(j).getWinner().getUsername().equals(account.getUsername())){
                    cnt++;
                }
            }
            Pair pair = new Pair();
            pair.wins = cnt;
            pair.username = account.getUsername();
            ans.add(pair);
        }
        for (int i = 0; i < ans.size(); i++){
            for (int j = 0; j < ans.size(); j++){
                if(ans.get(i).wins > ans.get(j).wins){
                    Collections.swap(ans, i, j);
                }
            }
        }
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(i + 1 + "- UserName : " + ans.get(i).username + "- Wins : " + ans.get(i).wins);
        }
    }
    public void help(){
        System.out.println("create account [user name]");
        System.out.println("login [user name]");
        System.out.println("show leaderboard");
        System.out.println("save");
        System.out.println("logout");
        System.out.println("help");
    }
}

class Pair{
    int wins;
    String username;
}
