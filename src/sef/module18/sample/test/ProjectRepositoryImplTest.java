package sef.module18.sample.test;

import junit.framework.AssertionFailedError;
import junit.framework.TestCase;
import sef.module18.activity.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

public class ProjectRepositoryImplTest extends TestCase {

    private Connection conn;
    private String url;
    private String username;
    private String password;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        username = "sa";
        password = "";
        Class.forName("org.h2.Driver");
        url = "jdbc:h2:~/test";
        conn = DriverManager.getConnection(url, username, password);
        conn.setAutoCommit(false);
        System.out.println("Connection successfully established!");
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        try {
            super.tearDown();
            conn.close();
            System.out.println("Connection closed!");
        } catch (AssertionFailedError e) {
            e.printStackTrace();
        }
    }

    public void testFindProjectByID() {
        ProjectRepository test = new ProjectRepositoryImpl(conn);
        try {
            Project result = test.findProjectByID(1);
            assertEquals(result.getProjectName().toLowerCase(), "online insurance system");
            assertEquals(result.getProjectDescription().toLowerCase(), "a web application that automates insurance transactions.");
        } catch (AssertionFailedError e) {
            fail();
        } catch (HRSSystemException e) {
            // TODO Auto-generated catch block
            fail();
        }
    }

    public void testFindProjectByName() {
        ProjectRepository test = new ProjectRepositoryImpl(conn);
        try {
            List<Project> results = test.findProjectByName("Online Insurance System");
            assertEquals(1, results.size());
            assertEquals(results.get(0).getProjectDescription(), "A web application that automates insurance transactions.");
        } catch (HRSSystemException e) {
            // TODO Auto-generated catch block
            fail();
        } catch (AssertionFailedError e) {
            fail();
        }
    }

    public void testFindProjectByEmployee() {

        ProjectRepository test = new ProjectRepositoryImpl(conn);
        try {
            List<Project> results = test.findProjectByEmployee(3);
            assertEquals(1, results.size());
            assertEquals(results.get(0).getProjectName().toLowerCase(), "time report system");
            assertEquals(results.get(0).getProjectDescription().toLowerCase(), "a stand-alone application that records and generates time reports.");

        } catch (HRSSystemException e) {
            e.printStackTrace();
            // TODO Auto-generated catch block
            fail();
        } catch (AssertionFailedError e) {
            fail();
        }
    }

    public void testInsertProject() {
        ProjectRepository test = new ProjectRepositoryImpl(conn);
        try {
            int i = test.insertProject(new ProjectImpl(0, "stas", "alekseev"));
            assertTrue(i > 0);
        } catch (HRSSystemException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            fail();
        } catch (AssertionFailedError e) {
            fail();
        }
    }

    public void testUpdateProject() {
        ProjectRepository test = new ProjectRepositoryImpl(conn);
        try {
            boolean i = test.updateProject(new ProjectImpl(33, "stas", "alekseev"));
            assertTrue(i);
            i = test.updateProject(new ProjectImpl(0, "stss", "alekseev"));
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