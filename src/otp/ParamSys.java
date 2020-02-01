package otp;

import java.security.SecureRandom;
import java.util.Properties;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

/**
 * @author JLDM
 */
public class ParamSys {

    private String ParamSys = null;
    private String idSistema = null;
    private String idUsrname = null;
    private String idTimer = null;
    private String idRandom = null;
    public static String newline = System.getProperty("line.separator");

    /**
     * @return the ParamSys value
     */
    public String getParamSys() {
        ParamSys = getidSistema();
        ParamSys += getidUsrname();
        ParamSys += getidTimer();
        ParamSys += getidRandom();
        return ParamSys;
    }

    /**
     * @return the idSistema
     */
    public String getidSistema() {
        Properties PropieSys = System.getProperties();
        idSistema = PropieSys.getProperty("java.version");
        return idSistema;
    }

    /**
     * @return the idUsrname
     */
    public String getidUsrname() {
        Properties PropieSys = System.getProperties();
        idUsrname = PropieSys.getProperty("user.name");
        return idUsrname;
    }

    /**
     * @return the idTimer
     */
    public String getidTimer() {
        Long IdTimerLong;
        IdTimerLong = System.nanoTime();
        idTimer = IdTimerLong.toString();
        IdTimerLong = null;
        return idTimer;
    }

    /**
     * @return the idRandom
     */
    public String getidRandom() {
        Long IdRandomLong;
        SecureRandom IdRandomRnd = new SecureRandom();
        IdRandomLong = IdRandomRnd.nextLong();
        idRandom = IdRandomLong.toString();
        return idRandom;
    }
}
