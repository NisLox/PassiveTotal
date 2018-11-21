import com.squareup.okhttp.*;
import java.io.IOException;


public class Main {

    public static void main(String args[]) {
        Main main = new Main();
        main.whoIP();
        main.passiveDns();
    }

    private void whoIP() {
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body1 = RequestBody.create(mediaType, "{\n    \"query\": \"bbc.co.uk\"\n}\n");
        Request request = new Request.Builder()
                .url("https://api.passivetotal.org/v2/whois")
                .get()
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Basic d2J1cmdlc3NAbWFzcy5jby51azphZTcxOGRhODljNWQ2NTM2MGIzMTc2ZTA4NDhhYjkzNjNmZjRlOWRhZGU3ZTE4NGNkZDBkNzJlMjg1ZWZhY2Rk")
                .addHeader("cache-control", "no-cache")
                .addHeader("Postman-Token", "b30645c8-8954-4f02-a8c6-3bc73ade54a0")
                .post(body1)
                .build();

        try {
            Response response = client.newCall(request).execute();
            System.out.println(response.message());
            System.out.println(response.body().string());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void passiveDns(){
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\n    \"query\": \"bbc.co.uk\"\n}");
        Request request = new Request.Builder()
                .url("https://api.passivetotal.org/v2/dns/passive")
                .get()
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Basic d2J1cmdlc3NAbWFzcy5jby51azphZTcxOGRhODljNWQ2NTM2MGIzMTc2ZTA4NDhhYjkzNjNmZjRlOWRhZGU3ZTE4NGNkZDBkNzJlMjg1ZWZhY2Rk")
                .addHeader("cache-control", "no-cache")
                .addHeader("Postman-Token", "ba1ad50e-9a76-4f65-be9a-682a1d8fee37")
                .post(body)
                .build();

        try {
            Response response = client.newCall(request).execute();
            System.out.println(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
