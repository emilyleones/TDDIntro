package com.thoughtworks.tddintro.library;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.*;

public class LibraryTest {


    /*

        List books tests. Implement the first three tests for the Verify exercise

     */
    private List<String> books;
    private PrintStream printStream;

    @Before
    public void setUp() throws Exception {
        books = new ArrayList<>();
        printStream = mock(PrintStream.class);
    }

    @Test
    public void shouldPrintBookTitleWhenThereIsOneBook() {

        String title = "Book Title";
        books.add(title);
        Library library = new Library(books, printStream, null);

        library.listBooks();

        // add a verify statement here that shows that the book title was printed by to the printStream
        verify(printStream).println(title);
    }

    @Test
    public void shouldPrintNothingWhenThereAreNoBooks() {

        Library library = new Library(books, printStream, null);

        library.listBooks();

        verifyZeroInteractions(printStream);
    }

    @Test
    public void shouldPrintBothBookTitlesWhenThereAreTwoBooks() {

        String title1 = "Head First Java";
        books.add(title1);
        String title2 = "Test Driven Development by Example";
        books.add(title2);
        Library library = new Library(books, printStream, null);

        library.listBooks();

        verify(printStream).println(title1);
        verify(printStream).println(title2);
    }

    /*

        Welcome message tests. Implement these tests for the when/thenReturn exercise

     */

    
    // This one is done for you
    @Test
    public void shouldWelcomeUser() {

        DateTimeFormatter dateTimeFormatter = mock(DateTimeFormatter.class);
        Library library = new Library(books, printStream, dateTimeFormatter);

        // We don't need to mock DateTime because it is a value object
        // We can't mock it because it is a final class
        DateTime time = new DateTime();
        
        library.welcome(time);
        
        verify(printStream).println(contains("Welcome"));
    }

    @Test
    public void shouldDisplayFormattedTimeWhenFormattedTimeIsAnEmptyString() {

        DateTime time = new DateTime();
        DateTimeFormatter dateTimeFormatter = mock(DateTimeFormatter.class);

        when(dateTimeFormatter.print(time)).thenReturn("");

        Library library = new Library(books, printStream, dateTimeFormatter);

        library.welcome(time);

        verify(printStream).println("Welcome to the library! The current time is ");
    }

    @Test
    public void shouldDisplayFormattedTimeWhenFormattedTimeIsNotEmpty() {

        DateTime time = new DateTime();
        DateTimeFormatter dateTimeFormatter = mock(DateTimeFormatter.class);

        when(dateTimeFormatter.print(time)).thenReturn("11:15 AM");

        Library library = new Library(books, printStream, dateTimeFormatter);

        library.welcome(time);

        verify(printStream).println("Welcome to the library! The current time is 11:15 AM");
    }
}