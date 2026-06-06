package com.my.rermux.ad.com;

import android.animation.*;
import android.app.*;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.os.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.*;
import org.json.*;

public class CommandsActivity extends AppCompatActivity {
	
	private ArrayList<HashMap<String, Object>> commandsList = new ArrayList<>();
	
	private LinearLayout header;
	private ListView listview_commands;
	private ImageView btn_back;
	private TextView txt_header_title;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.commands);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		header = findViewById(R.id.header);
		listview_commands = findViewById(R.id.listview_commands);
		btn_back = findViewById(R.id.btn_back);
		txt_header_title = findViewById(R.id.txt_header_title);
	}
	
	private void initializeLogic() {
		// 1. استلام العنوان الفرعي (مثل "إدارة الملفات")
		String subTitle = getIntent().getStringExtra("sub_title");
		txt_header_title.setText(subTitle); // التكست في أعلى الصفحة
		
		// 2. قائمة البيانات للأوامر (يجب إنشاء ListMap باسم commandsList)
		commandsList.clear();
		
		if (subTitle != null) {
			if (subTitle.contains("إدارة الملفات") || subTitle.contains("File Management")) {
				
				// إضافة الأمر الأول (ls -la)
				HashMap<String, Object> _cmd1 = new HashMap<>();
				_cmd1.put("cmd_display", "ls -la");
				_cmd1.put("cmd_real", "ls -la");
				_cmd1.put("desc", "عرض كافة الملفات والمجلدات بما في ذلك المخفية");
				commandsList.add(_cmd1);
				
				// إضافة الأمر الثاني (ls -lh)
				HashMap<String, Object> _cmd2 = new HashMap<>();
				_cmd2.put("cmd_display", "ls -lh");
				_cmd2.put("cmd_real", "ls -lh");
				_cmd2.put("desc", "عرض الملفات مع الحجم بتنسيق مفهوم (KB, MB)");
				commandsList.add(_cmd2);
			}
		}
		
		// 3. ربط القائمة بالـ ListView الخاص بالأوامر
		listview_commands.setAdapter(new Listview_commandsAdapter(commandsList));
		
		
	}
	
	public class Listview_commandsAdapter extends BaseAdapter {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Listview_commandsAdapter(ArrayList<HashMap<String, Object>> _arr) {
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
				_view = _inflater.inflate(R.layout.custom_commands, null);
			}
			
			final LinearLayout card_main_layout = _view.findViewById(R.id.card_main_layout);
			final TextView txt_cmd_desc = _view.findViewById(R.id.txt_cmd_desc);
			final LinearLayout layout_top = _view.findViewById(R.id.layout_top);
			final LinearLayout layout_bottom = _view.findViewById(R.id.layout_bottom);
			final ImageView imageview_copy = _view.findViewById(R.id.imageview_copy);
			final View view10 = _view.findViewById(R.id.view10);
			final TextView txt_cmd_view = _view.findViewById(R.id.txt_cmd_view);
			final TextView txt_cmd_real = _view.findViewById(R.id.txt_cmd_real);
			
			// 1. تصميم الجزء العلوي (زوايا علوية فقط)
			android.graphics.drawable.GradientDrawable topGd = new android.graphics.drawable.GradientDrawable();
			topGd.setColor(Color.parseColor("#1E293B"));
			// ترتيب الزوايا: [top-left, top-left, top-right, top-right, bottom-right, bottom-right, bottom-left, bottom-left]
			topGd.setCornerRadii(new float[]{20, 20, 20, 20, 0, 0, 0, 0});
			layout_top.setBackground(topGd);
			
			// 2. تصميم الجزء السفلي (زوايا سفلية فقط)
			android.graphics.drawable.GradientDrawable botGd = new android.graphics.drawable.GradientDrawable();
			botGd.setColor(Color.parseColor("#0F172A"));
			botGd.setCornerRadii(new float[]{0, 0, 0, 0, 20, 20, 20, 20});
			layout_bottom.setBackground(botGd);
			
			// 3. إضافة تأثير النسخ
			final String cmd = commandsList.get((int)_position).get("cmd_real").toString();
			imageview_copy.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					android.content.ClipboardManager cb = (android.content.ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
					cb.setPrimaryClip(android.content.ClipData.newPlainText("cmd", cmd));
					SketchwareUtil.showMessage(getApplicationContext(), "Copied!");
				}
			});
			
			// 4. تعيين النصوص
			txt_cmd_view.setText(commandsList.get((int)_position).get("cmd_display").toString());
			txt_cmd_real.setText(cmd);
			txt_cmd_desc.setText(commandsList.get((int)_position).get("desc").toString());
			
			
			
			return _view;
		}
	}
}