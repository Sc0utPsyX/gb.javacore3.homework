package lesson7;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;


public class MainStartClass {
    public static void main(String[] args) {
    start(TestClass2.class);
    start(TestClass3.class);
    try{
        start(TestClass.class);
    } catch (RuntimeException e){
        e.printStackTrace();
    }
    try{
        start(TestClass5.class);
    } catch (RuntimeException e){
        e.printStackTrace();
    }
    try{
        start(TestClass4.class);
    } catch (RuntimeException e){
        e.printStackTrace();
    }
    }

    public static void start(Class testClass) {
        if (!isOnlyCopy(testClass, BeforeSuite.class) || !isOnlyCopy(testClass, AfterSuite.class)) throw new RuntimeException();
        /*в условии написано "Методы с аннотациями @BeforeSuite и @AfterSuite должны присутствовать в единственном экземпляре,
         иначе необходимо бросить RuntimeException при запуске «тестирования»" однако, выше написано, что вначале нужно запускать
         метод @BeforeSuite "если таковой имеется". Поэтому реализовал последнее условие про присутствие в одном экземпляре.*/
        startAnnotations(testClass, BeforeSuite.class);
        startTestWithPriority(testClass, Test.class);
        startAnnotations(testClass, AfterSuite.class);
    }
    public static boolean isOnlyCopy(Class testClass, Class annotationClass){
        int count = 0;
        Method[] methods = testClass.getMethods();
        for (Method method : methods) {
            Annotation annotation = method.getAnnotation(annotationClass);
            if (annotation != null) {
                count++;
            }
        }
        return count != 0 && count <= 1;
    }

    public static void startAnnotations(Class testClass, Class annotationClass){
        Method[] methods = testClass.getMethods();
        for (Method method : methods) {
            if(method.isAnnotationPresent(annotationClass)){
                try {
                    method.invoke(testClass);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static void startTestWithPriority(Class testClass, Class<? extends Test> annotationClass){
        Method[] methods = testClass.getMethods();
        List<MethodList> methodList = new ArrayList<>();
        for (Method method : methods) {
            if(method.isAnnotationPresent(annotationClass)) {
                methodList.add(new MethodList(method.getAnnotation(annotationClass).priority(), method));
            }
        }
        Collections.sort(methodList, Comparator.comparingInt(MethodList::getPriority).reversed());
        for (MethodList method: methodList) {
            try {
                method.getMethod().invoke(testClass);
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
