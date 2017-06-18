package io.github.gingeraebi.study2;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

import com.gun0912.tedpermission.PermissionListener;

import java.util.ArrayList;

/**
 * Created by gingeraebi on 2017. 6. 18..
 */

public class PermissionUtil {

    private PermissionListener permissionListener;

    public PermissionUtil(final Context context) {
        new PermissionListener() {
            @Override
            public void onPermissionGranted() {
                Toast.makeText(context, "Permission Granted", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPermissionDenied(ArrayList<String> deniedPermissions) {
                Toast.makeText(context, "Permission Denied\n" + deniedPermissions.toString(), Toast.LENGTH_SHORT).show();
            }


        };
    }

    public PermissionListener getPermissionListener() {
        return permissionListener;
    }
}
