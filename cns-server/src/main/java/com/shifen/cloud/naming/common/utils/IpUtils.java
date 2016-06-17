package com.shifen.cloud.naming.common.utils;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

public final class IpUtils {
  private IpUtils() {
    throw new AssertionError("not support...");
  }

  public static String getIP(String path) {
    List<String> list = new ArrayList<String>();
    try {
      Enumeration<NetworkInterface> allNetInterfaces = NetworkInterface.getNetworkInterfaces();
      InetAddress ip = null;
      while (allNetInterfaces.hasMoreElements()) {
        NetworkInterface netInterface = (NetworkInterface) allNetInterfaces.nextElement();
        Enumeration<InetAddress> addresses = netInterface.getInetAddresses();
        while (addresses.hasMoreElements()) {
          ip = addresses.nextElement();

          if (!ip.isLoopbackAddress() && ip.getHostAddress().indexOf(":") == -1)
            list.add(ip.getHostAddress());
        }
      }
      // ip字符串排序
      Collections.sort(list);
      return list.get(0).toString();
    } catch (Exception e) {
      return path;
    }
  }

}
