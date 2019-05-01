package Shop;

public class ShopMenu {
    private ArrayList<Card> cards= new ArrayList<>();
    private ArrayList<Item> items= new ArrayList<>();
    public void help(){
        System.out.println("Collection");
        System.out.println("Shop");
        System.out.println("Battle");
        System.out.println("Exit");
        System.out.println("Help");
    }
    public void exit(){
        return;
    }
    public void showCollection(){}
    public void search(String name){
        boolean exist=false;
        for(Card x: cards){
            if(name.equals(x.getName())){
                System.out.println(x.getCardNumber());
                exist=true;
            }
        }
        for(Item x:items){
            if(name.equals(x.getName())){
                System.out.println(x.getItemNumber());
                exist=true;
            }
        }
        if(!exist){
            System.out.println("This Card/Item is not in the shop");
        }
    }
    public void searchCollection(String name,Account account){
        boolean exist=false;
        for(Card x: account.getCollection().getCards()){
            if(name.equals(x.getName())){
                System.out.println(x.getCardNumber());
                exist=true;
            }
        }
        for(Item x:account.getCollection().getItems()){
            if(name.equals(x.getName())){
                System.out.println(x.getItemNumber());
                exist=true;
            }
        }
        if(!exist){
            System.out.println("This Card/Item is not in the collection");
        }
    }
    public void buy(String name){}
    public void sell(int ID){}

    public JSONArray show(JSONArray list){
        return list;
    }
    public void showShopHelp(){}
    public void exit(){
        return;
    }
    public void help(){
        System.out.println("exit");
        System.out.println("show collection");
        System.out.println("search[item name|card name]");
        System.out.println("search collection[item name|card name]");
        System.out.println("buy[card name|item name]");
        System.out.println("sell[card id|item id]");
        System.out.println("show");
        System.out.println("help");
    }
}
