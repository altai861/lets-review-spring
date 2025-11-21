package com.example.letsreviewserver.util;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

public class CookieUtil {
    private CookieUtil() {

    }

    public static void addHttpOnlyCookie(
            HttpServletResponse response,
            String name,
            String value,
            int maxAgeInSeconds
    ) {
        Cookie cookie = new Cookie(name, value);
        cookie.setHttpOnly(true);

        // Set to true on prod HTTPS, false is for HTTP
        cookie.setSecure(false);

        cookie.setAttribute("SameSite", "Strict");

        cookie.setMaxAge(maxAgeInSeconds);
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    public static void deleteCookie(HttpServletResponse response, String name) {
        Cookie cookie = new Cookie(name, null);
        cookie.setHttpOnly(true);

        // Set to true on prod HTTPS, false is for HTTP
        cookie.setSecure(false);

        cookie.setAttribute("SameSite", "Strict");
        cookie.setMaxAge(0);
        cookie.setPath("/");
        response.addCookie(cookie);
    }
}
