package sml;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class SingletonTest {

    SingletonFactoryInstruction x = SingletonFactoryInstruction.getInstance();
    SingletonFactoryInstruction y = SingletonFactoryInstruction.getInstance();

    @Test
    void singletonTest() {
        Assert.assertEquals(x.hashCode(), y.hashCode());
    }
}
