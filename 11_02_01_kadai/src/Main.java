//メモ↓クラスはメイン
public class Main {
    /**
     * 
     * @param args
     */
    public static void main(String[] args) {

        
        //メモ↓Triangleインスタンスを生成
        //　　　triangleは変数で、名前はなんでもいい
    	//　　　インスタンスにTriangleに値を入れる
        Triangle triangle = new Triangle(0, 0, 100, 100, 0, 200);
        
        //メモ↓Rectangleインスタンスを生成
        //　　　rectangleは変数で、名前はなんでもいい
    	//　　　インスタンスにRectangleに値を入れる
        Rectangle rectangle = new Rectangle(0, 0, 100, 50);
        
        //メモ↓Circleインスタンスを生成
        //　　　circleは変数で、名前はなんでもいい
    	//　　　インスタンスにCircleに値を入れる
        Circle circle = new Circle(100, 100, 20);
        
        //メモ↓Lineインスタンスを生成
        //　　　lineは変数で、名前はなんでもいい
    	//　　　インスタンスにLineに値を入れる
        Line line = new Line(0, 0, 100, 100);
        
        //メモ↓Squareインスタンスを生成
        //　　　squareは変数で、名前はなんでもいい
    	//　　　インスタンスにSquareに値を入れる
        Square square = new Square(0, 0, 200);

        // メモ↓それぞれの図形
        triangle.draw();
        rectangle.draw();
        circle.draw();
        line.draw();
        square.draw();

        //メモ↓System.out.printlnで表示
        //　　　各図形の長さ
        System.out.println(triangle.getPerimeter());
        System.out.println(rectangle.getPerimeter());
        System.out.println(circle.getPerimeter());
        System.out.println(line.getPerimeter());
        System.out.println(square.getPerimeter());

        //メモ↓System.out.printlnで表示
        //　　　内角の和の計算
        System.out.println(triangle.getInternalAngle());
        System.out.println(rectangle.getInternalAngle());
        System.out.println(square.getInternalAngle());
    }
}