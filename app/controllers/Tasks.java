package controllers;

import models.Task;
import play.data.Form;
import play.mvc.*;

/**
 * Created with IntelliJ IDEA.
 * User: Guillaume
 * Date: 10/7/12
 * Time: 1:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class Tasks extends Controller {

    static Form<Task> taskForm= form(Task.class);

    public static Result tasks(){
        return ok(
                views.html.tasks.render(Task.all(), taskForm)

        );
    }

    public static Result newTask(){
         Form<Task> filledForm = taskForm.bindFromRequest();
         if (filledForm.hasErrors()){
             return badRequest(views.html.tasks.render(Task.all(),  filledForm));
         }
         else {
             Task.create(filledForm.get());
             return redirect(routes.Tasks.tasks());
         }
    }

    public static Result delete(Long id){
        Task.delete(id);
        return redirect(routes.Tasks.tasks());
    }

    public static Result complete(Long id){
        Task task = Task.find.ref(id);
        task.isComplete = true;
        task.save();
        return redirect(routes.Tasks.tasks());
    }

}
