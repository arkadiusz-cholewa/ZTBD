package com.ztbd.security;

public class SecurityConstants {
    static final String SECRET = "F78922662633DBC81D76056276DD7EC1EBF0734599833A7D0B0CE8E4F6C8306E";
    static final String TOKEN_PREFIX = "Bearer ";
    static final String HEADER_STRING = "Authorization";
    static final String SIGN_UP_URL = "/users/sign-up";
    static final long EXPIRATION_TIME = 86400000L;
}
