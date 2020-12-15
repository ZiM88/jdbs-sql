package jmx_server;

import javax.management.*;
import java.lang.management.ManagementFactory;

public class Main {
    public static void main(String[] args) throws MalformedObjectNameException, InterruptedException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException {
        MBeanServer server = ManagementFactory.getPlatformMBeanServer();
        ObjectName name = new ObjectName("jmx_server:type=Hello");
        Hello mben = new Hello();
        server.registerMBean(mben, name);

        System.out.println("waiting forever...");
        Thread.sleep(Long.MAX_VALUE);
    }
}
