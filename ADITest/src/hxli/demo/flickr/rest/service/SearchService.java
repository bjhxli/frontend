package hxli.demo.flickr.rest.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.REST;
import com.flickr4java.flickr.photos.Photo;
import com.flickr4java.flickr.photos.PhotoList;
import com.flickr4java.flickr.photos.SearchParameters;

import hxli.demo.flickr.common.Constants;
import hxli.demo.flickr.common.JsonUtil;
import hxli.demo.flickr.model.FlickrPhoto;

/**
 * This class provides functions for search rest service
 *
 */
public class SearchService {
	
	private Flickr f;
	
	public SearchService(){
		f = new Flickr(Constants.apiKey, Constants.apiSecret, new REST());
	}

	/**
	 * Return a page of flickr photos in Json
	 * 
	 * @return A String message contains photos information
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonGenerationException 
	 * @throws FlickrException 
	 */
	public String getPhotosByPageId(int pageId) throws JsonGenerationException, JsonMappingException, IOException, FlickrException {		
		SearchParameters sp = new SearchParameters();
		sp.setUserId(Constants.userId);
		PhotoList<Photo> ps = f.getPhotosInterface().search(sp, Constants.pageSize, pageId);

		List<FlickrPhoto> fPhotos = new ArrayList<FlickrPhoto>();
		for(Photo p:ps){
			FlickrPhoto photo = new FlickrPhoto();
			photo.setDescription(p.getDescription());
			photo.setLargeUrl(p.getLargeUrl());
			photo.setSmallUrl(p.getSmallUrl());
			photo.setTitle(p.getTitle());
			photo.setId(p.getId());
			fPhotos.add(photo);
		}
		return JsonUtil.convertToJson(fPhotos);
	}
	
	/**
	 * Get a photo information by id
	 * 
	 * @param photoId
	 * @return
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @throws FlickrException
	 */
	public String getPhotoById(String photoId) throws JsonGenerationException, JsonMappingException, IOException, FlickrException {		
		Photo p = f.getPhotosInterface().getPhoto(photoId);

		FlickrPhoto photo = new FlickrPhoto();
		photo.setDescription(p.getDescription());
		photo.setLargeUrl(p.getLargeUrl());
		photo.setSmallUrl(p.getSmallUrl());
		photo.setTitle(p.getTitle());
		photo.setId(p.getId());
		
		return JsonUtil.convertToJson(photo);
	}
	
	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException, FlickrException{
		SearchService s = new SearchService();
		System.out.println(s.getPhotosByPageId(1));
	}
}
