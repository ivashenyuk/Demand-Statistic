
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;

public class GetData implements TCPListener {
    private static Thread threadClient;
    private ArrayList<DataProduct> productList = new ArrayList<DataProduct>();

    public GetData() {
        threadClient = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    new Connection(GetData.this, "127.0.0.1", 9090);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        threadClient.start();
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onConnectionReady(Connection tcpConnection) {

    }

    @Override
    public void onReceive(Connection tcpConnection, String data) {
        DataProduct[] tmpData = new Gson().fromJson(data, DataProduct[].class);

        for (DataProduct tmp : tmpData) {
            productList.add(tmp);
        }
    }

    @Override
    public void onDisconnect(Connection tcpConnection) {

    }

    @Override
    public void onExeption(Connection tcpConnection, Exception ex) {

    }

    public ArrayList<DataProduct> getProductList() {
        return productList;
    }
}
