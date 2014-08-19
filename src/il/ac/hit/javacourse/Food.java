package il.ac.hit.javacourse;

/**
 * Created by shay on 13/07/2014.
 */
class Food implements Comparable {
    private long calories;

    public Food() {
    }


    Food(long cal) {
        calories = cal;
    }

    long getCalories() {
        return calories;
    }

    public void setCalories(long calories) {
        this.calories = calories;
    }

    public int compareTo(Object other) {
        if (this.getCalories() > ((Food) other).getCalories())
            return 1;
        else if (this.getCalories() < ((Food) other).getCalories())
            return -1;
        else
            return 0;


    }

    public String toString() {
        return "calories =" + calories;
    }
}

class Pizza extends Food {

    Pizza() {
        super(200);
    }
}

class Humborger extends Food {

    Humborger() {
        super(300);
    }
}

class Falafel extends Food {

    Falafel() {
        super(500);
    }
}