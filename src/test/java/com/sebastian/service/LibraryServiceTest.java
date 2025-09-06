package com.sebastian.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.sebastian.exceptions.BookNotFoundException;
import com.sebastian.exceptions.LoanNotFoundException;
import com.sebastian.model.Book;
import com.sebastian.model.Loan;
import com.sebastian.model.User;
import com.sebastian.repository.memory.MemoryBookRepository;
import com.sebastian.repository.memory.MemoryLoanRepository;

public class LibraryServiceTest {
    private MemoryBookRepository bookRepo;
    private MemoryLoanRepository loanRepo;
    private LibraryService service;

    @BeforeEach
    void start(){
        MockitoAnnotations.openMocks(this);
        bookRepo = Mockito.mock(MemoryBookRepository.class);
        loanRepo = Mockito.mock(MemoryLoanRepository.class);
        service = new LibraryService(bookRepo, loanRepo);
    }

    @Test
    void shouldAddABook(){
        Book book = new Book(0, "El llano en llamas", "Juan Rulfo");
        service.addBook(book);
        Mockito.verify(bookRepo).addBook(book);
    }

    @Test
    void shouldReturnABookByItsId() throws BookNotFoundException{
        Book bookMock = new Book(0, "El llano en llamas", "Juan Rulfo"); 
        Mockito.when(bookRepo.findBookById(0)).thenReturn(bookMock);

        Book book = service.getBook(0);
        assertEquals("El llano en llamas", book.getTitle());
    }

    //Duda, si no estamos agregando ningun loan, porque pasa? La lista deberia estar empty
    @Test
    void shouldReturnTheLoanByUser() throws LoanNotFoundException{
        User user = new User(1, "Juan");
        Book book = new Book(1,"1984", "Geore Orwell");
        Book book1 = new Book(2,"El jugador", "Dostoievsky");
        Loan loan = new Loan(user, book1);
        Loan loan1 = new Loan(user, book);

        List<Loan> loans = Arrays.asList(loan, loan1);
        Mockito.when(loanRepo.findByUser(user)).thenReturn(loans);

        List<Loan> result = service.getLoanByUser(user);
        
        assertEquals(2, result.size());
        assertEquals(loan, result.get(0));
        assertEquals(loan1, result.get(1));
    }


}
