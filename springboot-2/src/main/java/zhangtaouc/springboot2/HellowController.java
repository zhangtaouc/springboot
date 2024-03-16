package zhangtaouc.springboot2;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zhangtaouc.springboot2.Response.Result;

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
    private Result result;

    @Autowired
    private Person person;

    @RequestMapping("/hello")
    public String hello() {
        person.setAge(11);
        person.setName("张三");
        result.setRetCode("00000");
        result.setRetData(person);
        result.setState(200);
        String data = JSON.toJSONString(result);
        return data;
    }
}
