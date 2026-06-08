package demo.websocket;

import org.eclipse.dirigible.engine.java.annotations.Websocket;

/**
 * Demonstrates {@code @Websocket}: registers this class as the handler for the
 * {@code "java-chat"} WebSocket endpoint. Clients connect via
 * {@code ws://<host>/websockets/stomp/java-chat}.
 *
 * <p>
 * All four lifecycle methods are shown; any subset is valid — missing methods are silently skipped
 * by the runtime.
 */
@Websocket(name = "Java Chat", endpoint = "java-chat")
public class ChatHandler {

    static final String ENDPOINT = "java-chat";

    public void onOpen() {
        System.out.println("ChatHandler: client connected");
    }

    public void onMessage(String message, String from) {
        System.out.println("ChatHandler: " + from + " says: " + message);
    }

    public void onError(String error) {
        System.out.println("ChatHandler: error: " + error);
    }

    public void onClose() {
        System.out.println("ChatHandler: client disconnected");
    }

}