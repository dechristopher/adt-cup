package test;

import com.dechristopher.adtcup.Cup;
import com.dechristopher.adtcup.Exceptions.CupInvalidTypeException;
import com.dechristopher.adtcup.Exceptions.CupPourException;
import org.junit.Assert;
import org.junit.Test;

public class TestCupAccessors {

    @Test
    public void TestGetVolume() throws CupPourException, CupInvalidTypeException {
        Cup<Integer> c = new Cup<>();
        c.pour(5);
        Assert.assertEquals(5, c.getVolume());
    }

    @Test
    public void TestGetVolumeEmpty(){
        Cup<Integer> c = new Cup<>();
        Assert.assertEquals(0, c.getVolume());
    }

    @Test
    public void TestGetMaxVolumeDefault(){
        Cup<Integer> c = new Cup<>();
        Assert.assertEquals(75, c.getMaxVolume());
    }

    @Test
    public void TestGetMaxVolumeCustom(){
        Cup<Integer> c = new Cup<>(80);
        Assert.assertEquals(80, c.getMaxVolume());
    }

    @Test
    public void TestGetNumElements() throws CupPourException, CupInvalidTypeException {
        Cup<Integer> c = new Cup<>();
        c.pour(5);
        c.pour(10);
        c.pour(15);
        c.pour(20);
        Assert.assertEquals(4, c.getNumElements());
    }

    @Test
    public void TestGetNumElementsEmpty(){
        Cup<Integer> c = new Cup<>();
        Assert.assertEquals(0, c.getNumElements());
    }

    @Test
    public void TestToString() throws CupPourException, CupInvalidTypeException {
        Cup<Integer> c = new Cup<>();
        c.pour(5);
        c.pour(10);
        Assert.assertEquals("[CUP] Volume: 15/75 - Elements: 2", c.toString());
    }
}
