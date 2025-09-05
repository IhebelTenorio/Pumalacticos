package simulator;
public interface Service extends Observer{

    /**
     * @return return a object service 
     */
    public String getService();

    /**
     * @return return the price of an object service 
     */
    public int getPrice();

    /**
     * @return return a string with the name of the service
     */
    public String getId();

    /**
     * @return return the status of the service if its active on the user <true>
     */
    public boolean getStatus();

    /**
     * @param togggleTo changes the service's status to the given value, true for active and false for cancelled
     */
    public void setStatus(boolean toggleTo);

    public String getRecommendation();
}
