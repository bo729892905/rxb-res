package com.rxb.res.interceptor.shiro;

import com.rxb.res.entity.User;
import com.rxb.res.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

public class MonitorRealm extends AuthorizingRealm {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Resource
	private UserService userService;

	/**
	 * 重写授权方法
	 * @param p
	 * @return
     */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection p) {
		logger.info("doGetAuthorizationInfo....principals: "+p.toString());

		Set<String> roleNameSet = new HashSet<String>();
		Set<String> permissionSet = new HashSet<String>();
		permissionSet.add("test.do");

		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roleNameSet);
		info.setStringPermissions(permissionSet);

		return info;
	}

	/**
	 * 重写认证方法
	 * @param token
	 * @return
	 * @throws AuthenticationException
     */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		logger.info("doGetAuthenticationInfo...token: "+token.toString());

		String username=(String) token.getPrincipal();
		User user = userService.getUserByUsername(username);
		if (user == null) {
			throw new AuthenticationException();
		}

		return new SimpleAuthenticationInfo(username, user.getPassword(), getName());
	}

}
