
/**
 * Methods For Friendly Units
 * 
 * @author Cody Richter
 * @version 1.0
 */
public abstract class Friendly extends Unit
{
    /**
     * Makes New Friendly Unit
     */
    public Friendly()
    {
        super(1,1,1,1,null,null);
    }

    /**
     * Makes new friendly unit with given attributes
     */
    public Friendly(int healthLevel, int damageLevel, int range, int speed)
    {
        super(healthLevel, damageLevel, range, speed,null,null);
    }

}
