package com.genonbeta.TrebleShot.adapter;

import android.content.Context;
import android.net.wifi.p2p.WifiP2pDevice;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.genonbeta.TrebleShot.R;

import java.util.ArrayList;

public class P2pDeviceListAdapter extends BaseAdapter
{
	private Context mContext;
	private ArrayList<WifiP2pDevice> mPeers;
	private int[] mDeviceStatus = new int[]{R.string.connected, R.string.invited, R.string.connection_failured, R.string.available, R.string.not_available};

	public P2pDeviceListAdapter(Context context, ArrayList<WifiP2pDevice> peerList)
	{
		mContext = context;
		mPeers = peerList;
	}

	@Override
	public int getCount()
	{
		return mPeers.size();
	}

	@Override
	public Object getItem(int itemId)
	{
		return mPeers.get(itemId);
	}

	@Override
	public long getItemId(int p1)
	{
		return 0;
	}

	@Override
	public View getView(int position, View view, ViewGroup viewGroup)
	{
		if (view == null)
			view = LayoutInflater.from(mContext).inflate(R.layout.list_p2p_device, viewGroup, false);

		TextView deviceText = (TextView) view.findViewById(R.id.p2p_device_list_device_text);
		TextView deviceStatusText = (TextView) view.findViewById(R.id.p2p_device_list_device_status_text);
		WifiP2pDevice device = (WifiP2pDevice) getItem(position);

		deviceText.setText(device.deviceName);
		deviceStatusText.setText(mDeviceStatus[device.status]);

		return view;
	}
}
