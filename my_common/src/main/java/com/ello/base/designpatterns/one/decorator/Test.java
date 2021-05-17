package com.ello.base.designpatterns.one.decorator;

import java.io.File;

/**
 * @author longchenggong
 * @Description:
 * @date 2021/3/2910:20
 */
public class Test {

    public static void main(String[] args) {
        String path = System.getProperty("user.dir") + File.separator + "init/OutPutDemo.text";
        System.out.println();
        String salaryRecords = "Name,Salary\\nJohn Smith,100000\\nSteven Jobs,912000";
        DataSourceDecorator encoded = new CompressionDecorator(
                                            new EncryptionDecorator(
                                                    new FileDataSource(path)));
        encoded.writeData(salaryRecords);


        DataSource plain=new EncryptionDecorator(
                new FileDataSource(path));
        System.out.println(plain.readData());

    }


}
