package DAO;

import model.User;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import java.sql.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserDAOTest {

    private static UserDAO userDAO;
    private static DatabaseHelper dbHelper;
    private static Connection mockConnection;

    @BeforeAll
    static void setup() throws SQLException {
        // Mock the Connection and DatabaseHelper
        mockConnection = mock(Connection.class);
        ConnectionProvider mockProvider = mock(ConnectionProvider.class);
        when(mockProvider.getConnection()).thenReturn(mockConnection);
        dbHelper = new DatabaseHelper(mockProvider);

        userDAO = new UserDAO(dbHelper);
    }

    @Test
    @DisplayName("Add a new user successfully")
    void addUser_success() throws SQLException {
        User user = new User("John Doe", "johndoe@example.com");

        PreparedStatement stmt = mock(PreparedStatement.class);
        when(mockConnection.prepareStatement(anyString())).thenReturn(stmt);
        when(stmt.executeUpdate()).thenReturn(1);

        boolean result = userDAO.addUser(user);
        assertTrue(result, "User should be added successfully");

        verify(stmt).setString(1, user.getName());
        verify(stmt).setString(2, user.getEmail());
        verify(stmt).executeUpdate();
    }

    @Test
    @DisplayName("Get user by ID")
    void getUserById_success() throws SQLException {
        int userId = 1;
        User expectedUser = new User("Alice", "alice@example.com");

        PreparedStatement stmt = mock(PreparedStatement.class);
        ResultSet rs = mock(ResultSet.class);

        when(mockConnection.prepareStatement(anyString())).thenReturn(stmt);
        when(stmt.executeQuery()).thenReturn(rs);
        when(rs.next()).thenReturn(true);
        when(rs.getInt("id")).thenReturn(userId);
        when(rs.getString("name")).thenReturn(expectedUser.getName());
        when(rs.getString("email")).thenReturn(expectedUser.getEmail());

        User result = userDAO.getUserById(userId);
        assertNotNull(result);
        assertEquals(expectedUser.getName(), result.getName());
        assertEquals(expectedUser.getEmail(), result.getEmail());
    }

    @Test
    @DisplayName("Update user information")
    void updateUser_success() throws SQLException {
        User user = new User("Bob", "bob@example.com");

        PreparedStatement stmt = mock(PreparedStatement.class);
        when(mockConnection.prepareStatement(anyString())).thenReturn(stmt);
        when(stmt.executeUpdate()).thenReturn(1);

        boolean result = userDAO.updateUser(user);
        assertTrue(result);
    }

    @Test
    @DisplayName("Delete a user")
    void deleteUser_success() throws SQLException {
        int userId = 1;

        PreparedStatement stmt = mock(PreparedStatement.class);
        when(mockConnection.prepareStatement(anyString())).thenReturn(stmt);
        when(stmt.executeUpdate()).thenReturn(1);

        boolean result = userDAO.deleteUser(userId);
        assertTrue(result);
    }

    @Test
    @DisplayName("Get all users")
    void getAllUsers_success() throws SQLException {
        Statement stmt = mock(Statement.class);
        ResultSet rs = mock(ResultSet.class);

        when(mockConnection.createStatement()).thenReturn(stmt);
        when(stmt.executeQuery(anyString())).thenReturn(rs);
        when(rs.next()).thenReturn(false); // empty list

        List<User> users = userDAO.getAllUsers();
        assertNotNull(users);
        assertTrue(users.isEmpty());
    }
}
