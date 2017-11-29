package studio.clover.app.utils.connectivity;

public interface ConnectivityManagerWrapper {

    boolean isConnectedToNetwork();

    NetworkData getNetworkData();
}
