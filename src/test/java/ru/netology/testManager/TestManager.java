package ru.netology.testManager;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.manager.TicketManager;
import ru.netology.repository.TicketRepository;

public class TestManager {

        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);

    Ticket ticket1 = new Ticket(1, 17000, "LED", "VKO", 300);
    Ticket ticket2 = new Ticket(2, 12000, "SVO", "LED", 700);
    Ticket ticket3 = new Ticket(3, 9000, "LED", "VKO", 500);
    Ticket ticket4 = new Ticket(4, 21000, "LED", "AER", 240);
    Ticket ticket5 = new Ticket(5, 11000, "DME", "LED", 450);
    Ticket ticket6 = new Ticket(6, 14000, "LED", "VKO", 420);

        @Test
        public void searchTicket() {
            manager.addTicket(ticket1);
            manager.addTicket(ticket2);
            manager.addTicket(ticket3);
            manager.addTicket(ticket4);
            manager.addTicket(ticket5);
            manager.addTicket(ticket6);

            Ticket[] expected = {ticket4};
            Ticket[] actual = manager.searchBy("LED", "AER");
            Assertions.assertArrayEquals(expected, actual);


        }

    @Test
    public void searchMultipleTicket() {
        manager.addTicket(ticket1);
        manager.addTicket(ticket2);
        manager.addTicket(ticket3);
        manager.addTicket(ticket4);
        manager.addTicket(ticket5);
        manager.addTicket(ticket6);

        Ticket[] expected = {ticket3, ticket6, ticket1};
        Ticket[] actual = manager.searchBy("LED", "VKO");
        Assertions.assertArrayEquals(expected, actual);
    }
        @Test
        public void searchNotTicketTo() {
            manager.addTicket(ticket1);
            manager.addTicket(ticket2);
            manager.addTicket(ticket3);
            manager.addTicket(ticket4);
            manager.addTicket(ticket5);
            manager.addTicket(ticket6);

            Ticket[] expected = {};
            Ticket[] actual = manager.searchBy("DUB", "MAL");
            Assertions.assertArrayEquals(expected, actual);
        }
        @Test
        public void searchNotTicketFrom() {
            manager.addTicket(ticket1);
            manager.addTicket(ticket2);
            manager.addTicket(ticket3);
            manager.addTicket(ticket4);
            manager.addTicket(ticket5);
            manager.addTicket(ticket6);

            Ticket[] expected = {};
            Ticket[] actual = manager.searchBy("MAL", "DUB");
            Assertions.assertArrayEquals(expected, actual);
        }

    }