package Reflection;
//import InnerClass.InnerClassTest;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.*;


public class ReflectionTest  {
    public static void main(String[] args) {

        String name = "";

        if(args.length > 0) {
            name = args[0];
        }else{
            System.out.println("Usage: Enter class Name");
            System.exit(0);
        }



        try {
            Class cl = Class.forName(name);
            Class supercl = cl.getSuperclass();
            //Class cl = test.getClass();
            //Class supercl = cl.getSuperclass();
            if(supercl != null && supercl != Object.class)  {
                System.out.println(cl.getName() + " extends " + supercl.getName() + '{' );

            }
            else{
                System.out.println(cl.getName() + '{');
            }
            System.out.println("Constructors : ");
            printConstructor(cl);
            System.out.println("Fields : ") ;
            printFields(cl);
            System.out.println("Methods : ") ;
            printMethod(cl);
            System.out.println("}");

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void printConstructor(Class cl){
    Constructor[] constructors = cl.getDeclaredConstructors();

    for(Constructor constructor : constructors){
       String nameConstructor = constructor.getName();
       System.out.print(nameConstructor + '(');
       Class[] paramTypes = constructor.getParameterTypes();
       for(int i = 0 ; i < paramTypes.length ; i++){
           Class param = paramTypes[i] ;
           String nameParam = param.getName();
           if(i != paramTypes.length - 1)System.out.print(nameParam + ",");
           else System.out.print(nameParam);
       }
       System.out.print(')');
       System.out.println();
    }
    }
    public static void printMethod(Class cl){
        Method[] methods = cl.getDeclaredMethods();
        for(Method method : methods) {
            String accessModifier = Modifier.toString(method.getModifiers()) ;
            String nameMethod = method.getName();
            String returnType = method.getReturnType().getName();
            System.out.print(accessModifier + " " + returnType + " " + nameMethod + '(');
            Class[] paramTypes = method.getParameterTypes();
            for(int i = 0 ; i < paramTypes.length ; i++){
                Class param = paramTypes[i] ;
                String nameParam = param.getName();
                if(i != paramTypes.length - 1)System.out.print(nameParam + ",");
                else System.out.print(nameParam);
            }
            System.out.print(')');
            System.out.println();
        }
    }
    public static void printFields(Class cl){
        Field[] fields = cl.getDeclaredFields();
        for(Field field : fields){
            String name = field.getName();
            String type = field.getType().getName();
            String accessModifier = Modifier.toString(field.getModifiers()) ;
            System.out.print(accessModifier + " " + type + " " + name );
            System.out.println();
        }

    }
}


