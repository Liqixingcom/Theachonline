import org.junit.Test;

import java.util.Map;

public class GETUSERINFO {

    @Test
    public  void getname(){
        Map<String, String> map = System.getenv();
        String userName = map.get("USERNAME");// 获取// 用户名
        System.out.println("当前电脑用户名"+userName);
    }
}
