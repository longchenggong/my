package com.ello.base.designpatterns.one.decorator;

import java.util.Base64;

/**
 * @author longchenggong
 * @Description: 加密装饰
 * @date 2021/3/2910:13
 */
public class EncryptionDecorator extends DataSourceDecorator{
    public EncryptionDecorator(DataSource wrapper) {
        super(wrapper);
    }

    @Override
    public void writeData(String data) {
        super.writeData(encode(data));
    }


    @Override
    public String readData() {
        return decode(super.readData());
    }



    private String encode(String data) {
        byte[] result=data.getBytes();
        for (int i = 0; i < result.length; i++) {
            result[i]+=(byte) 1;
        }
        return Base64.getEncoder().encodeToString(result);
    }

    private String decode(String date) {
        byte[] result=Base64.getDecoder().decode(date);
        for (int i = 0; i <result.length ; i++) {
            result[i]-=(byte)1;
        }
        return new String(result);
    }
}
