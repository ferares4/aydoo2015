package ejemplo1.test.fiuba.algo3.ejemplo1;
//import junit.framework.Assert;
import ejemplo1.src.fiuba.algo3.ejemplo1.Foo;
import org.junit.Test;
import org.junit.Assert;

public class FooTest {

	@Test
	public void doFooShouldReturnFoo(){
        Foo foo;
        foo = new Foo();
        String result = foo.doFoo();
        Assert.assertEquals("Foo", result);

	}

}
