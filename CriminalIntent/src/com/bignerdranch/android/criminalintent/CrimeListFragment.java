package com.bignerdranch.android.criminalintent;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

public class CrimeListFragment extends ListFragment {
		private ArrayList<Crime> mCrimes;
		private static final String TAG="CrimeListFragment";
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		getActivity().setTitle(R.string.crime_title);
		mCrimes=CrimeLab.get(getActivity()).getCrimes();
//		ArrayAdapter<Crime> adapter=new ArrayAdapter<Crime>(getActivity(), android.R.layout.simple_list_item_1, mCrimes);
		CrimeAdapter adapter=new CrimeAdapter(mCrimes);
		setListAdapter(adapter);
	}
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
//		Crime c=(Crime)(getListAdapter()).getItem(position);
		Crime c=(Crime)getListAdapter().getItem(position);
//		Log.d(TAG,c.getTitle()+"was clicked");
//		start CrimeActivity;
		Intent intent=new Intent(getActivity(),CrimeActivity.class);
		intent.putExtra(CrimeFragment.EXTRA_CRIME_ID,c.getId());
		startActivity(intent);
	}
	public class CrimeAdapter extends ArrayAdapter<Crime>{
		public CrimeAdapter(ArrayList<Crime> crimes){
			super(getActivity(),0,crimes);
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			if (convertView==null){
				convertView=getActivity().getLayoutInflater().inflate(R.layout.list_item_crime, null);
			}
			Crime c=getItem(position);
			TextView titleTextView=(TextView)convertView.findViewById(R.id.crime_list_item_titleTextView);
			titleTextView.setText(c.getTitle());
			TextView dateTextView=(TextView)convertView.findViewById(R.id.crime_list_item_dateTextView);
			dateTextView.setText(c.getDate().toString());
			CheckBox solvedCheckBox=(CheckBox)convertView.findViewById(R.id.crime_list_item_solvedCheckBox);
			solvedCheckBox.setChecked(c.isSolved());
			return convertView;
			
			
			
			
			
			
		}
		
		
	}

	

}
