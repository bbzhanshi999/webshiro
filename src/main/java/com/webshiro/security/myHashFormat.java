package com.webshiro.security;

import org.apache.shiro.crypto.hash.Hash;
import org.apache.shiro.crypto.hash.format.ParsableHashFormat;

/**
 * Created by Administrator on 2016/2/11 0011.
 */
public class myHashFormat implements org.apache.shiro.crypto.hash.format.ParsableHashFormat {
    public Hash parse(String s) {
        return null;
    }

    public String format(Hash hash) {
        return null;
    }
}
