package com.librarymanagementsystem.testbookops;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;

import com.librarymanagementsystem.books.Book;
import com.librarymanagementsystem.books.BookCrudInterface;
import com.librarymanagementsystem.books.BookCrudInterfaceImpl;
import com.librarymanagementsystem.books.BookOperationsInterface;
import com.librarymanagementsystem.books.BookOperationsInterfaceImpl;

@RunWith(MockitoJUnitRunner.class)
public class TestBookOperations {
    @InjectMocks
    private BookOperationsInterfaceImpl bo;
    @Mock
    private BookCrudInterface bc;

    /*
     * @Before
     * public void createClassObjects() {
     * bc = mock(BookCrudInterfaceImpl.class);
     * bo = new BookOperationsInterfaceImpl(bc);
     * }
     * 
     * @After
     * public void destroyClassObjects() {
     * bo = null;
     * bc = null;
     * }
     */

    @Test
    public void testsearchBookByAuthor() {
        Book book = new Book("The Chamber", "Johnny Grisham", "0440220602", "Island Books");
        Map<String, String> search = new HashMap<>();
        Book expected = new Book("The Chamber", "Johnny Grisham", "0440220602", "Island Books");
        Book actual = null;
        try {
            search.put("author", "Johnny Grisham");
            when(bc.getBook(search)).thenReturn(book);
            actual = bo.searchBookByAuthor("Johnny Grisham");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        assertEquals(expected, actual);
    }

   

    @Test
    public void testsearchBookByTitle() {
        Book book = new Book("The Chamber", "Johnny Grisham", "0440220602", "Island Books");
        Map<String, String> search = new HashMap<>();
        Book expected = new Book("The Chamber", "Johnny Grisham", "0440220602", "Island Books");
        Book actual = null;
        try {
            search.put("title", "The Chamber");
            when(bc.getBook(search)).thenReturn(book);
            actual = bo.searchBookByTitle("The Chamber");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        assertEquals(expected, actual);
    }

    @Test
    public void testsearchBookByisbn() {
        Book book = new Book("The Chamber", "Johnny Grisham", "0440220602", "Island Books");
        Map<String, String> search = new HashMap<>();
        Book expected = new Book("The Chamber", "Johnny Grisham", "0440220602", "Island Books");
        Book actual = null;
        try {
            search.put("isbn", "0440220602");
            when(bc.getBook(search)).thenReturn(book);
            actual = bo.searchBookByisbn("0440220602");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        assertEquals(expected, actual);
    }

    @Test
    public void testdeleteBooks() {
        int actual = 0;
        try {
            when(bc.deleteBook("0440220602")).thenReturn(1);
            actual = bo.deleteBook("0440220602");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        assertEquals(1, actual);
    }

    @Test
    public void testupdateBook() {
        Book book = new Book("The Chamber", "Johnny Grisham", "0440220602", "Island Books");
        Book expected = new Book("The Chamber", "Johnny Grisham", "0440220602", "Island Books");
        Book actual = null;
        try {
            when(bc.updateBook(book)).thenReturn(book);
            actual = bo.updateBook(book);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        assertEquals(expected, actual);
    }

      @Test
    public void testaddBook() {
        Book book = new Book("The Chamber", "Johnny Grisham", "0440220602", "Island Books");
        Map<String, String> search = new HashMap<>();
        Book expected = new Book("The Chamber", "Johnny Grisham", "0440220602", "Island Books");
        Book actual = null;
        int act=0;
        try {
            search.put("title", "The Chamber");
            when(bc.addBook(book)).thenReturn(1);
            act=bc.addBook(book);
            when(bc.getBook(search)).thenReturn(book);
            actual = bo.searchBookByTitle("The Chamber");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        assertEquals(1,act);
        assertEquals(expected, actual);
    }

}
