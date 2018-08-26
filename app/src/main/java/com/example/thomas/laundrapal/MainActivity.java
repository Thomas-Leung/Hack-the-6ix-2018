package com.example.thomas.laundrapal;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    FragmentPagerAdapter adapterViewPager; // control viewPager and the adapter

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = findViewById(R.id.viewPager);

        // associate the adapter with view page
        adapterViewPager = new MyPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapterViewPager);
        viewPager.setCurrentItem(1);


        String URL = "https://vision.googleapis.com/v1/images:annotate?key=AIzaSyDXuGj70hx_92Fv29A1XChRFOkjmcuYqSk";
        // testing
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest objectRequest = new JsonObjectRequest(
                Request.Method.POST,
                URL,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.i("Rest Response", response.toString());
                    }

                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("hahaha", error.toString());
            }
        });

        requestQueue.add(objectRequest);
    }

    public static class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        /**
         * @param position
         * @return fragment depending on the position
         */
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    // return fragment clothes
                    return ClothesFragment.newInstance();
                case 1:
                    // return fragment main page
                    return MainFragment.newInstance();
                case 2:
                    // return fragment camera
                    return CameraFragment.newInstance(); // we can pass sth in the bracket to pass data (optional)
            }
            return null;
        }

        /**
         * @return the number of pages within our view page (which is 3)
         */
        @Override
        public int getCount() {
            return 3;
        }
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//    }
}
