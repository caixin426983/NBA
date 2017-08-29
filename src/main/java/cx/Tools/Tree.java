package cx.Tools;

import java.util.*;

/**
 * Created by Administrator on 2017-7-21.
 */
public class Tree {

    /**
     * 把数据转换成树的形式
     * @param pId
     * @param data
     * @return
     */
    public static List<Map>  turn2Tree(Integer pId,List<Map> data){
        List<Map> tree = new ArrayList<Map>();//定义一颗树
        Map node = null;//定义树的节点
        Iterator keys=null;//拿到节点所有的Key
        String key =null;
        if (data!=null && data.size()>0){
            //循环这颗树
            for (Map map: data) {
                if (pId == map.get("Pid_")){
                    //创建节点
                    node=new HashMap();
                    //拿到所有的map的key，返回一个迭代器
                    keys = map.keySet().iterator();
                    while (keys.hasNext()){
                        key= (String) keys.next();
                        node.put(key,map.get(key));
                        node.put("children",turn2Tree((Integer) map.get("id_"),data));
                    }
                    tree.add(node);
                }
            }
            return  tree;
        }
        return  null;
    }
}
