package il.ac.hit.innerClass;

/**
 * Created by shay on 21/07/2014.
 */
public class HumanBody {

    public Leg[] legs;
    public Hand[] hands;
    public Brain brain;

    public HumanBody() {
        legs = new Leg[2];
        hands = new Hand[2];

        legs[0] = new Leg("Right");
        legs[1] = new Leg("Left");

        hands[0] = new Hand("Right");
        hands[1] = new Hand("Left");

        brain = new Brain();
    }

    public Leg getLeg(String side) {
        if (side == "left")
            return legs[1];
        else
            return legs[0];

    }

    public Hand getHands(String side) {
        if (side == "left")
            return hands[1];
        else
            return hands[0];
    }

    public Brain getBrain() {
        return brain;
    }

    class Leg {
        String side;

        Leg(String side) {
            this.side = side;
        }

        public void vibe() {
            System.out.println(side + " leg vibe");
        }
    }

    class Hand {
        String side;

        Hand(String side) {
            this.side = side;
        }

        public void vibe() {
            System.out.println(side + " hand vibe");
        }
    }

    class Brain {


        public void vibe() {
            System.out.println(" Brain vibe");
            legs[0].vibe();
            legs[1].vibe();
            hands[0].vibe();
            hands[1].vibe();

        }
    }
}
