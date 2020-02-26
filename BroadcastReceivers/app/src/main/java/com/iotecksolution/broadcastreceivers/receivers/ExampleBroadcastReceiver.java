package com.iotecksolution.broadcastreceivers.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import android.widget.Toast;

public class ExampleBroadcastReceiver extends BroadcastReceiver {

    private static final String TAG = "ExampleBroadcastReceiver";
    private boolean isRegistered = false;

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "Calling onReceive()");
        Toast.makeText(context, "Calling static broadcast receiver - value: " + intent.getStringExtra("key"), Toast.LENGTH_SHORT).show();
    }

    // general methods:-----------------------------------------------------------------------------
    public Intent register(Context context, IntentFilter filter) {
        try {
            return !isRegistered
                    ? context.registerReceiver(this, filter)
                    : null;
        } finally {
            isRegistered = true;
        }
    }

    public boolean unRegister(Context context) {
        // additional work match on context before unregister
        // eg store weak ref in register then compare in unregister
        // if match same instance
        return isRegistered
                && unregisterInternal(context);
    }

    private boolean unregisterInternal(Context context) {
        context.unregisterReceiver(this);
        isRegistered = false;
        return true;
    }
}
