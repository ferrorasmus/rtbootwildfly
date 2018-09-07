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
       .get("/{type}") 
           .log("${body}")
           .to("direct:hello");
       .get("/")
           .log("${body}")
           .route().setHeader("type")
                .content("info")
                .to("direct:hello")
        .endRest();
 
    from("direct:hello")
      .log(LoggingLevel.INFO, "Hello World")
      .transform().simple("Hello World");
   }
}
