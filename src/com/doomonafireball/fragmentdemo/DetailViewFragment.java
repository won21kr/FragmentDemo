package com.doomonafireball.fragmentdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

public class DetailViewFragment extends Fragment {

	public static DetailViewFragment newInstance(int index) {
		// Create a new instance of DetailViewFragment
		// initialized to show the text at 'index'
		DetailViewFragment f = new DetailViewFragment();

		// Supply index input as an argument
		Bundle args = new Bundle();
		args.putInt("index", index);
		f.setArguments(args);

		return f;
	}

	public int getShownIndex() {
		return getArguments().getInt("index", 0);
	}

	public int getShownRace() {
		return getArguments().getInt("race", 0);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		if (container == null) {
			// Currently in a layout without a container, so no reason to create
			// our view
			return null;
		}

		ScrollView scroller = new ScrollView(getActivity());
		TextView text = new TextView(getActivity());
		int padding = (int) TypedValue.applyDimension(
				TypedValue.COMPLEX_UNIT_DIP, 4, getActivity().getResources()
						.getDisplayMetrics());
		text.setPadding(padding, padding, padding, padding);
		scroller.addView(text);
		switch (getShownRace()) {
		case 0:
			// toss
			text.setText(getActivity().getResources().getStringArray(
					R.array.protoss_demo_data)[getShownIndex()]);
			break;
		case 1:
			// terran
			text.setText(getActivity().getResources().getStringArray(
					R.array.terran_demo_data)[getShownIndex()]);
			break;
		case 2:
			// zerg
			text.setText(getActivity().getResources().getStringArray(
					R.array.zerg_demo_data)[getShownIndex()]);
			break;
		default:
			// toss
			text.setText(getActivity().getResources().getStringArray(
					R.array.protoss_demo_data)[getShownIndex()]);
			break;
		}

		return scroller;
	}
}
