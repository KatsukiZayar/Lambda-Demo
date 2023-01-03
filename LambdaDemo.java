package Lambda.June21;

import java.util.Arrays;
import java.util.Comparator;

public class LambdaDemo {
    
    interface Calculate{ // Functional Interface
        int calculate(int x,int y);
    }

    public static class Addition implements Calculate{
        @Override
        public int calculate(int x, int y) {
            return x + y;
        }
    }

    public static void main(String[] args) {
        Calculate c = new Addition();
        int r = c.calculate(10, 4);
        System.out.println(r);

        Calculate subtraction = new Calculate() {
            @Override
            public int calculate(int x, int y) {
                return x - y;
            }
        };

        System.out.println(subtraction.calculate(10, 4));

        Calculate multiply =  (int x, int y) -> {
                return x * y;
        };
        System.out.println(multiply.calculate(10, 4));

        Calculate division = (x, y) -> x/y;
        System.out.println(division.calculate(10, 4));

        Comparator<Car> nameComparator = (o1, o2) -> {
            int t1 = o1.capcity,t2 = o2.capcity;
            if (t1 == t2) {
                return 0;
            } else if(t1 > t2){
                return 1;                
            }else{
                return -1;
            }
        };
        Car list[] = {
            new Car("C", 10),
            new Car("A", 5) ,
            new Car("D", 1)
        };

        Arrays.sort(list,nameComparator);
        for (Car car : list) {
            System.out.println(car);
        }

    }

    public static class Car{
        public String name;
        public int capcity;
        public Car(String name, int capcity){
            this.name = name;
            this.capcity = capcity;
        }
        @Override
        public String toString() {
            return String.format("Car(%s ,%d)", name,capcity);
        }
    }
}
