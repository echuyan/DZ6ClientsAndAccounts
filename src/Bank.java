import java.util.ArrayList;
import java.util.HashSet;


public interface Bank {

    void addAccount (Client c, Account a);
    ArrayList<Account> getAccounts (Client c);
    void getClient (Account a);
}
