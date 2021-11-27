import java.util.HashSet;

public class BankOperations implements Bank{

    private HashSet<Client> clients;

    public BankOperations(HashSet<Client> clients) {
        this.clients=clients;
    }


    //добавить счет клиенту
    @Override
    public void addAccount (Client c,Account a) {
        for (Client s:clients)
             {
            if (s.equals(c)) {c.addAccount(a);}
        }
    }

    //добавить еще одного клиента
    public void addClient (Client c)
    {
        clients.add(c);
    }

    //Поиск всех счетов клиента
    @Override
    public HashSet<Account> getAccounts(Client c) {

        for (Client s : clients) {
            if (s.equals(c)) {
                return c.getAccounts(c);
            }

        }
       return null;
    }

    //Поиск клиента по счету
    @Override
    public Client getClient(Account a) {
        for (Client c:clients) {
            for (Account s:c.getAccounts(c)) {
                if (s.equals(a)) {return c;}
                 }
        }
        return null;
    }

    //вспомогательный метод печати всех клиентов и счетов в банке
    public void printAllClientsAndAccounts () {
        for (Client s:clients)
        {
            System.out.println(s.name);
            for (Account a:s.getAccounts(s))
            {
                System.out.println(a.id);}
        }
        System.out.println("\n");

    }

}
