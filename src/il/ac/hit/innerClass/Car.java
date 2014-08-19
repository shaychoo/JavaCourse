package il.ac.hit.innerClass;

/**
 * Created by shay on 20/07/2014.
 */
public class Car {

    private String color;
    private String id;
    private Engine engine;
    private Wheel[] wheels;

    public Car(String color, String id) {
        this.color = color;
        this.id = id;


        this.wheels = new Wheel[4];
        this.wheels[0] = new Wheel("Front right");
        this.wheels[1] = new Wheel("Front left");
        this.wheels[2] = new Wheel("Back right");
        this.wheels[3] = new Wheel("Back left");
        this.engine = new Engine();
    }

    public Engine getEngine() {
        return engine;
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", id='" + id + '\'' +
                ", engine=" + engine.speed +
                '}';
    }

    class Engine {
        private int speed;

        Engine(int speed) {
            setSpeed(speed);
        }

        Engine() {

            setSpeed(0);
        }

        public int getSpeed() {
            return speed;
        }

        public void setSpeed(int speed) {

            try {
                if (speed < 0)
                    throw new ImposbilSpeedExeption("Speed can't be under 0KPH");

                if (speed > 120)
                    throw new ImposbilSpeedExeption("Too Fast!!");


                this.speed = speed;
                for (Wheel wheel : wheels) {
                    wheel.setSpeed(speed);
                }
            } catch (ImposbilSpeedExeption imposbilSpeedExeption) {
                imposbilSpeedExeption.printStackTrace();
            }


        }

        @Override
        public String toString() {
            return "Engine{" +
                    "speed=" + speed +
                    '}';
        }

        private class ImposbilSpeedExeption extends Throwable {
            private ImposbilSpeedExeption(String message) {
                super(message);
            }
        }
    }

    private class Wheel {
        private String side;
        private int speed;

        private Wheel(String side) {

            setSide(side);
        }

        public String getSide() {
            return side;
        }

        public void setSide(String side) {
            this.side = side;
        }

        public void setSpeed(int speed) {
            this.speed = speed;
        }

        @Override
        public String toString() {
            return "Wheel{" +
                    "side='" + side + '\'' +
                    ", speed=" + speed +
                    '}';
        }
    }
}
