package inventoryproject.C;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProcessTransactions {
    private File file = new File("src/inventoryproject/C/TransactionList.in"); //file to be opened
    private Scanner input = new Scanner(System.in); // scanner of the user input
    public ArrayList<Transactions> listOfTransactions = new ArrayList<>(); //this is the transaction list

    //the menu of the transactions
    

    //read the transaction
    public void readTransactionList() throws IOException {
        if(file.length() == 0) {    //if the file does not exist, or it doesn't have any contents
            boolean unimportant = file.createNewFile(); //whether creates a file or not,.....no oe knows
        }
        Scanner readTransactions = new Scanner(file);   //   scanner object for reading the file

        while (readTransactions.hasNext()){
            //****reads the transaction****
            ArrayList<OrderedProducts> listOfProduct = new ArrayList<>();
            Transactions transactions = new Transactions();

            transactions.setDateAndTime(readTransactions.nextLine());   //read the date and time
            while(true){    //reads all the product that has been ordered in the cashier
                String string = readTransactions.nextLine();
                if(string.equals("Total"))  //if the string is equal to total, this means that there are no product left in the one transaction
                    break;
                String BrandName = string;
                String type = readTransactions.nextLine();
                String name = readTransactions.nextLine();
                String amount = readTransactions.nextLine();
                String price =readTransactions.nextLine();
                String totalPrice = readTransactions.nextLine();
                
                OrderedProducts newProduct = new OrderedProducts();
                newProduct.setBrandName(BrandName);
                newProduct.setType(type);
                newProduct.setName(name);
                newProduct.setAmount(amount);
                newProduct.setPrice(price);
                newProduct.setTotalPrice(totalPrice);
                
                listOfProduct.add(newProduct);
            }
            transactions.setListOfProducts(listOfProduct);  //set the list of the products
            transactions.setTotal(readTransactions.nextLine()); //set total of the transaction
            transactions.setCash(readTransactions.nextLine());
            transactions.setChange(readTransactions.nextLine());
            listOfTransactions.add(transactions);   //add the transaction to the list of the product
        }
        readTransactions.close();   //close the scanner object
    }

    
    //delete a transaction
    public void deleteTransactions(int toBeDeleted){
        listOfTransactions.remove(toBeDeleted); // ctrl + alt + delete}
    }
    //leaving the transaction inventory
    public void exit() throws IOException {
        if(file.length() == 0){ //if the file does not exit then create a new one
            boolean valueCatcher = file.createNewFile();
        }
        //write all the transaction data to the file
        new FileWriter(file, false).close();
        FileWriter writer = new FileWriter(file, true);

        for(Transactions c : listOfTransactions){   //write all the record to the file
            writer.write(c.getDateAndTime() + "\n");
            for(OrderedProducts d : c.getListOfProduct()){
                writer.write(d.getBrandName() + "\n" + d.getType() + "\n" + d.getName() + "\n" + d.getAmount() + "\n" + d.getPrice() + "\n" + d.getTotalPrice() + "\n");
            }
            writer.write("Total\n" + c.getTotal() + "\n" + c.getCash() + "\n" + c.getChange() + "\n");
        }
        writer.close();
        listOfTransactions.clear();

    }
}
