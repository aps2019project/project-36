package Battle;

import Player.Account;
import Player.Collection;

import java.util.ArrayList;
import java.util.Collections;

public class MainMenu {
    public void exit(){
        return;
    }
    public boolean login(String username, String password){
        for(int i = 0; i <Account.getAccounts().size(); i++){
            if(Account.getAccounts().get(i).getUsername().equals(username)){
                if (Account.getAccounts().get(i).getPassword().equals(password)){
                    return true;
                }
            }
        }
        return false;
    }

    public void createAccount(String username, String password){
        Account newAccount = new Account();
        newAccount.setUsername(username);
        newAccount.setPassword(password);
        newAccount.setDaric();
        Account.addToAccounts(newAccount);
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
        Collections.sort(ans);
    }
}

class Pair{
    int wins;
    String username;
}
