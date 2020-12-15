package jmx_server;

import javax.management.*;

public class Hello extends NotificationBroadcasterSupport implements HelloMBean {

    private String name;
    static int sequenceNumber = 0;

    @Override
    public void sayHello() {
        System.out.println("Hello from jmx");

        Notification notification = new AttributeChangeNotification(this, sequenceNumber++, System.currentTimeMillis(),
                "I sad hello", "sequenceNumber", "int", sequenceNumber - 1, sequenceNumber);
        sendNotification(notification);


    }

    @Override
    public int addIntegers(int a, int b) {
        return a + b;
    }

    @Override
    public Person getPerson() {
        return new Person();
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public MBeanNotificationInfo[] getNotificationInfo() {
        String[] types = new String[]{
                AttributeChangeNotification.ATTRIBUTE_CHANGE
        };
        String name = AttributeChangeNotification.class.getName();
        String description = "An Attributes of this MBean has changed";
        MBeanNotificationInfo info = new MBeanNotificationInfo(types, name, description);
        return new MBeanNotificationInfo[]{info};
    }
}
