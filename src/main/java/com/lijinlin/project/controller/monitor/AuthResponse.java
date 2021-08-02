package com.lijinlin.project.controller.monitor;

/**
 * @author lijinlin
 * @date2021年05月14日 14:17
 */
public class AuthResponse {
    /**
     * 访问令牌
     */
    private String Access_token;
    /**
     * 令牌类型
     */
    private String token_type;
    /**
     * 过期时间（秒）
     */
    private Long expires_in;
    /**
     * 权限范围
     */
    private String scope;

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public Long getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(Long expires_in) {
        this.expires_in = expires_in;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public void setAccess_token(String access_token) {
        Access_token = access_token;
    }

    public String getAccess_token() {
        return Access_token;
    }
}
