package cx.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017-8-25.
 */
@Service
public interface UserServiceI {


    /**
     *查询球员
     * @return
     */
    List<Map<String,Object>> getListUser(Object object);
}
