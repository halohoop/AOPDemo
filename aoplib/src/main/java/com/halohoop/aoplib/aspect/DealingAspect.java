package com.halohoop.aoplib.aspect;

import android.util.Log;

import com.halohoop.aoplib.annotation.DealingTrace;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * Created by Pooholah on 2017/3/29.
 */

@Aspect//标记这个是切面，切下来的蛋糕
public class DealingAspect {
    private static final String POINTCUT_METHOD =
            "execution(@com.halohoop.aoplib.annotation.DealingTrace * *(..))";

    private static final String POINTCUT_CONSTRUCTOR =
            "execution(@com.halohoop.aoplib.annotation.DealingTrace *.new(..))";
    private static final String TAG = "Halohoop";

    @Pointcut(POINTCUT_METHOD)//切点
    public void behavior1() {

    }

    //和上面的关联
    @Around("behavior1()")//处理，此处的方法名字自定义，参数和返回值Object规定。
    public Object dealMethod1(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        //获取切下部分逻辑所在类名
        String className = methodSignature.getDeclaringType().getSimpleName();
        //获取切下部分逻辑的方法名
        String methodName = methodSignature.getName();

        long start = System.currentTimeMillis();
//        Log.i(TAG, "dealMethod1: className:" + className);
//        Log.i(TAG, "dealMethod1: methodName:" + methodName);

        DealingTrace annotation = methodSignature.getMethod().getAnnotation(DealingTrace.class);
        int type1 = annotation.type1();
        int type2 = annotation.type2();
        String value1 = annotation.value1();
        String value2 = annotation.value2();

//        Log.i(TAG, "dealMethod1 type1: " + type1);
//        Log.i(TAG, "dealMethod1 type2: " + type2);

        //原来切下来的逻辑在这句执行
        Object result = joinPoint.proceed();//throws Throwable

//        Log.i(TAG, "dealMethod1 value1: " + value1);
//        Log.i(TAG, "dealMethod1 value2: " + value2);
        long elapse = System.currentTimeMillis() - start;
        Log.i(TAG, "dealMethod1: 耗时 ：" + elapse + "ms");
        return result;
    }
}
