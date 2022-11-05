package com.dx;

import org.junit.jupiter.api.Test;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;

/**
 * Description:
 *
 * @author rockstarsteve
 * @version 1.0
 * @copyright Copyright (c) 电信
 * @since 2022/10/6
 */
public class TempTest {

    @Test
    public void tempTest() throws Exception {

        List list = new LinkedList<>();
        Enumeration enumeration = NetworkInterface.getNetworkInterfaces();
        while (enumeration.hasMoreElements()) {
            NetworkInterface network = (NetworkInterface) enumeration.nextElement();
            if (network.isVirtual() || !network.isUp()) {
                continue;
            } else {
                Enumeration addresses = network.getInetAddresses();
                while (addresses.hasMoreElements()) {
                    InetAddress address = (InetAddress) addresses.nextElement();
                    if (address != null && (address instanceof Inet4Address || address instanceof Inet6Address)) {
                        list.add(address.getHostAddress());
                    }
                }
            }
        }

        for (Object o : list) {
            System.out.println("ip:" + o);
        }

        String hostAddress = InetAddress.getLocalHost().getHostAddress();
        System.out.println("hostAddress:" + hostAddress);


    }


}
