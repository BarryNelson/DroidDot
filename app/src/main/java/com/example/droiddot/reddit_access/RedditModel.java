package com.example.droiddot.reddit_access;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class RedditModel {
	
	private String TAG = "RedditModel";

	private String searchParam = "";
	private List<RedditPost> postings = null;
	private Context callingContext;
	private String serverAddress;
	private String results;
	private JSONObject tempJobj;

//	// Listing
//	private String before;
//	private String after;
//	private String modhash;
//	private List<Thing<E>> children;
//	
//	// Thing
//	private String kind;
//	private E data;
//
//	// Media
//    private  JSONObject   oembed            ;
//	private  String       type              ; // "youtube.com"
	    	
	// omebed
//    private  String    provider_url         ; // "http://www.youtube.com/",                                                                                                                                           
//    private  String    description          ; // "Uploaded by kevinrose on 2013-07-20.",                                                                                                                              
//    private  String    title                ; // "My dog Toaster was attacked by a raccoon",                                                                                                                          
//    private  String    url                  ; // "http://www.youtube.com/watch?v=hHN-f6xTzsY",                                                                                                                        
//    private  String    author_name          ; // "kevinrose",                                                                                                                                                         
//    private  int       height               ; // 450,                                                                                                                                                                 
//    private  int       width                ; // 600,                                                                                                                                                                 
//    private  String    html                 ; // "&lt;iframe width=\"600\" height=\"450\" src=\"http://www.youtube.com/embed/hHN-f6xTzsY?feature=oembed\" frameborder=\"0\" allowfullscreen&gt;&lt;/iframe&gt;",      
//    private  int       thumbnail_width      ; // 480,                                                                                                                                                                 
//    private  String    version              ; // "1.0",                                                                                                                                                               
//    private  String    provider_name        ; // "YouTube",                                                                                                                                                           
//    private  String    thumbnail_url        ; // "http://i1.ytimg.com/vi/hHN-f6xTzsY/hqdefault.jpg",                                                                                                                  
//    private  String    type                 ; // "video",                                                                                                                                                             
//    private  int       thumbnail_height     ; // 360,                                                                                                                                                                 
//    private  String    author_url           ; // "http://www.youtube.com/user/kevinrose"                                                                                                                              

	public void ParseJSONObject(String string) {
		
		try {
			ParseJSONObject(new JSONObject(string));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * parse JSON object into (Context currentTransaction)
	 */
	public void ParseJSONObject(JSONObject jsonObj) {
		Log.d(TAG, "ParseJSONObject");
		
		try {
			// Exit if we don't have a JSON Object
			if (jsonObj == null) {
				return;
			}

			JSONArray jsonArray = null;

			JSONObject tempJsonOBJ = null;
			try {
				tempJsonOBJ = new JSONObject(jsonObj.getString("data"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				jsonArray = tempJsonOBJ.getJSONArray("children");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

            int length = jsonArray != null ? jsonArray.length() : 0;

			postings = new ArrayList<RedditPost>();

			for (int x = 0; x < length; x++) {

				String jsonString = null;
				try {
					jsonString = (new JSONObject(jsonArray.getString(x))).getString("data");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				tempJobj = new JSONObject(jsonString);
				RedditPost currentPost = new RedditPost();
				
				currentPost.setDomain                    (getJSONString		("domain"));		        
				currentPost.setBanned_by                 (getJSONString		("banned_by"));		        
				currentPost.setMedia_embed               (getJSONString		("media_embed"));	        
				currentPost.setSubreddit                 (getJSONString		("subreddit"));		        
				currentPost.setSelftext_html             (getJSONString		("selftext_html"));		    
				currentPost.setSelftext                  (getJSONString		("selftext"));	            
				currentPost.setLikes                     (getJSONString		("likes"));		            
				currentPost.setLink_flair_text           (getJSONString		("link_flair_text"));		
				currentPost.setId                        (getJSONString		("id"));		            
				currentPost.setClicked                   (getJSONBoolean	("clicked"));		        
				currentPost.setTitle                     (getJSONString		("title"));		            
				currentPost.setMedia                     (getJSONObj        ("media"));		            
				currentPost.setScore                     (getJSONInt		("score"));		            
				currentPost.setApproved_by               (getJSONString		("approved_by"));		    
				currentPost.setOver_18                   (getJSONBoolean	("over_18"));		        
				currentPost.setHidden                    (getJSONBoolean	("hidden"));		        
				currentPost.setThumbnail                 (getJSONURLtoBitmap		("thumbnail"));		        
				currentPost.setSubreddit_id              (getJSONString		("subreddit_id"));	        
				currentPost.setEdited                    (getJSONBoolean	("edited"));		        
				currentPost.setLink_flair_css_class      (getJSONString		("link_flair_css_class"));	
				currentPost.setAuthor_flair_css_class    (getJSONString		("author_flair_css_class"));
				currentPost.setDowns                     (getJSONInt		("downs"));		            
				currentPost.setSaved                     (getJSONBoolean	("saved"));		            
				currentPost.setIs_self                   (getJSONBoolean	("is_self"));		        
				currentPost.setPermalink                 (getJSONString		("permalink"));		        
				currentPost.setName                      (getJSONString		("name"));	                
				currentPost.setCreated                   (getJSONDouble		("created"));		        
				currentPost.setUrl                       (getJSONString		("url"));		            
				currentPost.setAuthor_flair_text         (getJSONString		("author_flair_text"));		
				currentPost.setAuthor                    (getJSONDouble		("author"));		        
				currentPost.setCreated_utc               (getJSONDouble		("created_utc"));		    
				currentPost.setUps                       (getJSONInt		("ups"));		            
				currentPost.setNum_comments              (getJSONInt		("num_comments"));	        
				currentPost.setNum_reports               (getJSONInt		("num_reports"));		    
				currentPost.setDistinguished             (getJSONBoolean	("distinguished"));		    
				
				postings.add(currentPost);	
				Log.d(TAG, "postings size = "+postings.size());
				
			}
			
			
		}
 catch (Exception ex) {

			AlertDialog dialog = new AlertDialog.Builder(callingContext).create();
			dialog.setMessage(ex.getMessage());
			dialog.setButton(DialogInterface.BUTTON_NEGATIVE, "CLOSE", new DialogInterface.OnClickListener() {

				public void onClick(DialogInterface dialog, int which) {
					dialog.cancel();
				}
			});
			dialog.show();
			ex.printStackTrace();
			return;
		}

	}

	private String getJSONString(String string) {
		try {
			return tempJobj.getString(string);
		} catch (JSONException e) {
			return null;
		}
	}
	private JSONObject getJSONObj(String string) {
		try {
			return tempJobj.getJSONObject(string);
		} catch (JSONException e) {
			return null;
		}
	}
	private int getJSONInt(String string) {
		try {
			return tempJobj.getInt(string);
		} catch (JSONException e) {
			return 0;
		}
	}
	private double getJSONDouble(String string) {
		try {
			return tempJobj.getDouble(string);
		} catch (JSONException e) {
			return 0;
		}
	}
	private boolean getJSONBoolean(String string) {
		try {
			return tempJobj.getBoolean(string);
		} catch (JSONException e) {
			return false;
		}
	}

	private Bitmap getJSONURLtoBitmap(String string) {
		String imageUrl = getJSONString(string);
		if (imageUrl != null) {
			try {
				Bitmap bitmap = BitmapFactory.decodeStream((InputStream) new URL(imageUrl).getContent());
				return bitmap;
			} catch (MalformedURLException e) {

			} catch (IOException e) {

			}
		}
		return null;
	}
	
	public RedditModel(Context callingContext, String sParam) {
		this.callingContext = callingContext;
		this.searchParam = sParam;
		this.postings = new ArrayList<RedditPost>();
	}


	// get & set
	public String getSearchParam() {
		return searchParam;
	}

	public void setSearchParam(String searchParam) {
		this.searchParam = searchParam;
	}

	public List<RedditPost> getPostings() {
		return postings;
	}

	public void setPostings(List<RedditPost> postings) {
		this.postings = postings;
	}

	public void setServerAddress(String serverAddress) {
		this.serverAddress = serverAddress;
	}


	public String getServerAddress() {
		// TODO Auto-generated method stub
		return serverAddress;
	}

	public void setResults(String results) {
		this.results = results;
	}

	public String getResults() {
		// TODO Auto-generated method stub
		return results;
	}

}
