package demo;

import org.eclipse.dirigible.sdk.component.Component;

/**
 * A plain @Component service injected into a controller by constructor — the Spring-style DI the
 * client-Java model now supports.
 */
@Component
public class GreetingService {

    public String greet(String name) {
        return "Hello, " + name + "!";
    }
}
