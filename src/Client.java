import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;


public class Client{

public String name;
private GregorianCalendar birtdayDate;
private HashSet<Account> accounts;


    public Client(String name, GregorianCalendar birtdayDate,HashSet<Account> accounts) {
        this.name = name;
        this.birtdayDate = birtdayDate;
        this.accounts=accounts;
    }

    //добавить счет клиенту
    public void addAccount (Account account) {
    accounts.add(account);
    }

    //получить счета клиента
     public HashSet<Account> getAccounts(Client c) {
        return accounts;
    }

    //получить клиента
    public Client getClient (Account account) {
        return this;
    }



}




