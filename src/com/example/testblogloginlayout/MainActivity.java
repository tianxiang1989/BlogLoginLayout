package com.example.testblogloginlayout;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.opengl.Visibility;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);  
        
       
        setContentView(R.layout.activity_main);  
        
        final LinearLayout img_linearLayout=(LinearLayout) findViewById(R.id.login_linearLayout_img);
        
        final View activityRootView = findViewById(R.id.root_layout);  
        activityRootView.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {  
            private int preHeight = 0;  
            @Override  
            public void onGlobalLayout() {  
                int heightDiff = activityRootView.getRootView().getHeight() - activityRootView.getHeight();  
                Log.d("height differ =", heightDiff+"");
                //在数据相同时，减少发送重复消息。因为实际上在输入法出现时会多次调用这个onGlobalLayout方法。  
                if (preHeight == heightDiff) {  
                    return;  
                }  
                preHeight = heightDiff;  
                if (heightDiff > 200 ) {  
                    Toast.makeText(getApplicationContext(), "keyboard is  shown", Toast.LENGTH_SHORT).show();
                    img_linearLayout.setVisibility(View.GONE);
                } else {  
                    Toast.makeText(getApplicationContext(), "keyboard is hidden ", Toast.LENGTH_SHORT).show();  
                    img_linearLayout.setVisibility(View.VISIBLE);
                }  
            }  
   
        });  
	}
}
