package cx.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017-8-25.
 */
@Repository
public interface UserDaoI {

    /**
     *查询球员
     * @return
     */
    List<Map<String,Object>> getListUser(Object object);

}
