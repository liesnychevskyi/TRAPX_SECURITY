package methods_core.assertion;

import methods_core.loger.MyLogger;
import org.apache.log4j.Logger;
import org.testng.Assert;

public class AssertionHelper
{
    private static Logger log = MyLogger.getLogger(AssertionHelper.class);
    //===========================================================//
    public static void verifyText(String actual, String expected)
    {
        log.info("Verify text " + actual + " with " + expected);
        Assert.assertEquals(actual, expected);
    }
    //===========================================================//
    public static void makeTrue()
    {
        //log.info("Making script PASS..");
        Assert.assertTrue(true);
    }
    //===========================================================//
    public static void makeTrue(String massage)
    {
        log.info("Making script PASS with the massage : " + massage);
        Assert.assertTrue(true, massage);
    }
    //===========================================================//
    public static void makeFalse()
    {
        log.info("Making script FAIL..");
        Assert.assertTrue(false);
    }
    //===========================================================//
    public static void makeFalse(String massage)
    {
        log.info("Making script FAIL with the massage : " + massage);
        Assert.assertTrue(false, massage);
    }
    //===========================================================//
    public static void verifyTrue(boolean status)
    {
        log.info("");
        Assert.assertTrue(status);
    }
    //===========================================================//
    public static void verifyFalse(boolean status)
    {
        log.info("");
        Assert.assertFalse(status);
    }
    //============================================================//
    public static void verifyNullObject(String s1)
    {
        log.info("Verify object is NULL..");
        Assert.assertNull(s1);
    }
    //============================================================//
    public static void verifyNotNullObject(String s1)
    {
        log.info("Verify object is NOT NULL..");
        Assert.assertNotNull(s1);
    }
    //=============================================================//
    public static void fail()
    {
        Assert.assertTrue(false);
    }
    //=============================================================//
    public static void pass()
    {
        Assert.assertTrue(true);
    }
    //============================================================//
    public static void updateTestStatus(boolean status)
    {
        if(status)
        {
            pass();
        }
        else
        {
            fail();
        }
    }

}
