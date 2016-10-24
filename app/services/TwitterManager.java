package services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import play.Logger;
import play.data.validation.Constraints.Required;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

import com.avaje.ebean.*;

public class TwitterManager{
	
	private final static String CONSUMER_KEY = "q6Z4orwe36StMJyR0GwE4JV7f";
	private final static String CONSUMER_SECRET = "MwPVMDnEniJSJzw6kA6sKuLYZgAXRPWeJVSiCsnpwrpMSl5P5Q";
	private final static String ACCESS_TOKEN = "790372301535449088-vnDnRf6Py1IDC386T1tCNwkd9UEVwCP";
	private final static String ACCESS_TOKEN_SECRET = "bTmXgXTeRtyulyftOtpjdGG8WhbO2PUw8ZEZ93GqDAwmc";
	
	private static Twitter twitter = null;
	private static TwitterManager manager = null;
	
	public static TwitterManager getInstance(){
		if(manager == null){
			manager = new TwitterManager();
		}
		
		return manager;
	}
    public Twitter getTwitter(){
    	if(twitter == null){
    		ConfigurationBuilder configBuilder = new ConfigurationBuilder();
        	configBuilder.setDebugEnabled(true)
        		.setOAuthConsumerKey(CONSUMER_KEY)
        		.setOAuthConsumerSecret(CONSUMER_SECRET)
        		.setOAuthAccessToken(ACCESS_TOKEN)
        		.setOAuthAccessTokenSecret(ACCESS_TOKEN_SECRET);
        	
        	TwitterFactory twitterFactory = new TwitterFactory(configBuilder.build());
        	twitter = twitterFactory.getInstance();
    	}
    	
    	
    	return twitter;
    }
    
    public List<String> getTweets(String searchWord) throws TwitterException{
    	List<String> list = new ArrayList<String>();
    	Twitter twitter = getTwitter();
    	Query query = new Query(searchWord);
    	QueryResult result = twitter.search(query);
    	for(Status status: result.getTweets()){
    		Logger.info("@" + status.getUser().getScreenName() + ":" + status.getText());
    		list.add("@" + status.getUser().getScreenName() + ":" + status.getText());
    	}
    	
    	return list;
    }
	
	
	
}
