package DAO;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

class DatabaseHelperTest {

    @Test
    void getConnection_successfulConnection() throws SQLException {
        // Mock the ConnectionProvider
        ConnectionProvider mockProvider = mock(ConnectionProvider.class);
        Connection mockConnection = mock(Connection.class);

        when(mockProvider.getConnection()).thenReturn(mockConnection);

        DatabaseHelper helper = new DatabaseHelper(mockProvider);

        // Test that a connection is returned successfully
        assertNotNull(helper.getConnection());
    }

    @Test
    void getConnection_failureReturnsNull() throws SQLException {
        // Mock the ConnectionProvider to throw SQLException
        ConnectionProvider mockProvider = mock(ConnectionProvider.class);
        when(mockProvider.getConnection()).thenThrow(new SQLException());

        DatabaseHelper helper = new DatabaseHelper(mockProvider);

        // Test that null is returned on failure
        assertNull(helper.getConnection());
    }
}
