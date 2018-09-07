package bootwildfly;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.apache.camel.LoggingLevel;
import org.springframework.stereotype.Component;

@Component
public class CamelRoutes extends RouteBuilder {

  @Override
  public void configure() throws Exception {
    restConfiguration()
      .component("servlet");

    rest()
      .bindingMode(RestBindingMode.json)
      .produces("application/json")
       .get("/{type}").to("direct:hello")
       .get("/typ").to("direct:hello");
 
    from("direct:hello")
      .log(LoggingLevel.INFO, "Hello World")
      .transform().simple("Hello World");
   }
}
