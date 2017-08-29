package cx.service.impl;

import cx.dao.UserDaoI;
import cx.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017-8-25.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceI implements UserServiceI {

    @Autowired
    private UserDaoI userDaoI;

    public List<Map<String, Object>> getListUser(Object object) {
        return userDaoI.getListUser(object);
    }
}
