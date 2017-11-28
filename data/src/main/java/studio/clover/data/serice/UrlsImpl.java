package studio.clover.data.serice;

public final class UrlsImpl implements Urls {

    private static final ServerUrl SERVER_URL = new ServerUrl("https://spika.chat/api/v3");

    @Override
    public ServerUrl getServerUrl() {
        return SERVER_URL;
    }
}
