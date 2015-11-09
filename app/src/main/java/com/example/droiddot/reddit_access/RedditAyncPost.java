package com.example.droiddot.reddit_access;

import android.app.ProgressDialog;
import android.os.AsyncTask;

import com.example.droiddot.MainActivity;

// http://www.reddit.com/r/funny/.json

public class RedditAyncPost extends AsyncTask<RedditModel, Void, RedditModel>{

	private MainActivity callingContext;
	private ProgressDialog progress;

	public RedditAyncPost(MainActivity theContext)
	{
		callingContext = theContext;
		setProgress(new ProgressDialog(callingContext));
	}

	@Override
	protected RedditModel doInBackground(RedditModel... params) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @param progress the progress to set
	 */
	public void setProgress(ProgressDialog progress) {
		this.progress = progress;
	}

	/**
	 * @return the progress
	 */
	public ProgressDialog getProgress() {
		return progress;
	}

}
