package Shop;

import Collective.Card.Card;
import Collective.Item;
import Player.Account;

public class ShopMenu {

    public void exit() {
        return;
    }

    public void showCollection(Account account) {
        int i = 0;
        System.out.println("Heroes:");
        for (Card x : account.getCollection().getCards()) {
            if (x.getType().compareTo("Hero") == 0) {
                System.out.println((i + 1) + " Name: " + x.getName() + " - AP: " + x.getAP() + " - HP: " +
                        x.getHP() + " - Class: " + x.getClass() + " - Special Power: " +
                        x.getDesc() + " - Sell Cost: " + x.getPrice());
                i++;
            }
        }
        i = 0;
        System.out.println("Items:");
        for (Item x : account.getCollection().getItems()) {
            System.out.println((i + 1) + ": Name:" + x.getName() + "- Desc:" + x.getDesc() +
                    "Sell Cost:" + x.getPrice());
            i++;
        }
        i = 0;
        System.out.println("Cards:");
        for (Card x : account.getCollection().getCards()) {
            if (x.getType().compareTo("Spell") == 0) {
                System.out.println((i + 1) + "Type " + x.getType() + " - Name: " + x.getName() +
                        " - MP: " + x.getMP() + " - Class: " + x.getClass() + " - Description: " +
                        x.getDesc() + " - Sell Cost: " + x.getPrice());

            }
            else if (x.getType().compareTo("Minion") == 0) {
                System.out.println ((i + 1) + " Type " + x.getType ( ) + " - Name: " + x.getName ( ) +
                        " - Class: " + x.getClass ( ) + " - AP: " + x.getAP ( ) + " - HP: " + x.getHP ( ) + " - MP" + x.getMP ( ) + " - SpecialPower: " +
                        x.getDesc ( ) + " - Sell Cost: " + x.getPrice ( ));
            }
                i++;

        }

    }
    public void search(String name) {
        boolean found = false;
        for (Card x : Shop.getCards()) {
            if (name.compareToIgnoreCase(x.getName()) == 0) {
                System.out.println(x.getCardID());
                found = true;
                break;
            }
        }
        if (!found) {
            for (Item x : Shop.getItems()) {
                if (name.compareToIgnoreCase(x.getName()) == 0) {
                    System.out.println(x.getItemID());
                    found = true;
                    break;
                }
            }
        }
        if (!found) {
            System.out.println("This Card/Item is not in the shop");
        }
    }

    public void searchCollection(String name, Account account) {
        boolean found = false;
        for (Card x : account.getCollection().getCards()) {
            if (name.compareToIgnoreCase(x.getName()) == 0) {
                System.out.println(x.getCardID());
                found = true;
            }
        }
        if (!found) {
            for (Item x : account.getCollection().getItems()) {
                if (name.compareToIgnoreCase(x.getName()) == 0) {
                    System.out.println(x.getItemID());
                    found = true;
                }
            }
        }
        if (!found) {
            System.out.println("This Card/Item is not in the shop");
        }
    }

    public void buy(String name, Account account) {
        boolean found = false;
        for (Card card1 : Shop.getCards()) {
            if (name.compareToIgnoreCase(card1.getName()) == 0) {
                found = true;
                if (found) {
                    if (card1.getPrice() > account.getDaric()) {
                        System.out.println("You don't have enough money");
                    } else if (card1.getPrice() <= account.getDaric()) {
                        System.out.println("You bought this card successfully");
                        Card card = Shop.makeNewCardByName(card1.getName());
                        card.setCardID(makeID(card1.getName(), account)); //set card iD
                        account.getCollection().addToCards(card);
                        System.out.println (account.getCollection ().getCards ().get (0).getCardID ());
                        account.changeDaric(account.getDaric() - card1.getPrice());

                    }
                    break;
                }
            }
        }
        if (!found) {
            for (Item x : Shop.getItems()) {
                if (name.compareToIgnoreCase(x.getName()) == 0 && x.getType ().compareToIgnoreCase ("Collectible")!=0) {
                    found = true;
                    if (found) {
                        if (x.getPrice() > account.getDaric()) {
                            System.out.println("You don't have enough money.");
                        } else if (account.getNumberOfItemsOwned() >= 3) {
                            System.out.println("You can't have more than 3 items.");
                        } else if (account.getNumberOfItemsOwned() < 3 && x.getPrice() <= account.getDaric()) {
                            System.out.println("You bought this item successfully");
                            account.changeDaric(account.getDaric() - x.getPrice());
                            account.changeNumberOfItemsOwned(account.getNumberOfItemsOwned() + 1);
                            Item item = Shop.makeNewItemByName(x.getName());
                            item.setItemID(makeID(x.getName(), account));
                            account.getCollection().addToItems(item);
                        }
                        break;
                    }
                }
            }
        }
        if (!found) {
            System.out.println("This Card/Item is not in the shop");
        }

    }

