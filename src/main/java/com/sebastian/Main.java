package com.sebastian;

import com.sebastian.exceptions.BookNotFoundException;
import com.sebastian.model.Book;
import com.sebastian.model.User;
import com.sebastian.repository.memory.MemoryBookRepository;
import com.sebastian.repository.memory.MemoryLoanRepository;
import com.sebastian.service.LibraryService;

public class Main {
    public static void main(String[] args) {
        LibraryService service = new LibraryService(new MemoryBookRepository(), new MemoryLoanRepository());

        Book book = new Book(1, "Noche estrella", "Juan");
        Book book1 = new Book(2, "El llano en llamas", "Juan Rulfo");
        Book book2 = new Book(3, "El jugador", "Dostoyevski");

        service.addBook(book);
        service.addBook(book1);
        service.addBook(book2);

        try {
            System.out.println(service.getBook(1).getTitle());
            System.out.println(service.getBook(4));
        } catch (BookNotFoundException e) {
            System.out.println("error");
        }

        service.loanBook(new User(4, "Selbastian"), book2);
        
    }
}