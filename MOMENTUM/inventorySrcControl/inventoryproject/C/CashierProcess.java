package inventoryproject.C;
//important imports
import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.Scanner;

public class CashierProcess {

    //for the ordered products, it is the list
    public ArrayList<Product> order = new ArrayList<>();

    //for all the products
    public Hashtable<Long, Product> products = new Hashtable<>();

    //this method will execute if the user select the check-out
    public void recordTransaction(double totalValue, double payment) throws IOException {   //opens the file for appending the new information
        FileWriter writer = new FileWriter("src/inventoryproject/C/TransactionList.in", true);

        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy hh:mm a");  //generate a date and time data
        Date dateAndTime = new Date();  //related to date and time
        writer.write(sdf.format(dateAndTime) + "\n");
        for(Product c: order){
            writer.write(c.getBrandName() + "\n");
            writer.write(c.getType() + "\n");
            writer.write(c.getName() + "\n");
            writer.write(c.getAmount() + "\n");
            writer.write(c.getPrice() + "\n");
            writer.write(c.getAmount() * c.getPrice() + "\n");
        }   
        writer.write("Total\n" + totalValue + "\n" + payment + "\n" + (payment - totalValue) + "\n");  //prints the overall prices of the product ordered
        writer.close(); //closes the file writer
    }

    //this will save the changes caused by the order in the cashier
    public void saveChanges() throws IOException {
        for (Product c : order) //  save the new amount of the product in the stock after the order has performed
            products.get(c.getUniversalProductKey()).setAmount(products.get(c.getUniversalProductKey()).getAmount() - c.getAmount());

        new FileWriter("src/inventoryproject/C/ProductList.in", false).close();    //rewrites the product list file

        FileWriter writer = new FileWriter("src/inventoryproject/C/ProductList.in", true); // open the file writer for the appending of the information

        for(Long c : products.keySet()){ //prints the product information to the file
            writer.write(products.get(c).getUniversalProductKey() + "\n");
            writer.write(products.get(c).getCategory() + "\n");
            writer.write(products.get(c).getBrandName() + "\n");
            writer.write(products.get(c).getType() + "\n");
            writer.write(products.get(c).getName() + "\n");
            writer.write(products.get(c).getPrice() + "\n");
            writer.write(products.get(c).getAmount() + "\n");
        }
        writer.close(); //closes the file writer object
        order.clear();
    }

    //reads all the products in the file inventory
    public void readFile() throws FileNotFoundException {
        //open the file product list for the reading of all the product
        File file = new File("src/inventoryproject/C/ProductList.in");
        if(file.length() != 0){
            Scanner readFile = new Scanner(file);   //scanner object for reading the file
            while (readFile.hasNext()){ //reads all the products information
                Product newProduct = new Product();

                newProduct.setUniversalProductCode(Long.parseLong(readFile.nextLine()));
                newProduct.setCategory(Byte.parseByte(readFile.nextLine()));
                newProduct.setBrandName(readFile.nextLine());
                newProduct.setType(readFile.nextLine());
                newProduct.setName(readFile.nextLine());
                newProduct.setPrice(Double.parseDouble(readFile.nextLine()));
                newProduct.setAmount(Long.parseLong(readFile.nextLine()));
                products.put(newProduct.getUniversalProductKey(), newProduct);  //put to the hash table
            }
            readFile.close();   //close the scanner object
        }
    }

    //adds a product to the ordered list
    public void add(long UPC, long amount){
        if (products.containsKey(UPC)) {  //checks if there is a product that has the same UPC of the user input
            if (products.get(UPC).getAmount() != 0) { //-----------checks if the product is out of stock or not---------------
                if (amount <= products.get(UPC).getAmount()) {  //checks if the amount does not exceed to the amount of product in the stock
                    Product newOrder = new Product();
                    newOrder.copy(products.get(UPC), amount);   //copies all the attributes of the product

                    order.add(newOrder);    //add to the arraylist
                } else
                    JOptionPane.showMessageDialog(null, "The entered amount has exceed the amount in the stocks!", "Alert", JOptionPane.WARNING_MESSAGE);
            } else
                JOptionPane.showMessageDialog(null, "Product out of stock!", "Warning", JOptionPane.WARNING_MESSAGE);
        } else
            JOptionPane.showMessageDialog(null, "Product not found!", "Alert", JOptionPane.WARNING_MESSAGE);
    }

    //remove an ordered product
    public void delete(int indexToBeDelated){
        order.remove(indexToBeDelated); //remove the product of the selected index in the list
    }

    //changes the amount of the ordered product
    public boolean change(byte position, long newAmount){
        if(products.get(order.get(position).getUniversalProductKey()).getAmount() < newAmount)  //checks if the new amount exceeds to the amount of the product in the stocks
            JOptionPane.showMessageDialog( null, "The new amount has exceeded the amount of product in the stock!", "Warning", JOptionPane.ERROR_MESSAGE);
        else {
            if(JOptionPane.showConfirmDialog(null, "Continue?", "Confirmation", JOptionPane.OK_CANCEL_OPTION) == 0){
                if(newAmount == 0)  //if the new amount is zero then the product will be removed from the list
                    order.remove(position);
                else    //this changes the amount of the ordered products
                    order.get(position).setAmount(newAmount);
                JOptionPane.showMessageDialog(null, "Update Successfully!", "", JOptionPane.PLAIN_MESSAGE);
                return true;
            }
            else
                JOptionPane.showMessageDialog( null, "Operation has been calcelled");
        }
        return false;
    }
}
