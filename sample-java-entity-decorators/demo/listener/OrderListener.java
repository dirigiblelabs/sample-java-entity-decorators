package demo.listener;

import org.eclipse.dirigible.sdk.messaging.Listener;
import org.eclipse.dirigible.sdk.messaging.ListenerKind;

/**
 * Demonstrates {@code @Listener}: connects to the ActiveMQ queue {@code "java-order-queue"} and
 * logs every inbound text message. The companion {@code trigger.mjs} sends a test message that the
 * integration test asserts on via the log output.
 */
@Listener(name = "java-order-queue", kind = ListenerKind.QUEUE)
public class OrderListener {

    public void onMessage(String message) {
        System.out.println("OrderListener received: " + message);
    }

    public void onError(String error) {
        System.out.println("OrderListener error: " + error);
    }

}