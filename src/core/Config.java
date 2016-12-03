package core;

import twitter4j.conf.ConfigurationBuilder;

public class Config {
	
	ConfigurationBuilder cb = new ConfigurationBuilder();

	Config(){
	//Create the configuration to access twitter
		cb.setDebugEnabled(true)
		.setOAuthConsumerKey("o712oMqjyo8so0AeqVNEBNW9X")
		.setOAuthConsumerSecret("NVd8AUqqbDDJrDtXUjr0Bmj2XKvo7nYGFy3L3VAyZ4VYqx0zjy")
		.setOAuthAccessToken("1950091920-2lU2U9JTSctDPQ4guH9aKTD1erqBkfW6aCDbiiQ")
		.setOAuthAccessTokenSecret("ZQElZ2URx3iNzp9zLXjRSmZOsDirPvk4Y5mS0qimSvLto");
	}
	
	//Create the getter to access the configuration
	public ConfigurationBuilder getSettings(){
		return cb;
	}
}
