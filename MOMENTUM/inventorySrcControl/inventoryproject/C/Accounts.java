package inventoryproject.C;
import java.util.ArrayList;

public class Accounts{
    //data field
    private String userName;
    private String password;
    private ArrayList<Character> shuffledList;
    private String userNameDecrypted;
    private String passwordDecrypted;
    private String standing = "";

    //constructor
    Accounts(){
        this.setUserName(userName);
        this.setPassword(password);
        this.shuffledList = new ArrayList<>();
        this.setUserNameDecrypted(userNameDecrypted);
        this.setPasswordDecrypted(passwordDecrypted);
    }

    //setters
    public void setUserName(String userName){
        this.userName = userName;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setUserNameDecrypted(String userNameDecrypted){
        this.userNameDecrypted = userNameDecrypted;
    }

    public void setPasswordDecrypted(String passwordDecrypted){
        this.passwordDecrypted = passwordDecrypted;
    }

    public void setShuffledList(ArrayList<Character> myList){
        this.shuffledList = myList;
    }
    
    public void setStanding(String standing){
        this.standing = standing;
    }

    //getters
    public String getUserName(){
        return userName;
    }

    public String getUserNameDecrypted(){
        return userNameDecrypted;
    }

    public String getPasswordDecrypted(){
        return passwordDecrypted;
    }

    public String getPassword(){
        return password;
    }

    public ArrayList<Character> getShuffledList(){
        return shuffledList;
    }
    
    public String getStanding(){
        return standing;
    }
}
