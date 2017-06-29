package hxli.demo.flickr.rest;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

import com.flickr4java.flickr.FlickrException;

import hxli.demo.flickr.rest.service.SearchService;


/**
 * <p>
 * This API is used to search photos in Flickr.
 * </p>
 * 
 * <p>
 * The path for this API is /search
 * </p>
 *
 */
@Path("/search")
public class SearchResource {
	
	private SearchService s = new SearchService();

	/**
	 * This method is to get the photos per page by the page number 
	 * @param servletRequest HttpServletRequest
	 * @param pageId The value of the page of photos to be returned
	 * @return A Response object contains the list of photos
	 * @throws FlickrException 
	 * @throws IOException 
	 * @throws NumberFormatException 
	 * @throws JsonMappingException 
	 * @throws JsonGenerationException 
	 */
	@GET
	@Path("/{pageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response search(@Context HttpServletRequest servletRequest, @PathParam(value = "pageId") String pageId) throws JsonGenerationException, JsonMappingException, NumberFormatException, IOException, FlickrException {
		//TODO: check pageId is integer and larger than 0
		return Response
			.ok(s.getPhotosByPageId(pageId==null?0:Integer.parseInt(pageId)))
			.build();
	}
	
	/**
	 * This method is to get the photos per page by the page number 
	 * @param servletRequest HttpServletRequest
	 * @param pageId The value of the page of photos to be returned
	 * @return A Response object contains the list of photos
	 * @throws FlickrException 
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonGenerationException 
	 */
	@GET
	@Path("/photo/{photoId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response searchPhoto(@Context HttpServletRequest servletRequest, @PathParam(value = "photoId") String photoId) throws JsonGenerationException, JsonMappingException, IOException, FlickrException {
		//TODO: check photoId is valid
		return Response
			.ok(s.getPhotoById(photoId))
			.build();
	}
}
