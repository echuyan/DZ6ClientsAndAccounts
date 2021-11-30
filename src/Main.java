import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

    /**
     *
     * Применяем на практике навыки управления equals
     *
     * У нас есть банк , в котором хранятся золотые монеты.
     * У банка есть клиенты у которых есть имя и нам как банку важно знать их возраст для ограничений на операции.
     * У одного клиента может быть несколько счетов на которых хранятся золотые монеты.
     *
     * Нужно реализовать следующую функциональность :
     *
     * Найти все счета по клиенту (например List getAccounts(Client client) )
     * Найти клиента по счету (например Client findClient(Account account) ) Поиск должен работать максимально быстро(!!!) с использованием стандартных коллекций Java.
     * В классах Client и Account должно быть минимальное кол-во полей, достаточное для этой задачи.
     */
    public static void main(String[] args) {

        //Подготовка тестовых данных
        //Можно вывести их хранение в файл, бд, конфиг....
        Account acc11 = new Account("account1 of client1");
        Account acc12 = new Account("account2 of client1");
        Account acc21 = new Account("account1 of client2");
        Account acc22 = new Account("account2 of client2");
        Account acc23= new Account("account3 of client2");
        Client client1 = new Client("Client1",new GregorianCalendar(2020,11,5));
        Client client2 = new Client("Client2",new GregorianCalendar(2001,11,5));
        HashMap<Account,Client> bankMap = new HashMap<Account, Client>();
        bankMap.put(acc11,client1);
        bankMap.put(acc12,client1);
        bankMap.put(acc21,client2);
        bankMap.put(acc22,client2);
        bankMap.put(acc23,client2);

        BankOperations bank = new BankOperations(bankMap);



        System.out.println("Вот какие клиенты и счета есть в банке:");
        bank.printAllClientsAndAccounts();

        //Добавим нового клиента, а потом добавим ему еще один счет
        Account acc31 = new Account("account1 of client3");
        Account acc32 = new Account("account2 of client3");
        Client client3 = new Client("Client3",new GregorianCalendar(1975,11,5));
        bank.addAccount(client3,acc31);
        bank.addAccount(client3,acc32);
        Account acc33 = new Account("account3 of client3");
        bank.addAccount(client3,acc33);

        System.out.println("А теперь вот какие клиенты и их счета есть в банке:");
        bank.printAllClientsAndAccounts();

        System.out.println("Поищем счета клиента 3:");
        bank.getAccounts(client3);

        System.out.println("А теперь поищем клиента по счету");
        bank.getClient(acc31);

        System.out.println("Каким клиентам можем выдать деньги?");
        bank.canThisClientGetMoney(client1);
        bank.canThisClientGetMoney(client2);
        bank.canThisClientGetMoney(client3);

    }
}
