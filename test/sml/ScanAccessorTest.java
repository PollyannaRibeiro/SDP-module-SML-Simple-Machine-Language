package sml;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class ScanAccessorTest {

    @Test
    void scanAccessorTest() throws ClassNotFoundException {
        ScanAccessor scan = new ScanAccessor(()->{return 2;}, ()->{return "Hello World";});
        Assert.assertEquals("Hello World", scan.resolve(Class.forName("java.lang.String")));
    }

}