    public void sell(String ID, Account account) {
        boolean found = false;
        for (Card x : Shop.getCards()) {
            if (x.getCardID().compareToIgnoreCase(ID) == 0) {
                System.out.println("You sold this card successfully");
                account.changeDaric(account.getDaric() + x.getPrice());
                account.getCollection().removeFromCards(x);
                Card.removeFromCards(x);
                found = true;
                break;
            }
        }
        if (!found) {
            for (Item x : Shop.getItems()) {
                if (x.getItemID().compareToIgnoreCase(ID) == 00) {
                    System.out.println("You sold this item successfully");
                    account.getCollection().removeFromItems(x);
                    account.changeDaric(account.getDaric() + x.getPrice());
                    account.changeNumberOfItemsOwned(account.getNumberOfItemsOwned() - 1);
                    found = true;
                    break;
                }
            }
        }
        if (!found) {
            System.out.println("This Card/Item is not in the shop");
        }
    }

    public void show() {
        System.out.println ("Heroes:");
        for (int i = 0; i < Shop.getCards ( ).size ( ); i++) {
            if (Shop.getCards ( ).get (i).getType ( ).compareTo ("Hero") == 0) {
                System.out.println ((i + 1) + " Name: " + Shop.getCards ( ).get (i).getName ( ) + " - AP: " + Shop.getCards ( ).get (i).getAP ( ) +
                        " - HP: " + Shop.getCards ( ).get (i).getHP ( ) + " - Special Power: " + Shop.getCards ( ).get (i).getDesc ( ) +
                        " - Buy Cost: " + Shop.getCards ( ).get (i).getPrice ( ) + " - CardID: " + Shop.getCards ( ).get (i).getCardID ( ));
            }
        }
        System.out.println ("Items:");
        for (int i = 0; i < Shop.getItems ( ).size ( ); i++) {
            System.out.println ((i + 1) + ": Name:" + Shop.getItems ( ).get (i).getName ( ) + "- Desc:" + Shop.getItems ( ).get (i).getDesc ( ) +
                    "Buy Cost:" + Shop.getItems ( ).get (i).getPrice ( ) + " - ITEMID: " + Shop.getCards ( ).get (i).getCardID ( ));
        }
        System.out.println ("Cards:");
        for (int i = 0; i < Shop.getCards ( ).size ( ); i++) {
            if (Shop.getCards ( ).get (i).getType ( ).compareTo ("Spell") == 0) {
                System.out.println ((i + 1) + "Type " + Shop.getCards ( ).get (i).getType ( ) + " - Name: " + Shop.getCards ( ).get (i).getName ( ) +
                        " - MP: " + Shop.getCards ( ).get (i).getMP ( ) + " - Class: " + Shop.getCards ( ).getClass ( ) + " - Description: " +
                        Shop.getCards ( ).get (i).getDesc ( ) + " - Buy Cost: " + Shop.getCards ( ).get (i).getPrice ( ) + " - CardID: " + Shop.getCards ( ).get (i).getCardID ( ));
            } else if (Shop.getCards ( ).get (i).getType ( ).compareTo ("Minion") == 0) {
                System.out.println ((i + 1) + "Type " + Shop.getCards ( ).get (i).getType ( ) + " - Name: " +
                        Shop.getCards ( ).get (i).getName ( ) + " - Class: " + Shop.getCards ( ).getClass ( ) +
                        " - AP: " + Shop.getCards ( ).get (i).getAP ( ) + " - HP: " + Shop.getCards ( ).get (i).getHP ( ) +
                        " - MP" + Shop.getCards ( ).get (i).getMP ( ) + " - SpecialPower: " +
                        Shop.getCards ( ).get (i).getDesc ( ) + " - Buy Cost: " + Shop.getCards ( ).get (i).getPrice ( ) + " - CardID: " + Shop.getCards ( ).get (i).getCardID ( ));
            }
        }
    }

    public void help() {
        System.out.println("exit");
        System.out.println("show collection");
        System.out.println("search[item name|card name]");
        System.out.println("search collection[item name|card name]");
        System.out.println("buy[card name|item name]");
        System.out.println("sell[card id|item id]");
        System.out.println("show");
        System.out.println("help");
    }

    public String makeID(String name, Account account) {
        String ID;
        ID = account.getUsername() + "_" + name + "_" + getMaxNumber(name, account);
        return ID;

    }

    public int getMaxNumber(String name, Account account) {
        boolean found = false;
        int maxNumber = 0;
        for (Card x : account.getCollection().getCards()) {
            if (x.getName().compareTo(name) == 0) {
                maxNumber++;
                found = true;
            }
        }
        if (!found) {
            for (Item x : account.getCollection().getItems()) {
                if (x.getName().compareTo(name) == 0) {
                    maxNumber++;
                    found = true;
                }
            }
        }
        return ++maxNumber;
    }

}