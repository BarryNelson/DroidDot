package com.example.droiddot.reddit_access;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.util.Log;

import com.example.droiddot.MainActivity;

/**
 * AsyncHttpPostTask
 * 
 * 
 */
public class RedditAyncGet extends AsyncTask<RedditModel, Void, RedditModel> {
	
	private String TAG = "RedditAyncGet";
	
	StatusLine statusLine = null;
	private MainActivity callingActivity;


	/**
	 * Registers Activity for receiving data back
	 * 
	 * @param mainActivity
	 */
	public RedditAyncGet(MainActivity mainActivity) {
		this.callingActivity = mainActivity;
	}

	/**
	 * Run this task in background to send a file via POST
	 */
	@Override
	protected RedditModel doInBackground(RedditModel... params) {
		
		RedditModel redditModel = params[0];

//		String urlServer = redditModel.getServerAddress();
//		URL url = null;
//		try {
//			url = new URL(urlServer);
//		} catch (MalformedURLException e1) {
//			e1.printStackTrace();
//		}
//
		try {
//			HttpURLConnection c = (HttpURLConnection) url.openConnection();
			
			HttpGet request = new HttpGet(redditModel.getServerAddress());
			request.setHeader("Accept", "application/json");
			request.setHeader("Content-type", "application/json");

			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpResponse response = httpClient.execute(request);

			HttpEntity responseEntity = response.getEntity();
			Log.d(TAG, "Status :" + response.getStatusLine());
			Log.d(TAG, "content length :" + responseEntity.getContentLength());

			JSONObject jsonObject = null;
			try {
				jsonObject = new JSONObject(EntityUtils.toString(responseEntity));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Log.d(TAG, "Json:" + jsonObject);
			
			redditModel.ParseJSONObject(jsonObject);
			
//			c.setRequestMethod("GET");
//			c.setDoOutput(true);
//			c.connect();
//
//			InputStream is = c.getInputStream();
//
//			int lengthOfFile = c.getContentLength();
//			int interval = lengthOfFile / 100;
//			int runningTotal = 0;
//
//			byte[] buffer = new byte[interval];
//			int len1 = 0;
//			while ((len1 = is.read(buffer)) != -1) {
//				runningTotal += interval;
//				Log.d(TAG, ""+buffer);
//				redditModel.ParseJSONObject(new String(buffer));
//			//	publishProgress(""+(int)((runningTotal*100)/lengthOfFile));
//			//	fos.write(buffer, 0, len1);
//			}
//			//fos.close();
//			is.close(); // till here, it works fine - .apk is download to my
						// sdcard in download file

		//	Intent intent = new Intent(Intent.ACTION_VIEW);
		//	intent.setDataAndType(
		//			Uri.fromFile(new File(
		//					Environment.getExternalStorageDirectory()
		//					+ "/nelsoft/"
		//					+ "app.apk")),
		//			"application/vnd.android.package-archive");
		//	startActivity(intent);
		//	finish();

		} catch (IOException e) {
			//showAlert("Error with update!", e.getMessage());
			//Toast.makeText(getApplicationContext(), "Update error!" + e.getMessage(), Toast.LENGTH_LONG).show();
			redditModel.setResults("Exception:"+e.getMessage());
		}
	
		redditModel.setResults("Success");
		return redditModel;

	}

	/**
	 * send results of POST transmission back to Activity
	 */
	@Override
	protected void onPostExecute(RedditModel redditModel) {
		callingActivity.onDataReturned(redditModel);
	}

}