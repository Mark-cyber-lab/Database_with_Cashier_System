package inventoryproject.C;

import javax.swing.JOptionPane;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

public class ProcessProductData {
    public ArrayList<Hashtable<Long, Product>> products = new ArrayList<>();    //the data structure will be arraylist of hashtable

    //String builder for the viewing of the product's info
    StringBuilder viewProducts = new StringBuilder();
    long sameUPC = 0;    //if there is the same UPC
    

    //this will delete the data in the inventory
    public void processDelete(byte category,long productKey){
        products.get(category).remove(productKey);    //removes the selected product
    }

    //this will ready the hashmap by reading all the data in the file and adding it to the hashmap
    private void setArraylist(){    //this will add different hash tables in the arraylist,..., the hashtables are the indicator of the categories and categories can be access through arraylist indexing
        Hashtable<Long, Product> engineSystems = new Hashtable<>();
        Hashtable<Long, Product> bodySystems = new Hashtable<>();
        Hashtable<Long, Product> powerTransmissionSystems = new Hashtable<>();
        Hashtable<Long, Product> vehicleSecurityAndSafety = new Hashtable<>();
        Hashtable<Long, Product> specialPurposeVehiclePartsAndAccessories = new Hashtable<>();
        Hashtable<Long, Product> entertainmentAndCommunicationSystems = new Hashtable<>();
        Hashtable<Long, Product> carCaresAndRepairEquipment = new Hashtable<>();
        Hashtable<Long, Product> vehiclePartsManufacturing = new Hashtable<>();

        products.add(engineSystems);    //add all the hashtables in the arraylist
        products.add(bodySystems);
        products.add(powerTransmissionSystems);
        products.add(vehicleSecurityAndSafety);
        products.add(specialPurposeVehiclePartsAndAccessories);
        products.add(entertainmentAndCommunicationSystems);
        products.add(carCaresAndRepairEquipment);
        products.add(vehiclePartsManufacturing);
    }

    //this will put the product object or the product information to the hashtable
    private void putToHashTable(Product x){
        products.get(x.getCategory()).put(x.getUniversalProductKey(), x);
    }

    //this will read the product's info and store it in the arraylist based on its categories, hashtable signifies categories
    public void readyTheHashTableOfTheProduct(File fileToBeRead) throws FileNotFoundException {
        Scanner readFile = new Scanner(fileToBeRead);
        //this will be the holder of the data received from the file
        long UPC = 0;
        byte category = 0;
        String brandName = "";
        String type = "";
        String name;
        double price = 0;
        long amount = 0;

        try{//read the file and set the values for the array Hashtable
            while (readFile.hasNext()) {
                //get the attributes of the product
                UPC = Long.parseLong(readFile.nextLine());
                category = Byte.parseByte(readFile.nextLine());
                brandName = readFile.nextLine();
                type = readFile.nextLine();
                name = readFile.nextLine();
                price = Double.parseDouble(readFile.nextLine());
                amount = Long.parseLong(readFile.nextLine());

                //instantiate Product object
                Product product = new Product();

                //assigns the values to the products object
                product.setUniversalProductCode(UPC);
                product.setCategory(category);
                product.setBrandName(brandName);
                product.setType(type);
                product.setName(name);
                product.setPrice(price);
                product.setAmount(amount);

                putToHashTable(product);
            }
        }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "An Error has occurred!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        readFile.close();   //close the Scanner object
    }

    //this method will add a new product to the hashmap
    public void addProduct(Hashtable<Long, Product> productCategory, long UPC, byte category, String brandName, String type, String name, double price, long amount){
    //puts the Product object to the hashtable
        Product product = new Product();
        product.setUniversalProductCode(UPC);
        product.setCategory(category);
        product.setBrandName(brandName);
        product.setType(type);
        product.setName(name);
        product.setPrice(price);
        product.setAmount(amount);
                        
        productCategory.put(product.getUniversalProductKey(), product);
    }

    //this method will ask the user what part of information he/she wants to update
    public void updateInformation(Hashtable<Long, Product> productCategory, long UPC, String brandName, String type, String name, long amount, double price){
        productCategory.get(UPC).setBrandName(brandName);
        productCategory.get(UPC).setType(type);
        productCategory.get(UPC).setName(name);
        productCategory.get(UPC).setPrice(price);
        productCategory.get(UPC).setAmount(amount);
        JOptionPane.showMessageDialog(null, "Update Successfully!");
    }

    //this checks if there is an overlap in UPC
    public boolean same(long UPC){
        int loop= 0;
        for(Hashtable<Long, Product> e: products){   //this will loop throughout all the product to determine if the UPC has already been used
            for (Long s : e.keySet()) {
                if(e.get(s).getUniversalProductKey() == UPC) {
                    sameUPC = loop; //will record where is the category of the matched product
                    return true;    //return true if there is a match of the UPC
                }
            }
            ++loop;
        }
        return false;   //if there is no match
    }

    //-----when attempting to add, delete, update or change the stocks-----
    
    public void saveChangesAttempt() throws IOException {
         new FileWriter("src/inventoryproject/C/ProductList.in", false).close();   //override the file
        //instantiate an object fo a File Writer
        FileWriter writeToFile = new FileWriter("src/inventoryproject/C/ProductList.in", true);

        //write the information of the hashmap products to the file destination
        for(Hashtable<Long, Product> e: products){
            for (Long s : e.keySet())
                writeToFile.write(e.get(s).getUniversalProductKey() + "\n" + e.get(s).getCategory() + "\n" + e.get(s).getBrandName() + "\n" + e.get(s).getType() + "\n" + e.get(s).getName() + "\n" + e.get(s).getPrice() + "\n" + e.get(s).getAmount() + "\n");
        }
        //closes the File Writer Object
        writeToFile.close();
        products.clear();
        viewProducts.setLength(0);
    }
    //----------------------------------------------------------------------\\

    public void prepareStocks(){
        try{
            File fileToBeRead = new File("src/inventoryproject/C/ProductList.in");
            setArraylist();
            if (fileToBeRead.length() == 0)
                fileToBeRead.createNewFile();   //this will output the codes inside if the creation of file is successful, this means that the file does not exist and will be created
            
            readyTheHashTableOfTheProduct(fileToBeRead);    //read the file and store the datas in the data structure
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, "An Error has occurred!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }
}