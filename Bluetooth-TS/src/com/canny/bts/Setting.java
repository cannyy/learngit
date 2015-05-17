package com.canny.bts;

import java.util.Set;

import com.canny.bts.Bluetooth.ServerOrCilent;
import gjz.bluetooth.R;

import android.app.Activity;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
//设置参数activity
public class Setting extends Activity {
	private Spinner spinner;
	private ArrayAdapter<String> adapter;
	private Button serviceButton;
	private EditText edittext1;
	private EditText edittext2;

	private static final String[] m = { "GSI16", "GSI8" };

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.setting);
		serviceButton = (Button) findViewById(R.id.start_service_2);
		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, m);

		// 设置下拉列表的风格
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner = (Spinner) this.findViewById(R.id.Spinner01);
		// 将adapter 添加到spinner中
		spinner.setAdapter(adapter);

		// 添加事件Spinner事件监听
		// spinner.setOnItemSelectedListener(new SpinnerSelectedListener());

		// 设置默认值
		spinner.setVisibility(View.VISIBLE);
		edittext1=(EditText)this.findViewById(R.id.Btn_cequ);
		edittext2=(EditText)this.findViewById(R.id.Btn_ceduan);
		
		
		serviceButton = (Button) findViewById(R.id.start_service_2);
		
		serviceButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Bluetooth.serviceOrCilent = ServerOrCilent.SERVICE;
				final String c1=edittext1.getText().toString();
				final String c2=edittext2.getText().toString();
				Editor sharedata = (Editor) getSharedPreferences("tao", 0).edit();//传递参数
				sharedata.putString("cequ",c1 );
				sharedata.putString("ceduan",c2 );
				sharedata.commit();
				
				
				Bluetooth.mTabHost.setCurrentTab(1);
				
			}

		});
		
		
		
		
		class SpinnerSelectedListener implements OnItemSelectedListener {

			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {

			}

			public void onNothingSelected(AdapterView<?> arg0) {
			}
		}

	}
}
