package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {
  
  public static Result index() {
    //return redirect(routes.Tasks.tasks());
      return ok("Guillaume");
  }
  
}