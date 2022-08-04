import entities.Item;
import entities.Card;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();

        Card card1 = new Card("Card1","Card2.1");
        Card card2 = new Card("Card2","Card2.2");
        Card card3 = new Card("Card3","Card2.3");
        Card card4 = new Card("Card4","Card2.4");


        Item item1 = new Item("test1");
        Item item2 = new Item("test2");


        item1.addCard(card1);
        item1.addCard(card2);
        item1.addCard(card3);
        item1.addCard(card4);

        item2.addCard(card1);

        card1.addItem(item1);
        card1.addItem(item2);

        card2.addItem(item1);
        card3.addItem(item1);
        card4.addItem(item2);

        session.save(item1);
        session.save(item2);


        transaction.commit();
        session.close();
    }

    private static Session getSession(){
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        return sessionFactory.openSession();

    }
}

