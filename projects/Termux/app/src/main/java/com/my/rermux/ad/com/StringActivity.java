package com.my.rermux.ad.com;

import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.content.*;
import android.content.Intent;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.net.Uri;
import android.os.*;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import java.io.*;
import java.io.InputStream;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import org.json.*;

public class StringActivity extends AppCompatActivity {
	
	private String e = "";
	
	private LinearLayout header;
	private LinearLayout linear1;
	private LinearLayout linear6;
	private LinearLayout linear5;
	private LinearLayout linear7;
	private LinearLayout card_bg;
	private ImageView btn_back;
	private TextView txt_header_title;
	private TextView textview1;
	private ImageView imageview1;
	private ImageView imageview3;
	private TextView textview3;
	private ImageView imageview4;
	private ImageView imageview8;
	private TextView textview2;
	private ImageView imageview9;
	private TextView textview4;
	private ImageView imageview10;
	private ImageView img_icon;
	private TextView txt_title;
	
	private Intent ad = new Intent();
	private Intent ey = new Intent();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.string);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		header = findViewById(R.id.header);
		linear1 = findViewById(R.id.linear1);
		linear6 = findViewById(R.id.linear6);
		linear5 = findViewById(R.id.linear5);
		linear7 = findViewById(R.id.linear7);
		card_bg = findViewById(R.id.card_bg);
		btn_back = findViewById(R.id.btn_back);
		txt_header_title = findViewById(R.id.txt_header_title);
		textview1 = findViewById(R.id.textview1);
		imageview1 = findViewById(R.id.imageview1);
		imageview3 = findViewById(R.id.imageview3);
		textview3 = findViewById(R.id.textview3);
		imageview4 = findViewById(R.id.imageview4);
		imageview8 = findViewById(R.id.imageview8);
		textview2 = findViewById(R.id.textview2);
		imageview9 = findViewById(R.id.imageview9);
		textview4 = findViewById(R.id.textview4);
		imageview10 = findViewById(R.id.imageview10);
		img_icon = findViewById(R.id.img_icon);
		txt_title = findViewById(R.id.txt_title);
		
		linear1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		btn_back.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				ad.setClass(getApplicationContext(), MainActivity.class);
				startActivity(ad);
			}
		});
		
		textview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				String apk = "";
				String uri = (getApplicationContext().getPackageName());
				
				try {
					android.content.pm.PackageInfo pi = getPackageManager().getPackageInfo(uri, android.content.pm.PackageManager.GET_ACTIVITIES);
					
					apk = pi.applicationInfo.publicSourceDir;
				} catch (Exception e) {
					showMessage(e.toString());
				}
				Intent iten = new Intent(Intent.ACTION_SEND);
				iten.setType("*/*");
				iten.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(new java.io.File(apk)));
				
				startActivity(Intent.createChooser(iten, ""));
			}
		});
		
		textview4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				ad.setAction(Intent.ACTION_VIEW);
				ad.setData(Uri.parse("https://t.me/progmamar"));
				startActivity(ad);
			}
		});
	}
	
	private void initializeLogic() {
	}
	
	
	public void _ArabWareShareStart () {
		/**/
		String apk = getApplicationContext().getPackageName().concat(".apk");
		String uri = (getApplicationContext().getPackageName());
		
		try {
			android.content.pm.PackageInfo pi = getPackageManager().getPackageInfo(uri, android.content.pm.PackageManager.GET_ACTIVITIES);
			
			apk = pi.applicationInfo.publicSourceDir;
		} catch (Exception e) {
			showMessage(e.toString());
		}
		Intent iten = new Intent(Intent.ACTION_SEND);
		iten.setType("*/*");
		iten.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(new java.io.File(apk)));
		
		startActivity(Intent.createChooser(iten, ""));
	}
	
}