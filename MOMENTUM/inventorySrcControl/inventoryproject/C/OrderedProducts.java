/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventoryproject.C;

/**
 *
 * @author Mark Nelson
 */
public class OrderedProducts {
    
    //data field
    private String brandName = "";
    private String type = "";
    private String name = "";
    private String price = "";
    private String amount = "";
    private String totalPrice = "";

    //constructor
    public OrderedProducts(){
        this.setBrandName(brandName);
        this.setName(name);
        this.setPrice(price);
        this.setAmount(amount);
        this.setType(type);
        this.setTotalPrice(totalPrice);
    }

    //setters
    public void setName(String productName){
        name = productName;
    }
    public void setPrice(String productPrice){
        price = productPrice;
    }
    public void setAmount(String amountOfProduct) {
        amount = amountOfProduct;
    }
    public void setBrandName(String brandName){
        this.brandName = brandName;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }
    
    //getters
    public String getBrandName() {
        return brandName;
    }
    public String getName(){
        return name;
    }
    public String getPrice(){
        return price;
    }
    public String getAmount(){
        return amount;
    }
    public String getType() {
        return type;
    }
    public String getTotalPrice(){
        return totalPrice;
    }
}
