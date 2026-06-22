package demo;

import org.eclipse.dirigible.sdk.component.Beans;
import org.eclipse.dirigible.sdk.http.Controller;
import org.eclipse.dirigible.sdk.http.Get;
import org.eclipse.dirigible.sdk.http.PathParam;

/**
 * Constructor injection (preferred, testable). Also shows the Beans facade for programmatic lookup
 * when an injection point isn't convenient.
 */
@Controller
public class GreetingController {

    private final GreetingService greetings;

    public GreetingController(GreetingService greetings) {
        this.greetings = greetings;
    }

    @Get("/greet/{name}")
    public String greet(@PathParam("name") String name) {
        return greetings.greet(name);
    }

    @Get("/greet-via-beans/{name}")
    public String greetViaBeans(@PathParam("name") String name) {
        return Beans.get(GreetingService.class)
                    .greet(name);
    }
}
