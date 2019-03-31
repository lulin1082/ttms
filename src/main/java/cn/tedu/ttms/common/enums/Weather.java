package cn.tedu.ttms.common.enums;

/**
 * @Author: lulin
 * @Date: 3/16/2019 1:21 PM
 * @Version 1.0
 */
public enum Weather {
    YES(1),
        N0(0);

    private  int value;

    Weather(int value){
        this.value=value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
