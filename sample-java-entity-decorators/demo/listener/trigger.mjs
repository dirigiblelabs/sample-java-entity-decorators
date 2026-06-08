import { producer } from "@aerokit/sdk/messaging";

producer.queue("java-order-queue").send("Hello from Java @Listener trigger!");