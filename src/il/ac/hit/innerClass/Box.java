package il.ac.hit.innerClass;

/**
 * Created by shay on 20/07/2014.
 */
public class Box {
    Fly fly;
    private int xSize;
    private int ySize;
    private int zSize;

    public Box(int xSize, int ySize, int zSize) {
        this.xSize = xSize;
        this.ySize = ySize;
        this.zSize = zSize;
        fly = new Fly(1, 1, 1);


    }

    @Override
    public String toString() {
        return "Box{" +
                "fly=" + fly +
                ", xSize=" + xSize +
                ", ySize=" + ySize +
                ", zSize=" + zSize +
                '}';
    }

    class Fly {
        private int x, y, z;

        Fly(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public void setX(int x) {
            if (x < xSize && x > 0)
                this.x = x;
        }

        public void setY(int y) {
            if (y < ySize && y > 0)
                this.y = y;
        }

        public void setZ(int z) {
            if (z < zSize && z > 0)
                this.z = z;
        }

        @Override
        public String toString() {
            return "Fly{" +
                    "x=" + x +
                    ", y=" + y +
                    ", z=" + z +
                    '}';
        }
    }
}
