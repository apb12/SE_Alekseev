package sef.module18.sample.test;

import junit.framework.AssertionFailedError;
import junit.framework.TestCase;
import sef.module18.activity.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

public class EmployeeRepositoryImplTest extends TestCase {

    private Connection conn;
    private String url;
    private String username;
    private String password;

    public void setUp() throws Exception {
        super.setUp();
        username = "sa";
        password = "";
        Class.forName("org.h2.Driver");
        url = "jdbc:h2:~/test";
        conn = DriverManager.getConnection(url, username, password);
        conn.setAutoCommit(false);
        System.out.println("Connection successfully established!");
    }

    public void tearDown() throws Exception {
        try {
            super.tearDown();
            conn.close();
            System.out.println("Connection closed!");
        } catch (AssertionFailedError e) {
            e.printStackTrace();
        }
    }

    public void testFindEmployeeByID() {
        EmployeeRepositoryImpl test = new EmployeeRepositoryImpl(conn);
        try {
            Employee result = test.findEmployeeByID(1);
            assertEquals(result.getFirstName().toUpperCase(), "JOHN");
            assertEquals(result.getLastName().toUpperCase(), "DOE");
            assertEquals(result.getProfLevel(), 1);
        } catch (AssertionFailedError e) {
            fail();
        } catch (HRSSystemException e) {
            // TODO Auto-generated catch block
            fail();
        }
    }

    public void testFindEmployeeByName() {
        EmployeeRepository test = new EmployeeRepositoryImpl(conn);
        try {
            List<Employee> results = test.findEmployeeByName("J", "DOE");
            assertEquals(2, results.size());

            assertEquals(results.get(0).getFirstName().toUpperCase(), "JOHN");
            assertEquals(results.get(0).getLastName().toUpperCase(), "DOE");
            assertEquals(results.get(0).getProfLevel(), 1);


            assertEquals(results.get(1).getFirstName().toUpperCase(), "JANE");
            assertEquals(results.get(1).getLastName().toUpperCase(), "DOE");
            assertEquals(results.get(1).getProfLevel(), 2);

        } catch (HRSSystemException e) {
            // TODO Auto-generated catch block
            fail();
        } catch (AssertionFailedError e) {

            fail();
        }
    }

    public void testFindEmployeeByProfLevel() {
        EmployeeRepository test = new EmployeeRepositoryImpl(conn);
        try {
            List<Employee> results = test.findEmployeeByProfLevel(2);
            assertEquals(1, results.size());

            assertEquals(results.get(0).getFirstName().toUpperCase(), "JANE");
            assertEquals(results.get(0).getLastName().toUpperCase(), "DOE");
            assertEquals(results.get(0).getProfLevel(), 2);

        } catch (HRSSystemException e) {
            // TODO Auto-generated catch block
            fail();
        } catch (AssertionFailedError e) {

            fail();
        }
    }

    public void testFindEmployeeByProject() {
        EmployeeRepository test = new EmployeeRepositoryImpl(conn);
        try {
            List<Employee> results = test.findEmployeeByProject(3);
            assertEquals(2, results.size());

            assertEquals(results.get(0).getFirstName().toUpperCase(), "JANE");
            assertEquals(results.get(0).getLastName().toUpperCase(), "DOE");
            assertEquals(results.get(0).getProfLevel(), 2);


            assertEquals(results.get(1).getFirstName().toUpperCase(), "JAMES");
            assertEquals(results.get(1).getLastName().toUpperCase(), "DONNELL");
            assertEquals(results.get(1).getProfLevel(), 3);

        } catch (HRSSystemException e) {
            // TODO Auto-generated catch block
            fail();
        } catch (AssertionFailedError e) {

            fail();
        }

    }

    public void testInsertEmployee() {
        EmployeeRepository test = new EmployeeRepositoryImpl(conn);

        try {
            int i = test.insertEmployee(new EmployeeImpl(0, "stas", "alekseev", 1));
            assertTrue(i > 0);

        } catch (HRSSystemException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            fail();
        } catch (AssertionFailedError e) {

            fail();
        }
    }

    public void testUpdateEmployee() {
        EmployeeRepository test = new EmployeeRepositoryImpl(conn);

        try {
            boolean i = test.updateEmployee(new EmployeeImpl(6, "stas", "alekseev", 1));
            assertTrue(i);
            i = test.updateEmployee(new EmployeeImpl(0, "stss", "alekseev", 1));
            assertFalse(i);

        } catch (HRSSystemException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            fail();
        } catch (AssertionFailedError e) {

            fail();
        }
    }
}