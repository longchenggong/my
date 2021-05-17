package com.ello.base.designpatterns.one.decorator;

import java.io.*;

/**
 * @author longchenggong
 * @Description:
 * @date 2021/3/299:59
 */
public class FileDataSource implements DataSource {
    private String name;

    public FileDataSource(String name) {
        this.name = name;
    }

    public void writeData(String data) {
        File file=new File(name);
        try(OutputStream outputStream= new FileOutputStream(file)){
            outputStream.write(data.getBytes(), 0, data.length());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readData() {
        char[] buffer=null;
        File file=new File(name);
        try(FileReader fileReader = new FileReader(file)){
           buffer=new char[(int) file.length()];
           fileReader.read(buffer);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String(buffer);
    }
}
