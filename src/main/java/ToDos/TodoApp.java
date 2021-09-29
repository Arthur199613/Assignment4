package ToDos;

import com.google.gson.Gson;
import no.hvl.dat110.rest.counters.Counters;

import java.util.List;

import static spark.Spark.*;

public class TodoApp {
    static Todo todo = null;
    public static void main(String[] args)
    {

        if (args.length > 0) {
            port(Integer.parseInt(args[0]));
        } else {
            port(8082);
        }

         todo = new Todo();


        after((req, res) -> {
            res.type("application/json");
        });

        post("/todo",(req,res)->{
            Gson gson = new Gson();
            todo = gson.fromJson(req.body(),Todo.class);
            return todo.toJson();
        });

        get("/todo", (req, res) -> todo.toJson());

        get("/hello", (req, res) -> "Hello World!");

        delete("/todos",(req,res) -> {
            Gson gson = new Gson();

            todo = gson.fromJson(req.body(), Todo.class);

            return todo.toJson();
        });

        put("/todo", (req,res) -> {

            Gson gson = new Gson();

            todo = gson.fromJson(req.body(), Todo.class);

            return todo.toJson();

        });



        //get("/counters", (req, res) -> counters.toJson());


        // TODO: put for green/red and in JSON
        // variant that returns link/references to red and green counter
        /*
        put("/counters", (req,res) -> {

            Gson gson = new Gson();

            counters = gson.fromJson(req.body(), Counters.class);

            return counters.toJson();

        });*/
    }

}
