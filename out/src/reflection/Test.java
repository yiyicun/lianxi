package reflection;



import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/*
*  反射读取对象属性,递归调用
*  BodyMsg 属性含LIST,支持多层嵌套
* */
public class Test {

    public void checkBodyMsg(BodyMsg bodyMsg) throws IntrospectionException, InvocationTargetException, IllegalAccessException {

        Class<? extends BodyMsg> cls = bodyMsg.getClass();
        Field[] fields = cls.getDeclaredFields();
        checkField(bodyMsg,cls,fields);

    }

    public void checkField(Object obj,Class<?> cls,Field[] fields) throws IntrospectionException, InvocationTargetException, IllegalAccessException {

        for (Field f : fields) {
            //属性为LIST
            if(f.getType().isAssignableFrom(List.class)) {
                PropertyDescriptor pd = new PropertyDescriptor(f.getName(),cls);
                Method method = pd.getReadMethod();
                Object o = method.invoke(obj);
                //遍历LIST
                if( o!=null){
                    Type type = f.getGenericType();
                    if( type instanceof ParameterizedType){
                        ParameterizedType pt = (ParameterizedType) type;
                        Class<?> listClz = (Class)pt.getActualTypeArguments()[0];
                        List<?> tarList = objCastList(o,listClz);
                        for (Object t : tarList) {
                            Class<?> rClass = t.getClass();
                            Field[] rFields = rClass.getDeclaredFields();
                            checkField(t,rClass,rFields);
                        }
                    }
                }
            //普通属性
            } else {
                PropertyDescriptor pd = new PropertyDescriptor(f.getName(),cls);
                Method method = pd.getReadMethod();
                Object o = method.invoke(obj);
                System.out.println(f.getName()+" : "+o);
            }


        }

    }

    //转换LIST
    private <R> List<R> objCastList(Object obj, Class<R> clazz) {
        List<R> list = new ArrayList<>();
        if(obj instanceof  List<?>){
            for(Object o : (List<?>)obj){
                list.add(clazz.cast(o));
            }
        }
        return list;
    }

    public static void main(String[] args) throws IllegalAccessException, IntrospectionException, InvocationTargetException {

        Test test = new Test();

        BodyMsg bodyMsg =new BodyMsg();
        bodyMsg.setBankNo("109");
        bodyMsg.setCusNo("1234567");
        bodyMsg.setUuid("0000000000111");
        bodyMsg.setLifeIndex(1);
        bodyMsg.setStartDate(new Date());

        List<SubMsg> subMsgList = new ArrayList<>();
        SubMsg subMsg = new SubMsg();
        subMsg.setSubMsgNo("123596");
        subMsg.setSubStartDate(new Date());
        subMsg.setUuid("0000000000111");
        subMsgList.add(subMsg);
        bodyMsg.setSubMsgList(subMsgList);

        test.checkBodyMsg(bodyMsg);

    }
}
