package test;

import com.dechristopher.adtcup.Cup;
import com.dechristopher.adtcup.Exceptions.CupInvalidTypeException;
import com.dechristopher.adtcup.Exceptions.CupPourException;
import com.dechristopher.adtcup.Exceptions.CupStateInvalidException;
import org.junit.Assert;
import org.junit.Test;

public class TestCupState {

    @Test
    public void TestCupFullWhenFull() throws CupPourException, CupInvalidTypeException {
        Cup<Integer> c = new Cup<>(5);
        c.pour(5);
        Assert.assertEquals(true, c.isCupFull());
    }

    @Test
    public void TestCupFullWhenEmpty(){
        Cup<Integer> c = new Cup<>();
        Assert.assertEquals(false, c.isCupFull());
    }

    @Test
    public void TestCupEmptyWhenEmpty() throws CupStateInvalidException {
        Cup<Integer> c = new Cup<>();
        Assert.assertEquals(true, c.isCupEmpty());
    }

    @Test
    public void TestCupEmptyWhenFull() throws CupStateInvalidException, CupPourException, CupInvalidTypeException {
        Cup<Integer> c = new Cup<>(5);
        c.pour(5);
        Assert.assertEquals(false, c.isCupEmpty());
    }
}
