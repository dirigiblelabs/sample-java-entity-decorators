package demo.websocket;

import org.eclipse.dirigible.sdk.net.Websocket;
import org.eclipse.dirigible.sdk.net.WebsocketHandler;

/**
 * Demonstrates {@code @Websocket} + the typed {@link WebsocketHandler} contract: registers this
 * class as the handler for the {@code "java-chat"} WebSocket endpoint. Clients connect via
 * {@code ws://<host>/websockets/stomp/java-chat}.
 *
 * <p>
 * Implementing {@code WebsocketHandler} gives compile-time signature checking and lets each
 * lifecycle callback be omitted — the interface provides empty default implementations, so a
 * handler that only cares about {@code onMessage} doesn't have to declare empty stubs for
 * {@code onOpen} / {@code onError} / {@code onClose}. All four are overridden here to keep the
 * existing log output the integration test relies on.
 */
@Websocket(name = "Java Chat", endpoint = "java-chat")
public class ChatHandler implements WebsocketHandler {

    static final String ENDPOINT = "java-chat";

    @Override
    public void onOpen() {
        System.out.println("ChatHandler: client connected");
    }

    @Override
    public void onMessage(String message, String from) {
        System.out.println("ChatHandler: " + from + " says: " + message);
    }

    @Override
    public void onError(String error) {
        System.out.println("ChatHandler: error: " + error);
    }

    @Override
    public void onClose() {
        System.out.println("ChatHandler: client disconnected");
    }

}
