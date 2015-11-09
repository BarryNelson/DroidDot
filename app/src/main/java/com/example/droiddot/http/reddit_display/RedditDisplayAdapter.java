package com.example.droiddot.http.reddit_display;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.droiddot.MainActivity;
import com.example.droiddot.R;
import com.example.droiddot.reddit_access.RedditPost;

import java.util.ArrayList;
import java.util.List;

public class RedditDisplayAdapter extends BaseAdapter{

	ArrayList<RedditPost> redditPosts;
	private Activity context;
	private LayoutInflater inflater;
	private RedditPost post;
		
	public RedditDisplayAdapter(MainActivity context, List<RedditPost> redditPosts) {
		this.context = context;
		this.redditPosts = (ArrayList<RedditPost>)redditPosts;
		
		this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public int getCount() {
		return redditPosts.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	public class ViewHolder {
		ImageView thumbnail;
		TextView title;
		TextView subReddit;

	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub

		ViewHolder holder;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = inflater.inflate(R.layout.reddit_line_item, null);

			holder.thumbnail = (ImageView) convertView.findViewById(R.id.lineThumbnail);
			holder.subReddit = (TextView) convertView.findViewById(R.id.lineLabel);
			holder.title = (TextView) convertView.findViewById(R.id.lineDetail);
			holder.title.setTypeface(Typeface.createFromAsset(this.context.getAssets(), "fonts/bebasneue.ttf"));

			convertView.setTag(holder);
		}else{
			holder = (ViewHolder) convertView.getTag();
		}

		post = redditPosts.get(position);
		Bitmap thumbnail = post.getThumbnail();
		
		holder.thumbnail.setImageBitmap(thumbnail);
		holder.subReddit.setText("@"+post.getSubreddit());
		holder.title.setText(post.getTitle());

		return convertView;
	
	}


	
}
