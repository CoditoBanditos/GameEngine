package game.friendly;

import base.Unit;
import game.Startup;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Friendly Unit: Crossbowman
 *
 * @author Cody Richter
 * @version 1.0
 */
public class Crossbowman extends Friendly {
    //Spawning Cooldown Variables
    protected static int cooldown = 10;
    private static Timer timer = new Timer();
    private static boolean isComplete = true;
    public static final int COST = 250;

    public Crossbowman() {
        super(6,0,20,1);
        this.setSprite("crossbowman");
        delayBetweenAttacks = 3;
    }

    @Override
    public void attack(Unit u) {
        Projectile p = new Projectile();
        p.spawn(this);
        doingAction = true;

        //Sets Timer For Cooldown
        Timer t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                doingAction = false;
                currentlyAttacking = false;
            }
        }, (int)(delayBetweenAttacks*1000));
    }


    public static void startCooldown()
    {
        if (Startup.ADMINMODE && Startup.NOCOOLDOWN) return;
        isComplete = false;
        Startup.menu.repaint();

        //Sets Timer For Cooldown
        Timer t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                isComplete = true;
                Startup.menu.repaint();
            }
        }, cooldown*1000);
    }

    public static boolean isReadyToSpawn()
    {
        return isComplete;
    }

    //
    // Economy
    //

    public static int getUnitCost()
    {
        if (COST <= 0) return -1;
        else return COST;
    }

    public String toString(){return "Crossbowman";}

}
