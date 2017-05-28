package game.friendly;

import base.Unit;
import game.CastleDefense;
import game.Friendly;
import game.Main;

import javax.imageio.ImageIO;
import java.io.InputStream;

/**
 * Friendly Unit: Catapult Projectile (90kg Rock Lobbed Over a Distance Of 300m)
 *
 * @author Cody Richter
 * @version 1.0
 */
public class CatapultProjectile extends Friendly {
    public CatapultProjectile(){
        super(1,7,1,5);
        areaAttack = true;
        isProjectile = true;
        delayBetweenAttacks = 0;

        InputStream in = getClass().getResourceAsStream("/game/images/cProjectile.png");
        try {
            this.setSprite(ImageIO.read(in));
        } catch (Exception e){
            System.out.println("Exception when setting cProjectile " + e.getMessage());
        }

    }

    public void spawn(Catapult c){

        //Adds Unit To List Of Units On Gameboard
        Main.b.addUnit(this);
        CastleDefense.addFriendly(this);

        //Sets X and Y Coordinates Of Spawned Unit
        int x = (int) c.getX();
        int y = (int) c.getY();

        pos.setLocation(x, y);
    }

    @Override
    public void attack(Unit u) {
        if ((!this.hasAreaAttack() && doingAction)) return;
        u.damage(damage);
        this.damage(1);
    }

    public String toString(){return "";}

}
