package com.rxb.res.filter;

import org.apache.shiro.web.filter.authz.PermissionsAuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 自定义权限过滤器：url过滤器
 * Created by rxb on 2016/1/27.
 */
public class URLPermissionsFilter extends PermissionsAuthorizationFilter {

    @Override
    public boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws IOException {
        return super.isAccessAllowed(request,response,buildPermissions(request));
    }

    private String[] buildPermissions(ServletRequest request) {
        String[] perms=new String[1];
        HttpServletRequest req=(HttpServletRequest) request;
        perms[0]=req.getServletPath().split("/")[1];
        return perms;
    }
}
