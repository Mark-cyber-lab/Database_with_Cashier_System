package inventoryproject.C;

public class Product{
    //data field
    private long universalProductCode = 0;
    private String brandName = "";
    private String type = "";
    private String name = "";
    private double price = 0;
    private long amount = 0;
    private byte category = 0;

    //constructor
    public Product(){
        this.setUniversalProductCode(universalProductCode);
        this.setBrandName(brandName);
        this.setName(name);
        this.setPrice(price);
        this.setAmount(amount);
        this.setType(type);
        this.setCategory(category);
    }

    //setters
    public void setUniversalProductCode(long keyID){
        universalProductCode = keyID;
    }
    public void setName(String productName){
        name = productName;
    }
    public void setPrice(double productPrice){
        price = productPrice;
    }
    public void setAmount(long amountOfProduct) {
        amount = amountOfProduct;
    }
    public void setBrandName(String brandName){
        this.brandName = brandName;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setCategory(byte category) {
        this.category = category;
    }

    //getters
    public long getUniversalProductKey(){
        return universalProductCode;
    }
    public String getBrandName() {
        return brandName;
    }
    public String getName(){
        return name;
    }
    public double getPrice(){
        return price;
    }
    public long getAmount(){
        return amount;
    }
    public String getType() {
        return type;
    }
    public byte getCategory() {
        return category;
    }

    //copies the objects attribute
    public void copy(Product x, long amount){
        this.setUniversalProductCode(x.getUniversalProductKey());
        this.setBrandName(x.getBrandName());
        this.setCategory(x.getCategory());
        this.setType(x.getType());
        this.setName(x.getName());
        this.setPrice(x.getPrice());
        this.setCategory(x.getCategory());
        this.setAmount(amount);
    }
}
