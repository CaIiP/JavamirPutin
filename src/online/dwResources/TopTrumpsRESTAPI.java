

package online.dwResources;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import online.configuration.TopTrumpsJSONConfiguration;
import view.RoundView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import controller.Controller;
import controller.DeckController;
import controller.OnlineController;
import model.Card;
import model.DTO;
import model.Deck;
import model.Player;
import model.Round;
import model.TopTrumpsModel;

@Path("/toptrumps") // Resources specified here should be hosted at http://localhost:7777/toptrumps
@Produces(MediaType.APPLICATION_JSON) // This resource returns JSON content
@Consumes(MediaType.APPLICATION_JSON) // This resource can take JSON content as input
/**
 * This is a Dropwizard Resource that specifies what to provide when a user
 * requests a particular URL. In this case, the URLs are associated to the
 * different REST API methods that you will need to expose the game commands
 * to the Web page.
 * 
 * Below are provided some sample methods that illustrate how to create
 * REST API methods in Dropwizard. You will need to replace these with
 * methods that allow a TopTrumps game to be controled from a Web page.
 */
public class TopTrumpsRESTAPI {
	
	Controller controller;

	/** A Jackson Object writer. It allows us to turn Java objects
	 * into JSON strings easily. */
	ObjectWriter oWriter = new ObjectMapper().writerWithDefaultPrettyPrinter();
	
	/**
	 * Contructor method for the REST API. This is called first. It provides
	 * a TopTrumpsJSONConfiguration from which you can get the location of
	 * the deck file and the number of AI players.
	 * @param conf
	 */
	public TopTrumpsRESTAPI(TopTrumpsJSONConfiguration conf) {
		// ----------------------------------------------------
		// Add relevant initalization here
		// ----------------------------------------------------
	}
	
	// ----------------------------------------------------
	// Add relevant API methods here
	// ----------------------------------------------------
	
	@GET
	@Path("/helloJSONList")
	/**
	 * Here is an example of a simple REST get request that returns a String.
	 * We also illustrate here how we can convert Java objects to JSON strings.
	 * @return - List of words as JSON
	 * @throws IOException
	 */
	public String helloJSONList() throws IOException {
		
		List<String> listOfWords = new ArrayList<String>();
		listOfWords.add("Hello");
		listOfWords.add("World!");
		
		// We can turn arbatory Java objects directly into JSON strings using
		// Jackson seralization, assuming that the Java objects are not too complex.
		String listAsJSONString = oWriter.writeValueAsString(listOfWords);
		
		return listAsJSONString;
	}
	
	@GET
	@Path("/helloWord")
	/**
	 * Here is an example of how to read parameters provided in an HTML Get request.
	 * @param Word - A word
	 * @return - A String
	 * @throws IOException
	 */
	public String helloWord(@QueryParam("Word") String Word) throws IOException {
		return "Hello "+Word;
	}

	
	
	@GET
	@Path("/newGame/{playerCount}")
	//first screen api
	public boolean newGameButton(@PathParam("playerCount") int playerCount)	{
		controller = new OnlineController(playerCount, true);
		return true;
	}

	//ObjectWriter oWriter = new ObjectMapper().writerWithDefaultPrettyPrinter();
	//WILL BE NEEDED FOR ARRAYS
	@GET
	@Path("/stats")
	public String gameStatsButton()	{
		return "";
	}
	
	@GET
	@Path("/currentplayer")
	public String currentPlayer()	{
		Player player = controller.getCAController().getDecidingPlayer(controller.getTopTrumpsModel());
		return player.getName();
	}
	
	//ObjectWriter oWriter = new ObjectMapper().writerWithDefaultPrettyPrinter();
	//WILL BE NEEDED FOR ARRAYS
	@GET
	@Path("/currentcards")
	public String currPlayerCards()	{
		RoundView rv = new RoundView();
		String r = rv.getRound().getDeck().getSize();
		return r;
	}
	
	@GET
	@Path("/chooseAttribute/{attributeName}")
	public String chooseAttributes(@PathParam("attributeName") String attributeName)	{
		
		
		return "";
	}
	
	
	@GET
	@Path("/nextStage")
	public String nextRoundStage()	{
		return "";
	}	

}
