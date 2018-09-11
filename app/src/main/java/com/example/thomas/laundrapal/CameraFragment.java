package com.example.thomas.laundrapal;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.storage.StorageScopes;

import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

import static android.provider.ContactsContract.CommonDataKinds.Website.URL;

public class CameraFragment extends Fragment {

    int REQUEST_IMAGE_CAPTURE = 12345;
    ImageView imageView;

    public static CameraFragment newInstance() {
        CameraFragment fragment = new CameraFragment();
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_camera, container, false);

//        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//        Fragment frag = this;
//        /** Pass your fragment reference **/
//        frag.startActivityForResult(intent, REQUEST_IMAGE_CAPTURE); // REQUEST_IMAGE_CAPTURE = 12345
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imageView = getActivity().findViewById(R.id.imageView);
    }

//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (resultCode == Activity.RESULT_OK) {
//            if (requestCode == REQUEST_IMAGE_CAPTURE) {
//                // Do something with imagePath
//
//                HttpTransport httpTransport = new NetHttpTransport();
//                JsonFactory jsonFactory = new JacksonFactory();
//                List<String> scopes = new ArrayList<String>();
//                scopes.add(StorageScopes.DEVSTORAGE_FULL_CONTROL);
//
//                try {
//                    com.google.api.client.auth.oauth2.Credential credential = new GoogleCredential.Builder()
//                            .setTransport(httpTransport)
//                            .setJsonFactory(jsonFactory)
//                            .setServiceAccountId("rahulanilkumar@comp-vision-214408.iam.gserviceaccount.com") //Email
//                            .setServiceAccountPrivateKeyFromP12File(getTempPkc12File())
//                            .setServiceAccountScopes(scopes).build();
//                } catch (GeneralSecurityException e) {
//                    e.printStackTrace();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//
//
//                Bitmap bmp = (Bitmap) data.getExtras().get("data");
//                ByteArrayOutputStream stream = new ByteArrayOutputStream();
//                bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);
//
//
////                 testing
//                RequestQueue requestQueue = Volley.newRequestQueue(getView().getContext());
//                JsonObjectRequest objectRequest = new JsonObjectRequest(
//                        Request.Method.POST,
//                        URL,
//                        null,
//                        new Response.Listener<JSONObject>() {
//                            @Override
//                            public void onResponse(JSONObject response) {
//                                Log.i("Rest Response", response.toString());
//                            }
//
//                        }, new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Log.e("hahaha", error.toString());
//                    }
//                });
//                requestQueue.add(objectRequest);
//
//                // convert byte array to Bitmap
//                byte[] byteArray = stream.toByteArray();
//                Bitmap bitmap = BitmapFactory.decodeByteArray(byteArray, 0,
//                        byteArray.length);
//                imageView.setImageBitmap(bitmap);
//            }
//        }
//    }
//
//
//    private String getStringFromBitmap(Bitmap bitmapPicture) {
//        /*
//         * This functions converts Bitmap picture to a string which can be
//         * JSONified.
//         * */
//        final int COMPRESSION_QUALITY = 100;
//        String encodedImage;
//        ByteArrayOutputStream byteArrayBitmapStream = new ByteArrayOutputStream();
//        bitmapPicture.compress(Bitmap.CompressFormat.PNG, COMPRESSION_QUALITY,
//                byteArrayBitmapStream);
//        byte[] b = byteArrayBitmapStream.toByteArray();
//        encodedImage = Base64.encodeToString(b, Base64.DEFAULT);
//        return encodedImage;
//    }
//
//    private File getTempPkc12File() {
//        try {
//            // xxx.p12 export from google API console
//            InputStream pkc12Stream = getActivity().getResources().getAssets().open("Comp Vision-3bbcdfd72782.p12");
//            File tempPkc12File = File.createTempFile("temp_pkc12_file", "p12");
//            OutputStream tempFileStream = new FileOutputStream(tempPkc12File);
//            int read = 0;
//            byte[] bytes = new byte[1024];
//            while ((read = pkc12Stream.read(bytes)) != -1) {
//                tempFileStream.write(bytes, 0, read);
//            }
//            return tempPkc12File;
//        } catch (Exception e)
//
//        {
//
//            class Local {
//            }
//            ;
//            Log.d("Alkamli", "Sub: " + Local.class.getEnclosingMethod().getName() + " Error code: " + e.getMessage());
//
//        }
//        Log.d("Alkamli", " getTempPkc12File is null");
//        return null;
//    }
}

