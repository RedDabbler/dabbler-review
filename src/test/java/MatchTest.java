import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by whh on 2017/11/10.
 */
public class MatchTest {

    // matcher 使用
    @Test
    public void test() {
        Pattern p = Pattern.compile("(\\d+)");
        String s = "123,456-34,345";
        Matcher m = p.matcher(s);

        while (m.find()){  // find 才去执行解析匹配
            System.out.println("m.group():" + m.group()); //打印所有
            System.out.println( m.toString());
            System.out.println("m.group(0):" + m.group(0)); //打印所有
            System.out.println("m.groupCount():"+m.groupCount());
            System.out.println("m.group(1):" + m.group(1)); //打印数字的

            System.out.println("m.group(2):" + m.group(2)); //打印字母的
            System.out.println();
        }
        System.out.println("是否匹配："+m.matches());

        System.out.println("捕获个数:groupCount()=" + m.groupCount());

    }
}