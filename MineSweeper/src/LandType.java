public abstract class LandType {
    protected char land;

    public void setLand( char land ) {
        this.land = land;
    }

    @Override
    public String toString() {
        return this.land + "";
    }
}
