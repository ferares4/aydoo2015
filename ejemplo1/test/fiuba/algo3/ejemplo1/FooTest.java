package fiuba.algo3.ejemplo1;
//import junit.framework.Assert;
import org.junit.Test;
import org.junit.Assert;
import fiuba.algo3.ejemplo1.Foo;

public class FooTest {

	@Test
	public void doFooShouldReturnFoo(){
        Foo foo = new Foo();
        String result = foo.doFoo();
        Assert.assertEquals("Foo", result);

	}

}
