package models;

import java.util.ArrayList;
import java.util.List;
import play.data.validation.Constraints.*;
import play.db.ebean.*;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: Guillaume
 * Date: 10/7/12
 * Time: 2:56 PM
 * To change this template use File | Settings | File Templates.
 */

@Entity
public class Task extends Model {
    @Id
    public Long id;

    @Required
    public String label;
    public boolean isComplete = false;

    public static Finder<Long,Task> find = new Finder(
            Long.class, Task.class
    );

    public static List<Task> all(){
        return find.orderBy("isComplete,label").findList();
    }

    public static void create(Task task){
        task.save();
    }

    public static void delete (Long id){
         find.ref(id).delete();
    }

}
