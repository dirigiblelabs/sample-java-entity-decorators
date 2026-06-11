package demo.listener;

import org.eclipse.dirigible.sdk.messaging.Listener;
import org.eclipse.dirigible.sdk.messaging.ListenerKind;
import org.eclipse.dirigible.sdk.messaging.MessageHandler;

/**
 * Demonstrates {@code @Listener} + the typed {@link MessageHandler} contract: connects to the
 * ActiveMQ queue {@code "java-order-queue"} and logs every inbound text message. Implementing
 * {@code MessageHandler} gives compile-time signature checking and a direct, non-reflective
 * dispatch path; the default {@code onError} no-op is overridden here for demonstration.
 */
@Listener(name = "java-order-queue", kind = ListenerKind.QUEUE)
public class OrderListener implements MessageHandler {

    @Override
    public void onMessage(String message) {
        System.out.println("OrderListener received: " + message);
    }

    @Override
    public void onError(String error) {
        System.out.println("OrderListener error: " + error);
    }

}
