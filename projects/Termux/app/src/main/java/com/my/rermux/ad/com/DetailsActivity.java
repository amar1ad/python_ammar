package com.my.rermux.ad.com;

import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.content.*;
import android.content.SharedPreferences;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.os.*;
import android.os.Bundle;
import android.provider.Settings.Secure;
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

public class DetailsActivity extends AppCompatActivity {
	
	private HashMap<String, Object> i1 = new HashMap<>();
	private HashMap<String, Object> i2 = new HashMap<>();
	private HashMap<String, Object> i3 = new HashMap<>();
	private HashMap<String, Object> itemData = new HashMap<>();
	private String categoryTitle = "";
	private String t = "";
	private String currentLang = "";
	
	private ArrayList<HashMap<String, Object>> detailsList = new ArrayList<>();
	
	private LinearLayout linear11;
	private ListView listview_details;
	private ImageView btn_back;
	private TextView txt_detail_title;
	private View view12;
	
	private SharedPreferences lang_pref;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.details);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear11 = findViewById(R.id.linear11);
		listview_details = findViewById(R.id.listview_details);
		btn_back = findViewById(R.id.btn_back);
		txt_detail_title = findViewById(R.id.txt_detail_title);
		view12 = findViewById(R.id.view12);
		lang_pref = getSharedPreferences("lang_pref", Activity.MODE_PRIVATE);
	}
	
	private void initializeLogic() {
		// 1. استلام البيانات واللغة
		String categoryTitle = getIntent().getStringExtra("title");
		String currentLang = getSharedPreferences("lang_pref", MODE_PRIVATE).getString("lang", "en");
		
		// تعيين العنوان في أعلى الشاشة
		if (categoryTitle != null) {
			txt_detail_title.setText(categoryTitle);
		}
		
		// 2. تفريغ القائمة قبل البدء
		
		// تفريغ القائمة قبل البدء لضمان عدم تكرار البيانات
		detailsList.clear();
		
		if (categoryTitle != null) {
			String t = categoryTitle.toLowerCase();
			boolean isAr = currentLang.equals("ar");
			
			// ==========================================
			// 1. استخدام لينكس الأساسي (Basic Linux Usage)
			// ==========================================
			if (t.contains("basic linux") || t.contains("أساسي") || t.contains("linux") || t.contains("لينكس")) {
				// العناصر الأصلية
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "إدارة الملفات (ls, cd, cp)" : "File Management"); _m.put("desc", isAr ? "اكتشف أسرار الإدارة الفعالة للملفات والمجلدات!" : "Unlock the secrets of efficient file and directory management!"); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "تحرير النصوص (nano, vim)" : "Text Editing"); _m.put("desc", isAr ? "احتراف تحرير النصوص كالمحترفين في الشيل!" : "Master text editing like a pro with nano and vim!"); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "عرض الملفات (cat, less)" : "Viewing Files"); _m.put("desc", isAr ? "أوامر قوية لإلقاء نظرة خاطفة على محتويات الملفات." : "Discover powerful commands to peek into file contents!"); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "إدارة الأذونات (chmod)" : "Permissions Management"); _m.put("desc", isAr ? "أحكم سيطرتك؛ احترف فن إدارة أذونات الملفات!" : "Take control: Master the art of file permissions management!"); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "استهلاك القرص (du, df)" : "Disk Usage"); _m.put("desc", isAr ? "اكشف المساحات المستهلكة واستعد مساحة التخزين." : "Uncover hidden disk space hogs and reclaim your storage!"); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "إدارة العمليات (top, kill)" : "Process Management"); _m.put("desc", isAr ? "التحكم في العمليات الجارية مثل مديري الأنظمة." : "Control running processes like a seasoned administrator!"); detailsList.add(_m); }
				
				// عناصر إضافية من الصور
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "معلومات النظام" : "System Information"); _m.put("desc", isAr ? "احصل على معلومات مفصلة عن نظامك مثل لم يسبق لها مثيل." : "Get insider info about your system like never before."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "إدارة الشبكة" : "Network Management"); _m.put("desc", isAr ? "إدارة الواجهات والإعدادات بسهولة." : "Manage interfaces and settings with ease."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "إدارة الحزم" : "Package Management"); _m.put("desc", isAr ? "تثبيت وتحديث وإزالة الحزم بكفاءة." : "Install, update, and remove packages efficiently."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "إدارة المستخدمين" : "User Management"); _m.put("desc", isAr ? "إنشاء وإدارة حسابات المستخدمين للتشغيل السلس." : "Create and manage user accounts for seamless operation."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "متغيرات البيئة" : "Environment Variables"); _m.put("desc", isAr ? "كشف أسرار متغيرات البيئة للمستخدمين المتقدمين." : "Unravel the mysteries of environment variables for advanced users."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "الضغط والأرشفة" : "Compression and Archiving"); _m.put("desc", isAr ? "تعلم الأوامر الأساسية لضغط وأرشفة الملفات." : "Learn essential commands for compressing and archiving files."); detailsList.add(_m); }
			}
			
			// ==========================================
			// 2. البرمجة والسكربتات (Programming and Scripting)
			// ==========================================
			else if (t.contains("programming") || t.contains("scripting") || t.contains("برمجة")) {
				// العناصر الأصلية
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "بيئة Python" : "Python Programming"); _m.put("desc", isAr ? "إعداد لغة بايثون وتثبيت المكتبات عبر pip." : "Setup Python environment and manage libraries via pip."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "سكربتات Bash" : "Bash Scripting"); _m.put("desc", isAr ? "أتمتة المهام المتكررة باستخدام سكربتات الصدفة." : "Automate repetitive tasks with smart shell scripts."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "التحكم بالإصدارات (Git)" : "Version Control (Git)"); _m.put("desc", isAr ? "إدارة الكود الخاص بك والمشاركة في المشاريع." : "Manage your codebase and collaborate using Git."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "تطوير Node.js" : "Node.js Development"); _m.put("desc", isAr ? "تشغيل سيرفرات جافاسكريبت وتطوير الويب الحديث." : "Run JS servers and modern web development tools."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "محررات الكود المتقدمة" : "Advanced Code Editors"); _m.put("desc", isAr ? "إعداد Micro أو Vim ليصبح بيئة تطوير كاملة." : "Setup Micro or Vim as a full-featured terminal IDE."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "إدارة البيئات (pipenv, venv)" : "Environment Management"); _m.put("desc", isAr ? "اعزل تبعيات مشاريعك لتجنب التعارضات." : "Isolate project dependencies to avoid conflicts."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "أدوات البناء (Make, CMake)" : "Build Tools"); _m.put("desc", isAr ? "أتمتة عملية بناء المشاريع الكبيرة." : "Automate the build process for large projects."); detailsList.add(_m); }
				
				// عناصر إضافية من الصور
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "تثبيت لغات البرمجة" : "Install Languages"); _m.put("desc", isAr ? "تثبيت لغات مختلفة مثل Python, Ruby, Node.js, Go والمزيد." : "Install various programming languages like Python, Ruby, Node.js, Go, and more."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "تشغيل السكربتات" : "Run Scripts"); _m.put("desc", isAr ? "تنفيذ سكربتات بلغات متعددة بما فيها Bash, Python, Ruby, Node.js, Perl." : "Execute scripts written in different languages, including Python, Bash, Ruby, Node.js, and Perl."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "تجميع البرامج" : "Compiling Programs"); _m.put("desc", isAr ? "تجميع برامج C, C++, Java باستخدام GCC, G++, OpenJDK." : "Compile programs written in C, C++, and Java using GCC, G++, and OpenJDK."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "سكربتات الأتمتة" : "Automation Scripts"); _m.put("desc", isAr ? "إنشاء وجدولة سكربتات الأتمتة باستخدام Bash, Cron, at." : "Create and schedule automation scripts using Bash, Cron, and at."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "أدوات التصحيح" : "Debugging Tools"); _m.put("desc", isAr ? "استخدم أدوات مثل echo, set -x, trap, printf, strace لتصحيح الأخطاء." : "Utilize debugging tools like echo, set -x, trap, printf, and strace to identify and fix errors."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "لغات السكربت (Python, Bash, Ruby)" : "Scripting Languages"); _m.put("desc", isAr ? "تعلم أساسيات كتابة السكربتات في Python, Bash, Ruby." : "Learn the basics of scripting in Python, Bash, and Ruby."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "إعداد البيئة" : "Environment Setup"); _m.put("desc", isAr ? "تثبيت الحزم الأساسية وتكوين متغيرات البيئة وأدوات اللغة." : "Set up Termux environment by installing essential packages and configuring environment variables."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "مديرو الحزم (pip, npm)" : "Package Managers"); _m.put("desc", isAr ? "إدارة حزم Python و Node.js باستخدام pip و npm." : "Manage packages for Python and Node.js using pip and npm."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "البيئات الافتراضية (venv, virtualenv)" : "Virtual Environments"); _m.put("desc", isAr ? "عزل تبعيات المشاريع باستخدام venv و virtualenv." : "Isolate project dependencies using venv and virtualenv."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "محررات النصوص (nano, vim, emacs)" : "Text Editors"); _m.put("desc", isAr ? "تعلم استخدام nano, vim, emacs لتحرير النصوص والشفرة." : "Learn to use nano, vim, and emacs for code editing and file manipulation."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "بيئات التطوير المتكاملة (VS Code, PyCharm)" : "IDEs"); _m.put("desc", isAr ? "إعداد واستخدام VS Code و PyCharm للتطوير." : "Set up and use Visual Studio Code and PyCharm for development."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "تمييز الصيغة" : "Syntax Highlighting"); _m.put("desc", isAr ? "تفعيل وتخصيص تمييز الصيغة في nano, vim, emacs لقراءة أفضل." : "Enable and customize syntax highlighting in nano, vim, and emacs for improved code readability."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "فحص الكود" : "Code Linting"); _m.put("desc", isAr ? "تحسين جودة الكود باستخدام Flake8, ESLint, ShellCheck." : "Improve code quality with linting tools like Flake8, ESLint, and ShellCheck."); detailsList.add(_m); }
			}
			
			// ==========================================
			// 3. إدارة الحزم (Package Management)
			// ==========================================
			else if (t.contains("package") || t.contains("حزم")) {
				// العناصر الأصلية
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "تحديث النظام (pkg upgrade)" : "System Upgrade"); _m.put("desc", isAr ? "تحديث قائمة الحزم لضمان استقرار الأدوات." : "Update package lists and upgrade tools for stability."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "البحث عن الأدوات" : "Search for Tools"); _m.put("desc", isAr ? "كيفية العثور على الأدوات المخفية في مستودعات تيرموكس." : "Find hidden gems in Termux repositories using search."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "تنظيف المخلفات (pkg clean)" : "Cleanup Storage"); _m.put("desc", isAr ? "إزالة ملفات الكاش والحزم غير المستخدمة." : "Remove cache files and unused package dependencies."); detailsList.add(_m); }
				
				// عناصر إضافية من الصور
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "تثبيت الحزم (pkg install)" : "Install Packages"); _m.put("desc", isAr ? "تثبيت حزم برمجية جديدة من مستودعات تيرموكس." : "Install new software packages from Termux repositories."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "تحديث قائمة الحزم (apt update)" : "Update Package List"); _m.put("desc", isAr ? "تحديث قائمة الحزم المتاحة وإصداراتها." : "Refresh the list of available packages and their versions."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "ترقية الحزم المثبتة (apt upgrade)" : "Upgrade Installed Packages"); _m.put("desc", isAr ? "ترقية الحزم المثبتة لأحدث إصداراتها." : "Upgrade installed packages to their latest versions."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "إزالة الحزم (pkg uninstall)" : "Remove Packages"); _m.put("desc", isAr ? "إزالة الحزم غير المرغوب فيها لتوفير مساحة التخزين." : "Uninstall unwanted packages to free up storage space."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "البحث عن الحزم (pkg search)" : "Search for Packages"); _m.put("desc", isAr ? "البحث عن حزم برمجية باستخدام كلمات مفتاحية." : "Find available software packages using keywords."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "ملفات التهيئة (nginx.conf, .bashrc)" : "Configuration Files"); _m.put("desc", isAr ? "تخصيص سلوك البرامج عن طريق تحرير ملفات التهيئة." : "Customize software behavior by editing configuration files."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "تنظيف الحزم غير المستخدمة (apt autoremove)" : "Clean Unused Packages"); _m.put("desc", isAr ? "إزالة الحزم التي لم تعد ضرورية." : "Remove packages that are no longer needed."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "بناء الحزم من المصدر" : "Build Packages from Source"); _m.put("desc", isAr ? "تجميع وتثبيت البرامج مباشرة من شيفرتها المصدرية." : "Compile and install software directly from its source code."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "استخدام حزم Snap" : "Using Snap Packages"); _m.put("desc", isAr ? "تثبيت وإدارة حزم Snap المستقلة." : "Install and manage self-contained Snap packages."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "إدارة المستودعات" : "Managing Repositories"); _m.put("desc", isAr ? "إضافة أو إزالة أو تحديث مصادر البرامج في تيرموكس." : "Add, remove, or update software sources in Termux."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "الرجوع إلى إصدار سابق" : "Rollback Packages"); _m.put("desc", isAr ? "الرجوع إلى الإصدارات السابقة من الحزم (دعم محدود)." : "Revert to previous versions of packages (limited support)."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "تثبيت من AUR" : "Install from AUR"); _m.put("desc", isAr ? "بناء وتثبيت حزم من مستودع AUR." : "Build and install packages from the Arch User Repository."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "إصدارات الحزم" : "Package Versioning"); _m.put("desc", isAr ? "فهم وإدارة إصدارات الحزم لتتبع التغييرات." : "Understand and manage package versions to track changes."); detailsList.add(_m); }
			}
			
			// ==========================================
			// 4. الشبكات والاتصال (Networking)
			// ==========================================
			else if (t.contains("networking") || t.contains("شبكات") || t.contains("اتصال")) {
				// العناصر الأصلية
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "الوصول عبر SSH" : "Remote Access (SSH)"); _m.put("desc", isAr ? "التحكم في الأجهزة البعيدة ونقل الملفات بأمان." : "Securely control remote machines and transfer files."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "فحص الشبكة (Nmap)" : "Network Scanning"); _m.put("desc", isAr ? "تحليل الأجهزة المتصلة والمنافذ المفتوحة." : "Discover hosts and scan open ports in your network."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "أدوات التحميل (Curl/Wget)" : "Request Tools"); _m.put("desc", isAr ? "التفاعل مع واجهات البرمجة وتحميل الملفات." : "Interact with APIs and download data from URLs."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "نقل الملفات (SCP, rsync)" : "File Transfer"); _m.put("desc", isAr ? "انقل الملفات بأمان بين الأجهزة." : "Securely transfer files between devices."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "أدوات الشبكة (Netcat, tcpdump)" : "Network Utilities"); _m.put("desc", isAr ? "تحليل حركة المرور واختبار الاتصالات." : "Analyze traffic and test connectivity."); detailsList.add(_m); }
				
				// عناصر إضافية من الصور
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "الاتصال الآمن (SSH)" : "SSH (Secure Shell)"); _m.put("desc", isAr ? "الوصول الآمن إلى الأنظمة البعيدة عبر شبكات غير آمنة." : "Securely access remote systems over unsecured networks."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "فحص الشبكة (nmap)" : "Network Scanning (nmap)"); _m.put("desc", isAr ? "اكتشاف الخدمات والثغرات على الشبكة." : "Discover hosts, services, and vulnerabilities on a network."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "نقل الملفات الآمن (scp, rsync)" : "Secure File Transfer"); _m.put("desc", isAr ? "نقل الملفات بأمان بين المضيفين." : "Securely transfer files between hosts using SCP and Rsync."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "سطح المكتب البعيد (VNC)" : "Remote Desktop (VNC)"); _m.put("desc", isAr ? "التحكم في جهاز كمبيوتر عن بُعد باستخدام VNC." : "Control a computer remotely using VNC for graphical access."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "إعداد VPN (OpenVPN, WireGuard)" : "VPN Setup"); _m.put("desc", isAr ? "إنشاء اتصالات VPN آمنة." : "Establish secure VPN connections with OpenVPN or WireGuard."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "توجيه المنافذ" : "Port Forwarding"); _m.put("desc", isAr ? "إعادة توجيه حركة الشبكة من منفذ إلى آخر." : "Redirect network traffic from one port to another."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "تكوين الجدار الناري" : "Firewall Configuration"); _m.put("desc", isAr ? "تكوين وإدارة قواعد الجدار الناري باستخدام IPTables." : "Configure and manage firewall rules using IPTables."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "استكشاف مشاكل الشبكة (ping, traceroute)" : "Network Troubleshooting"); _m.put("desc", isAr ? "تشخيص وحل مشاكل الاتصال بالشبكة." : "Diagnose and resolve network connectivity issues."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "إدارة Wi-Fi" : "Wi-Fi Management"); _m.put("desc", isAr ? "إدارة اتصالات Wi-Fi والمسح والاتصال باستخدام أوامر Termux." : "Manage Wi-Fi connections, scan for networks, and connect using Termux commands."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "تكوين البروكسي" : "Proxy Configuration"); _m.put("desc", isAr ? "توجيه حركة الإنترنت عبر خادم بروكسي." : "Route internet traffic through a proxy server."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "تنفيذ الأوامر عن بُعد" : "Remote Command Execution"); _m.put("desc", isAr ? "تنفيذ أوامر على خوادم أو أجهزة بعيدة عبر SSH." : "Execute commands on remote servers or devices via SSH."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "DNS الديناميكي" : "Dynamic DNS"); _m.put("desc", isAr ? "استخدام DNS ديناميكي للوصول إلى الأجهزة ذات العناوين المتغيرة." : "Use Dynamic DNS to access devices with dynamic IP addresses."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "إدارة عناوين IP" : "IP Address Management"); _m.put("desc", isAr ? "إدارة عناوين IP وتكوين DHCP وتعيين عناوين ثابتة." : "Manage IP addresses, configure DHCP, and assign static IPs."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "بروتوكولات الشبكة" : "Network Protocols"); _m.put("desc", isAr ? "فهم واستخدام TCP و UDP لاحتياجات الاتصال المختلفة." : "Understand and utilize TCP and UDP for different network communication needs."); detailsList.add(_m); }
			}
			
			// ==========================================
			// 5. واجهة Termux API (System Integration)
			// ==========================================
			else if (t.contains("api") || t.contains("واجهة")) {
				// العناصر الأصلية
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "إشعارات النظام" : "System Notifications"); _m.put("desc", isAr ? "إرسال تنبيهات لهاتف أندرويد من السكربتات." : "Send Android notifications directly from scripts."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "إدارة البطارية والحساسات" : "Battery & Sensors"); _m.put("desc", isAr ? "قراءة بيانات المستشعرات والبطارية برمجياً." : "Programmatically read sensor and battery data."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "التحكم في الكليب بورد" : "Clipboard Access"); _m.put("desc", isAr ? "نسخ ولصق النصوص بين تيرموكس وتطبيقات الهاتف." : "Copy and paste text between Termux and Android apps."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "الاهتزاز والضوء" : "Vibration & Torch"); _m.put("desc", isAr ? "التحكم في الاهتزاز والفلاش عبر الأوامر." : "Control vibration and flashlight via commands."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "إدارة المكالمات والرسائل" : "Calls & SMS"); _m.put("desc", isAr ? "إرسال رسائل وإجراء مكالمات من الطرفية." : "Send messages and make calls from the terminal."); detailsList.add(_m); }
				
				// عناصر إضافية من الصور
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "معلومات الجهاز (termux-battery-status)" : "Device Information"); _m.put("desc", isAr ? "الوصول إلى معلومات مفصلة عن حالة بطارية جهاز أندرويد." : "Access detailed information about your Android device's battery status."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "أوامر الرسائل النصية (termux-sms-list, termux-sms-send)" : "SMS Commands"); _m.put("desc", isAr ? "إدارة وإرسال رسائل SMS برمجياً من Termux." : "Manage and send SMS messages programmatically from Termux."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "GPS والموقع (termux-location)" : "GPS and Location"); _m.put("desc", isAr ? "استرجاع واستخدام بيانات الموقع في الوقت الفعلي." : "Retrieve and utilize real-time GPS location data."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "التحكم في الاهتزاز والفلاش (termux-vibrate, termux-torch)" : "Vibration & Flashlight Control"); _m.put("desc", isAr ? "التحكم في اهتزاز الجهاز والفلاش للإشعارات." : "Control device vibration and flashlight for notifications."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "الوصول إلى حساسات الجهاز (termux-sensor)" : "Accessing Device Sensors"); _m.put("desc", isAr ? "الوصول إلى بيانات حساسات الجهاز مثل التسارع والجيروسكوب." : "Access and utilize data from various device sensors like accelerometer and gyroscope."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "الوصول إلى الحافظة (termux-clipboard-get, termux-clipboard-set)" : "Clipboard Access"); _m.put("desc", isAr ? "التفاعل مع حافظة أندرويد للحصول على النص وتعيينه." : "Interact with the Android clipboard to get and set text content."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "الوصول إلى الوسائط (termux-media-scan)" : "Media Access"); _m.put("desc", isAr ? "فحص وتحديث قاعدة بيانات الوسائط للجهاز." : "Scan and update the device's media database."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "الوصول إلى الشبكة (termux-internet-status)" : "Network Access"); _m.put("desc", isAr ? "التحقق من حالة الاتصال بالإنترنت من Termux." : "Check the internet connectivity status of your Android device."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "إدارة الإشعارات (termux-notification)" : "Notification Management"); _m.put("desc", isAr ? "إنشاء وتحديث وإدارة إشعارات أندرويد من Termux." : "Create, update, and manage Android notifications directly from Termux."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "الوصول إلى الطرفية (termux-open, termux-open-url)" : "Terminal Access"); _m.put("desc", isAr ? "فتح الملفات وعناوين URL من محطة Termux باستخدام التطبيقات المرتبطة." : "Open files and URLs from the Termux terminal using associated applications."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "إدارة Wi-Fi (termux-wifi-status)" : "Wi-Fi Management"); _m.put("desc", isAr ? "التحقق من حالة اتصال Wi-Fi وإدارة شبكات Wi-Fi من Termux." : "Check Wi-Fi connection status and manage Wi-Fi networks from Termux."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "مراقبة حالة البطارية" : "Battery Status Monitoring"); _m.put("desc", isAr ? "مراقبة مستويات البطارية وأتمتة الإجراءات بناءً على حالتها." : "Monitor battery levels and automate actions based on battery status."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "أتمتة تعتمد على الموقع" : "Location-based Automation"); _m.put("desc", isAr ? "أتمتة المهام بناءً على موقع الجهاز باستخدام بيانات GPS." : "Automate tasks based on your device's location using GPS data."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "استخدام Termux في تطبيقات أندرويد" : "Using Termux in Android Apps"); _m.put("desc", isAr ? "دمج Termux مع تطبيقات أندرويد للوصول إلى وظائف سطر الأوامر وحزم لينكس." : "Integrate Termux with Android applications to access command-line functionalities and Linux packages."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "التكامل مع التطبيقات الأخرى" : "Integrating with Other Apps"); _m.put("desc", isAr ? "ربط Termux مع تطبيقات أندرويد الأخرى لتبادل البيانات وتعزيز الوظائف." : "Connect Termux with other Android apps for data exchange and enhanced functionality."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "مستمعات الأحداث لأوامر API" : "Event Listeners for API Commands"); _m.put("desc", isAr ? "إعداد مستمعات الأحداث لتشغيل السكربتات بناءً على أحداث النظام أو التطبيق." : "Set up event listeners to trigger scripts based on system or application events."); detailsList.add(_m); }
			}
			
			// ==========================================
			// 6. الخوادم (Servers)
			// ==========================================
			else if (t.contains("server") || t.contains("خوادم")) {
				// العناصر الأصلية
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "خادم الويب Apache/Nginx" : "Web Servers"); _m.put("desc", isAr ? "استضافة مواقع الويب وتطبيقاتك محلياً." : "Host websites and your web apps locally on Android."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "قواعد بيانات MariaDB" : "MariaDB / MySQL"); _m.put("desc", isAr ? "إعداد محرك قواعد بيانات SQL متكامل." : "Setup and manage a full SQL database engine."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "خادم الملفات (SFTP)" : "SFTP File Server"); _m.put("desc", isAr ? "مشاركة ملفاتك مع الأجهزة الأخرى عبر الشبكة." : "Share files with other devices over your network."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "خادم PHP" : "PHP Server"); _m.put("desc", isAr ? "تشغيل تطبيقات PHP محلياً باستخدام الخادم المدمج." : "Run PHP apps locally using the built-in server."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "خادم SSH" : "SSH Server"); _m.put("desc", isAr ? "اجعل جهازك متاحاً للاتصال عبر SSH." : "Make your device accessible for SSH connections."); detailsList.add(_m); }
				
				// عناصر إضافية من الصور
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "خادم HTTP Python (python -m http.server)" : "Python HTTP Server"); _m.put("desc", isAr ? "استخدام خادم HTTP المدمج في Python لخدمة الملفات وتطوير الويب محلياً." : "Use Python's built-in HTTP server for simple file serving and local web development."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "تثبيت Lighttpd (pkg install lighttpd)" : "Lighttpd Installation"); _m.put("desc", isAr ? "تثبيت وتكوين Lighttpd، خادم ويب خفيف وعالي الأداء." : "Install and configure Lighttpd, a lightweight and high-performance web server."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "إعداد PostgreSQL (pkg install postgresql)" : "PostgreSQL Setup"); _m.put("desc", isAr ? "تثبيت وتكوين PostgreSQL، نظام قاعدة بيانات قوي." : "Install and configure PostgreSQL, a powerful object-relational database system."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "إعداد خادم FTP (pkg install ftpd)" : "FTP Server Setup"); _m.put("desc", isAr ? "تمكين نقل الملفات بين جهاز Termux والأجهزة البعيدة باستخدام FTP." : "Enable file transfers between your Termux device and remote devices using FTP."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "تكوين خادم الملفات (Samba)" : "File Server Configuration"); _m.put("desc", isAr ? "تكوين خادم ملفات باستخدام Samba لمشاركة الملفات عبر الشبكة." : "Configure a file server using Samba to share files over a network."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "إدارة خادم قاعدة البيانات" : "Database Server Management"); _m.put("desc", isAr ? "إدارة خوادم قواعد البيانات، بما في ذلك إنشاء قواعد البيانات والمستخدمين وعمل النسخ الاحتياطية." : "Manage database servers, including creating databases, users, and performing backups."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "خادم WebSocket" : "WebSocket Server"); _m.put("desc", isAr ? "إنشاء خادم WebSocket باستخدام Node.js للتواصل ثنائي الاتجاه في الوقت الفعلي." : "Create a WebSocket server using Node.js for real-time, full-duplex communication."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "إعداد خادم بروكسي (Squid)" : "Proxy Server Setup"); _m.put("desc", isAr ? "إعداد خادم بروكسي باستخدام Squid ليعمل كوسيط بين العملاء والخوادم." : "Set up a proxy server using Squid to act as an intermediary between clients and servers."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "خوادم التخزين المؤقت (Redis, Memcached)" : "Caching Servers"); _m.put("desc", isAr ? "تحسين الأداء باستخدام Redis أو Memcached لتخزين البيانات المتكررة." : "Improve performance by using Redis or Memcached to cache frequently accessed data."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "موازنة التحميل" : "Load Balancing"); _m.put("desc", isAr ? "توزيع حركة الشبكة عبر خوادم متعددة باستخدام HAProxy." : "Distribute network traffic across multiple servers using HAProxy."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "مراقبة أداء الخادم" : "Monitoring Server Performance"); _m.put("desc", isAr ? "مراقبة أداء الخادم باستخدام أدوات مثل htop و Netdata." : "Monitor server performance using tools like htop and Netdata."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "تكوين الوكيل العكسي" : "Reverse Proxy Configuration"); _m.put("desc", isAr ? "إعداد وكيل عكسي لتحسين الأمان وتوزيع الحمل." : "Set up a reverse proxy to improve security and load distribution."); detailsList.add(_m); }
			}
			
			// ==========================================
			// 7. واجهة لينكس الرسومية (Linux GUI)
			// ==========================================
			else if (t.contains("gui") || t.contains("رسومية") || t.contains("desktop")) {
				// العناصر الأصلية
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "تثبيت XFCE4" : "XFCE4 Desktop"); _m.put("desc", isAr ? "تشغيل سطح مكتب كامل وتطبيقات رسومية." : "Run a full desktop environment and GUI apps."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "خادم VNC" : "VNC Server"); _m.put("desc", isAr ? "إعداد الاتصال المرئي لرؤية سطح المكتب." : "Setup visual connection to view your desktop."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "خادم X11 (Termux:X11)" : "X11 Server"); _m.put("desc", isAr ? "تشغيل تطبيقات رسومية بدون VNC." : "Run GUI apps without VNC."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "تطبيقات رسومية خفيفة" : "Lightweight GUI Apps"); _m.put("desc", isAr ? "تثبيت متصفحات ومشغلات وسائط بسيطة." : "Install simple browsers and media players."); detailsList.add(_m); }
				
				// عناصر إضافية من الصور
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "أدوات سطر الأوامر المخصصة" : "Custom Command Line Tools"); _m.put("desc", isAr ? "إنشاء أدوات سطر أوامر خاصة بك باستخدام سكربتات Bash لأتمتة المهام." : "Create your own command line tools using Bash scripts to automate tasks."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "تشغيل تطبيقات رسومية (Firefox, GIMP)" : "Running GUI Applications"); _m.put("desc", isAr ? "تثبيت وتشغيل تطبيقات رسومية مثل Firefox و GIMP داخل Termux." : "Install and run graphical applications like Firefox and GIMP within Termux."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "توجيه X11" : "X11 Forwarding"); _m.put("desc", isAr ? "تمكين توجيه X11 لعرض التطبيقات الرسومية التي تعمل في Termux على خادم X11 بعيد." : "Enable X11 forwarding to display graphical applications running in Termux on a remote X11 server."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "تثبيت بيئات سطح مكتب أخرى" : "Installing Other Desktop Environments"); _m.put("desc", isAr ? "استكشاف وتثبيت بيئات سطح مكتب أخرى مثل LXDE و MATE." : "Explore and install other desktop environments like LXDE and MATE."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "إعداد بروتوكول سطح المكتب البعيد (RDP)" : "Remote Desktop Protocol (RDP) Setup"); _m.put("desc", isAr ? "تكوين واستخدام RDP للوصول إلى بيئة سطح المكتب في Termux عن بُعد." : "Configure and utilize RDP to access your Termux desktop environment remotely."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "تكوين مدير العرض" : "Configuring Display Manager"); _m.put("desc", isAr ? "إعداد مدير عرض مثل LightDM لتجربة تسجيل دخول رسومية." : "Set up a display manager like LightDM for a graphical login experience."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "تثبيت تطبيقات GTK أو Qt" : "Installing GTK or Qt Applications"); _m.put("desc", isAr ? "تثبيت واستخدام تطبيقات GTK و Qt داخل بيئة Termux الرسومية." : "Install and use GTK and Qt applications within your graphical Termux environment."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "إعداد مديري الملفات للواجهة الرسومية" : "Setting Up File Managers for GUI"); _m.put("desc", isAr ? "تثبيت مديري ملفات رسومية مثل Thunar و PCManFM لتسهيل إدارة الملفات." : "Install graphical file managers like Thunar and PCManFM for easier file management."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "تكوين دعم الصوت" : "Configuring Sound and Audio Support"); _m.put("desc", isAr ? "تمكين وتكوين دعم الصوت في Termux لاستخدام الصوت في التطبيقات الرسومية." : "Enable and configure audio support in Termux to use sound in graphical applications."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "استخدام الحافظة مع التطبيقات الرسومية" : "Using Clipboard with GUI Applications"); _m.put("desc", isAr ? "إدارة محتوى الحافظة واستخدام وظائف النسخ واللصق في تطبيقات الواجهة الرسومية." : "Manage clipboard content and use copy/paste functionality in GUI applications."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "تشغيل تطبيقات Java (مثل IntelliJ IDEA)" : "Running Java Applications"); _m.put("desc", isAr ? "تثبيت وتشغيل تطبيقات Java، بما في ذلك IntelliJ IDEA، داخل بيئة Termux." : "Install and run Java applications, including IntelliJ IDEA, within your Termux environment."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "استخدام Docker مع التطبيقات الرسومية" : "Using Docker with GUI Applications"); _m.put("desc", isAr ? "تشغيل التطبيقات الرسومية بسلاسة داخل حاويات Docker في Termux." : "Run GUI applications seamlessly within Docker containers in Termux."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "تشغيل الألعاب على Termux" : "Running Games on Termux"); _m.put("desc", isAr ? "تثبيت وتشغيل الألعاب في Termux باستخدام SteamCMD، RetroArch، DOSBox." : "Install and play games in Termux using various methods, including SteamCMD, RetroArch, and DOSBox."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "تخصيص مظهر الواجهة الرسومية" : "Customizing GUI Appearance"); _m.put("desc", isAr ? "تخصيص شكل بيئة Termux الرسومية بتغيير الثيمات، الأيقونات، والخطوط." : "Personalize the look of your graphical Termux environment by changing themes, icons, and fonts."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "إدارة ارتباطات الملفات" : "File Association Management"); _m.put("desc", isAr ? "إدارة ارتباطات الملفات لتحديد التطبيقات الافتراضية لفتح أنواع الملفات المختلفة." : "Manage file associations to define default applications for opening different file types."); detailsList.add(_m); }
			}
			
			// ==========================================
			// 8. إعداد Termux المخصص (Custom Setup)
			// ==========================================
			else if (t.contains("custom") || t.contains("مخصص") || t.contains("setup")) {
				// العناصر الأصلية
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "تخصيص الصدفة (ZSH)" : "ZSH Customization"); _m.put("desc", isAr ? "تغيير الثيمات والخطوط لبيئة عمل أجمل." : "Change themes and fonts for a beautiful workspace."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "رسالة الترحيب (Banner)" : "Welcome Banner"); _m.put("desc", isAr ? "إضافة شعار ASCII مخصص يظهر عند البدء." : "Add a custom ASCII logo at startup."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "مفاتيح إضافية" : "Extra Keys Row"); _m.put("desc", isAr ? "إضافة أزرار التحكم والأسهم فوق الكيبورد." : "Add control and arrow keys above the keyboard."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "الاختصارات (Aliases)" : "Aliases"); _m.put("desc", isAr ? "أنشئ أوامر مختصرة لتوفير الوقت." : "Create short commands to save time."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "رسالة اليوم (MOTD)" : "Message of the Day"); _m.put("desc", isAr ? "اعرض نصائح أو معلومات عند فتح الجلسة." : "Display tips or info when session starts."); detailsList.add(_m); }
				
				// عناصر إضافية من الصور
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "تخصيص موجه الأوامر" : "Customize Shell Prompt"); _m.put("desc", isAr ? "تخصيص موجه الأوامر بالألوان وحالة Git والمزيد." : "Personalize your shell prompt with colors, Git status, and more."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "إنشاء اختصارات وأسماء مستعارة" : "Create Aliases and Shortcuts"); _m.put("desc", isAr ? "تبسيط إدخال الأوامر وتحسين الإنتاجية بإنشاء اختصارات للأوامر المستخدمة بكثرة." : "Simplify command entry and improve productivity by creating aliases for frequently used commands."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "إعداد ثيمات وألوان مخصصة" : "Set Up Custom Themes and Color Schemes"); _m.put("desc", isAr ? "تحسين المظهر البصري وقابلية القراءة باستخدام ثيمات وألوان مخصصة." : "Enhance visual appeal and readability with custom themes and color schemes."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "تخصيص تعيين المفاتيح" : "Key Mapping Customization"); _m.put("desc", isAr ? "تخصيص تعيين المفاتيح لإنشاء اختصارات وتحسين سير العمل." : "Customize key mappings to create shortcuts and optimize your workflow."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "تكوين خطوط الطرفية" : "Terminal Fonts Configuration"); _m.put("desc", isAr ? "تغيير نوع وحجم ونمط الخط في الطرفية لتحسين القراءة والتخصيص." : "Change the font family, size, and style of your terminal for better readability."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "إدارة الجلسات (tmux)" : "Session Management"); _m.put("desc", isAr ? "إدارة جلسات طرفية متعددة باستخدام tmux لتنظيم العمل." : "Manage multiple terminal sessions effectively using tmux."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "النسخ الاحتياطي واستعادة التهيئة" : "Backup and Restore Configuration"); _m.put("desc", isAr ? "نسخ واستعادة تهيئة Termux، بما في ذلك الإعدادات والأسماء المستعارة والحزم المثبتة." : "Back up and restore your Termux configuration, including settings, aliases, and installed packages."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "سكربتات التهيئة المخصصة" : "Custom Scripts for Initialization"); _m.put("desc", isAr ? "أتمتة المهام وتكوين بيئة Termux باستخدام سكربتات تهيئة مخصصة." : "Automate tasks and configure your Termux environment using custom initialization scripts."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "إنشاء إضافات Termux مخصصة" : "Creating Custom Termux Plugins"); _m.put("desc", isAr ? "توسيع وظائف Termux عن طريق إنشاء إضافات تضيف أوامر وميزات جديدة." : "Extend Termux functionality by creating custom plugins that add new commands and features."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "استخدام لوحات المفاتيح الخارجية" : "Using External Keyboards"); _m.put("desc", isAr ? "توصيل وتكوين لوحات المفاتيح الخارجية لتعزيز الإنتاجية." : "Connect and configure external keyboards for enhanced productivity."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "إعداد الأوامر الافتراضية" : "Setting Up Default Commands"); _m.put("desc", isAr ? "تكوين الأوامر الافتراضية لتشغيل تلقائي عند بدء جلسة Termux جديدة." : "Configure default commands to run automatically upon starting a new Termux session."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "تخصيص سكربتات بدء التشغيل" : "Customizing Startup Scripts"); _m.put("desc", isAr ? "أتمتة المهام وتخصيص بيئة Termux باستخدام سكربتات بدء تشغيل مخصصة." : "Automate tasks and personalize your Termux environment with custom startup scripts."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "تكوين متغيرات البيئة" : "Environment Variables Configuration"); _m.put("desc", isAr ? "إدارة متغيرات البيئة لتخصيص بيئة الصدفة وسلوك التطبيقات." : "Manage environment variables to customize your shell environment and application behavior."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "إدارة الملفات الشخصية" : "Profile Management"); _m.put("desc", isAr ? "إنشاء وإدارة ملفات شخصية للتبديل بين تكوينات وإعدادات طرفية مختلفة." : "Create and manage profiles to switch between different terminal configurations."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "تكوين الوصول عن بُعد" : "Remote Access Configuration"); _m.put("desc", isAr ? "إعداد وتكوين الوصول عن بُعد إلى بيئة Termux باستخدام SSH." : "Set up and configure remote access to your Termux environment using SSH."); detailsList.add(_m); }
			}
			
			// ==========================================
			// 9. تشغيل Docker والبيئات الوهمية (Virtualization)
			// ==========================================
			else if (t.contains("docker") || t.contains("proot") || t.contains("distro")) {
				// العناصر الأصلية
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "توزيعات PRoot" : "PRoot Distro Management"); _m.put("desc", isAr ? "تشغيل Ubuntu و Kali Linux بدون روت." : "Run Ubuntu and Kali Linux without root access."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "عزل المشاريع (Virtualenv)" : "Project Isolation"); _m.put("desc", isAr ? "عزل مكتبات المشاريع المختلفة عن بعضها." : "Isolate project dependencies using virtual environments."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "إدارة التوزيعات (proot-distro)" : "Distro Management"); _m.put("desc", isAr ? "تثبيت وحذف توزيعات متعددة بسهولة." : "Easily install and remove multiple distros."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "تشغيل حاويات (Docker-like)" : "Container-Like Execution"); _m.put("desc", isAr ? "استخدم chroot أو proot لتشغيل بيئات معزولة." : "Use chroot or proot for isolated environments."); detailsList.add(_m); }
				
				// عناصر إضافية من الصور
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "إعداد root (pkg install root-distro)" : "Set Up root"); _m.put("desc", isAr ? "تثبيت وتكوين root لتشغيل توزيعات لينكس مختلفة داخل بيئة Termux." : "Install and configure root to run different Linux distributions within Termux."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "تشغيل حاويات Docker" : "Running Docker Containers"); _m.put("desc", isAr ? "تثبيت Docker وتعلم تشغيل الحاويات وإدارتها باستخدام الأوامر الأساسية." : "Install Docker and learn to run containers, manage them, and interact with them using basic commands."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "إنشاء صور Docker" : "Creating Docker Images"); _m.put("desc", isAr ? "بناء صور Docker مخصصة باستخدام Dockerfiles، وإدارتها ودفعها إلى السجلات." : "Build custom Docker images using Dockerfiles, manage them, and push them to registries."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "تنظيم الحاويات" : "Container Orchestration"); _m.put("desc", isAr ? "استخدام Docker Compose لتعريف وإدارة تطبيقات متعددة الحاويات بسهولة." : "Use Docker Compose to define and manage multi-container applications with ease."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "الشبكات في Docker" : "Networking in Docker"); _m.put("desc", isAr ? "استكشاف شبكات Docker، إنشاء شبكات مخصصة، وإدارة الاتصال بين الحاويات." : "Explore Docker networking, create custom networks, and manage communication between containers."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "استخدام Docker Compose" : "Using Docker Compose"); _m.put("desc", isAr ? "التعمق في Docker Compose، وتعلم الأوامر والخيارات المختلفة لإدارة التطبيقات متعددة الحاويات." : "Dive deeper into Docker Compose, learning about various commands and options for managing multi-container applications."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "إدارة وحدات التخزين" : "Volume Management"); _m.put("desc", isAr ? "إدارة التخزين المستمر في Docker، إنشاء واستخدام وحدات التخزين لتخزين البيانات خارج الحاويات." : "Manage persistent storage in Docker, create and use volumes to store data outside containers."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "إدارة سجل Docker" : "Docker Registry Management"); _m.put("desc", isAr ? "التفاعل مع سجلات Docker، دفع وسحب الصور، وإدارة الصور بشكل فعال." : "Learn how to interact with Docker registries, push and pull images, and manage your images effectively."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "ممارسات أمان الحاويات" : "Container Security Practices"); _m.put("desc", isAr ? "تنفيذ أفضل ممارسات الأمان لحاويات Docker، بما في ذلك تقليل الصلاحيات والمسح بحثًا عن الثغرات." : "Implement security best practices for Docker containers, including minimizing permissions and scanning for vulnerabilities."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "تصحيح أخطاء حاويات Docker" : "Debugging Docker Containers"); _m.put("desc", isAr ? "استكشاف الأخطاء وإصلاحها في حاويات Docker باستخدام تقنيات وأوامر مختلفة." : "Troubleshoot and debug issues in Docker containers using various techniques and commands."); detailsList.add(_m); }
			}
			
			// ==========================================
			// 10. مراقبة النظام (System Monitoring)
			// ==========================================
			else if (t.contains("monitoring") || t.contains("مراقبة")) {
				// العناصر الأصلية
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "أداة HTOP المتقدمة" : "HTOP Monitoring"); _m.put("desc", isAr ? "مراقبة المعالج والذاكرة والعمليات حياً." : "Monitor CPU, RAM, and processes in real-time."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "معلومات الجهاز (Neofetch)" : "System Info (Neofetch)"); _m.put("desc", isAr ? "عرض مواصفات الهاتف بنقرة واحدة." : "Display phone specs with a single click."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "مراقبة الشبكة (Netstat)" : "Network Monitoring"); _m.put("desc", isAr ? "تتبع اتصالات الإنترنت النشطة والتطبيقات." : "Track active internet connections and apps."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "مراقبة الإدخال/الإخراج (iotop)" : "I/O Monitoring"); _m.put("desc", isAr ? "اعرف أي العمليات تستهلك القرص." : "Find out which processes are disk-heavy."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "مراقبة النطاق الترددي (iftop)" : "Bandwidth Monitoring"); _m.put("desc", isAr ? "تتبع استهلاك الإنترنت لكل اتصال." : "Track bandwidth usage per connection."); detailsList.add(_m); }
				
				// عناصر إضافية من الصور
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "مراقبة العمليات (htop)" : "Process Monitoring (htop)"); _m.put("desc", isAr ? "مراقبة عمليات النظام في الوقت الفعلي باستخدام htop للحصول على رؤى مفصلة وإدارة." : "Monitor system processes in real-time using htop for detailed insights and management."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "مراقبة حركة الشبكة (iftop, netstat)" : "Network Traffic Monitoring"); _m.put("desc", isAr ? "تحليل حركة الشبكة باستخدام iftop و netstat لتحديد استخدام النطاق الترددي والاتصالات النشطة." : "Analyze network traffic with iftop and netstat to identify bandwidth usage and active connections."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "استخدام التخزين والذاكرة (df, du, free)" : "Storage and RAM Usage"); _m.put("desc", isAr ? "التحقق من استخدام مساحة القرص واستهلاك الذاكرة باستخدام df و du و free." : "Check disk space usage and memory consumption using df, du, and free commands."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "مراقبة حالة البطارية (termux-battery-status)" : "Battery Status Monitoring"); _m.put("desc", isAr ? "مراقبة مستوى البطارية وحالتها وصحتها باستخدام Termux API." : "Monitor battery level, status, and health using Termux API."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "تنبيهات استخدام موارد النظام" : "System Resource Usage Alerts"); _m.put("desc", isAr ? "إعداد تنبيهات لارتفاع استخدام وحدة المعالجة المركزية أو انخفاض مساحة القرص أو تجاوز الذاكرة للحدود." : "Set up alerts for high CPU usage, low disk space, or memory exceeding thresholds."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "أدوات تحليل الأداء" : "Performance Profiling Tools"); _m.put("desc", isAr ? "استخدام أدوات مثل htop و sar و ioping و perf لتحليل الأداء ومراقبة الموارد." : "Utilize tools like htop, sar, ioping, and perf for performance analysis and resource monitoring."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "سكربتات التسجيل والمراقبة" : "Logging and Monitoring Scripts"); _m.put("desc", isAr ? "إنشاء سكربتات لأتمتة تسجيل ومراقبة مقاييس النظام واستخدام الموارد." : "Create scripts to automate logging and monitoring of system metrics and resource usage."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "إعداد مهام cron للمراقبة" : "Setting Up Cron Jobs for Monitoring"); _m.put("desc", isAr ? "جدولة مهام المراقبة الآلية باستخدام cron jobs لإجراء عمليات فحص وتسجيل دورية." : "Schedule automated monitoring tasks using cron jobs for periodic checks and logging."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "مراقبة صحة القرص (smartctl)" : "Disk Health Monitoring"); _m.put("desc", isAr ? "مراقبة صحة القرص وأدائه باستخدام smartctl للتحقق من الأخطاء والتنبؤ بالأعطال المحتملة." : "Monitor disk health and performance using smartctl to check for errors and predict potential failures."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "تحليل متوسط حمل النظام" : "System Load Average Analysis"); _m.put("desc", isAr ? "تحليل متوسط حمل النظام لفهم استخدام وحدة المعالجة المركزية واستجابة النظام." : "Analyze system load average to understand CPU utilization and system responsiveness."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "مراقبة زمن الوصول للشبكة" : "Network Latency Monitoring"); _m.put("desc", isAr ? "مراقبة زمن الوصول للشبكة باستخدام ping و traceroute و mtr لتشخيص مشاكل الاتصال." : "Monitor network latency with ping, traceroute, and mtr to diagnose connectivity issues."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "مراقبة أداء التطبيقات" : "Application Performance Monitoring"); _m.put("desc", isAr ? "مراقبة أداء تطبيقات محددة باستخدام أدوات مثل top و htop و iotop." : "Monitor the performance of specific applications using tools like top, htop, and iotop."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "تحليل سجلات النظام" : "Analyzing System Logs"); _m.put("desc", isAr ? "عرض وتحليل سجلات النظام والتطبيقات لاستكشاف المشكلات وتحديد التهديدات الأمنية." : "View and analyze system and application logs to troubleshoot issues and identify potential security threats."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "مراقبة أداء CPU و GPU" : "CPU and GPU Performance Monitoring"); _m.put("desc", isAr ? "مراقبة استخدام وحدة المعالجة المركزية ووحدة معالجة الرسومات باستخدام أدوات متنوعة لتحليل أداء النظام." : "Monitor CPU and GPU usage with various tools to analyze system performance and identify bottlenecks."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "كشف تسرب الذاكرة" : "Memory Leak Detection"); _m.put("desc", isAr ? "كشف وإدارة تسربات الذاكرة في التطبيقات باستخدام Valgrind و HeapTrack وأدوات تصحيح أخرى." : "Detect and manage memory leaks in applications using Valgrind, HeapTrack, and other debugging tools."); detailsList.add(_m); }
				{ HashMap<String, Object> _m = new HashMap<>(); _m.put("title", isAr ? "أدوات إعداد التقارير الآلية" : "Automated Reporting Tools"); _m.put("desc", isAr ? "إنشاء وإرسال تقارير آلية عن أداء النظام واستخدام الموارد والمقاييس الأخرى." : "Generate and send automated reports on system performance, resource usage, and other metrics."); detailsList.add(_m); }
			}
			
			// ==========================================
			// في حال عدم تطابق أي فئة، نعرض رسالة مناسبة
			// ==========================================
			else {
				HashMap<String, Object> defaultItem = new HashMap<>();
				defaultItem.put("title", isAr ? "لا توجد نتائج" : "No results found");
				defaultItem.put("desc", isAr ? "لم يتم العثور على محتوى لهذه الفئة." : "No content found for this category.");
				detailsList.add(defaultItem);
			}
		}
		
		// تحديث الـ ListView وربط المحول (Adapter)
		Listview_detailsAdapter adapter = new Listview_detailsAdapter(detailsList);
		listview_details.setAdapter(adapter);
		adapter.notifyDataSetChanged();
	}
	
	public class Listview_detailsAdapter extends BaseAdapter {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Listview_detailsAdapter(ArrayList<HashMap<String, Object>> _arr) {
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
				_view = _inflater.inflate(R.layout.custom_details, null);
			}
			
			final TextView item_num = _view.findViewById(R.id.item_num);
			final LinearLayout linear8 = _view.findViewById(R.id.linear8);
			final ImageView imageview8 = _view.findViewById(R.id.imageview8);
			final TextView item_title = _view.findViewById(R.id.item_title);
			final TextView item_desc = _view.findViewById(R.id.item_desc);
			
			HashMap<String, Object> _itemData = detailsList.get((int)_position);
			
			// التأكد من وجود title قبل عرضه
			if (_itemData.containsKey("title") && _itemData.get("title") != null) {
				item_title.setText(_itemData.get("title").toString());
			} else {
				item_title.setText(""); 
			}
			
			// التأكد من وجود desc قبل عرضه (هذا هو المسبب الأكبر للخطأ)
			if (_itemData.containsKey("desc") && _itemData.get("desc") != null) {
				item_desc.setText(_itemData.get("desc").toString());
			} else {
				item_desc.setText(""); // اترك الوصف فارغاً إذا لم يوجد
			}
			
			// تعيين رقم العنصر (هذا السطر سليم)
			item_num.setText(String.valueOf((int)_position + 1));
			
			
			
			// 4. تنسيق الخطوط (اختياري)
			try {
				Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/airoplaybold.ttf");
				item_title.setTypeface(tf);
				item_num.setTypeface(tf);
				item_desc.setTypeface(tf);
			} catch (Exception e) {}
			
			// هذا الكود يوضع داخل بلوك Add Source Directly في حدث onBindCustomView
			// لربط النقر على العنصر بالانتقال لواجهة الأوامر التفصيلية
			
			linear8.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Intent i = new Intent();
					// تأكد من إنشاء Activity بهذا الاسم (CommandsActivity)
					i.setClass(getApplicationContext(), CommandsActivity.class);
					
					// نمرر عنوان العنصر لنعرف أي أوامر سنعرض
					i.putExtra("sub_title", detailsList.get((int)_position).get("title").toString());
					
					startActivity(i);
				}
			});
			
			// إضافة تأثير الوميض (Ripple) لجعل التصميم تفاعلياً
			android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
			gd.setColor(Color.parseColor("#1E293B")); 
			gd.setCornerRadius(15f);
			android.content.res.ColorStateList clr = new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{Color.parseColor("#334155")});
			android.graphics.drawable.RippleDrawable ripple = new android.graphics.drawable.RippleDrawable(clr, gd, null);
			linear8.setBackground(ripple);
			linear8.setClickable(true);
			linear8.setFocusable(true);
			
			
			
			return _view;
		}
	}
}