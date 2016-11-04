package test;

import com.dechristopher.adtcup.Cup;
import com.dechristopher.adtcup.Exceptions.CupElementNegativeVolumeException;
import com.dechristopher.adtcup.Exceptions.CupInvalidTypeException;
import com.dechristopher.adtcup.Exceptions.CupPourException;
import com.dechristopher.adtcup.Exceptions.CupStateInvalidException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TestCupDataAccessors {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void TestCupPour() throws CupPourException, CupInvalidTypeException {
        Cup<Integer> c = new Cup<>();
        c.pour(45);
        Assert.assertEquals(45, c.getVolume());
        Assert.assertEquals(1, c.getNumElements());
    }

    @Test
    public void TestCupPourSuccess() throws CupPourException, CupInvalidTypeException {
        Cup<Integer> c = new Cup<>();
        boolean success = c.pour(45);
        Assert.assertEquals(true, success);
    }

    @Test
    public void TestCupPourFilled() throws CupPourException, CupInvalidTypeException {
        Cup<Integer> c = new Cup<>(5);
        c.pour(5);
        boolean success = c.pour(5);
        Assert.assertEquals(false, success);
    }

    @Test
    public void TestCupPourWontFit() throws CupPourException, CupInvalidTypeException {
        Cup<Integer> c = new Cup<>(5);
        c.pour(4);
        boolean success = c.pour(5);
        Assert.assertEquals(false, success);
    }

    @Test
    public void TestCupPourNegative() throws CupPourException, CupInvalidTypeException {
        Cup<Integer> c = new Cup<>();
        c.pour(-45);
        Assert.assertEquals(45, c.getVolume());
        Assert.assertEquals(1, c.getNumElements());
    }

    @Test
    public void TestCupPourNull() throws CupPourException, CupInvalidTypeException {
        thrown.expect(NullPointerException.class);
        thrown.expectMessage("Cups don't accept null liquids...bastard.");
        Cup<Integer> c = new Cup<>();
        c.pour(null);
    }

    @Test
    public void TestCupPourInvalidType() throws CupPourException, CupInvalidTypeException, CupStateInvalidException {
        thrown.expect(CupInvalidTypeException.class);
        thrown.expectMessage("Couldn't get volume of element of type: java.lang.Long");
        Cup<Long> c = new Cup<>();
        c.pour(new Long("8348237497498234"));
    }

    @Test
    public void TestCupSip() throws CupPourException, CupInvalidTypeException, CupElementNegativeVolumeException {
        Cup<Integer> c = new Cup<>();
        c.pour(45);
        c.sip();
        Assert.assertEquals(0, c.getVolume());
        Assert.assertEquals(0, c.getNumElements());
    }

    @Test
    public void TestCupSipSuccess() throws CupPourException, CupInvalidTypeException, CupElementNegativeVolumeException {
        Cup<Integer> c = new Cup<>();
        c.pour(45);
        int x = c.sip();
        Assert.assertEquals(45, x);
    }
}
