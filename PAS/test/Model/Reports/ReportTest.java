/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Reports;

import Model.Pool;
import Model.Swimmer;
import Model.Visit;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author d.mikhaylov
 */
public class ReportTest {
    
    Report instance;
    Pool pool;
    SimpleDateFormat df;
    
    public ReportTest() {
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
     instance = pool.getReport();
     df = new SimpleDateFormat("yyyy-MM-dd");
     
    }
    
    
    /**
     * Test of getStartDate method, of class Report.
     */
    @Test
    public void testGetStartDate() throws ParseException {
        System.out.println("getStartDate");
        
        Date expResult = df.parse("2018-09-10");  
        Date result = instance.getStartDate();
//        System.out.println("exp result " + expResult.toString());
//        System.out.println("result " + result.toString());
        assertTrue(Math.abs(expResult.getTime()- result.getTime()) < 100);

    }

    /**
     * Test of setStartDate method, of class Report.
     */
    @Test
    public void testSetStartDate() throws ParseException {
        System.out.println("setStartDate");
        Date startDate = df.parse("2018-09-10");      
        instance.setStartDate(startDate);
        System.out.println(startDate.getTime());
        System.out.println(instance.getStartDate().getTime());
        assertEquals(instance.getStartDate().getTime(),startDate.getTime());
    }

    /**
     * Test of getEndDate method, of class Report.
     */
    @Test
    public void testGetEndDate() {
        System.out.println("getEndDate");        
        Date expResult = new Date();
        expResult.setTime(expResult.getTime() + 3600000); 
        Date result = instance.getEndDate();
        assertEquals(expResult, result);
        assertTrue(Math.abs(expResult.getTime()- result.getTime()) < 1000);
    }

    /**
     * Test of setEndDate method, of class Report.
     */
    @Test
    public void testSetEndDate() throws ParseException {
        System.out.println("setEndDate");
        Date endDate = df.parse("2018-09-12");      
        instance.setEndDate(endDate);        
        assertEquals(instance.getEndDate(),endDate);
    }

    /**
     * Test of getActiveReport method, of class Report.
     */
    @Test
    public void testGetActiveReport() {
        System.out.println("getActiveReport");

        AbstractReport expResult = new ReportVisits(instance);
        AbstractReport result = instance.getActiveReport();
        assertEquals(expResult.getReportType(), result.getReportType());

    }

    /**
     * Test of getAllVisits method, of class Report.
     */
    @Test
    public void testGetAllVisits() {
        System.out.println("getAllVisits");

        ArrayList<Visit> expResult = pool.getVisits();
        ArrayList<Visit> result = instance.getAllVisits();
        assertEquals(expResult, result);

    }
    
}
