package hxli.demo.flickr.common;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import hxli.demo.flickr.model.FlickrPhoto;

import java.io.IOException;
import java.util.List;

public class JsonUtil {
	
	private static final ObjectMapper mapper = new ObjectMapper();
	
	public static String convertToJson(List<FlickrPhoto> fPhotos) throws JsonGenerationException, JsonMappingException, IOException{
		return mapper.writeValueAsString(fPhotos);
	}
	
	public static String convertToJson(FlickrPhoto photo) throws JsonGenerationException, JsonMappingException, IOException{
		return mapper.writeValueAsString(photo);
	}

}
