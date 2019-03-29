package Gsafety.GIS.websocket.test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class test {
    @RequestMapping("/test")
    public String helloWorld(){
        String str = "HelloWorld";
        System.out.println(str);
        return str;
    }
}
