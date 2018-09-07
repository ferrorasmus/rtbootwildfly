package bootwildfly;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/get")
    public Response getEntry(@RequestParam(value="id") Long id) {
        System.out.println("Handling get request with id=" + id);
        return new Response(id, "id is " + id);
    }


}
