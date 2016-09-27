package com.example.android.servicesdemo;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p/>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class MyIntentServiceWithHelpers extends IntentService {

    private static final String ACTION_DOWNLOAD = "com.example.android.servicesdemo.action.Download";
    private static final String EXTRA_URL = "com.example.android.servicesdemo.extra.url";

    public MyIntentServiceWithHelpers() {
        super("MyIntentServiceWithHelpers");
    }


    public static void downloadUrl(Context context, String url) {
        Intent intent = new Intent(context, MyIntentServiceWithHelpers.class);
        intent.setAction(ACTION_DOWNLOAD);
        intent.putExtra(EXTRA_URL, url);

        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_DOWNLOAD.equals(action)) {
                final String url = intent.getStringExtra(EXTRA_URL);
                handleDownload(url);
            }
        }
    }

    private void handleDownload(String url) {

    }
}
