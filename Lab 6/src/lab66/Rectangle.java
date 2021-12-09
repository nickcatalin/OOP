package lab66;

public class Rectangle extends Shape{

    private double width,length;
    public Rectangle()
    {   super();
        this.width = 1;
        this.length = 2;
    }
    public Rectangle(double width, double length)
    { super();
        this.width = width;
        this.length = length;
    }
    public Rectangle(double width, double length, String color, boolean filled)
    {
        super(color,filled);
        this.length=length;
        this.width = width;

    }
    public double getWidth()
    {
        return this.width;
    }
    public void setWidth(double width)
    {
        this.width = width;
    }
    public double getLength()
    {
        return this.length;
    }
    public void setLength(double length)
    {
        this.length = length;
    }

    @Override
    public double getArea() {
        return this.width*this.length;
    }

    @Override
    public double getPerimeter() {
        return 2*this.length+2*this.width;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", length=" + length +
                '}';
    }
}
