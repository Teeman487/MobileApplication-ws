package com.appsdeveloperblog.app.ws.mobileappws.Utils;

import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class Utils {
    public  String generateUserId()
    {
        return UUID.randomUUID().toString(); // Debug   // Construction Based Dependency Injection
    }
}
