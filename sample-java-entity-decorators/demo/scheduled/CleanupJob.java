package demo.scheduled;

import org.eclipse.dirigible.engine.java.annotations.Scheduled;

/**
 * Demonstrates {@code @Scheduled}: fires every second via Quartz. Each execution logs a line that
 * the integration test asserts on to confirm the job was picked up by the runtime.
 */
@Scheduled(expression = "* * * * * ?")
public class CleanupJob {

    public void run() {
        System.out.println("CleanupJob executed!");
    }

}