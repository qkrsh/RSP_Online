package com.networkH2021.gachon;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class MyCharacter extends Person{
    private int port = 10001;
    private InetAddress ipAddress;
    private String lastLog;
    public MyCharacter(String name, String id, char[] password, String email, int score) throws UnknownHostException {
        super(name, id, password, email, score);
        setIpAddress(InetAddress.getLocalHost());//테스트로 로컬로 설정함
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public InetAddress getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(InetAddress ipAddress) {
        this.ipAddress = ipAddress;
    }
}
