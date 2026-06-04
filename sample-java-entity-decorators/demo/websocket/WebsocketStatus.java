package demo.websocket;

import java.util.Map;

import org.eclipse.dirigible.components.base.spring.BeanProvider;
import org.eclipse.dirigible.engine.java.annotations.http.Controller;
import org.eclipse.dirigible.engine.java.annotations.http.Get;
import org.eclipse.dirigible.engine.java.websocket.JavaWebsocketRegistry;

/**
 * REST endpoint that reports whether {@link ChatHandler} was registered in the
 * {@code JavaWebsocketRegistry} after publish.
 *
 * <p>
 * {@code GET /services/java/sample-java-entity-decorators/demo/websocket/WebsocketStatus/status}
 * returns {@code {"registered": true}} when the {@code "java-chat"} handler is active.
 */
@Controller
public class WebsocketStatus {

    @Get("/status")
    public Map<String, Object> status() {
        JavaWebsocketRegistry registry = BeanProvider.getBean(JavaWebsocketRegistry.class);
        return Map.of("registered", registry.contains(ChatHandler.ENDPOINT));
    }

}