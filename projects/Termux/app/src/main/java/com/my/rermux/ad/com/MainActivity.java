package com.my.rermux.ad.com;

import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.content.*;
import android.content.Intent;
import android.content.SharedPreferences;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.*;
import org.json.*;

public class MainActivity extends AppCompatActivity {
	
	private HashMap<String, Object> pma = new HashMap<>();
	private HashMap<String, Object> map = new HashMap<>();
	private String currentLang = "";
	
	private ArrayList<HashMap<String, Object>> listMap = new ArrayList<>();
	
	private LinearLayout linear4;
	private LinearLayout linear5;
	private LinearLayout linear6;
	private LinearLayout scroll_content;
	private GridView gridview1;
	private ImageView imageview1;
	private TextView textview_title;
	private TextView btn_lang;
	private TextView tab_effects;
	private TextView tab_essentials;
	private TextView tab_games;
	private TextView txt_disclaimer;
	
	private SharedPreferences lang_pref;
	private Intent intent = new Intent();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear4 = findViewById(R.id.linear4);
		linear5 = findViewById(R.id.linear5);
		linear6 = findViewById(R.id.linear6);
		scroll_content = findViewById(R.id.scroll_content);
		gridview1 = findViewById(R.id.gridview1);
		imageview1 = findViewById(R.id.imageview1);
		textview_title = findViewById(R.id.textview_title);
		btn_lang = findViewById(R.id.btn_lang);
		tab_effects = findViewById(R.id.tab_effects);
		tab_essentials = findViewById(R.id.tab_essentials);
		tab_games = findViewById(R.id.tab_games);
		txt_disclaimer = findViewById(R.id.txt_disclaimer);
		lang_pref = getSharedPreferences("lang_pref", Activity.MODE_PRIVATE);
		
		imageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getApplicationContext(), StringActivity.class);
				startActivity(intent);
			}
		});
		
		btn_lang.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				String currentLang = lang_pref.getString("lang", "en");
				if (currentLang.equals("en")) {
					lang_pref.edit().putString("lang", "ar").commit();
				} else {
					lang_pref.edit().putString("lang", "en").commit();
				}
				// Restart Activity
				intent.setClass(getApplicationContext(), MainActivity.class);
				startActivity(intent);
				finish();
				
			}
		});
	}
	
	private void initializeLogic() {
		// 1. تنسيق شريط الحالة (Status Bar)
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
			getWindow().setStatusBarColor(Color.parseColor("#161B2A"));
			getWindow().getDecorView().setSystemUiVisibility(0); 
		}
		
		// 2. التحقق من اللغة وتجهيز القائمة
		String currentLang = lang_pref.getString("lang", "en");
		
		// تفريغ القائمة لمنع التكرار عند العودة للشاشة
		listMap.clear();
		
		if (currentLang.equals("ar")) {
			// --- الإعدادات العربية ---
			getWindow().getDecorView().setLayoutDirection(android.view.View.LAYOUT_DIRECTION_RTL);
			
			textview_title.setText("أساسيات Termux");
			btn_lang.setText("English");
			tab_effects.setText("تأثيرات");
			tab_essentials.setText("أساسيات");
			tab_games.setText("ألعاب");
			txt_disclaimer.setText("هذا التطبيق للأغراض التعليمية فقط. يوفر دروساً وموارد لتعلم واستكشاف قدرات Termux. لا يوجد محتوى في هذا التطبيق يشجع أو يروج لأي أنشطة غير مصرح بها أو ضارة.");
			
			String[] arTitles = {"البرمجة والسكربتات", "استخدام لينكس الأساسي", "إدارة الحزم", "الشبكات والاتصال عن بُعد", "دمج واجهة Termux API", "الخوادم", "واجهة لينكس الرسومية", "إعداد Termux المخصص", "تشغيل Docker", "مراقبة النظام"};
			
			for (int i = 0; i < arTitles.length; i++) {
				java.util.HashMap<String, Object> _map = new java.util.HashMap<>();
				_map.put("title", arTitles[i]);
				_map.put("icon", String.valueOf(i));
				listMap.add(_map);
			}
		} else {
			// --- الإعدادات الإنجليزية ---
			getWindow().getDecorView().setLayoutDirection(android.view.View.LAYOUT_DIRECTION_LTR);
			
			textview_title.setText("Termux Essentials");
			btn_lang.setText("عربي");
			tab_effects.setText("Effects");
			tab_essentials.setText("Essentials");
			tab_games.setText("Games");
			txt_disclaimer.setText("This app is for educational purposes only. It provides tutorials and resources for learning and exploring Termux capabilities.");
			
			String[] enTitles = {"Programming and Scripting", "Basic Linux Usage", "Package Management", "Networking and Remote...", "Termux API Integration", "Servers", "Linux GUI on Termux", "Custom Termux Setup", "Running Docker", "System Monitoring"};
			
			for (int i = 0; i < enTitles.length; i++) {
				java.util.HashMap<String, Object> _map = new java.util.HashMap<>();
				_map.put("title", enTitles[i]);
				_map.put("icon", String.valueOf(i));
				listMap.add(_map);
			}
		}
		
		// 3. ربط القائمة بالـ GridView وتنسيقه
		gridview1.setAdapter(new Gridview1Adapter(listMap));
		gridview1.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0, 1.0f));
		
		int spacing = (int) android.util.TypedValue.applyDimension(android.util.TypedValue.COMPLEX_UNIT_DIP, 12, getResources().getDisplayMetrics());
		gridview1.setHorizontalSpacing(spacing);
		gridview1.setVerticalSpacing(spacing);
		gridview1.setNumColumns(2);
		gridview1.setStretchMode(GridView.STRETCH_COLUMN_WIDTH);
		gridview1.setNestedScrollingEnabled(true);
		
		// 4. تطبيق الخطوط (تأكد من وجود ملف الخط في Assets)
		try {
			final Typeface selectedFont = Typeface.createFromAsset(getAssets(), "fonts/airoplaybold.ttf");
			
			class FontHelper {
				public void applyFont(View view, Typeface tf) {
					if (view instanceof ViewGroup) {
						ViewGroup vg = (ViewGroup) view;
						for (int i = 0; i < vg.getChildCount(); i++) applyFont(vg.getChildAt(i), tf);
					} else if (view instanceof TextView) {
						((TextView) view).setTypeface(tf);
					}
				}
			}
			new FontHelper().applyFont(linear4, selectedFont);
		} catch (Exception e) {}
		
		// 5. تنسيق نص إخلاء المسؤولية (Disclaimer)
		txt_disclaimer.setBackgroundColor(Color.TRANSPARENT);
		txt_disclaimer.setTextColor(Color.parseColor("#D1D5DB"));
		txt_disclaimer.setPadding(30, 20, 30, 20);
		txt_disclaimer.setLineSpacing(1.2f, 1.2f);
		
		// 6. تنسيق ألوان التبويبات (Tabs)
		tab_essentials.setTextColor(Color.WHITE); 
		tab_effects.setTextColor(Color.parseColor("#A0AAB5"));
		tab_games.setTextColor(Color.parseColor("#A0AAB5"));
		
		
	}
	
	public class Gridview1Adapter extends BaseAdapter {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Gridview1Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public int getCount() {
			return _data.size();
		}
		
		@Override
		public HashMap<String, Object> getItem(int _index) {
			return _data.get(_index);
		}
		
		@Override
		public long getItemId(int _index) {
			return _index;
		}
		
		@Override
		public View getView(final int _position, View _v, ViewGroup _container) {
			LayoutInflater _inflater = getLayoutInflater();
			View _view = _v;
			if (_view == null) {
				_view = _inflater.inflate(R.layout.card_item, null);
			}
			
			final LinearLayout card_bg = _view.findViewById(R.id.card_bg);
			final ImageView img_icon = _view.findViewById(R.id.img_icon);
			final TextView txt_title = _view.findViewById(R.id.txt_title);
			
			// 1. تصميم الخلفية مع تأثير اللمس (Ripple)
			android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
			gd.setColor(Color.parseColor("#1E293B")); 
			gd.setCornerRadius(20f); 
			gd.setStroke(2, Color.parseColor("#334155"));
			
			android.content.res.ColorStateList clrb = new android.content.res.ColorStateList(
			new int[][]{new int[]{}}, 
			new int[]{Color.parseColor("#334155")}
			);
			android.graphics.drawable.RippleDrawable rippleDrawable = new android.graphics.drawable.RippleDrawable(clrb, gd, null);
			
			// 2. تطبيق الخلفية على الحاوية
			card_bg.setBackground(rippleDrawable);
			card_bg.setClickable(true);
			card_bg.setFocusable(true);
			
			// 3. كتابة النص وتغيير الخط
			txt_title.setText(listMap.get((int)_position).get("title").toString());
			txt_title.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/airoplaybold.ttf"));
			
			// 4. برمجة حدث النقر المباشر لحل مشكلة عدم الانتقال
			card_bg.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Intent i = new Intent();
					i.setClass(getApplicationContext(), DetailsActivity.class);
					// نأخذ القيمة بناءً على الموقع _position
					i.putExtra("title", listMap.get((int)_position).get("title").toString());
					startActivity(i);
				}
			});
			
			// 5. معالجة الأيقونات
			try {
				String iconIndex = listMap.get((int)_position).get("icon").toString();
				int imgId = getResources().getIdentifier("icon_" + iconIndex, "drawable", getPackageName());
				if (imgId != 0) {
					img_icon.setImageResource(imgId);
					img_icon.setVisibility(View.VISIBLE);
				} else {
					img_icon.setVisibility(View.GONE);
				}
			} catch (Exception e) {
				img_icon.setVisibility(View.GONE);
			}
			
			
			
			return _view;
		}
	}
}