import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CastTest {

    Logger LOG = LoggerFactory.getLogger(CastTest.class);
    @Test
    public void test(){
        Object[] values = new Object[3];
        values[0] = 1243;
        int count = 0;
        for (Object value : values) {
            if (value != null) {
             //   count=count+(int)value; // 直接强转编译问题
            }
        }
    }

    /**
     * shift operator
     */
    @Test
    public void testValue(){
        LOG.info("2<<2 value:{}",2<<2);
        System.out.println(2<<2);
        System.out.println(2>>2);
    }
}
