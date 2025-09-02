package simulator;
public interface Service {
    int price = 0;
    int months = 0;
    String service = "";

    //public getRecommendations()

    public default int getMonths(){
        return months;
    }

    public default String getService() {
        return service;
    }

}
