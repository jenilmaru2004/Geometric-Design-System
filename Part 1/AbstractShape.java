public abstract class AbstractShape  {
    protected static int numberOfInstances;

    public AbstractShape() {
        numberOfInstances++;
    }

    public static int getNumOfInstances() {
        return numberOfInstances;
    }
}
