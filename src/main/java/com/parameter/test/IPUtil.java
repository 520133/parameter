package com.parameter.test;

import com.parameter.binding.DataBlock;
import com.parameter.binding.DbConfig;
import com.parameter.binding.DbSearcher;
import com.parameter.binding.Util;

import java.io.File;
import java.lang.reflect.Method;

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
        System.out.println(getCityInfo("223.104.215.170"));
        String[] split = getCityInfo("223.104.215.170").split("\\|");
        System.out.println(split[2]);
        System.out.println(split[3]);
    }

}
