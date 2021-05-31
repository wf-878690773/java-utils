import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: wang feng
 * @create: 2021-05-31 18:49
 **/
public class RemoveListMapKey {

    public static void main(String[] args) {
        List<Map<String, String>> list = new ArrayList<>(16);
        Map<String, String> map1 = new HashMap<>(16);
        map1.put("code", "terminal");
        Map<String, String> map2 = new HashMap<>(16);
        map2.put("code", "terminal");
        list.add(map1);
        list.add(map2);
        //打印list里面的数据
        System.out.println(list);
        removeRepeatMapByKey(list, "code");
        System.out.println("=======去重前后分界线=======");
        System.out.println(list);

    }


    /**
     根据map中的某个key 去除List中重复的map
     @author  shijing
     @param list
     @param mapKey
     @return
     */
    public static List<Map<String, String>> removeRepeatMapByKey(List<Map<String, String>> list, String mapKey){
        //把list中的数据转换成msp,去掉同一id值多余数据，保留查找到第一个id值对应的数据
        List<Map<String, String>> listMap = new ArrayList<>();
        Map<String, Map> msp = new HashMap<>();
        for(int i = list.size()-1 ; i>=0; i--){
            Map map = list.get(i);
            String id = (String)map.get(mapKey);
            map.remove(mapKey);
            msp.put(id, map);
        }
        //把msp再转换成list,就会得到根据某一字段去掉重复的数据的List<Map>
        Set<String> mspKey = msp.keySet();
        for(String key: mspKey){
            Map newMap = msp.get(key);
            newMap.put(mapKey, key);
            listMap.add(newMap);
        }
        return listMap;
    }

}
