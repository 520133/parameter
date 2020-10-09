package com.parameter.test;

import com.parameter.binding.DataBlock;
import com.parameter.binding.DbConfig;
import com.parameter.binding.DbSearcher;
import com.parameter.binding.Util;

import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author 杨森霖
 * @author 2020/8/5 0005 下午 16:05
 */
public class IPUtil {

    public static String getCityInfo(String ip){
        //db
        String dbPath = IPUtil.class.getResource("/static/ip2region.db").getPath();

        File file = new File(dbPath);
        if ( file.exists() == false ) {
            System.out.println("Error: Invalid ip2region.db file");
        }

        //查询算法
        int algorithm = DbSearcher.BTREE_ALGORITHM;
        try {
            DbConfig config = new DbConfig();
            DbSearcher searcher = new DbSearcher(config, dbPath);

            Method method = null;
            switch ( algorithm )
            {
                case DbSearcher.BTREE_ALGORITHM:
                    method = searcher.getClass().getMethod("btreeSearch", String.class);
                    break;
                case DbSearcher.BINARY_ALGORITHM:
                    method = searcher.getClass().getMethod("binarySearch", String.class);
                    break;
                case DbSearcher.MEMORY_ALGORITYM:
                    method = searcher.getClass().getMethod("memorySearch", String.class);
                    break;
            }

            DataBlock dataBlock = null;
            if ( Util.isIpAddress(ip) == false ) {
                System.out.println("Error: Invalid ip address");
            }

            dataBlock  = (DataBlock) method.invoke(searcher, ip);

            return dataBlock.getRegion();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) {
        testLambda();
    }

    public static int cmp(Comparator comparator, int i, int j) {
        return comparator.compare(i, j);
    }

    public static void testJava() {
        //传递一个对象
        int cmp = cmp(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 + o2;
            }
        }, 1, 2);
        System.out.println(cmp);
    }

    public static void testLambda() {
        int cmp = cmp((Comparator<Integer>)(o1,o2)->o1*o2,1,2);
        System.out.println(cmp);
    }

}

@FunctionalInterface
interface Consumer<T> {

    /**
     * @param t 输入参数
     */
    void accept(T t);

    //……
}

class ConsumerTest {

    public static void main(String[] args) {
        //一个初始化集合
        List<Integer> objects = new ArrayList<>();
        objects.add(1);
        objects.add(2);
        objects.add(3);

        //对集合数据进行  加1然后输出的操作
        consume(objects, i -> System.out.println(i + 1));
    }

    /**
     * 使用Consumer对集合元素进行操作的方法
     *
     * @param list     需要操作的集合
     * @param consumer 对元素的具体的操作，在调用的时候传递某个动作就行了
     */
    private static <T> void consume(List<T> list, Consumer<T> consumer) {
        for (T t : list) {
            consumer.accept(t);
        }
    }
}
