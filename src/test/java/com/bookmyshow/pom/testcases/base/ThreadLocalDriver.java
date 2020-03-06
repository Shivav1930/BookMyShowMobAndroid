package com.bookmyshow.pom.testcases.base;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class ThreadLocalDriver {
	public static ThreadLocal<AndroidDriver> tlDriver = new ThreadLocal<>();

    public static void setTLDriver(AndroidDriver driver) {
        tlDriver.set(driver);
    }

  
	public synchronized static AndroidDriver getTLDriver() {
        return tlDriver.get();
    }
}
