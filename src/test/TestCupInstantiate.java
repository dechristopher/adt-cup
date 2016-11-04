package test;

import com.dechristopher.adtcup.Cup;
import org.junit.Assert;
import org.junit.Test;

public class TestCupInstantiate {

    @Test
    public void TestCupInstantiateDefault(){
        Cup<Integer> c = new Cup<>();
        Assert.assertEquals(75, c.getMaxVolume());
    }

    @Test
    public void TestCupInstantiateCustom(){
        Cup<Integer> c = new Cup<>(80);
        Assert.assertEquals(80, c.getMaxVolume());
    }
}
