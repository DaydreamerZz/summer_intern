package designpattern.factory;

public class ShapeFactory {
    public Shape getShape(String shapeType){
        if(shapeType == null)
            return null;
        if("designpattern.factory.Circle".equalsIgnoreCase(shapeType))
            return new Circle();
        else if("designpattern.factory.Square".equalsIgnoreCase(shapeType))
            return new Square();
        return null;
    }

    public Object getClass(Class<?extends Shape> clazz){
        Object obj = null;

        try{
            obj = Class.forName(clazz.getName()).newInstance();
        }catch (Exception e){
            e.printStackTrace();
        }
        return obj;
    }

    public <T> T getClass2(Class<?extends Shape> clazz){
        T obj = null;

        try{
            obj = (T) Class.forName(clazz.getName()).newInstance();
        }catch (Exception e){
            e.printStackTrace();
        }
        return obj;
    }
}
