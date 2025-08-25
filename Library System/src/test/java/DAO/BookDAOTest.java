package DAO;

import model.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.sql.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BookDAOTest {

    @Mock
    private Connection mockConnection;

    @Mock
    private PreparedStatement mockPreparedStatement;

    @Mock
    private ResultSet mockResultSet;

    @InjectMocks
    private BookDAO bookDAO;

    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        bookDAO = new BookDAO(mockConnection);
    }

    @Test
    void addBook_success() throws Exception {
        Book book = new Book("1", "Test Title", "Test Author");

        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeUpdate()).thenReturn(1);

        boolean result = bookDAO.addBook(book);
        assertTrue(result);

        verify(mockPreparedStatement).setString(1, "1");
        verify(mockPreparedStatement).setString(2, "Test Title");
        verify(mockPreparedStatement).setString(3, "Test Author");
        verify(mockPreparedStatement).executeUpdate();
    }

    @Test
    void getBookById_found() throws Exception {
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true);
        when(mockResultSet.getString("id")).thenReturn("1");
        when(mockResultSet.getString("title")).thenReturn("Test Title");
        when(mockResultSet.getString("author")).thenReturn("Test Author");

        Book book = bookDAO.getBookById("1");
        assertNotNull(book);
        assertEquals("1", book.getId());
        assertEquals("Test Title", book.getTitle());
        assertEquals("Test Author", book.getAuthor());
    }

    @Test
    void getBookById_notFound() throws Exception {
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(false);

        Book book = bookDAO.getBookById("2");
        assertNull(book);
    }

    @Test
    void getAllBooks_success() throws Exception {
        Statement mockStatement = mock(Statement.class);
        when(mockConnection.createStatement()).thenReturn(mockStatement);
        when(mockStatement.executeQuery(anyString())).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true, true, false);
        when(mockResultSet.getString("id")).thenReturn("1", "2");
        when(mockResultSet.getString("title")).thenReturn("Title1", "Title2");
        when(mockResultSet.getString("author")).thenReturn("Author1", "Author2");

        List<Book> books = bookDAO.getAllBooks();
        assertEquals(2, books.size());
        assertEquals("Title1", books.get(0).getTitle());
        assertEquals("Title2", books.get(1).getTitle());
    }

    @Test
    void updateBook_success() throws Exception {
        Book book = new Book("1", "Updated Title", "Updated Author");

        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeUpdate()).thenReturn(1);

        boolean result = bookDAO.updateBook(book);
        assertTrue(result);

        verify(mockPreparedStatement).setString(1, "Updated Title");
        verify(mockPreparedStatement).setString(2, "Updated Author");
        verify(mockPreparedStatement).setString(3, "1");
    }

    @Test
    void deleteBook_success() throws Exception {
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeUpdate()).thenReturn(1);

        boolean result = bookDAO.deleteBook("1");
        assertTrue(result);

        verify(mockPreparedStatement).setString(1, "1");
        verify(mockPreparedStatement).executeUpdate();
    }
}
