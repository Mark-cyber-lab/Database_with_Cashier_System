package inventoryproject.C;
//necessary imports
import javax.swing.JOptionPane;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class AccountManagerProcess {

    //data field
    private Scanner receive = new Scanner(System.in);
    //this will be used for the keys
    public ArrayList<Character> keys;
    private static Hashtable<String, Accounts> accountList = new Hashtable<>(); //for signup panel
    public ArrayList<Accounts> listOfAccount = new ArrayList<>();   //for the managing the accounts

    //------------wild attributes-----------------------
    //this will read all the datas of the file
    protected Hashtable<String, Accounts> readFileContents(boolean userChoice) throws IOException {
        
        File file;
        
        if(userChoice) //READS the files based on user choice
            file = new File("src/inventoryproject/C/accountsForCashier.in");
        else
            file = new File("src/inventoryproject/C/accountsForAdmins.in");
        
        generateKey();  //generate ordered key

        //this will handle if the file needed is absent or doesn't have any contents
        if(file.length() == 0){
            boolean catcher = file.createNewFile();
        }
        else
            getData(file);  //this will read all the data in thw chosen file
        
        return accountList;
    }

    //go back to the main method after writing all the contents of the hashtable to the file
    protected void exitSave(boolean userChoice){
        try{
            //for the rewriting of the both file when saving the progress
            if(!userChoice)
                new FileWriter("src/inventoryproject/C/accountsForAdmins.in", false).close();
            else
                new FileWriter("src/inventoryproject/C/accountsForCashier.in", false).close();
            

            //write the following information like encrypted username, password and shuffled key to the file
            FileWriter writeToFile;
            
            //for the writing
            if(!userChoice)
                writeToFile = new FileWriter("src/inventoryproject/C/accountsForAdmins.in", true);
            else
                writeToFile = new FileWriter("src/inventoryproject/C/accountsForCashier.in", true);
            
            for (String a : accountList.keySet()) { //iterate while storing all the datas in their respective file storage
                writeToFile.write(accountList.get(a).getUserName() + "\n" + accountList.get(a).getPassword() + "\n");
                
                for(char i: accountList.get(a).getShuffledList())
                    writeToFile.write(i);
                writeToFile.write("\n");
            }
            writeToFile.close();    //closes the file writer
            keys.clear();   //clears the keys and account list
            accountList.clear();
        }catch (IOException e){
            JOptionPane.showMessageDialog(null, "Cannot write to file" , "Alert", JOptionPane.ERROR_MESSAGE);
        }
    }

    //this is for storing all the accounts red in the file
    public String fetchSignInKey() throws IOException {
        File file = new File("src/inventoryproject/C/SignInKey.in");    //for the opening of the sign in key file
        String randomString = "";

        if(file.length() == 0){ //-----------if the file is not present or there is no content
            boolean valueCatcher = file.createNewFile();
            randomString = generateRandomString().substring(0, 25).replaceAll("-", ""); //****creates the sign in key****
            FileWriter write = new FileWriter(file);
            write.write(randomString);
            write.close();
        }
        else{   //this means that the file exists
            Scanner scan = new Scanner(file); //---gets the sign in key---
            randomString = scan.nextLine();
            scan.close();
        }
        return randomString;
    }

    //checks if the username is already been used
    public boolean userNameExist(String newUsername, int pointed){
            for(int i = 0; i < listOfAccount.size(); ++i){  //iterate through the arraylist and compare the new username to the existing ones
                if(i != pointed && listOfAccount.get(i).getUserNameDecrypted().equals(newUsername))
                    return true;    //this means username exists otherwise
            }
            return false;
        }

    //this method will generate key
    protected void generateKey(){
        keys = new ArrayList<>();   //will generate keys for the accounts

        char character = ' ';
        //this will store characters starting from the ascii value 32 to 126
        for(int i = 0; i < 95; ++i){
            keys.add(character);
            ++character;
        }
    }

    //reads the shuffled key from the file
    private ArrayList<Character> readShuffledKey(Scanner scan){
        //read the shuffled key as an array then declare the holder of the shuffled key
        char[] shuffledCharacterList = scan.nextLine().toCharArray();

        //declare an arraylist object as a holder for the shuffled key
        ArrayList<Character> shuffleKey = new ArrayList<>();

        //put the contents of the array to the arraylist shuffledKey
        for(char a: shuffledCharacterList)
            shuffleKey.add(a);

        //put the arraylist to the account object
        return shuffleKey;
    }

    //make the char array to a string
    private String putToString(char[] charArray){
        //creates string builder object
        StringBuilder stringBuilder = new StringBuilder();

        //puts all the letter of the char array to the string builder object
        for(char a: charArray)
            stringBuilder.append(a);

        //returns the value of the string builder to the caller
        return stringBuilder.toString();
    }

    //decrypt the information provided
    private String decryptSomething(char[] charArray, ArrayList<Character> shuffledKeys){
        //decrypt the char array using the keys generated and the shuffled kay
        for(int i = 0; i < charArray.length; ++i){
            for (int j = 0; j < shuffledKeys.size(); ++j){
                if(charArray[i] == shuffledKeys.get(j)){
                    charArray[i] = keys.get(j);
                    break;
                }
            }
        }
        //turn the char array into a string and return it
        return putToString(charArray);

    }

    //encrypt provided data
    public String encryptData(char[] charArray, ArrayList<Character> shuffledKey){
        for(int i = 0; i < charArray.length; ++i){  //implement the AES encryption method
            for(int j = 0; j < keys.size(); ++j){
                if(charArray[i] == keys.get(j)){
                    charArray[i] = shuffledKey.get(j);
                    break;
                }
            }
        }
        return putToString(charArray);  //converts the array into a string before returning
    }
    
    
    /************************************for the managing the accounts****************************************************************/    
    //this will read all the contents of the file and store them in arraylist
    public void readAllAccounts(boolean userChoice)throws IOException{
        
        File file;
        
        if(userChoice)  //opens the file depending on the userChoice variable
            file = new File("src/inventoryproject/C/accountsForCashier.in");
        else
            file = new File("src/inventoryproject/C/accountsForAdmins.in");
        
        generateKey();

        //this will handle if the file needed is absent or doesn't have any contents
        if(file.length() == 0){
            boolean catcher = file.createNewFile();
        }
        else
            getAccounts(file, userChoice);
    }
    
    //this will really read all the datas from the file
    protected void getAccounts(File file, boolean userChoice) throws IOException {
        //create a scanner object for reading the file contents
        Scanner scan = new Scanner(file);

        while (scan.hasNext()) {
            //creates an object for all the data pertaining to the accounts
            Accounts account = new Accounts();

            //get the username of the account, password and the shuffled key
            account.setUserName(scan.nextLine());
            account.setPassword(scan.nextLine());

            //reads the shuffled kay from the file
            account.setShuffledList(readShuffledKey(scan));
            
            if(!userChoice)
                account.setStanding("Admin");
            else
                account.setStanding("Cashier User");

            //decrypt the username and password and store it to their respective place in the Account object
            account.setUserNameDecrypted(decryptSomething(account.getUserName().toCharArray(), account.getShuffledList()));
            account.setPasswordDecrypted(decryptSomething(account.getPassword().toCharArray(), account.getShuffledList()));

            //put the account to the hash table
            listOfAccount.add(account);
        }
        //close the scanner
        scan.close();
    }
    
    //saves all the arraylist contents in their respective file storages
    public void saveProgress(){
       try{
            new FileWriter("src/inventoryproject/C/accountsForAdmins.in", false).close();
            new FileWriter("src/inventoryproject/C/accountsForCashier.in", false).close();
            
            FileWriter writerAdmin = new FileWriter("src/inventoryproject/C/accountsForAdmins.in", true);
            FileWriter writerCashier = new FileWriter("src/inventoryproject/C/accountsForCashier.in", true);
            
            for(Accounts c: listOfAccount){
                if(c.getStanding().equals("Admin")){
                    writerAdmin.write(c.getUserName() + "\n" + c.getPassword() + "\n");
                    for(char e: c.getShuffledList())
                        writerAdmin.write(e);
                    writerAdmin.write("\n");
                }
                else{
                    writerCashier.write(c.getUserName() + "\n" + c.getPassword() + "\n");
                    for(char e: c.getShuffledList())
                        writerCashier.write(e);
                    writerCashier.write("\n");
                }
            }
            writerAdmin.close();
            writerCashier.close();
            keys.clear();
            listOfAccount.clear();
       }catch(IOException e){
           JOptionPane.showMessageDialog(null, "Problem saving progress!", "Warning", JOptionPane.WARNING_MESSAGE);
       }
    }
    
    //simply removes the selected account to the arraylist
    public void deleteAccount(int toBeDeleted){
        listOfAccount.remove(toBeDeleted);    //deletes the account if present
    }
    
    //generate random string
    public String generateRandomString(){
        return UUID.randomUUID().toString().replaceAll("_",""); //+++will generate random string+++
    }


    //************************for the sign up*******************************
    //adds account
    public boolean addAccount(String userName, String password, String signInKey, boolean userChoice) throws IOException {
        
        readFileContents(userChoice);
        
        String SIGNINKEY = fetchSignInKey();    //gets the sign in key
        boolean valid = true;   //indicator if the entered sign in key matches with the right sign in key
        
        if(signInKey.equals(SIGNINKEY)){
            if(accountList.containsKey(userName)){
                JOptionPane.showMessageDialog(null, "Username already exist!", "Warning", JOptionPane.WARNING_MESSAGE);
                valid = false;
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Invalid Sign In Key", "Warning", JOptionPane.WARNING_MESSAGE);
            valid = false;
        }
        
        if(valid){//encrypt username and password
            Accounts newAccount;
            newAccount = new Accounts();
            //put the created shuffled key for the encryption of the information to the object
            newAccount.setShuffledList(createShuffledList());

            newAccount.setUserNameDecrypted(userName);
            newAccount.setPasswordDecrypted(password);

            newAccount.setUserName(encryptData(newAccount.getUserNameDecrypted().toCharArray(), newAccount.getShuffledList()));
            newAccount.setPassword(encryptData(newAccount.getPasswordDecrypted().toCharArray(), newAccount.getShuffledList()));

            accountList.put(newAccount.getUserNameDecrypted(), newAccount);
            JOptionPane.showMessageDialog(null, "Sign In Successfully!");
            exitSave(userChoice);
        }
        return valid;
    }

    //this method will create the shuffled key for encryption
    public ArrayList<Character> createShuffledList(){
        //create an arraylist and instantiate the contents of the keys to the new Arraylist object
        ArrayList<Character> newArraylist = new ArrayList<>(keys);
        //shuffle the contents
        Collections.shuffle(newArraylist);
        //return the arraylist
        return newArraylist;
    }

    //gets the data from the file and process it
    protected void getData(File file) throws IOException {
        //create a scanner object for reading the file contents
        Scanner scan = new Scanner(file);

        while (scan.hasNext()) {
            //creates an object for all the data pertaining to the accounts
            Accounts account = new Accounts();

            //get the username of the account, password and the shuffled key
            account.setUserName(scan.nextLine());
            account.setPassword(scan.nextLine());

            //reads the shuffled kay from the file
            account.setShuffledList(readShuffledKey(scan));

            //decrypt the username and password and store it to their respective place in the Account object
            account.setUserNameDecrypted(decryptSomething(account.getUserName().toCharArray(), account.getShuffledList()));
            account.setPasswordDecrypted(decryptSomething(account.getPassword().toCharArray(), account.getShuffledList()));

            //put the account to the hash table
            accountList.put(account.getUserNameDecrypted(), account);
        }
        //close the scanner
        scan.close();
    }
}
