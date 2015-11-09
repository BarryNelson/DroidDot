package com.example.droiddot.reddit_access;

import org.json.JSONObject;

import android.graphics.Bitmap;


public class RedditPost {

	// type t3
	// reddit posting
	private String domain                    ; // "i.imgur.com"
	private String banned_by                 ; // null
	private String media_embed          	 ; // {}
	private String subreddit                 ; // "funny"
	private String selftext_html             ; // null
	private String selftext                  ; // ""
	private String likes                     ; // null
	private String link_flair_text           ; // null
	private String id                        ; // "1iphxx"
	private boolean clicked                  ; // false
	private String title                     ; // "Found this gem inside the bathroom of an Irish pub in Denver CO"
	private JSONObject media                     ; // null
	private int score                        ; // 1504
	private String approved_by               ; // null
	private boolean over_18                  ; // false
	private boolean hidden                   ; // false
	private Bitmap thumbnail                 ; // "http://c.thumbs.redditmedia.com/wbsx7nGEGT7EWodh.jpg"
	private String subreddit_id              ; // "t5_2qh33"
	private boolean edited                   ; // false
	private String link_flair_css_class      ; // null
	private String author_flair_css_class    ; // null
	private int downs                        ; // 1358
	private boolean saved                    ; // false
	private boolean is_self                  ; // false
	private String permalink                 ; // "/r/funny/comments/1iphxx/found_this_gem_inside_the_bathroom_of_an_irish/"
	private String name                      ; // "t3_1iphxx"
	private double created                     ; // 1374375242
	private String url                       ; // "http://i.imgur.com/fcaO2SL.jpg"
	private String author_flair_text         ; // null
	private double author                    ; // "TimmyCorn"
	private double created_utc               ; // 1374346442
	private int ups                          ; // 2862
	private int num_comments                 ; // 95
	private int num_reports                  ; // null
	private boolean distinguished            ; // null
	
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getBanned_by() {
		return banned_by;
	}
	public void setBanned_by(String banned_by) {
		this.banned_by = banned_by;
	}
	public String getMedia_embed() {
		return media_embed;
	}
	public void setMedia_embed(String media_embed) {
		this.media_embed = media_embed;
	}
	public String getSubreddit() {
		return subreddit;
	}
	public void setSubreddit(String subreddit) {
		this.subreddit = subreddit;
	}
	public String getSelftext_html() {
		return selftext_html;
	}
	public void setSelftext_html(String selftext_html) {
		this.selftext_html = selftext_html;
	}
	public String getSelftext() {
		return selftext;
	}
	public void setSelftext(String selftext) {
		this.selftext = selftext;
	}
	public String getLikes() {
		return likes;
	}
	public void setLikes(String likes) {
		this.likes = likes;
	}
	public String getLink_flair_text() {
		return link_flair_text;
	}
	public void setLink_flair_text(String link_flair_text) {
		this.link_flair_text = link_flair_text;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public boolean isClicked() {
		return clicked;
	}
	public void setClicked(boolean clicked) {
		this.clicked = clicked;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public JSONObject getMedia() {
		return media;
	}
	public void setMedia(JSONObject jsonObject) {
		this.media = jsonObject;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getApproved_by() {
		return approved_by;
	}
	public void setApproved_by(String approved_by) {
		this.approved_by = approved_by;
	}
	public boolean isOver_18() {
		return over_18;
	}
	public void setOver_18(boolean over_18) {
		this.over_18 = over_18;
	}
	public boolean isHidden() {
		return hidden;
	}
	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}
	public Bitmap getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(Bitmap thumbnail) {
		this.thumbnail = thumbnail;
	}
	public String getSubreddit_id() {
		return subreddit_id;
	}
	public void setSubreddit_id(String subreddit_id) {
		this.subreddit_id = subreddit_id;
	}
	public boolean isEdited() {
		return edited;
	}
	public void setEdited(boolean edited) {
		this.edited = edited;
	}
	public String getLink_flair_css_class() {
		return link_flair_css_class;
	}
	public void setLink_flair_css_class(String link_flair_css_class) {
		this.link_flair_css_class = link_flair_css_class;
	}
	public String getAuthor_flair_css_class() {
		return author_flair_css_class;
	}
	public void setAuthor_flair_css_class(String author_flair_css_class) {
		this.author_flair_css_class = author_flair_css_class;
	}
	public int getDowns() {
		return downs;
	}
	public void setDowns(int downs) {
		this.downs = downs;
	}
	public boolean isSaved() {
		return saved;
	}
	public void setSaved(boolean saved) {
		this.saved = saved;
	}
	public boolean isIs_self() {
		return is_self;
	}
	public void setIs_self(boolean is_self) {
		this.is_self = is_self;
	}
	public String getPermalink() {
		return permalink;
	}
	public void setPermalink(String permalink) {
		this.permalink = permalink;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getCreated() {
		return created;
	}
	public void setCreated(double created) {
		this.created = created;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getAuthor_flair_text() {
		return author_flair_text;
	}
	public void setAuthor_flair_text(String author_flair_text) {
		this.author_flair_text = author_flair_text;
	}
	public double getAuthor() {
		return author;
	}
	public void setAuthor(double author) {
		this.author = author;
	}
	public double getCreated_utc() {
		return created_utc;
	}
	public void setCreated_utc(double created_utc) {
		this.created_utc = created_utc;
	}
	public int getUps() {
		return ups;
	}
	public void setUps(int ups) {
		this.ups = ups;
	}
	public int getNum_comments() {
		return num_comments;
	}
	public void setNum_comments(int num_comments) {
		this.num_comments = num_comments;
	}
	public int getNum_reports() {
		return num_reports;
	}
	public void setNum_reports(int num_reports) {
		this.num_reports = num_reports;
	}
	public boolean isDistinguished() {
		return distinguished;
	}
	public void setDistinguished(boolean distinguished) {
		this.distinguished = distinguished;
	}
	

	@Override
	public String toString() {
		String str = "RedditPost : " 
						   + "   domain :" + domain                  
						   + ",  banned_by :" + banned_by               
						   + ",  media_embed  :" + media_embed
						   + ",  subreddit :" + subreddit               
						   + ",  selftext_html :" + selftext_html           
						   + ",  selftext  :" + selftext                
						   + ",  likes :" + likes                   
						   + ",  link_flair_text   :" + link_flair_text         
						   + ",  id :" + id                      
						   + ",  clicked   :" + clicked                 
						   + ",  title :" + title                   
						   + ",  media :" + media                   
						   + ",  score :" + score                   
						   + ",  approved_by   :" + approved_by             
						   + ",  over_18   :" + over_18                 
						   + ",  hidden :" + hidden                  
						   + ",  thumbnail :" + thumbnail               
						   + ",  subreddit_id  :" + subreddit_id            
						   + ",  edited :" + edited                  
						   + ",  link_flair_css_class  :" + link_flair_css_class    
						   + ",  author_flair_css_class :" + author_flair_css_class  
						   + ",  downs :" + downs                   
						   + ",  saved :" + saved                   
						   + ",  is_self   :" + is_self                 
						   + ",  permalink :" + permalink               
						   + ",  name  :" + name                    
						   + ",  created   :" + created                 
						   + ",  url   :" + url                     
						   + ",  author_flair_text :" + author_flair_text       
						   + ",  author :" + author                  
						   + ",  created_utc   :" + created_utc             
						   + ",  ups   :" + ups                     
						   + ",  num_comments  :" + num_comments            
						   + ",  num_reports   :" + num_reports             
						   + ",  distinguished :" + distinguished
						   ;
		return str;
	}
}
