package com.nanshan.springbootsql2o.infra.utils;

import io.github.novacrypto.base58.Base58;

import java.security.SecureRandom;

public class Utils {

    private static final SecureRandom RANDOM = new SecureRandom();

    /**
     * 生成 7 位的 Base58 編碼
     */
    public static String getBase58Code() {
        byte[] randomBytes = new byte[16];
        RANDOM.nextBytes(randomBytes);
        return Base58.base58Encode(randomBytes).substring(0, 7);
    }

}
