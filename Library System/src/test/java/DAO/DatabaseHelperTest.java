package DAO;

import org.junit.jupiter.api.*;
import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DatabaseHelperTest {

    private ConnectionProvider mockProvider;
    private DatabaseHelper helper;

    @BeforeEach
    void setup() {
        mockProvider = mock(ConnectionProvider.class);
        helper = new DatabaseHelper(mockProvider);
    }

    @Test
    @DisplayName("Successful connection returns non-null")
    void getConnection_successfulConnection() throws SQLException {
        Connection mockConnection = mock(Connection.class);
        when(mockProvider.getConnection()).thenReturn(mockConnection);

        Connection conn = helper.getConnection();
        assertNotNull(conn, "Connection should not be null");
    }

    @Test
    @DisplayName("Failed connection returns null")
    void getConnection_failureReturnsNull() throws SQLException {
        when(mockProvider.getConnection()).thenThrow(new SQLException());

        Connection conn = helper.getConnection();
        assertNull(conn, "Connection should be null when SQLException occurs");
    }
}
