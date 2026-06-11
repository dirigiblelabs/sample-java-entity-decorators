package demo.scheduled;

import org.eclipse.dirigible.sdk.job.JobHandler;
import org.eclipse.dirigible.sdk.job.Scheduled;

/**
 * Demonstrates {@code @Scheduled} + the typed {@link JobHandler} contract: fires every second via
 * Quartz. Each execution logs a line that the integration test asserts on to confirm the job was
 * picked up by the runtime. Implementing {@code JobHandler} gives compile-time signature checking
 * and lets the runtime dispatch the callback directly (no reflection).
 */
@Scheduled(expression = "* * * * * ?")
public class CleanupJob implements JobHandler {

    @Override
    public void run() {
        System.out.println("CleanupJob executed!");
    }

}
