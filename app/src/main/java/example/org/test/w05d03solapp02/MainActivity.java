package example.org.test.w05d03solapp02;

import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    public static final String SEND_BROADCAST = "example.org.test.w05d03solapp01.SEND_BROADCAST";
    MyBroadcastReceiver myBroadcastReceiver;
    IntentFilter intentFilter;
    RecyclerView recyclerView;
    MyRecycleViewAdapter myRecycleViewAdapter;
    ProductDatabaseHelper productDatabaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myBroadcastReceiver = new MyBroadcastReceiver();
        intentFilter = new IntentFilter();
        intentFilter.addAction(SEND_BROADCAST);

        recyclerView = findViewById(R.id.rvRecycleView);

        // the 2 things for Recycle View
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        myRecycleViewAdapter = new MyRecycleViewAdapter(productDatabaseHelper.getAllProductsFromDatabase());
        recyclerView.setAdapter(myRecycleViewAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        registerReceiver(myBroadcastReceiver, intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}
