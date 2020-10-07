import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleTestClass extends BaseTestClass{

    @Test
    public void sampleMethod(){
        Assert.assertTrue(false,"Assertion fails");
    }

}
