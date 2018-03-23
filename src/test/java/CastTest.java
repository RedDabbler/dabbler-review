import org.junit.Test;

public class CastTest {

    @Test
    public void test(){
        Object[] values = new Object[3];
        values[0] = 1243;
        int count = 0;
        for (Object value : values) {
            if (value != null) {
              //  count=count+(int)value; // 直接强转编译问题
            }
        }
    }
}
