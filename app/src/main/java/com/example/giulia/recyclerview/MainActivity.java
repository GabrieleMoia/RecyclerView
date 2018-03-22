package com.example.giulia.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    int n = 0;
    private RecyclerView myRecyclerView;
    private RecyclerView.Adapter<Adapter.ViewHolder> myAdapter;
    private RecyclerView.LayoutManager myLayoutManager;
    public static LayoutManagerType myLayoutManagerType;

    public enum LayoutManagerType {
        GRID_LAYOUT_MANAGER,
        LINEAR_LAYOUT_MANAGER
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myRecyclerView = (RecyclerView) findViewById(R.id.recycleView);
        myLayoutManager = new LinearLayoutManager(this);
        myLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;
        myRecyclerView.setLayoutManager(myLayoutManager);
        myAdapter = new Adapter(getApplicationContext());
        myRecyclerView.setAdapter(myAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_cart:
                switch (myLayoutManagerType) {
                    case GRID_LAYOUT_MANAGER:
                        setRecyclerViewLayoutManager(LayoutManagerType.LINEAR_LAYOUT_MANAGER);
                        break;
                    case LINEAR_LAYOUT_MANAGER:
                        setRecyclerViewLayoutManager(LayoutManagerType.GRID_LAYOUT_MANAGER);
                        break;
                    default:
                        setRecyclerViewLayoutManager(LayoutManagerType.LINEAR_LAYOUT_MANAGER);
                        break;
                }
        }
        return true;
    }


    public void setRecyclerViewLayoutManager(LayoutManagerType layoutManagerType) {
        int scrollPosition = 0;

        // If a layout manager has already been set, get current scroll position.
        if (myRecyclerView.getLayoutManager() != null) {
            scrollPosition = ((LinearLayoutManager) myRecyclerView.getLayoutManager())
                    .findFirstCompletelyVisibleItemPosition();
        }

        switch (layoutManagerType) {
            case GRID_LAYOUT_MANAGER:
                myLayoutManager = new GridLayoutManager(this, 2);
                myLayoutManagerType = LayoutManagerType.GRID_LAYOUT_MANAGER;
                break;
            case LINEAR_LAYOUT_MANAGER:
                myLayoutManager = new LinearLayoutManager(this);
                myLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;
                break;
            default:
                myLayoutManager = new LinearLayoutManager(this);
                myLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;
        }

        myAdapter = new Adapter(getApplicationContext());
        myRecyclerView.setAdapter(myAdapter);

        myRecyclerView.setLayoutManager(myLayoutManager);
        myRecyclerView.scrollToPosition(scrollPosition);
    }
}

