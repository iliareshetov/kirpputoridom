package com.example.hyperlearner.util;

import java.net.InetAddress;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class IdUtil {

    private IdUtil() {
    }

    // The last 5 char of the generated id
    private static String LOCAL_IP_23 = null;
    private static int[] SEQUENCE_NUMBER = new int[1];
    private static SimpleDateFormat FORMATTER = new SimpleDateFormat("yyMMddHHmmssSSS");

    /*
     ** Returns the last 2 IP address in hexadecimal.
     **
     ** @return a <code><b>String</b></code> value
     */
    public static String fetchLocalIP23() {
        if (LOCAL_IP_23 == null) {
            try {
                byte[] ips = InetAddress.getLocalHost().getAddress();
                int ip2 = (new Byte(ips[2])).intValue();
                ip2 = ip2 < 0 ? 0x100 + ip2 : ip2;
// CR 33417               String cip2 = ip2 > 0xf ? Integer.toHexString(ip2) : "0" + Integer.toHexString(ip2);
                String cip2 = Integer.toHexString(ip2 & 0x0F); // CR 33417
                int ip3 = (new Byte(ips[3])).intValue();
                ip3 = ip3 < 0 ? 0x100 + ip3 : ip3;
                String cip3 = ip3 > 0xf ? Integer.toHexString(ip3) : "0" + Integer.toHexString(ip3);
                LOCAL_IP_23 = cip2 + cip3;
            } catch (Exception e) {
                LOCAL_IP_23 = "000";
            }
        }
        return LOCAL_IP_23;
    }

    /*
     ** Returns the timestamp in YYMMDDhhmmssnnn
     **
     ** @return a <code><b>String</b></code> value
     */
    public static String fetchGMTTimestamp() {
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        return IdUtil.FORMATTER.format(ts);
    }

    private static String fetchSequence() {
        int seqNo = 0;
        synchronized (SEQUENCE_NUMBER) {
            seqNo = (SEQUENCE_NUMBER[0] + 1) % 100000;
            SEQUENCE_NUMBER[0] = seqNo;
        }
        if (seqNo < 10) {
            return "0000" + seqNo;
        } else if (seqNo < 100) {
            return "000" + seqNo;
        } else if (seqNo < 1000) {
            return "00" + seqNo;
        } else if (seqNo < 10000) {
            return "0" + seqNo;
        } else {
            return "" + seqNo;
        }
    }

    /*
     ** Returns the complete ID of the form: iiiiYYMMDDhhmmssnnnrrrrr
     **
     ** @return a <code><b>String</b></code> value
     */
    public static String generateId() {
// CR 33417        return (fetchLocalIP23() + fetchGMTTimestamp() + fetchSequence());
        return ("z" + fetchGMTTimestamp() + fetchSequence() + fetchLocalIP23());
    }

    public static void _removed_main (String[] args) {
        int a = Integer.parseInt(args[0]);
        long beg = System.currentTimeMillis();
        for (int i = 0; i < a; i++) {
            //generateId();
        }
        long total = System.currentTimeMillis() - beg;
    }
}
