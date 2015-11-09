    package com.example.droiddot;

    import android.app.Activity;
    import android.content.Intent;
    import android.os.Bundle;
    import android.support.v7.widget.LinearLayoutManager;
    import android.support.v7.widget.RecyclerView;
    import android.telephony.SmsManager;
    import android.util.Log;
    import android.view.Menu;
    import android.view.View;
    import android.view.View.OnClickListener;
    import android.widget.AdapterView;
    import android.widget.EditText;
    import android.widget.ImageView;
    import android.widget.ListView;

    import com.example.droiddot.http.reddit_display.RedditDisplayAdapter;
    import com.example.droiddot.http.reddit_display.RedditRecyclerAdapter;
    import com.example.droiddot.reddit_access.RedditAyncGet;
    import com.example.droiddot.reddit_access.RedditModel;
    import com.example.droiddot.reddit_access.RedditPost;

public class MainActivity extends Activity {

	private String TAG;
	private EditText searchValue;
	private String searchText;
	private RedditModel redditPostings;
	private String serverAddress;
	private ListView redditListView;
	private RedditDisplayAdapter adapter;
	private RecyclerView redditRecyclerView;
    private RedditRecyclerAdapter redditRecyclerAdapter;
    private LinearLayoutManager layoutManager;

    @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);
		
		initControls();
		doSearch();
		
	}

	private void initControls() {
		
		searchValue = (EditText)findViewById(R.id.searchText);
		
		((ImageView) findViewById(R.id.imageSearch)).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				doSearch();
			}
		});
		
		((ImageView) findViewById(R.id.clearSearchText)).setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                searchValue.setText("");
            }
        });


	}
	
	/**
	 * Access reddit
	 */
	protected void doSearch() {
		searchText = searchValue.getText().toString();
		Log.d(TAG, "search param{" + searchText.toString() + "}");

		if (!searchText.equals("")) {

			serverAddress = "https://www.reddit.com/r/" + searchText + "/.json";

			redditPostings = new RedditModel(MainActivity.this, searchText);
			redditPostings.setServerAddress(serverAddress);

			// RedditAyncPost redditAyncPost = new
			// RedditAyncPost(MainActivity.this);
			// redditAyncPost.execute(redditPostings);

			RedditAyncGet redditAyncGet = new RedditAyncGet(MainActivity.this);
			redditAyncGet.execute(redditPostings);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	/**
	 * got response from asyntask
	 * @param redditModel
	 */
	public void onDataReturned(final RedditModel redditModel) {
		Log.d(TAG, "onDataReturned:" + redditModel.getResults());
		displayPostsInListView(redditModel);
//        displayPostsInRecyclerView(redditModel);
	}

	/**
	 * Display RedditModel postings in ListView
	 * @param redditModel
	 */
	private void displayPostsInListView(final RedditModel redditModel) {
		redditListView = (ListView) findViewById(R.id.listView1);

		adapter = new RedditDisplayAdapter(this, redditModel.getPostings());
		redditListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			
			@Override
			public void onItemClick(AdapterView<?> adapterView, View selectedView, int position, long rowID) {
				
				RedditPost post = redditModel.getPostings().get(position);
				
				sendEmail(post);
				//sendSMS("4252478090", "Check out this epic tweet!" + post.getTitle());
				
			}
		});

		redditListView.setAdapter(adapter);
	}

	/**
	 * Display RedditModel postings in RecyclerView
	 * @param redditModel
	 */
/*
	private void displayPostsInRecyclerView(final RedditModel redditModel) {

        redditRecyclerView = (RecyclerView) findViewById(R.id.redit_recycler_view);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        redditRecyclerView.setLayoutManager(layoutManager);

        redditRecyclerAdapter = new RedditRecyclerAdapter(this, redditModel.getPostings());

        redditRecyclerView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(view);
            }
        });

        redditRecyclerView.setAdapter(redditRecyclerAdapter);

    }
*/

	/**
	 * Send an email
	 * @param post
	 */
	private void sendEmail(RedditPost post) {
		
		Intent intent = new Intent(android.content.Intent.ACTION_SEND);
		intent.setType("plain/text");
		intent.putExtra(Intent.EXTRA_SUBJECT, "Check out this epic tweet!");
		intent.putExtra(Intent.EXTRA_TEXT, ""+post.getTitle());
		
		// keep it to real email programs
		intent.setType("message/rfc822");
		
		startActivity(Intent.createChooser(intent, "Send email using"));
	}

	/**
	 * Send a Text Message
	 * @param phoneNumber
	 * @param message
	 */
	private void sendSMS(String phoneNumber, String message) {
		SmsManager sms = SmsManager.getDefault();
		sms.sendTextMessage(phoneNumber, null, message, null, null);
	}


}
