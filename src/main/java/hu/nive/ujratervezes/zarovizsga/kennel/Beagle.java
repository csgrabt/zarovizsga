package hu.nive.ujratervezes.zarovizsga.kennel;

public class Beagle extends Dog {
    public static final int INCREASE_HAPPINESS_WHEN_FEED = 2;
    public static final int INCREASE_HAPPINESS_PLAY_MULTIPLIER = 2;

    public Beagle(String name) {
        super(name);
    }

    @Override
    public void feed() {
        this.happiness = happiness + INCREASE_HAPPINESS_WHEN_FEED;
    }

    @Override
    public void play(int hours) {
        this.happiness = happiness + hours * INCREASE_HAPPINESS_PLAY_MULTIPLIER;
    }
}
