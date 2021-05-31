import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: wang feng
 * @create: 2021-05-31 18:49
 **/
public class RemoveListMapKeyValue {

    public static void main(String[] args) {
        List<Map<String, String>> list = new ArrayList<>(16);
        Map<String, String> map1 = new HashMap<>(16);
        map1.put("code", "terminal");
        map1.put("value", "val1");
        Map<String, String> map2 = new HashMap<>(16);
        map2.put("code", "terminal");
        map2.put("value", "val2");
        list.add(map1);
        list.add(map2);
        //打印list里面的数据
        System.out.println(list);

        ArrayList<Map<String, String>> data = list.stream().collect(
                Collectors.collectingAndThen(Collectors.toCollection(
                        () -> new TreeSet<>(Comparator.comparing(m -> m.get("code")))), ArrayList::new));
        System.out.println("=======去重前后分界线=======");
        //打印过滤后的数据
        System.out.println(data);


    }

}
