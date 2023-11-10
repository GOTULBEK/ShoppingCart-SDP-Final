package com.shoppingcart.observer;

import java.util.ArrayList;
import java.util.List;

public class NotificationService implements CartObserver {
    private List<String> notifications;

    public NotificationService() {
        notifications = new ArrayList<>();
    }

    public void addNotification(String notification) {
        notifications.add(notification);
    }

    @Override
    public void update() {
        // In a real implementation, you could send notifications to users.
        for (String notification : notifications) {
            System.out.println("Notification: " + notification);
        }
        notifications.clear();
    }
}
