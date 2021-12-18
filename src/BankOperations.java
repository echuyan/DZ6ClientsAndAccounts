import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.Map;

public class BankOperations implements Bank {

    private HashMap<Account, Client> bank;
    private static final int ADULT_AGE = 18;

    public BankOperations(HashMap<Account, Client> bank) {
        this.bank = bank;
    }


    //добавить счет клиенту
    @Override
    public void addAccount(Client c, Account a) {
        bank.put(a, c);

    }

    //Поиск и печать всех счетов клиента
    @Override
    public void printAccountId(Client c) {

        System.out.println("Выводим счета клиента " + c.getName());
        for (Map.Entry<Account, Client> entry : bank.entrySet()) {
            if (entry.getValue().equals(c)) {
                System.out.println(entry.getKey().getAccountId());
            }
        }

    }

    //Поиск и печать клиента по счету
    public void printClientName(Account a) {

        System.out.println(bank.get(a).getName());
    }

    //вспомогательный метод печати всех клиентов и счетов в банке
    public void printAllClientsAndAccounts() {

        for (Map.Entry<Account, Client> entry : bank.entrySet()) {
            System.out.print(entry.getValue().getName() + " ");
            System.out.println(entry.getKey().getAccountId());
        }

        System.out.println("\n");
    }

    //предусмотреть system.err вместо печати

    public boolean canThisClientGetMoney(Client c) {
        LocalDate now = LocalDate.now();
        int age;


        if ((c.getBirthdayDate(c) != null) && (now != null)) {
            age = Period.between(c.getBirthdayDate(c), now).getYears();
        } else {
            age = 0;
        }
        return (age >= 18);
    }


}
