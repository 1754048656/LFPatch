package org.lsposed.lspatch.loader;

import android.app.ActivityThread;
import android.app.LoadedApk;
import android.content.res.XResources;

import de.robv.android.fposed.FposedBridge;
import de.robv.android.fposed.FposedInit;
import de.robv.android.fposed.callbacks.FC_LoadPackage;

public class LSPLoader {
    public static void initModules(LoadedApk loadedApk) {
        FposedInit.loadedPackagesInProcess.add(loadedApk.getPackageName());
        XResources.setPackageNameForResDir(loadedApk.getPackageName(), loadedApk.getResDir());
        FC_LoadPackage.LoadPackageParam lpparam = new FC_LoadPackage.LoadPackageParam(
                FposedBridge.sLoadedPackageCallbacks);
        lpparam.packageName = loadedApk.getPackageName();
        lpparam.processName = ActivityThread.currentProcessName();
        lpparam.classLoader = loadedApk.getClassLoader();
        lpparam.appInfo = loadedApk.getApplicationInfo();
        lpparam.isFirstApplication = true;
        FC_LoadPackage.callAll(lpparam);
    }
}
