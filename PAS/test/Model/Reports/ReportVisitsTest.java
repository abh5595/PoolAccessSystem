/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Reports;

import Model.Pool;
import Model.Swimmer;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author d.mikhaylov
 */
public class ReportVisitsTest {
    
    ReportVisits instance;
    Pool pool;
    SimpleDateFormat df;
    
    public ReportVisitsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUpInstance() throws FileNotFoundException{
     pool = new Pool();   
     Swimmer swimmerJones = new Swimmer("Jones");
     pool.addSwimmer(swimmerJones);  
     pool.addVisit(swimmerJones);  
     
     instance = new ReportVisits(pool.getReport());
     df = new SimpleDateFormat("yyyy-MM-dd");
     
     
    }

    /**
     * Test of update method, of class ReportVisits.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        instance.update();
        assertEquals(instance.startDate, pool.getReport().getStartDate());
        assertEquals(instance.endDate, pool.getReport().getEndDate());
        assertTrue(instance.allVisits.equals(pool.getReport().getAllVisits()));
    }

    /**
     * Test of getRowCount method, of class ReportVisits.
     */
    @Test
    public void testGetRowCount() {
        System.out.println("getRowCount");
        int expResult = 1;
        int result = instance.getRowCount();
        assertEquals(expResult, result);

    }

    /**
     * Test of getColumnCount method, of class ReportVisits.
     */
    @Test
    public void testGetColumnCount() {
        System.out.println("getColumnCount");
        int expResult = 3;
        int result = instance.getColumnCount();
        assertEquals(expResult, result);
    }

    /**
     * Test of getValueAt method, of class ReportVisits.
     */
    @Test
    public void testGetValueAt() {
        System.out.println("getValueAt");
        int rowIndex = 0;
        int columnIndex = 0;
        Object expResult = "Jones";
        Object result = instance.getValueAt(rowIndex, columnIndex);
        assertEquals(expResult, result);

    }

    /**
     * Test of getReportType method, of class ReportVisits.
     */
    @Test
    public void testGetReportType() {
        System.out.println("getReportType");
        String expResult = "Visits report";
        String result = instance.getReportType();
        assertEquals(expResult, result);

    }
    
}
