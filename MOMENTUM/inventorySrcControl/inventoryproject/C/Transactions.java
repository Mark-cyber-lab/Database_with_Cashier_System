package inventoryproject.C;

import java.util.ArrayList;

public class Transactions {
    String dateAndTime = "";    //   for the date and time info
    ArrayList<OrderedProducts> listOfProducts;   //   for the list of product in the transaction
    String total = "";  //the total amount in the transaction that happened in a certain transaction
    String cash = "";
    String change = "";

    Transactions(){ //constructor for the transaction class
        this.setDateAndTime(dateAndTime);
        this.setListOfProducts(listOfProducts);
        this.setTotal(total);
    }

    ///setters
    protected void setDateAndTime(String DateAndTime){
        this.dateAndTime = DateAndTime;
    }
    protected void setListOfProducts(ArrayList<OrderedProducts> listOfProducts){
        this.listOfProducts = listOfProducts;
    }
    protected void setTotal(String total){
        this.total = total;
    }
    protected void setCash(String cash){
        this.cash = cash;
    }
    protected void setChange(String change){
        this.change = change;
    }

    //getters
    public String getDateAndTime(){
        return dateAndTime;
    }
    public String getTotal(){
        return total;
    }
    public String getCash(){
        return cash;
    }
    public String getChange(){
        return change;
    }
    public ArrayList<OrderedProducts> getListOfProduct(){
        return listOfProducts;
    }
}
