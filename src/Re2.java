import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

public class Re2 {
    public static void main(String[] args) throws Exception {
        char yy = '\u5cb3';
        System.out.println(yy);

        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\re.properties"));
        String classfullpath = properties.get("classfullpath").toString();
        String methodName = properties.get("method").toString();
        System.out.println("classfullpath: " + classfullpath);
        System.out.println("methodName: " + methodName);

        Class<?> aClass = Class.forName(classfullpath);
        Object o = aClass.newInstance();
        System.out.println("o.getClass(): " + o.getClass());
        Method method = aClass.getMethod(methodName);
        method.invoke(o);

        Field age = aClass.getField("age");
        System.out.println(age.get(o));

        Constructor<?> constructor = aClass.getConstructor();
        System.out.println(constructor);

        Constructor<?> constructor1 = aClass.getConstructor(String.class);
        System.out.println(constructor1);


    }
}