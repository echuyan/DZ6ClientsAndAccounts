import java.util.HashSet;


public interface Bank {

    void addAccount (Client c, Account a);
    HashSet<Account> getAccounts (Client c);
    Client getClient (Account a);
}
