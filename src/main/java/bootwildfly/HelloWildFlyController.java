package bootwildfly;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWildFlyController {

    @Autowired
    ProducerTemplate producerTemplate;

    @RequestMapping("direct")
    public String direct(){
        producerTemplate.sendBody("direct:firstRoute", "Hello, SpringBoot on Wildfly via camel route");
    }

    @RequestMapping("hello")
    public String sayHello(){
        return ("Hello, SpringBoot on Wildfly");
    }
}
