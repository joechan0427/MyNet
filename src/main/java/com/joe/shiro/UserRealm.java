package com.joe.shiro;

import com.joe.entity.ActiveUser;
import com.joe.entity.User;
import com.joe.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author joe
 * @date 2020-04-03 21:20
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * Shiro认证就是从这里获取数据的
     *
     * @param token
     * @return
     * @throws AuthenticationException
     */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        //得到用户名
        String userCode = (String) token.getPrincipal();


        //得到密码
        String password = new String((char[])token.getCredentials());


        User user = userService.validateUserExist(userCode);

        if (user == null) {
            return null;
        }

        //将数据存到用户的身份信息实体中
        ActiveUser activeUser = new ActiveUser();
        activeUser.setUserId(user.getUserId());
        activeUser.setUserEmail(user.getUserEmail());
        activeUser.setUserNickname(user.getUserNickname());
        activeUser.setUserPassword(password);


        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
                activeUser, user.getUserPassword(), ByteSource.Util.bytes(user.getSalt()), this.getName());
        return simpleAuthenticationInfo;
    }

    //清除缓存
    public void clearCached() {
        PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
        super.clearCache(principals);
    }
}
