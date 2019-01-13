package com.imooc.systeminfo;

import android.os.Build;

public class SystemInfoTools {

    public static String makeInfoString(String[] description, String[] prop) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < prop.length; i++) {
            sb.append(description[i]).append(" : ").append(prop[i]).append("\r\n");
        }
        return sb.toString();
    }

    public static String getBuildInfo() {
        String board = Build.BOARD;                 // 主板
        String brand = Build.BRAND;                 // Android 系统定制商
//        String supported_abis = Build.SUPPORTED_ABIS[0];    // CPU 指令集
        String device = Build.DEVICE;               // 设备参数
        String display = Build.DISPLAY;             // 显示参数
        String fingerprint = Build.FINGERPRINT;     // 唯一编号
        String serial = Build.SERIAL;               // 硬件系列号
        String id = Build.ID;                       // 修订版本号
        String manufacturer = Build.MANUFACTURER;   // 硬件自造商
        String model = Build.MODEL;                 // 版本
        String hardware = Build.HARDWARE;
        String product = Build.PRODUCT;
        String tags = Build.TAGS;
        String type = Build.TYPE;
        String codename = Build.VERSION.CODENAME;
        String incremental = Build.VERSION.INCREMENTAL;
        String release = Build.VERSION.RELEASE;
        String sdk_int = "" + Build.VERSION.SDK_INT;
        String host = Build.HOST;
        String user = Build.USER;
        String time = "" + Build.TIME;
        String[] prop = {
                board,
                brand,
//                supported_abis,
                device,
                display,
                fingerprint,
                serial,
                id,
                manufacturer,
                model,
                hardware,
                product,
                tags,
                type,
                codename,
                incremental,
                release,
                sdk_int,
                host,
                user,
                time
        };
        String[] description = {
                "board",
                "brand",
                "supported_abis",
                "device",
                "display",
                "fingerprint",
                "serial",
                "id",
                "manufacturer",
                "model",
                "hardware",
                "product",
                "tags",
                "type",
                "codename",
                "incremental",
                "release",
                "sdk_int",
                "host",
                "user",
                "time"
        };
        return makeInfoString(description, prop);
    }

    public static String getSystemPropertyInfo() {
        String os_version = System.getProperty("os.version");
        String os_name = System.getProperty("os.name");
        String os_arch = System.getProperty("os.arch");
        String user_home = System.getProperty("user.home");
        String user_name = System.getProperty("user.name");
        String user_dir = System.getProperty("user.dir");
        String user_timezone = System.getProperty("user.timezone");
        String path_separator = System.getProperty("path.separator");
        String line_separator = System.getProperty("line.separator");
        String file_separator = System.getProperty("file.separator");
        String java_vendor_url = System.getProperty("java.vendor.url");
        String java_class_path = System.getProperty("java.class.path");
        String java_class_version = System.getProperty("java.class.version");
        String java_vendor = System.getProperty("java.vendor");
        String java_version = System.getProperty("java.version");
        String java_home = System.getProperty("java_home");
        String[] prop = {
                os_version,
                os_name,
                os_arch,
                user_home,
                user_name,
                user_dir,
                user_timezone,
                path_separator,
                line_separator,
                file_separator,
                java_vendor_url,
                java_class_path,
                java_class_version,
                java_vendor,
                java_version,
                java_home
        };
        String[] description = {
                "os_version",
                "os_name",
                "os_arch",
                "user_home",
                "user_name",
                "user_dir",
                "user_timezone",
                "path_separator",
                "line_separator",
                "file_separator",
                "java_vendor_url",
                "java_class_path",
                "java_class_version",
                "java_vendor",
                "java_version",
                "java_home"
        };
        return makeInfoString(description, prop);
    }
}
