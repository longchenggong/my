package com.ello.base.gc;

import com.ello.entity.Car;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author longchenggong
 * @Description:
 * @date 2021/3/817:27
 */
public class OOMTest {

    public static void main(String[] args) {

//        元空间内存溢出(); //    -XX:MetaspaceSize=10m -XX:MaxMetaspaceSize=10m

//        栈空间内存溢出();


        堆内存溢出(); //-Xms10m -Xmx10m
    }

    static void 堆内存溢出(){
        long counter=0;
        List<Object> list=new ArrayList<>();
        while (true){
            list.add(new Object());
            System.out.println("当前创建了第"+(++counter)+"个对象");
        }
    }
    static void 元空间内存溢出(){
        long counter=0;
        while (true){
            System.out.println("目前创建了"+(++counter)+"个Car类的子类");
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(Car.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                    if (method.getName().equals("run")){
                        System.out.println("启动汽车之前，先进行自动的安全检查...");
                        return methodProxy.invokeSuper(o,objects);
                    }else {
                        return methodProxy.invokeSuper(o,objects);

                    }
                }
            });

            Car car= (Car) enhancer.create();
            car.run();
        }
    }
    static long counter=0;

    static void 栈空间内存溢出(){
        System.out.println("目前是第"+(++counter)+"次调用方法");
        栈空间内存溢出();
    }
    static class Car {
        public void run(){
            System.out.println("汽车在启动，开始行使...");
        }
    }
}
