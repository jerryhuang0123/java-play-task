package controllers;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import models.SearchHistory;
import play.mvc.*;
import play.data.DynamicForm;
import play.data.FormFactory;
import services.TwitterManager;
import twitter4j.TwitterException;
import views.html.*;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

	private static List<String> tweetList = new ArrayList<String>();
	@Inject 
	FormFactory formFactory;
    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {
    	return ok(index.render(tweetList));
    }
    
    public Result search() throws TwitterException{
    	SearchHistory searchHistory = formFactory.form(SearchHistory.class).bindFromRequest().get();
    	DynamicForm requestData = formFactory.form().bindFromRequest();
    	searchHistory.save();
    	tweetList = TwitterManager.getInstance().getTweets(searchHistory.searchWord, Integer.parseInt(requestData.get("quantity")));
    	return redirect(routes.HomeController.index());
    }

}
