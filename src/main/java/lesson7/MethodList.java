package lesson7;

import java.lang.reflect.Method;

public class MethodList{
    Integer priority;
    Method method;

    public int getPriority() {
        return priority;
    }

    public Method getMethod() {
        return method;
    }

    public MethodList(int priority, Method method) {
        this.priority = priority;
        this.method = method;
    }
}





