package ToDos;

import no.hvl.dat110.rest.counters.Counters;
import okhttp3.*;

import java.io.IOException;

public class Post {
    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");
    public static void main(String[] args)
    {

        Todo todo = new Todo(1,"Hello","description");

        OkHttpClient client = new OkHttpClient();

        RequestBody body = RequestBody.create(JSON, todo.toJson());

        Request request = new Request.Builder().url("http://localhost:8082/todo").post(body).build();

        System.out.println(request.toString());

        try (Response response = client.newCall(request).execute()) {
            System.out.println(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }

