package com.imedia.oracle.dao;

import com.imedia.service.user.model.UserInfoRes;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Service
public class UsersDAO {
    static final Logger logger = LogManager.getLogger(UsersDAO.class);
    private final EntityManager entityManager;

    @Autowired
    public UsersDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public UserInfoRes getUserInfo(String username) {
        UserInfoRes userInfoRes = null;
        String sql = "SELECT b.*, (SELECT ID FROM STORAGES s WHERE b.GROUPID = s.GROUP_ID AND s.STATUS = 1) warehouseId, "
                + "( SELECT NAME FROM STORAGES s WHERE b.GROUPID = s.GROUP_ID AND s.STATUS = 1 ) warehouseName "
                + "FROM "
                + "	(SELECT "
                + "		a.*, "
                + "		gs.CODE ROLE "
                + "	FROM "
                + "		("
                + "		SELECT "
                + "			u.ID AS id, "
                + "			u.NAME AS name, "
                + "			u.EMAIL AS email, "
                + "			u.PHONE AS phone, "
                + "			u.USERNAME AS username, "
                + "			u.PASSWORD_MD5 AS passwordMd5, "
                + "			u.IS_SUPER_ADMIN AS isSuperAdmin, "
                + "			u.STATUS AS status, "
                + "			u.SALT AS salt, "
                + "			u.IS_LOGIN_FIRST_TIME AS isLoginFirstTime, "
                + "			g.GROUP_ID AS groupId "
                + "		FROM "
                + "			USERS u, "
                + "			USER_GROUPS_HOLA g "
                + "		WHERE "
                + "			u.ID = g.USER_ID "
                + "			AND u.STATUS = 1 "
                + "			AND u.USERNAME = '" + username + "' "
                + "		) a "
                + "		LEFT JOIN GROUPS gs ON gs.ID = a.GROUPID "
                + "	WHERE gs.STATUS = 1) b";
        Query query = entityManager.createNativeQuery(sql, "UserInfoResMapping");
        List<UserInfoRes> res = query.getResultList();
        if (!res.isEmpty()) {
            userInfoRes = res.get(0);
        }
        return userInfoRes;
    }

}
