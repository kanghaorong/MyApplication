package com.qike.corelibrary;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.qike.corelibrary.database.impl.DataBaseProviderimpl;
import com.qike.corelibrary.test.Stu;

public class MainActivity extends Activity implements OnClickListener {

	private TextView content;
	private DataBaseProviderimpl dbImpl;
	private Stu s;
	private int i;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
//		initView();
//		StorageDriectory path = SDCardUtils.getInnerStorageDirectory(this, true);
//		String p = "/data/data/"+getPackageName();
//		File f = new File(p);
//		if(!f.exists() || !f.isDirectory()){
//			f.mkdir();
//		}
//		dbImpl = new DataBaseProviderimpl(p+"/mydb.db");
//		i = 0;
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
	}

//	private void initData() {
//		s = new Stu();
//		s.setId(i++);
//		s.setName("cc");
//		s.setSex(true);
//		s.setAge(1);
//	}
//
//	private void initView() {
//		findViewById(R.id.add).setOnClickListener(this);
//		findViewById(R.id.delete).setOnClickListener(this);
//		findViewById(R.id.updae).setOnClickListener(this);
//		findViewById(R.id.query).setOnClickListener(this);
//		content = (TextView) findViewById(R.id.content);
//	}
//
//	@Override
//	public void onClick(View arg0) {
//		switch (arg0.getId()) {
//
//		default:
//			break;
//		}
//	}
//	@Override
//	protected void onDestroy() {
//		dbImpl.close();
//		super.onDestroy();
//	}

}
