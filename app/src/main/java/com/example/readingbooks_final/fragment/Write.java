package com.example.readingbooks_final.fragment;

import static com.example.readingbooks_final.activity.Write_tab2.AUTHOR;
import static com.example.readingbooks_final.activity.Write_tab2.CATEGORY;
import static com.example.readingbooks_final.activity.Write_tab2.COVER;
import static com.example.readingbooks_final.activity.Write_tab2.DESCRIPTION;
import static com.example.readingbooks_final.activity.Write_tab2.STATUS;
import static com.example.readingbooks_final.activity.Write_tab2.TITLE;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.example.readingbooks_final.MainActivity;
import com.example.readingbooks_final.R;
import com.example.readingbooks_final.activity.ListBook;
import com.example.readingbooks_final.activity.Write_tab2;


public class Write extends Fragment {

    private TextView create_story, edit_story;

    private View view;
    private MainActivity mainActivity;
    private static final int Write_Frag=1;


    private int current =Write_Frag;





    public Write() {
        // Required empty public constructor
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         view = inflater.inflate(R.layout.fragment_write, container, false);
        initView();
        createStory();
        editStory();
    return view;
    }

    private void initView(){
        create_story= view.findViewById(R.id.create_story);
        edit_story=view.findViewById(R.id.edit_story);


    }

    private void createStory(){
        create_story.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.btn_click_anim));


                Intent intent = new Intent(view.getContext(), Write_tab2.class);
               // startActivity(intent);
                startActivityForResult.launch(intent);



            }
        });
    }

    private void editStory(){
        edit_story.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.btn_click_anim));
                    //Hiển thị trang chứa truyện vừa tạo
                    openListBook();
            }
        });
    }

    final ActivityResultLauncher<Intent> startActivityForResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
//
                    if(result.getResultCode() ==Activity.RESULT_OK) {

                        Intent intent = result.getData();
                        if (intent==null){
                            return;
                        }
                       // String newData = intent.getStringExtra("data back");

                        String title_reply = intent.getStringExtra(TITLE);
                        String author_reply = intent.getStringExtra(AUTHOR);
                        String category_reply = intent.getStringExtra(CATEGORY);
                        String status_reply = intent.getStringExtra(STATUS);
                        String description_reply = intent.getStringExtra(DESCRIPTION);
                        String cover_reply = intent.getStringExtra(COVER);
//                        String title_content = intent.getStringExtra(TITLE_CHAPTER);
//                        String chap_content = intent.getStringExtra(CONTENT_CHAPTER);





                    }
                }
            });

//    private void replaceFragment(Fragment fragment, int position) {
//       FragmentManager getSupportManager =  mainActivity.getSupportFragmentManager();
//        FragmentTransaction transaction=getSupportManager.beginTransaction();
//        transaction.replace(R.id.content_tool,fragment, fragment.getClass().getName());
//        transaction.commit();
//    }
//    public void displayView(int position){
//        switch (position){
//            case 0:
//                replaceFragment(new ListBook(), position);
//                break;
//
//
//
//        }
//    }

//    public  void Open_List(){
//        if (current!=List_Frag){
//            displayView(0);
//            current=List_Frag;
//        }
//
//    }

    private void openListBook(){
        Intent intent = new Intent(getActivity(), ListBook.class);
        startActivity(intent);
    }

}