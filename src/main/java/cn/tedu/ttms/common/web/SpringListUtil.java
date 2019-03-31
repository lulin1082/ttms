package cn.tedu.ttms.common.web;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Transformer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: lulin
 * @Date: 3/25/2019 2:47 AM
 * @Version 1.0
 */
public class SpringListUtil {

    public static List<Integer> parseIntegerList(String strList, List<Integer> listInt){
        List<String> listStr = Arrays.asList(strList.split(","));
        listInt =new ArrayList<Integer>(listStr.size());
        CollectionUtils.collect(listStr,
                new Transformer(){
                    public java.lang.Object transform(java.lang.Object input){
                        return Integer.parseInt((String)input);
                    }
                } ,listInt );
        return listInt;
    }
}
