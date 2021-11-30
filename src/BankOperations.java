import java.util.*;

public class BankOperations implements Bank{

    private HashMap<Account,Client> bank;

    public BankOperations(HashMap<Account,Client> bank) {
        this.bank=bank;
    }


    //добавить счет клиенту
    @Override
    public void addAccount (Client c,Account a) {
        bank.put(a,c);

    }

    //Поиск и печать всех счетов клиента
    @Override
    public ArrayList<Account> getAccounts(Client c) {

        System.out.println("Выводим счета клиента "+c.getName());
        for (Map.Entry<Account,Client> entry: bank.entrySet()) {
           if (entry.getValue().equals(c)) {
               System.out.println(entry.getKey().getAccountId());
           }        }

       return null;
    }

    //Поиск и печать клиента по счету
    @Override
    public void getClient(Account a) {

        System.out.println(bank.get(a).getName());
     }

    //вспомогательный метод печати всех клиентов и счетов в банке
    public void printAllClientsAndAccounts () {

        for (Map.Entry<Account,Client> entry: bank.entrySet()) {
            System.out.print(entry.getValue().getName()+" ");
            System.out.println(entry.getKey().getAccountId());
        }

        System.out.println("\n");
    }

    //Можем ли выдавать золотые монеты этому клиенту?
    public void canThisClientGetMoney(Client c) {
        Calendar calendar = Calendar.getInstance();
        GregorianCalendar gc = (GregorianCalendar) calendar;

        if (gc.get(Calendar.YEAR)-c.getBirthdayDate(c).get(Calendar.YEAR)>=18) {
            System.out.println("Можем выдать клиенту "+c.getName()+" деньги!");}
        else
        if (gc.get(Calendar.MONTH)-c.getBirthdayDate(c).get(Calendar.MONTH)>=1) {
            System.out.println("Можем выдать клиенту "+c.getName()+" деньги!");}
        else
        if (gc.get(Calendar.DAY_OF_MONTH)-c.getBirthdayDate(c).get(Calendar.DAY_OF_MONTH)>=1) {
            System.out.println("Можем выдать клиенту "+c.getName()+" деньги!");}
        else {
            System.out.println("Не можем выдать клиенту "+c.getName()+" деньги!");}
    }


}
