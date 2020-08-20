package com.parameter.util;

import com.ej.common.model.RequestDataPackage;
;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

/**
 * ParcelDataPackage
 *
 * @author linapex
 */
public class ParcelDataPackage extends RequestDataPackage {

    private static Map<String, Locale> localeMap = new HashMap<>();

    private String security;
    private String device;
    private String os;
    private String text;
    private String loc;
    private String identity;

    static {
        Locale chinese = Locale.SIMPLIFIED_CHINESE;
        Locale english = Locale.ENGLISH;
        localeMap.put("chinese", chinese);
        localeMap.put("english", english);
    }

//    public int getUserId() {
//        return getUser().getId();
//    }
//
//    public User getUser() {
//        return SSO.getUserByCache(getToken());
//    }

    public boolean isLogin() {
        String token = getToken();
        if (StringUtils.isBlank(getToken())) {
            return false;
        }
        return true;
    }

    public String getSecurity() {
        return security;
    }

    public void setSecurity(String security) {
        this.security = security;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    @Override
    public String getOs() {
        if (Objects.nonNull(os)) {
            return os;
        }
        if (Objects.nonNull(getGlobal())) {
            return super.getOs();
        }
        return null;
    }

    public String getIdentity() {
        if (Objects.nonNull(identity)) {
            return identity;
        }
        if (Objects.nonNull(getGlobal())) {
            return getGlobal("identity");
        }
        return identity;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public Locale getLocale() {
        return localeMap.getOrDefault(loc, Locale.SIMPLIFIED_CHINESE);
    }
}
