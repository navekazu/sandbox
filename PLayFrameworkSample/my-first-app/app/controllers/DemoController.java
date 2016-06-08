package controllers;

import play.*;
import play.mvc.*;

public class DemoController extends Controller {
    public Result index() {
        return ok("It works!");
    }
}
