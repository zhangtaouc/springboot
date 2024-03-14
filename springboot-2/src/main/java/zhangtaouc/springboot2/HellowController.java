package zhangtaouc.springboot2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HellowController {
    /**
     * 读取配置内容的方法
     * @Value
     * Environment getProperty
     * @
     * */

    @Value("${username}")
    private String name;
    @Value("${persion.name}")
    private String name1;

    @Value("${age}")
    private int age;

    @Autowired
    private Environment env;

    @Autowired
    private Persion persion;

    @RequestMapping("/hello")
    public String hello() {
        System.out.println("加载配置文件啦"+ env.getProperty("username"));
        System.out.println(persion);
        return "姓名:"+this.name+"年龄："+this.age + this.name1;
    }
}
