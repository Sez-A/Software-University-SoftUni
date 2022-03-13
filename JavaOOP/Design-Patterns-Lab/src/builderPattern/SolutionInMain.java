//package builderPattern;
//
//public class SolutionInMain {
//    import builderPattern.Car;
//
//    public class Main {
//        public static void main(String[] args) {
//
//            // TODO: 24.8.2021 г. Here we have car which had make Mercedes-Benz, color is red and etc.
//            Car car = Car.build()
//                    .make("Mercedes-Benz")
//                    .color("Red")
//                    .horsePower("500")
//                    .numberOfDoors("2")
//                    .buildCar();
//
//        /* TODO: 24.8.2021 г. We change car make using builder pattern and we have the same with different make
//        /  */
//            car = Car.build(car)
//                    .make("BMW")
//                    .buildCar();
//
//            System.out.println(car);
//        }
//    }
//
//}
