package inventoryproject.C;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Scanner;

public class LogInProcess extends AccountManagerProcess{

    Hashtable<String, Accounts> accountList;
    public boolean logInPanel(String userName, String password, boolean userChoice) throws IOException {
        //--------------------this will read the file contents and will set the accounts in place-------------
        accountList = readFileContents(userChoice);
        if(accountList.containsKey(userName)) {
            boolean confirmation = accountList.get(userName).getPasswordDecrypted().equals(password);
            accountList.clear();
            return confirmation;
        }
        accountList.clear();
        return false;
    }
}
