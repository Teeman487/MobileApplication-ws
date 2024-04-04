package com.appsdeveloperblog.app.ws.mobileappws.shared;

import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class Utils {
    public static String generateUserId()
    {
        return UUID.randomUUID().toString(); // Debug   // Construction Based Dependency Injection
    }
}
