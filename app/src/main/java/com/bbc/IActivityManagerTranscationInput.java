package com.bbc;

import static android.os.IBinder.INTERFACE_TRANSACTION;

import android.app.ActivityManager;
import android.app.ApplicationErrorReport;
import android.app.ApplicationExitInfo;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.LocusId;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Debug;
import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.StrictMode;
import android.os.WorkSource;
import android.text.TextUtils;
import android.util.Log;

import java.util.List;

public class IActivityManagerTranscationInput {
    public static final java.lang.String DESCRIPTOR = "android.app.IActivityManager";
    static final int TRANSACTION_openContentUri = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
    static final int TRANSACTION_registerUidObserver = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
    static final int TRANSACTION_unregisterUidObserver = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
    static final int TRANSACTION_isUidActive = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
    static final int TRANSACTION_getUidProcessState = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
    static final int TRANSACTION_checkPermission = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
    static final int TRANSACTION_handleApplicationCrash = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
    static final int TRANSACTION_startActivity = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
    static final int TRANSACTION_startActivityWithFeature = (android.os.IBinder.FIRST_CALL_TRANSACTION + 8);
    static final int TRANSACTION_unhandledBack = (android.os.IBinder.FIRST_CALL_TRANSACTION + 9);
    static final int TRANSACTION_finishActivity = (android.os.IBinder.FIRST_CALL_TRANSACTION + 10);
    static final int TRANSACTION_registerReceiver = (android.os.IBinder.FIRST_CALL_TRANSACTION + 11);
    static final int TRANSACTION_registerReceiverWithFeature = (android.os.IBinder.FIRST_CALL_TRANSACTION + 12);
    static final int TRANSACTION_unregisterReceiver = (android.os.IBinder.FIRST_CALL_TRANSACTION + 13);
    static final int TRANSACTION_broadcastIntent = (android.os.IBinder.FIRST_CALL_TRANSACTION + 14);
    static final int TRANSACTION_broadcastIntentWithFeature = (android.os.IBinder.FIRST_CALL_TRANSACTION + 15);
    static final int TRANSACTION_unbroadcastIntent = (android.os.IBinder.FIRST_CALL_TRANSACTION + 16);
    static final int TRANSACTION_finishReceiver = (android.os.IBinder.FIRST_CALL_TRANSACTION + 17);
    static final int TRANSACTION_attachApplication = (android.os.IBinder.FIRST_CALL_TRANSACTION + 18);
    static final int TRANSACTION_getTasks = (android.os.IBinder.FIRST_CALL_TRANSACTION + 19);
    static final int TRANSACTION_moveTaskToFront = (android.os.IBinder.FIRST_CALL_TRANSACTION + 20);
    static final int TRANSACTION_getTaskForActivity = (android.os.IBinder.FIRST_CALL_TRANSACTION + 21);
    static final int TRANSACTION_getContentProvider = (android.os.IBinder.FIRST_CALL_TRANSACTION + 22);
    static final int TRANSACTION_publishContentProviders = (android.os.IBinder.FIRST_CALL_TRANSACTION + 23);
    static final int TRANSACTION_refContentProvider = (android.os.IBinder.FIRST_CALL_TRANSACTION + 24);
    static final int TRANSACTION_getRunningServiceControlPanel = (android.os.IBinder.FIRST_CALL_TRANSACTION + 25);
    static final int TRANSACTION_startService = (android.os.IBinder.FIRST_CALL_TRANSACTION + 26);
    static final int TRANSACTION_stopService = (android.os.IBinder.FIRST_CALL_TRANSACTION + 27);
    static final int TRANSACTION_bindService = (android.os.IBinder.FIRST_CALL_TRANSACTION + 28);
    static final int TRANSACTION_bindServiceInstance = (android.os.IBinder.FIRST_CALL_TRANSACTION + 29);
    static final int TRANSACTION_updateServiceGroup = (android.os.IBinder.FIRST_CALL_TRANSACTION + 30);
    static final int TRANSACTION_unbindService = (android.os.IBinder.FIRST_CALL_TRANSACTION + 31);
    static final int TRANSACTION_publishService = (android.os.IBinder.FIRST_CALL_TRANSACTION + 32);
    static final int TRANSACTION_setDebugApp = (android.os.IBinder.FIRST_CALL_TRANSACTION + 33);
    static final int TRANSACTION_setAgentApp = (android.os.IBinder.FIRST_CALL_TRANSACTION + 34);
    static final int TRANSACTION_setAlwaysFinish = (android.os.IBinder.FIRST_CALL_TRANSACTION + 35);
    static final int TRANSACTION_startInstrumentation = (android.os.IBinder.FIRST_CALL_TRANSACTION + 36);
    static final int TRANSACTION_addInstrumentationResults = (android.os.IBinder.FIRST_CALL_TRANSACTION + 37);
    static final int TRANSACTION_finishInstrumentation = (android.os.IBinder.FIRST_CALL_TRANSACTION + 38);
    static final int TRANSACTION_getConfiguration = (android.os.IBinder.FIRST_CALL_TRANSACTION + 39);
    static final int TRANSACTION_updateConfiguration = (android.os.IBinder.FIRST_CALL_TRANSACTION + 40);
    static final int TRANSACTION_updateMccMncConfiguration = (android.os.IBinder.FIRST_CALL_TRANSACTION + 41);
    static final int TRANSACTION_stopServiceToken = (android.os.IBinder.FIRST_CALL_TRANSACTION + 42);
    static final int TRANSACTION_setProcessLimit = (android.os.IBinder.FIRST_CALL_TRANSACTION + 43);
    static final int TRANSACTION_getProcessLimit = (android.os.IBinder.FIRST_CALL_TRANSACTION + 44);
    static final int TRANSACTION_checkUriPermission = (android.os.IBinder.FIRST_CALL_TRANSACTION + 45);
    static final int TRANSACTION_checkUriPermissions = (android.os.IBinder.FIRST_CALL_TRANSACTION + 46);
    static final int TRANSACTION_grantUriPermission = (android.os.IBinder.FIRST_CALL_TRANSACTION + 47);
    static final int TRANSACTION_revokeUriPermission = (android.os.IBinder.FIRST_CALL_TRANSACTION + 48);
    static final int TRANSACTION_setActivityController = (android.os.IBinder.FIRST_CALL_TRANSACTION + 49);
    static final int TRANSACTION_showWaitingForDebugger = (android.os.IBinder.FIRST_CALL_TRANSACTION + 50);
    static final int TRANSACTION_signalPersistentProcesses = (android.os.IBinder.FIRST_CALL_TRANSACTION + 51);
    static final int TRANSACTION_getRecentTasks = (android.os.IBinder.FIRST_CALL_TRANSACTION + 52);
    static final int TRANSACTION_serviceDoneExecuting = (android.os.IBinder.FIRST_CALL_TRANSACTION + 53);
    static final int TRANSACTION_getIntentSender = (android.os.IBinder.FIRST_CALL_TRANSACTION + 54);
    static final int TRANSACTION_getIntentSenderWithFeature = (android.os.IBinder.FIRST_CALL_TRANSACTION + 55);
    static final int TRANSACTION_cancelIntentSender = (android.os.IBinder.FIRST_CALL_TRANSACTION + 56);
    static final int TRANSACTION_getInfoForIntentSender = (android.os.IBinder.FIRST_CALL_TRANSACTION + 57);
    static final int TRANSACTION_registerIntentSenderCancelListenerEx = (android.os.IBinder.FIRST_CALL_TRANSACTION + 58);
    static final int TRANSACTION_unregisterIntentSenderCancelListener = (android.os.IBinder.FIRST_CALL_TRANSACTION + 59);
    static final int TRANSACTION_enterSafeMode = (android.os.IBinder.FIRST_CALL_TRANSACTION + 60);
    static final int TRANSACTION_noteWakeupAlarm = (android.os.IBinder.FIRST_CALL_TRANSACTION + 61);
    static final int TRANSACTION_removeContentProvider = (android.os.IBinder.FIRST_CALL_TRANSACTION + 62);
    static final int TRANSACTION_setRequestedOrientation = (android.os.IBinder.FIRST_CALL_TRANSACTION + 63);
    static final int TRANSACTION_unbindFinished = (android.os.IBinder.FIRST_CALL_TRANSACTION + 64);
    static final int TRANSACTION_setProcessImportant = (android.os.IBinder.FIRST_CALL_TRANSACTION + 65);
    static final int TRANSACTION_setServiceForeground = (android.os.IBinder.FIRST_CALL_TRANSACTION + 66);
    static final int TRANSACTION_getForegroundServiceType = (android.os.IBinder.FIRST_CALL_TRANSACTION + 67);
    static final int TRANSACTION_moveActivityTaskToBack = (android.os.IBinder.FIRST_CALL_TRANSACTION + 68);
    static final int TRANSACTION_getMemoryInfo = (android.os.IBinder.FIRST_CALL_TRANSACTION + 69);
    static final int TRANSACTION_getProcessesInErrorState = (android.os.IBinder.FIRST_CALL_TRANSACTION + 70);
    static final int TRANSACTION_clearApplicationUserData = (android.os.IBinder.FIRST_CALL_TRANSACTION + 71);
    static final int TRANSACTION_stopAppForUser = (android.os.IBinder.FIRST_CALL_TRANSACTION + 72);
    static final int TRANSACTION_registerForegroundServiceObserver = (android.os.IBinder.FIRST_CALL_TRANSACTION + 73);
    static final int TRANSACTION_forceStopPackage = (android.os.IBinder.FIRST_CALL_TRANSACTION + 74);
    static final int TRANSACTION_killPids = (android.os.IBinder.FIRST_CALL_TRANSACTION + 75);
    static final int TRANSACTION_getServices = (android.os.IBinder.FIRST_CALL_TRANSACTION + 76);
    static final int TRANSACTION_getRunningAppProcesses = (android.os.IBinder.FIRST_CALL_TRANSACTION + 77);
    static final int TRANSACTION_peekService = (android.os.IBinder.FIRST_CALL_TRANSACTION + 78);
    static final int TRANSACTION_profileControl = (android.os.IBinder.FIRST_CALL_TRANSACTION + 79);
    static final int TRANSACTION_shutdown = (android.os.IBinder.FIRST_CALL_TRANSACTION + 80);
    static final int TRANSACTION_stopAppSwitches = (android.os.IBinder.FIRST_CALL_TRANSACTION + 81);
    static final int TRANSACTION_resumeAppSwitches = (android.os.IBinder.FIRST_CALL_TRANSACTION + 82);
    static final int TRANSACTION_bindBackupAgent = (android.os.IBinder.FIRST_CALL_TRANSACTION + 83);
    static final int TRANSACTION_backupAgentCreated = (android.os.IBinder.FIRST_CALL_TRANSACTION + 84);
    static final int TRANSACTION_unbindBackupAgent = (android.os.IBinder.FIRST_CALL_TRANSACTION + 85);
    static final int TRANSACTION_handleIncomingUser = (android.os.IBinder.FIRST_CALL_TRANSACTION + 86);
    static final int TRANSACTION_addPackageDependency = (android.os.IBinder.FIRST_CALL_TRANSACTION + 87);
    static final int TRANSACTION_killApplication = (android.os.IBinder.FIRST_CALL_TRANSACTION + 88);
    static final int TRANSACTION_closeSystemDialogs = (android.os.IBinder.FIRST_CALL_TRANSACTION + 89);
    static final int TRANSACTION_getProcessMemoryInfo = (android.os.IBinder.FIRST_CALL_TRANSACTION + 90);
    static final int TRANSACTION_killApplicationProcess = (android.os.IBinder.FIRST_CALL_TRANSACTION + 91);
    static final int TRANSACTION_handleApplicationWtf = (android.os.IBinder.FIRST_CALL_TRANSACTION + 92);
    static final int TRANSACTION_killBackgroundProcesses = (android.os.IBinder.FIRST_CALL_TRANSACTION + 93);
    static final int TRANSACTION_isUserAMonkey = (android.os.IBinder.FIRST_CALL_TRANSACTION + 94);
    static final int TRANSACTION_getRunningExternalApplications = (android.os.IBinder.FIRST_CALL_TRANSACTION + 95);
    static final int TRANSACTION_finishHeavyWeightApp = (android.os.IBinder.FIRST_CALL_TRANSACTION + 96);
    static final int TRANSACTION_handleApplicationStrictModeViolation = (android.os.IBinder.FIRST_CALL_TRANSACTION + 97);
    static final int TRANSACTION_isTopActivityImmersive = (android.os.IBinder.FIRST_CALL_TRANSACTION + 98);
    static final int TRANSACTION_crashApplicationWithType = (android.os.IBinder.FIRST_CALL_TRANSACTION + 99);
    static final int TRANSACTION_crashApplicationWithTypeWithExtras = (android.os.IBinder.FIRST_CALL_TRANSACTION + 100);
    static final int TRANSACTION_getProviderMimeType = (android.os.IBinder.FIRST_CALL_TRANSACTION + 101);
    static final int TRANSACTION_getProviderMimeTypeAsync = (android.os.IBinder.FIRST_CALL_TRANSACTION + 102);
    static final int TRANSACTION_dumpHeap = (android.os.IBinder.FIRST_CALL_TRANSACTION + 103);
    static final int TRANSACTION_isUserRunning = (android.os.IBinder.FIRST_CALL_TRANSACTION + 104);
    static final int TRANSACTION_setPackageScreenCompatMode = (android.os.IBinder.FIRST_CALL_TRANSACTION + 105);
    static final int TRANSACTION_switchUser = (android.os.IBinder.FIRST_CALL_TRANSACTION + 106);
    static final int TRANSACTION_getSwitchingFromUserMessage = (android.os.IBinder.FIRST_CALL_TRANSACTION + 107);
    static final int TRANSACTION_getSwitchingToUserMessage = (android.os.IBinder.FIRST_CALL_TRANSACTION + 108);
    static final int TRANSACTION_setStopUserOnSwitch = (android.os.IBinder.FIRST_CALL_TRANSACTION + 109);
    static final int TRANSACTION_removeTask = (android.os.IBinder.FIRST_CALL_TRANSACTION + 110);
    static final int TRANSACTION_registerProcessObserver = (android.os.IBinder.FIRST_CALL_TRANSACTION + 111);
    static final int TRANSACTION_unregisterProcessObserver = (android.os.IBinder.FIRST_CALL_TRANSACTION + 112);
    static final int TRANSACTION_isIntentSenderTargetedToPackage = (android.os.IBinder.FIRST_CALL_TRANSACTION + 113);
    static final int TRANSACTION_updatePersistentConfiguration = (android.os.IBinder.FIRST_CALL_TRANSACTION + 114);
    static final int TRANSACTION_updatePersistentConfigurationWithAttribution = (android.os.IBinder.FIRST_CALL_TRANSACTION + 115);
    static final int TRANSACTION_getProcessPss = (android.os.IBinder.FIRST_CALL_TRANSACTION + 116);
    static final int TRANSACTION_showBootMessage = (android.os.IBinder.FIRST_CALL_TRANSACTION + 117);
    static final int TRANSACTION_killAllBackgroundProcesses = (android.os.IBinder.FIRST_CALL_TRANSACTION + 118);
    static final int TRANSACTION_getContentProviderExternal = (android.os.IBinder.FIRST_CALL_TRANSACTION + 119);
    static final int TRANSACTION_removeContentProviderExternal = (android.os.IBinder.FIRST_CALL_TRANSACTION + 120);
    static final int TRANSACTION_removeContentProviderExternalAsUser = (android.os.IBinder.FIRST_CALL_TRANSACTION + 121);
    static final int TRANSACTION_getMyMemoryState = (android.os.IBinder.FIRST_CALL_TRANSACTION + 122);
    static final int TRANSACTION_killProcessesBelowForeground = (android.os.IBinder.FIRST_CALL_TRANSACTION + 123);
    static final int TRANSACTION_getCurrentUser = (android.os.IBinder.FIRST_CALL_TRANSACTION + 124);
    static final int TRANSACTION_getCurrentUserId = (android.os.IBinder.FIRST_CALL_TRANSACTION + 125);
    static final int TRANSACTION_getLaunchedFromUid = (android.os.IBinder.FIRST_CALL_TRANSACTION + 126);
    static final int TRANSACTION_unstableProviderDied = (android.os.IBinder.FIRST_CALL_TRANSACTION + 127);
    static final int TRANSACTION_isIntentSenderAnActivity = (android.os.IBinder.FIRST_CALL_TRANSACTION + 128);
    static final int TRANSACTION_startActivityAsUser = (android.os.IBinder.FIRST_CALL_TRANSACTION + 129);
    static final int TRANSACTION_startActivityAsUserWithFeature = (android.os.IBinder.FIRST_CALL_TRANSACTION + 130);
    static final int TRANSACTION_stopUser = (android.os.IBinder.FIRST_CALL_TRANSACTION + 131);
    static final int TRANSACTION_stopUserWithDelayedLocking = (android.os.IBinder.FIRST_CALL_TRANSACTION + 132);
    static final int TRANSACTION_registerUserSwitchObserver = (android.os.IBinder.FIRST_CALL_TRANSACTION + 133);
    static final int TRANSACTION_unregisterUserSwitchObserver = (android.os.IBinder.FIRST_CALL_TRANSACTION + 134);
    static final int TRANSACTION_getRunningUserIds = (android.os.IBinder.FIRST_CALL_TRANSACTION + 135);
    static final int TRANSACTION_requestSystemServerHeapDump = (android.os.IBinder.FIRST_CALL_TRANSACTION + 136);
    static final int TRANSACTION_requestBugReport = (android.os.IBinder.FIRST_CALL_TRANSACTION + 137);
    static final int TRANSACTION_requestBugReportWithDescription = (android.os.IBinder.FIRST_CALL_TRANSACTION + 138);
    static final int TRANSACTION_requestTelephonyBugReport = (android.os.IBinder.FIRST_CALL_TRANSACTION + 139);
    static final int TRANSACTION_requestWifiBugReport = (android.os.IBinder.FIRST_CALL_TRANSACTION + 140);
    static final int TRANSACTION_requestInteractiveBugReportWithDescription = (android.os.IBinder.FIRST_CALL_TRANSACTION + 141);
    static final int TRANSACTION_requestInteractiveBugReport = (android.os.IBinder.FIRST_CALL_TRANSACTION + 142);
    static final int TRANSACTION_requestFullBugReport = (android.os.IBinder.FIRST_CALL_TRANSACTION + 143);
    static final int TRANSACTION_requestRemoteBugReport = (android.os.IBinder.FIRST_CALL_TRANSACTION + 144);
    static final int TRANSACTION_launchBugReportHandlerApp = (android.os.IBinder.FIRST_CALL_TRANSACTION + 145);
    static final int TRANSACTION_getBugreportWhitelistedPackages = (android.os.IBinder.FIRST_CALL_TRANSACTION + 146);
    static final int TRANSACTION_getIntentForIntentSender = (android.os.IBinder.FIRST_CALL_TRANSACTION + 147);
    static final int TRANSACTION_getLaunchedFromPackage = (android.os.IBinder.FIRST_CALL_TRANSACTION + 148);
    static final int TRANSACTION_killUid = (android.os.IBinder.FIRST_CALL_TRANSACTION + 149);
    static final int TRANSACTION_setUserIsMonkey = (android.os.IBinder.FIRST_CALL_TRANSACTION + 150);
    static final int TRANSACTION_hang = (android.os.IBinder.FIRST_CALL_TRANSACTION + 151);
    static final int TRANSACTION_getAllRootTaskInfos = (android.os.IBinder.FIRST_CALL_TRANSACTION + 152);
    static final int TRANSACTION_moveTaskToRootTask = (android.os.IBinder.FIRST_CALL_TRANSACTION + 153);
    static final int TRANSACTION_setFocusedRootTask = (android.os.IBinder.FIRST_CALL_TRANSACTION + 154);
    static final int TRANSACTION_getFocusedRootTaskInfo = (android.os.IBinder.FIRST_CALL_TRANSACTION + 155);
    static final int TRANSACTION_restart = (android.os.IBinder.FIRST_CALL_TRANSACTION + 156);
    static final int TRANSACTION_performIdleMaintenance = (android.os.IBinder.FIRST_CALL_TRANSACTION + 157);
    static final int TRANSACTION_appNotRespondingViaProvider = (android.os.IBinder.FIRST_CALL_TRANSACTION + 158);
    static final int TRANSACTION_getTaskBounds = (android.os.IBinder.FIRST_CALL_TRANSACTION + 159);
    static final int TRANSACTION_setProcessMemoryTrimLevel = (android.os.IBinder.FIRST_CALL_TRANSACTION + 160);
    static final int TRANSACTION_getTagForIntentSender = (android.os.IBinder.FIRST_CALL_TRANSACTION + 161);
    static final int TRANSACTION_startUserInBackground = (android.os.IBinder.FIRST_CALL_TRANSACTION + 162);
    static final int TRANSACTION_isInLockTaskMode = (android.os.IBinder.FIRST_CALL_TRANSACTION + 163);
    static final int TRANSACTION_startActivityFromRecents = (android.os.IBinder.FIRST_CALL_TRANSACTION + 164);
    static final int TRANSACTION_startSystemLockTaskMode = (android.os.IBinder.FIRST_CALL_TRANSACTION + 165);
    static final int TRANSACTION_isTopOfTask = (android.os.IBinder.FIRST_CALL_TRANSACTION + 166);
    static final int TRANSACTION_bootAnimationComplete = (android.os.IBinder.FIRST_CALL_TRANSACTION + 167);
    static final int TRANSACTION_registerTaskStackListener = (android.os.IBinder.FIRST_CALL_TRANSACTION + 168);
    static final int TRANSACTION_unregisterTaskStackListener = (android.os.IBinder.FIRST_CALL_TRANSACTION + 169);
    static final int TRANSACTION_notifyCleartextNetwork = (android.os.IBinder.FIRST_CALL_TRANSACTION + 170);
    static final int TRANSACTION_setTaskResizeable = (android.os.IBinder.FIRST_CALL_TRANSACTION + 171);
    static final int TRANSACTION_resizeTask = (android.os.IBinder.FIRST_CALL_TRANSACTION + 172);
    static final int TRANSACTION_getLockTaskModeState = (android.os.IBinder.FIRST_CALL_TRANSACTION + 173);
    static final int TRANSACTION_setDumpHeapDebugLimit = (android.os.IBinder.FIRST_CALL_TRANSACTION + 174);
    static final int TRANSACTION_dumpHeapFinished = (android.os.IBinder.FIRST_CALL_TRANSACTION + 175);
    static final int TRANSACTION_updateLockTaskPackages = (android.os.IBinder.FIRST_CALL_TRANSACTION + 176);
    static final int TRANSACTION_noteAlarmStart = (android.os.IBinder.FIRST_CALL_TRANSACTION + 177);
    static final int TRANSACTION_noteAlarmFinish = (android.os.IBinder.FIRST_CALL_TRANSACTION + 178);
    static final int TRANSACTION_getPackageProcessState = (android.os.IBinder.FIRST_CALL_TRANSACTION + 179);
    static final int TRANSACTION_startBinderTracking = (android.os.IBinder.FIRST_CALL_TRANSACTION + 180);
    static final int TRANSACTION_stopBinderTrackingAndDump = (android.os.IBinder.FIRST_CALL_TRANSACTION + 181);
    static final int TRANSACTION_suppressResizeConfigChanges = (android.os.IBinder.FIRST_CALL_TRANSACTION + 182);
    static final int TRANSACTION_unlockUser = (android.os.IBinder.FIRST_CALL_TRANSACTION + 183);
    static final int TRANSACTION_killPackageDependents = (android.os.IBinder.FIRST_CALL_TRANSACTION + 184);
    static final int TRANSACTION_makePackageIdle = (android.os.IBinder.FIRST_CALL_TRANSACTION + 185);
    static final int TRANSACTION_getMemoryTrimLevel = (android.os.IBinder.FIRST_CALL_TRANSACTION + 186);
    static final int TRANSACTION_isVrModePackageEnabled = (android.os.IBinder.FIRST_CALL_TRANSACTION + 187);
    static final int TRANSACTION_notifyLockedProfile = (android.os.IBinder.FIRST_CALL_TRANSACTION + 188);
    static final int TRANSACTION_startConfirmDeviceCredentialIntent = (android.os.IBinder.FIRST_CALL_TRANSACTION + 189);
    static final int TRANSACTION_sendIdleJobTrigger = (android.os.IBinder.FIRST_CALL_TRANSACTION + 190);
    static final int TRANSACTION_sendIntentSender = (android.os.IBinder.FIRST_CALL_TRANSACTION + 191);
    static final int TRANSACTION_isBackgroundRestricted = (android.os.IBinder.FIRST_CALL_TRANSACTION + 192);
    static final int TRANSACTION_setRenderThread = (android.os.IBinder.FIRST_CALL_TRANSACTION + 193);
    static final int TRANSACTION_setHasTopUi = (android.os.IBinder.FIRST_CALL_TRANSACTION + 194);
    static final int TRANSACTION_restartUserInBackground = (android.os.IBinder.FIRST_CALL_TRANSACTION + 195);
    static final int TRANSACTION_cancelTaskWindowTransition = (android.os.IBinder.FIRST_CALL_TRANSACTION + 196);
    static final int TRANSACTION_scheduleApplicationInfoChanged = (android.os.IBinder.FIRST_CALL_TRANSACTION + 197);
    static final int TRANSACTION_setPersistentVrThread = (android.os.IBinder.FIRST_CALL_TRANSACTION + 198);
    static final int TRANSACTION_waitForNetworkStateUpdate = (android.os.IBinder.FIRST_CALL_TRANSACTION + 199);
    static final int TRANSACTION_backgroundAllowlistUid = (android.os.IBinder.FIRST_CALL_TRANSACTION + 200);
    static final int TRANSACTION_startUserInBackgroundWithListener = (android.os.IBinder.FIRST_CALL_TRANSACTION + 201);
    static final int TRANSACTION_startDelegateShellPermissionIdentity = (android.os.IBinder.FIRST_CALL_TRANSACTION + 202);
    static final int TRANSACTION_stopDelegateShellPermissionIdentity = (android.os.IBinder.FIRST_CALL_TRANSACTION + 203);
    static final int TRANSACTION_getDelegatedShellPermissions = (android.os.IBinder.FIRST_CALL_TRANSACTION + 204);
    static final int TRANSACTION_getLifeMonitor = (android.os.IBinder.FIRST_CALL_TRANSACTION + 205);
    static final int TRANSACTION_startUserInForegroundWithListener = (android.os.IBinder.FIRST_CALL_TRANSACTION + 206);
    static final int TRANSACTION_appNotResponding = (android.os.IBinder.FIRST_CALL_TRANSACTION + 207);
    static final int TRANSACTION_getHistoricalProcessExitReasons = (android.os.IBinder.FIRST_CALL_TRANSACTION + 208);
    static final int TRANSACTION_killProcessesWhenImperceptible = (android.os.IBinder.FIRST_CALL_TRANSACTION + 209);
    static final int TRANSACTION_setActivityLocusContext = (android.os.IBinder.FIRST_CALL_TRANSACTION + 210);
    static final int TRANSACTION_setProcessStateSummary = (android.os.IBinder.FIRST_CALL_TRANSACTION + 211);
    static final int TRANSACTION_isAppFreezerSupported = (android.os.IBinder.FIRST_CALL_TRANSACTION + 212);
    static final int TRANSACTION_isAppFreezerEnabled = (android.os.IBinder.FIRST_CALL_TRANSACTION + 213);
    static final int TRANSACTION_killUidForPermissionChange = (android.os.IBinder.FIRST_CALL_TRANSACTION + 214);
    static final int TRANSACTION_resetAppErrors = (android.os.IBinder.FIRST_CALL_TRANSACTION + 215);
    static final int TRANSACTION_enableAppFreezer = (android.os.IBinder.FIRST_CALL_TRANSACTION + 216);
    static final int TRANSACTION_enableFgsNotificationRateLimit = (android.os.IBinder.FIRST_CALL_TRANSACTION + 217);
    static final int TRANSACTION_holdLock = (android.os.IBinder.FIRST_CALL_TRANSACTION + 218);
    static final int TRANSACTION_startProfile = (android.os.IBinder.FIRST_CALL_TRANSACTION + 219);
    static final int TRANSACTION_stopProfile = (android.os.IBinder.FIRST_CALL_TRANSACTION + 220);
    static final int TRANSACTION_queryIntentComponentsForIntentSender = (android.os.IBinder.FIRST_CALL_TRANSACTION + 221);
    static final int TRANSACTION_getUidProcessCapabilities = (android.os.IBinder.FIRST_CALL_TRANSACTION + 222);
    static final int TRANSACTION_waitForBroadcastIdle = (android.os.IBinder.FIRST_CALL_TRANSACTION + 223);
    static final int TRANSACTION_getBackgroundRestrictionExemptionReason = (android.os.IBinder.FIRST_CALL_TRANSACTION + 224);
    public static java.lang.String getDefaultTransactionName(int transactionCode)
    {
        switch (transactionCode)
        {
            case TRANSACTION_openContentUri:
            {
                return "openContentUri";
            }
            case TRANSACTION_registerUidObserver:
            {
                return "registerUidObserver";
            }
            case TRANSACTION_unregisterUidObserver:
            {
                return "unregisterUidObserver";
            }
            case TRANSACTION_isUidActive:
            {
                return "isUidActive";
            }
            case TRANSACTION_getUidProcessState:
            {
                return "getUidProcessState";
            }
            case TRANSACTION_checkPermission:
            {
                return "checkPermission";
            }
            case TRANSACTION_handleApplicationCrash:
            {
                return "handleApplicationCrash";
            }
            case TRANSACTION_startActivity:
            {
                return "startActivity";
            }
            case TRANSACTION_startActivityWithFeature:
            {
                return "startActivityWithFeature";
            }
            case TRANSACTION_unhandledBack:
            {
                return "unhandledBack";
            }
            case TRANSACTION_finishActivity:
            {
                return "finishActivity";
            }
            case TRANSACTION_registerReceiver:
            {
                return "registerReceiver";
            }
            case TRANSACTION_registerReceiverWithFeature:
            {
                return "registerReceiverWithFeature";
            }
            case TRANSACTION_unregisterReceiver:
            {
                return "unregisterReceiver";
            }
            case TRANSACTION_broadcastIntent:
            {
                return "broadcastIntent";
            }
            case TRANSACTION_broadcastIntentWithFeature:
            {
                return "broadcastIntentWithFeature";
            }
            case TRANSACTION_unbroadcastIntent:
            {
                return "unbroadcastIntent";
            }
            case TRANSACTION_finishReceiver:
            {
                return "finishReceiver";
            }
            case TRANSACTION_attachApplication:
            {
                return "attachApplication";
            }
            case TRANSACTION_getTasks:
            {
                return "getTasks";
            }
            case TRANSACTION_moveTaskToFront:
            {
                return "moveTaskToFront";
            }
            case TRANSACTION_getTaskForActivity:
            {
                return "getTaskForActivity";
            }
            case TRANSACTION_getContentProvider:
            {
                return "getContentProvider";
            }
            case TRANSACTION_publishContentProviders:
            {
                return "publishContentProviders";
            }
            case TRANSACTION_refContentProvider:
            {
                return "refContentProvider";
            }
            case TRANSACTION_getRunningServiceControlPanel:
            {
                return "getRunningServiceControlPanel";
            }
            case TRANSACTION_startService:
            {
                return "startService";
            }
            case TRANSACTION_stopService:
            {
                return "stopService";
            }
            case TRANSACTION_bindService:
            {
                return "bindService";
            }
            case TRANSACTION_bindServiceInstance:
            {
                return "bindServiceInstance";
            }
            case TRANSACTION_updateServiceGroup:
            {
                return "updateServiceGroup";
            }
            case TRANSACTION_unbindService:
            {
                return "unbindService";
            }
            case TRANSACTION_publishService:
            {
                return "publishService";
            }
            case TRANSACTION_setDebugApp:
            {
                return "setDebugApp";
            }
            case TRANSACTION_setAgentApp:
            {
                return "setAgentApp";
            }
            case TRANSACTION_setAlwaysFinish:
            {
                return "setAlwaysFinish";
            }
            case TRANSACTION_startInstrumentation:
            {
                return "startInstrumentation";
            }
            case TRANSACTION_addInstrumentationResults:
            {
                return "addInstrumentationResults";
            }
            case TRANSACTION_finishInstrumentation:
            {
                return "finishInstrumentation";
            }
            case TRANSACTION_getConfiguration:
            {
                return "getConfiguration";
            }
            case TRANSACTION_updateConfiguration:
            {
                return "updateConfiguration";
            }
            case TRANSACTION_updateMccMncConfiguration:
            {
                return "updateMccMncConfiguration";
            }
            case TRANSACTION_stopServiceToken:
            {
                return "stopServiceToken";
            }
            case TRANSACTION_setProcessLimit:
            {
                return "setProcessLimit";
            }
            case TRANSACTION_getProcessLimit:
            {
                return "getProcessLimit";
            }
            case TRANSACTION_checkUriPermission:
            {
                return "checkUriPermission";
            }
            case TRANSACTION_checkUriPermissions:
            {
                return "checkUriPermissions";
            }
            case TRANSACTION_grantUriPermission:
            {
                return "grantUriPermission";
            }
            case TRANSACTION_revokeUriPermission:
            {
                return "revokeUriPermission";
            }
            case TRANSACTION_setActivityController:
            {
                return "setActivityController";
            }
            case TRANSACTION_showWaitingForDebugger:
            {
                return "showWaitingForDebugger";
            }
            case TRANSACTION_signalPersistentProcesses:
            {
                return "signalPersistentProcesses";
            }
            case TRANSACTION_getRecentTasks:
            {
                return "getRecentTasks";
            }
            case TRANSACTION_serviceDoneExecuting:
            {
                return "serviceDoneExecuting";
            }
            case TRANSACTION_getIntentSender:
            {
                return "getIntentSender";
            }
            case TRANSACTION_getIntentSenderWithFeature:
            {
                return "getIntentSenderWithFeature";
            }
            case TRANSACTION_cancelIntentSender:
            {
                return "cancelIntentSender";
            }
            case TRANSACTION_getInfoForIntentSender:
            {
                return "getInfoForIntentSender";
            }
            case TRANSACTION_registerIntentSenderCancelListenerEx:
            {
                return "registerIntentSenderCancelListenerEx";
            }
            case TRANSACTION_unregisterIntentSenderCancelListener:
            {
                return "unregisterIntentSenderCancelListener";
            }
            case TRANSACTION_enterSafeMode:
            {
                return "enterSafeMode";
            }
            case TRANSACTION_noteWakeupAlarm:
            {
                return "noteWakeupAlarm";
            }
            case TRANSACTION_removeContentProvider:
            {
                return "removeContentProvider";
            }
            case TRANSACTION_setRequestedOrientation:
            {
                return "setRequestedOrientation";
            }
            case TRANSACTION_unbindFinished:
            {
                return "unbindFinished";
            }
            case TRANSACTION_setProcessImportant:
            {
                return "setProcessImportant";
            }
            case TRANSACTION_setServiceForeground:
            {
                return "setServiceForeground";
            }
            case TRANSACTION_getForegroundServiceType:
            {
                return "getForegroundServiceType";
            }
            case TRANSACTION_moveActivityTaskToBack:
            {
                return "moveActivityTaskToBack";
            }
            case TRANSACTION_getMemoryInfo:
            {
                return "getMemoryInfo";
            }
            case TRANSACTION_getProcessesInErrorState:
            {
                return "getProcessesInErrorState";
            }
            case TRANSACTION_clearApplicationUserData:
            {
                return "clearApplicationUserData";
            }
            case TRANSACTION_stopAppForUser:
            {
                return "stopAppForUser";
            }
            case TRANSACTION_registerForegroundServiceObserver:
            {
                return "registerForegroundServiceObserver";
            }
            case TRANSACTION_forceStopPackage:
            {
                return "forceStopPackage";
            }
            case TRANSACTION_killPids:
            {
                return "killPids";
            }
            case TRANSACTION_getServices:
            {
                return "getServices";
            }
            case TRANSACTION_getRunningAppProcesses:
            {
                return "getRunningAppProcesses";
            }
            case TRANSACTION_peekService:
            {
                return "peekService";
            }
            case TRANSACTION_profileControl:
            {
                return "profileControl";
            }
            case TRANSACTION_shutdown:
            {
                return "shutdown";
            }
            case TRANSACTION_stopAppSwitches:
            {
                return "stopAppSwitches";
            }
            case TRANSACTION_resumeAppSwitches:
            {
                return "resumeAppSwitches";
            }
            case TRANSACTION_bindBackupAgent:
            {
                return "bindBackupAgent";
            }
            case TRANSACTION_backupAgentCreated:
            {
                return "backupAgentCreated";
            }
            case TRANSACTION_unbindBackupAgent:
            {
                return "unbindBackupAgent";
            }
            case TRANSACTION_handleIncomingUser:
            {
                return "handleIncomingUser";
            }
            case TRANSACTION_addPackageDependency:
            {
                return "addPackageDependency";
            }
            case TRANSACTION_killApplication:
            {
                return "killApplication";
            }
            case TRANSACTION_closeSystemDialogs:
            {
                return "closeSystemDialogs";
            }
            case TRANSACTION_getProcessMemoryInfo:
            {
                return "getProcessMemoryInfo";
            }
            case TRANSACTION_killApplicationProcess:
            {
                return "killApplicationProcess";
            }
            case TRANSACTION_handleApplicationWtf:
            {
                return "handleApplicationWtf";
            }
            case TRANSACTION_killBackgroundProcesses:
            {
                return "killBackgroundProcesses";
            }
            case TRANSACTION_isUserAMonkey:
            {
                return "isUserAMonkey";
            }
            case TRANSACTION_getRunningExternalApplications:
            {
                return "getRunningExternalApplications";
            }
            case TRANSACTION_finishHeavyWeightApp:
            {
                return "finishHeavyWeightApp";
            }
            case TRANSACTION_handleApplicationStrictModeViolation:
            {
                return "handleApplicationStrictModeViolation";
            }
            case TRANSACTION_isTopActivityImmersive:
            {
                return "isTopActivityImmersive";
            }
            case TRANSACTION_crashApplicationWithType:
            {
                return "crashApplicationWithType";
            }
            case TRANSACTION_crashApplicationWithTypeWithExtras:
            {
                return "crashApplicationWithTypeWithExtras";
            }
            case TRANSACTION_getProviderMimeType:
            {
                return "getProviderMimeType";
            }
            case TRANSACTION_getProviderMimeTypeAsync:
            {
                return "getProviderMimeTypeAsync";
            }
            case TRANSACTION_dumpHeap:
            {
                return "dumpHeap";
            }
            case TRANSACTION_isUserRunning:
            {
                return "isUserRunning";
            }
            case TRANSACTION_setPackageScreenCompatMode:
            {
                return "setPackageScreenCompatMode";
            }
            case TRANSACTION_switchUser:
            {
                return "switchUser";
            }
            case TRANSACTION_getSwitchingFromUserMessage:
            {
                return "getSwitchingFromUserMessage";
            }
            case TRANSACTION_getSwitchingToUserMessage:
            {
                return "getSwitchingToUserMessage";
            }
            case TRANSACTION_setStopUserOnSwitch:
            {
                return "setStopUserOnSwitch";
            }
            case TRANSACTION_removeTask:
            {
                return "removeTask";
            }
            case TRANSACTION_registerProcessObserver:
            {
                return "registerProcessObserver";
            }
            case TRANSACTION_unregisterProcessObserver:
            {
                return "unregisterProcessObserver";
            }
            case TRANSACTION_isIntentSenderTargetedToPackage:
            {
                return "isIntentSenderTargetedToPackage";
            }
            case TRANSACTION_updatePersistentConfiguration:
            {
                return "updatePersistentConfiguration";
            }
            case TRANSACTION_updatePersistentConfigurationWithAttribution:
            {
                return "updatePersistentConfigurationWithAttribution";
            }
            case TRANSACTION_getProcessPss:
            {
                return "getProcessPss";
            }
            case TRANSACTION_showBootMessage:
            {
                return "showBootMessage";
            }
            case TRANSACTION_killAllBackgroundProcesses:
            {
                return "killAllBackgroundProcesses";
            }
            case TRANSACTION_getContentProviderExternal:
            {
                return "getContentProviderExternal";
            }
            case TRANSACTION_removeContentProviderExternal:
            {
                return "removeContentProviderExternal";
            }
            case TRANSACTION_removeContentProviderExternalAsUser:
            {
                return "removeContentProviderExternalAsUser";
            }
            case TRANSACTION_getMyMemoryState:
            {
                return "getMyMemoryState";
            }
            case TRANSACTION_killProcessesBelowForeground:
            {
                return "killProcessesBelowForeground";
            }
            case TRANSACTION_getCurrentUser:
            {
                return "getCurrentUser";
            }
            case TRANSACTION_getCurrentUserId:
            {
                return "getCurrentUserId";
            }
            case TRANSACTION_getLaunchedFromUid:
            {
                return "getLaunchedFromUid";
            }
            case TRANSACTION_unstableProviderDied:
            {
                return "unstableProviderDied";
            }
            case TRANSACTION_isIntentSenderAnActivity:
            {
                return "isIntentSenderAnActivity";
            }
            case TRANSACTION_startActivityAsUser:
            {
                return "startActivityAsUser";
            }
            case TRANSACTION_startActivityAsUserWithFeature:
            {
                return "startActivityAsUserWithFeature";
            }
            case TRANSACTION_stopUser:
            {
                return "stopUser";
            }
            case TRANSACTION_stopUserWithDelayedLocking:
            {
                return "stopUserWithDelayedLocking";
            }
            case TRANSACTION_registerUserSwitchObserver:
            {
                return "registerUserSwitchObserver";
            }
            case TRANSACTION_unregisterUserSwitchObserver:
            {
                return "unregisterUserSwitchObserver";
            }
            case TRANSACTION_getRunningUserIds:
            {
                return "getRunningUserIds";
            }
            case TRANSACTION_requestSystemServerHeapDump:
            {
                return "requestSystemServerHeapDump";
            }
            case TRANSACTION_requestBugReport:
            {
                return "requestBugReport";
            }
            case TRANSACTION_requestBugReportWithDescription:
            {
                return "requestBugReportWithDescription";
            }
            case TRANSACTION_requestTelephonyBugReport:
            {
                return "requestTelephonyBugReport";
            }
            case TRANSACTION_requestWifiBugReport:
            {
                return "requestWifiBugReport";
            }
            case TRANSACTION_requestInteractiveBugReportWithDescription:
            {
                return "requestInteractiveBugReportWithDescription";
            }
            case TRANSACTION_requestInteractiveBugReport:
            {
                return "requestInteractiveBugReport";
            }
            case TRANSACTION_requestFullBugReport:
            {
                return "requestFullBugReport";
            }
            case TRANSACTION_requestRemoteBugReport:
            {
                return "requestRemoteBugReport";
            }
            case TRANSACTION_launchBugReportHandlerApp:
            {
                return "launchBugReportHandlerApp";
            }
            case TRANSACTION_getBugreportWhitelistedPackages:
            {
                return "getBugreportWhitelistedPackages";
            }
            case TRANSACTION_getIntentForIntentSender:
            {
                return "getIntentForIntentSender";
            }
            case TRANSACTION_getLaunchedFromPackage:
            {
                return "getLaunchedFromPackage";
            }
            case TRANSACTION_killUid:
            {
                return "killUid";
            }
            case TRANSACTION_setUserIsMonkey:
            {
                return "setUserIsMonkey";
            }
            case TRANSACTION_hang:
            {
                return "hang";
            }
            case TRANSACTION_getAllRootTaskInfos:
            {
                return "getAllRootTaskInfos";
            }
            case TRANSACTION_moveTaskToRootTask:
            {
                return "moveTaskToRootTask";
            }
            case TRANSACTION_setFocusedRootTask:
            {
                return "setFocusedRootTask";
            }
            case TRANSACTION_getFocusedRootTaskInfo:
            {
                return "getFocusedRootTaskInfo";
            }
            case TRANSACTION_restart:
            {
                return "restart";
            }
            case TRANSACTION_performIdleMaintenance:
            {
                return "performIdleMaintenance";
            }
            case TRANSACTION_appNotRespondingViaProvider:
            {
                return "appNotRespondingViaProvider";
            }
            case TRANSACTION_getTaskBounds:
            {
                return "getTaskBounds";
            }
            case TRANSACTION_setProcessMemoryTrimLevel:
            {
                return "setProcessMemoryTrimLevel";
            }
            case TRANSACTION_getTagForIntentSender:
            {
                return "getTagForIntentSender";
            }
            case TRANSACTION_startUserInBackground:
            {
                return "startUserInBackground";
            }
            case TRANSACTION_isInLockTaskMode:
            {
                return "isInLockTaskMode";
            }
            case TRANSACTION_startActivityFromRecents:
            {
                return "startActivityFromRecents";
            }
            case TRANSACTION_startSystemLockTaskMode:
            {
                return "startSystemLockTaskMode";
            }
            case TRANSACTION_isTopOfTask:
            {
                return "isTopOfTask";
            }
            case TRANSACTION_bootAnimationComplete:
            {
                return "bootAnimationComplete";
            }
            case TRANSACTION_registerTaskStackListener:
            {
                return "registerTaskStackListener";
            }
            case TRANSACTION_unregisterTaskStackListener:
            {
                return "unregisterTaskStackListener";
            }
            case TRANSACTION_notifyCleartextNetwork:
            {
                return "notifyCleartextNetwork";
            }
            case TRANSACTION_setTaskResizeable:
            {
                return "setTaskResizeable";
            }
            case TRANSACTION_resizeTask:
            {
                return "resizeTask";
            }
            case TRANSACTION_getLockTaskModeState:
            {
                return "getLockTaskModeState";
            }
            case TRANSACTION_setDumpHeapDebugLimit:
            {
                return "setDumpHeapDebugLimit";
            }
            case TRANSACTION_dumpHeapFinished:
            {
                return "dumpHeapFinished";
            }
            case TRANSACTION_updateLockTaskPackages:
            {
                return "updateLockTaskPackages";
            }
            case TRANSACTION_noteAlarmStart:
            {
                return "noteAlarmStart";
            }
            case TRANSACTION_noteAlarmFinish:
            {
                return "noteAlarmFinish";
            }
            case TRANSACTION_getPackageProcessState:
            {
                return "getPackageProcessState";
            }
            case TRANSACTION_startBinderTracking:
            {
                return "startBinderTracking";
            }
            case TRANSACTION_stopBinderTrackingAndDump:
            {
                return "stopBinderTrackingAndDump";
            }
            case TRANSACTION_suppressResizeConfigChanges:
            {
                return "suppressResizeConfigChanges";
            }
            case TRANSACTION_unlockUser:
            {
                return "unlockUser";
            }
            case TRANSACTION_killPackageDependents:
            {
                return "killPackageDependents";
            }
            case TRANSACTION_makePackageIdle:
            {
                return "makePackageIdle";
            }
            case TRANSACTION_getMemoryTrimLevel:
            {
                return "getMemoryTrimLevel";
            }
            case TRANSACTION_isVrModePackageEnabled:
            {
                return "isVrModePackageEnabled";
            }
            case TRANSACTION_notifyLockedProfile:
            {
                return "notifyLockedProfile";
            }
            case TRANSACTION_startConfirmDeviceCredentialIntent:
            {
                return "startConfirmDeviceCredentialIntent";
            }
            case TRANSACTION_sendIdleJobTrigger:
            {
                return "sendIdleJobTrigger";
            }
            case TRANSACTION_sendIntentSender:
            {
                return "sendIntentSender";
            }
            case TRANSACTION_isBackgroundRestricted:
            {
                return "isBackgroundRestricted";
            }
            case TRANSACTION_setRenderThread:
            {
                return "setRenderThread";
            }
            case TRANSACTION_setHasTopUi:
            {
                return "setHasTopUi";
            }
            case TRANSACTION_restartUserInBackground:
            {
                return "restartUserInBackground";
            }
            case TRANSACTION_cancelTaskWindowTransition:
            {
                return "cancelTaskWindowTransition";
            }
            case TRANSACTION_scheduleApplicationInfoChanged:
            {
                return "scheduleApplicationInfoChanged";
            }
            case TRANSACTION_setPersistentVrThread:
            {
                return "setPersistentVrThread";
            }
            case TRANSACTION_waitForNetworkStateUpdate:
            {
                return "waitForNetworkStateUpdate";
            }
            case TRANSACTION_backgroundAllowlistUid:
            {
                return "backgroundAllowlistUid";
            }
            case TRANSACTION_startUserInBackgroundWithListener:
            {
                return "startUserInBackgroundWithListener";
            }
            case TRANSACTION_startDelegateShellPermissionIdentity:
            {
                return "startDelegateShellPermissionIdentity";
            }
            case TRANSACTION_stopDelegateShellPermissionIdentity:
            {
                return "stopDelegateShellPermissionIdentity";
            }
            case TRANSACTION_getDelegatedShellPermissions:
            {
                return "getDelegatedShellPermissions";
            }
            case TRANSACTION_getLifeMonitor:
            {
                return "getLifeMonitor";
            }
            case TRANSACTION_startUserInForegroundWithListener:
            {
                return "startUserInForegroundWithListener";
            }
            case TRANSACTION_appNotResponding:
            {
                return "appNotResponding";
            }
            case TRANSACTION_getHistoricalProcessExitReasons:
            {
                return "getHistoricalProcessExitReasons";
            }
            case TRANSACTION_killProcessesWhenImperceptible:
            {
                return "killProcessesWhenImperceptible";
            }
            case TRANSACTION_setActivityLocusContext:
            {
                return "setActivityLocusContext";
            }
            case TRANSACTION_setProcessStateSummary:
            {
                return "setProcessStateSummary";
            }
            case TRANSACTION_isAppFreezerSupported:
            {
                return "isAppFreezerSupported";
            }
            case TRANSACTION_isAppFreezerEnabled:
            {
                return "isAppFreezerEnabled";
            }
            case TRANSACTION_killUidForPermissionChange:
            {
                return "killUidForPermissionChange";
            }
            case TRANSACTION_resetAppErrors:
            {
                return "resetAppErrors";
            }
            case TRANSACTION_enableAppFreezer:
            {
                return "enableAppFreezer";
            }
            case TRANSACTION_enableFgsNotificationRateLimit:
            {
                return "enableFgsNotificationRateLimit";
            }
            case TRANSACTION_holdLock:
            {
                return "holdLock";
            }
            case TRANSACTION_startProfile:
            {
                return "startProfile";
            }
            case TRANSACTION_stopProfile:
            {
                return "stopProfile";
            }
            case TRANSACTION_queryIntentComponentsForIntentSender:
            {
                return "queryIntentComponentsForIntentSender";
            }
            case TRANSACTION_getUidProcessCapabilities:
            {
                return "getUidProcessCapabilities";
            }
            case TRANSACTION_waitForBroadcastIdle:
            {
                return "waitForBroadcastIdle";
            }
            case TRANSACTION_getBackgroundRestrictionExemptionReason:
            {
                return "getBackgroundRestrictionExemptionReason";
            }
            default:
            {
                return null;
            }
        }
    }

    private static final String TAG = "Transca";
    private static final void Log_arg(Object _arg,int index){
        Log.d(TAG, String.format("onTransactPrintParcel() called with: _arg%d = [%s]",index,_arg));
    }
    private static final void Log_arg(Object _arg){
        Log.d(TAG, String.format("onTransactPrintParcel() called with: _arg%d = [%s]",0,_arg));
    }
    private static final void Log_readStrongBinder(Parcel data){
        Log.d(TAG, String.format("onTransactPrintParcel() called with: StrongBinder_arg = [%s]",data.readStrongBinder()));
    }
    private static final void Log_readBoolean(Parcel data){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            Log.d(TAG, String.format("onTransactPrintParcel() called with: Boolean_arg = [%s]",data.readBoolean()+""));
        }
    }
    private static final void Log_readStringArray(Parcel data){
        String[] _arg7;
        _arg7 = data.createStringArray();
        Log.d(TAG, String.format("onTransactPrintParcel() called with: StringArray_arg = [%s]",_arg7));
    }
    private static final void Log_readString(Parcel data){
        Log.d(TAG, String.format("onTransactPrintParcel() called with: String_arg = [%s]",data.readString()));
    }
    private static final void Log_readInt(Parcel data){
        Log.d(TAG, String.format("onTransactPrintParcel() called with: Int_arg = [%s]",data.readInt()));
    }
    private static final void Log_readLong(Parcel data){
        Log.d(TAG, String.format("onTransactPrintParcel() called with: Long_arg = [%s]",data.readLong()));
    }
    private static final void Log_readTypedObject(Parcel data, Parcelable.Creator creator){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Log.d(TAG, String.format("onTransactPrintParcel() called with: TypedObject_arg = [%s]",data.readTypedObject(creator)));
        }
    }
     public static void onTransactPrintParcel(int code, Parcel data)
    {
        Log.d(TAG, "onTransactPrintParcel() called with: code = [" + code + "], data = [" + data + "]");
        if (data==null) return;
        String descriptor = DESCRIPTOR;
        if (code >= IBinder.FIRST_CALL_TRANSACTION && code <= IBinder.LAST_CALL_TRANSACTION) {
            //data.enforceInterface(descriptor);
            data.readInt();data.readInt();
        }
        if (code == INTERFACE_TRANSACTION) {
            //reply.writeString(descriptor);
            return ;
        }
        switch (code)
        {
            case TRANSACTION_openContentUri:
            {
                String _arg0;
                _arg0 = data.readString();
                Log_arg( _arg0,0 );
                //data.enforceNoDataAvail();
                //android.os.ParcelFileDescriptor _result = this.openContentUri(_arg0);
                //reply.writeNoException();
                //reply.writeTypedObject(_result, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
                break;
            }
            case TRANSACTION_registerUidObserver:
            {
//                android.app.IUidObserver _arg0;
//                _arg0 = android.app.IUidObserver.Stub.asInterface(data.readStrongBinder());
                IBinder t=data.readStrongBinder();
                Log_arg(t,0);
                int _arg1;
                _arg1 = data.readInt();
                
                Log_arg(_arg1,1);
                int _arg2;
                _arg2 = data.readInt();
                Log_arg(_arg2,2);
                String _arg3;
                _arg3 = data.readString();
                Log_arg(_arg3,3);
                //data.enforceNoDataAvail();
                //this.registerUidObserver(_arg0, _arg1, _arg2, _arg3);
                //reply.writeNoException();
                break;
            }
            case TRANSACTION_unregisterUidObserver:
            {
//                android.app.IUidObserver _arg0;
//                _arg0 = android.app.IUidObserver.Stub.asInterface(data.readStrongBinder());
                IBinder t=data.readStrongBinder();
                Log_arg(t,0);
                //data.enforceNoDataAvail();
//                this.unregisterUidObserver(_arg0);
                //reply.writeNoException();
                break;
            }
            case TRANSACTION_isUidActive:
            {
                int _arg0;
                _arg0 = data.readInt();
               
                Log_arg(_arg0,0);
                String _arg1;
                _arg1 = data.readString();
                Log_arg(_arg1,1);
                //data.enforceNoDataAvail();
                //boolean _result = this.isUidActive(_arg0, _arg1);
                //reply.writeNoException();
                //reply.writeBoolean(_result);
                break;
            }
            case TRANSACTION_getUidProcessState:
            {
                int _arg0;
                _arg0 = data.readInt();
                Log_arg(_arg0,0);
                String _arg1;
                _arg1 = data.readString();
                Log_arg(_arg1,1);
                //data.enforceNoDataAvail();
                ////int _result = this.getUidProcessState(_arg0, _arg1);
                //reply.writeNoException();
                //reply.writeInt(_result);
                break;
            }
            case TRANSACTION_checkPermission:
            {
                String _arg0;
                _arg0 = data.readString();
                int _arg1;
                _arg1 = data.readInt();
                int _arg2;
                _arg2 = data.readInt();
                //data.enforceNoDataAvail();
                //int _result = this.checkPermission(_arg0, _arg1, _arg2);
                //reply.writeNoException();
                //reply.writeInt(_result);
                break;
            }
            case TRANSACTION_handleApplicationCrash:
            {
//                android.os.IBinder _arg0;
//                _arg0 = data.readStrongBinder();
//                android.app.ApplicationErrorReport.ParcelableCrashInfo _arg1;
//                _arg1 = data.readTypedObject(android.app.ApplicationErrorReport.ParcelableCrashInfo.CREATOR);
                //data.enforceNoDataAvail();
                //this.handleApplicationCrash(_arg0, _arg1);
                //reply.writeNoException();
                break;
            }
            case TRANSACTION_startActivity:
            {
//                android.app.IApplicationThread _arg0;
//                _arg0 = android.app.IApplicationThread.Stub.asInterface(data.readStrongBinder());
                IBinder t=data.readStrongBinder();
                Log_arg(t,0);
                String _arg1;
                _arg1 = data.readString();
                Log_arg(_arg1,1);
                Intent _arg2;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    _arg2 = data.readTypedObject(Intent.CREATOR);
                    Log_arg(_arg2,2);
                }

                String _arg3;
                _arg3 = data.readString();
                Log_arg(_arg3,3);
                IBinder _arg4;
                _arg4 = data.readStrongBinder();
                Log_arg(_arg4,4);
                String _arg5;
                _arg5 = data.readString();
                Log_arg(_arg5,5);
                int _arg6;
                _arg6 = data.readInt();
                Log_arg(_arg6,6);
                int _arg7;
                _arg7 = data.readInt();
                Log_arg(_arg7,7);
                ProfilerInfo _arg8;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    _arg8 = data.readTypedObject(ProfilerInfo.CREATOR);
                    Log_arg(_arg8,8);
                }

                Bundle _arg9;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    _arg9 = data.readTypedObject(Bundle.CREATOR);
                    Log_arg(_arg9,9);
                }

                //data.enforceNoDataAvail();
                //int _result = this.startActivity(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5, _arg6, _arg7, _arg8, _arg9);
                //reply.writeNoException();
                //reply.writeInt(_result);
                break;
            }
            case TRANSACTION_startActivityWithFeature:
            {
                IBinder t=data.readStrongBinder();
                Log_arg(t,0);
                String _arg1;
                _arg1 = data.readString();
                Log_arg(_arg1,1);
                String _arg2;
                _arg2 = data.readString();
                Log_arg(_arg2,2);
                Intent _arg3;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    _arg3 = data.readTypedObject(Intent.CREATOR);
                    Log_arg(_arg3,3);
                }
                String _arg4;
                _arg4 = data.readString();
                Log_arg(_arg4,4);
                IBinder _arg5;
                _arg5 = data.readStrongBinder();
                Log_arg(_arg5,5);
                String _arg6;
                _arg6 = data.readString();
                Log_arg(_arg6,6);
                int _arg7;
                _arg7 = data.readInt();
                Log_arg(_arg7,7);
                int _arg8;
                _arg8 = data.readInt();
                Log_arg(_arg8,8);
                ProfilerInfo _arg9;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    _arg9 = data.readTypedObject(ProfilerInfo.CREATOR);
                    Log_arg(_arg9,9);
                }
                Bundle _arg10;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    _arg10 = data.readTypedObject(Bundle.CREATOR);
                    Log_arg(_arg10,10);
                }

                //data.enforceNoDataAvail();
                //int _result = this.startActivityWithFeature(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5, _arg6, _arg7, _arg8, _arg9, _arg10);
                //reply.writeNoException();
                //reply.writeInt(_result);
                break;
            }
            case TRANSACTION_unhandledBack:
            {
                //this.unhandledBack();
                //reply.writeNoException();
                break;
            }
            case TRANSACTION_finishActivity:
            {
                IBinder _arg0;
                _arg0 = data.readStrongBinder();
                Log_arg(_arg0,0);
                int _arg1;
                _arg1 = data.readInt();
                Log_arg(_arg1,1);
                Intent _arg2;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    _arg2 = data.readTypedObject(Intent.CREATOR);
                    Log_arg(_arg2,2);
                }

                int _arg3;
                _arg3 = data.readInt();
                Log_arg(_arg3,3);
                //data.enforceNoDataAvail();
                //boolean _result = this.finishActivity(_arg0, _arg1, _arg2, _arg3);
                //reply.writeNoException();
                //reply.writeBoolean(_result);
                break;
            }
            case TRANSACTION_registerReceiver:
            {
                IBinder _arg0;
                _arg0 = data.readStrongBinder();
                Log_arg(_arg0,0);
                String _arg1;
                _arg1 = data.readString();
                IBinder _arg2;
                _arg2 = data.readStrongBinder();
                Log_arg(_arg2,2);
                IntentFilter _arg3;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    _arg3 = data.readTypedObject(IntentFilter.CREATOR);
                    Log_arg(_arg3,3);
                }
                String _arg4;
                _arg4 = data.readString();
                Log_arg(_arg4,4);
                int _arg5;
                _arg5 = data.readInt();
                Log_arg(_arg5,5);
                int _arg6;
                _arg6 = data.readInt();
                Log_arg(_arg6,6);
                //data.enforceNoDataAvail();
                //Intent _result = this.registerReceiver(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5, _arg6);
                //reply.writeNoException();
                //reply.writeTypedObject(_result, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
                break;
            }
            case TRANSACTION_registerReceiverWithFeature:
            {
                Log_readStrongBinder(data);
                Log_readString(data);
                Log_readString(data);
                Log_readString(data);
                Log_readStrongBinder(data);
                Log_readTypedObject(data,IntentFilter.CREATOR);
                Log_readString(data);
                Log_readInt(data);
                Log_readInt(data);
                String _arg6;
                _arg6 = data.readString();
                int _arg7;
                _arg7 = data.readInt();
                int _arg8;
                _arg8 = data.readInt();
                //data.enforceNoDataAvail();
                //Intent _result = this.registerReceiverWithFeature(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5, _arg6, _arg7, _arg8);
                //reply.writeNoException();
                //reply.writeTypedObject(_result, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
                break;
            }
            case TRANSACTION_unregisterReceiver:
            {
                Log_readStrongBinder(data);
//                android.content.IIntentReceiver _arg0;
//                _arg0 = android.content.IIntentReceiver.Stub.asInterface(data.readStrongBinder());
//                //data.enforceNoDataAvail();
//                this.unregisterReceiver(_arg0);
                //reply.writeNoException();
                break;
            }
            case TRANSACTION_broadcastIntent:
            {
                Log_readStrongBinder(data);
                Log_readTypedObject(data,IntentFilter.CREATOR);
                Log_readString(data);
                Log_readStrongBinder(data);
                Log_readInt(data);
                Log_readString(data);
                Log_readStringArray(data);
                Log_readInt(data);
                Log_readTypedObject(data,IntentFilter.CREATOR);
               Log_readBoolean(data);
                Log_readBoolean(data);
                Log_readInt(data);

                //data.enforceNoDataAvail();
                //int _result = this.broadcastIntent(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5, _arg6, _arg7, _arg8, _arg9, _arg10, _arg11, _arg12);
                //reply.writeNoException();
                //reply.writeInt(_result);
                break;
            }
            case TRANSACTION_broadcastIntentWithFeature:
            {
                Log_readStrongBinder(data);
                Log_readString(data);
                Log_readTypedObject(data,IntentFilter.CREATOR);
                Log_readString(data);
                Log_readStrongBinder(data);
                Log_readInt(data);
                Log_readString(data);
                Log_readTypedObject(data,IntentFilter.CREATOR);
                Log_readStringArray(data);
                Log_readStringArray(data);
                Log_readStringArray(data);
                Log_readInt(data);
                Log_readTypedObject(data,IntentFilter.CREATOR);
                Log_readBoolean(data);
                Log_readBoolean(data);
                Log_readInt(data);
//                android.app.IApplicationThread _arg0;
//                _arg0 = android.app.IApplicationThread.Stub.asInterface(data.readStrongBinder());
//                String _arg1;
//                _arg1 = data.readString();
//                Intent _arg2;
//                _arg2 = data.readTypedObject(Intent.CREATOR);
//                String _arg3;
//                _arg3 = data.readString();
//                android.content.IIntentReceiver _arg4;
//                _arg4 = android.content.IIntentReceiver.Stub.asInterface(data.readStrongBinder());
//                int _arg5;
//                _arg5 = data.readInt();
//                String _arg6;
//                _arg6 = data.readString();
//                Bundle _arg7;
//                _arg7 = data.readTypedObject(Bundle.CREATOR);
//                String[] _arg8;
//                _arg8 = data.createStringArray();
//                String[] _arg9;
//                _arg9 = data.createStringArray();
//                String[] _arg10;
//                _arg10 = data.createStringArray();
//                int _arg11;
//                _arg11 = data.readInt();
//                Bundle _arg12;
//                _arg12 = data.readTypedObject(Bundle.CREATOR);
//                boolean _arg13;
//                _arg13 = data.readBoolean();
//                boolean _arg14;
//                _arg14 = data.readBoolean();
                int _arg15;
                _arg15 = data.readInt();
                //data.enforceNoDataAvail();
                //int _result = this.broadcastIntentWithFeature(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5, _arg6, _arg7, _arg8, _arg9, _arg10, _arg11, _arg12, _arg13, _arg14, _arg15);
                //reply.writeNoException();
                //reply.writeInt(_result);
                break;
            }
            case TRANSACTION_unbroadcastIntent:
            {
                Log_readStrongBinder(data);
                Log_readTypedObject(data,IntentFilter.CREATOR);
                Log_readInt(data);
//                android.app.IApplicationThread _arg0;
//                _arg0 = android.app.IApplicationThread.Stub.asInterface(data.readStrongBinder());
//                Intent _arg1;
//                _arg1 = data.readTypedObject(Intent.CREATOR);
//                int _arg2;
//                _arg2 = data.readInt();
//                //data.enforceNoDataAvail();
//                this.unbroadcastIntent(_arg0, _arg1, _arg2);
                //reply.writeNoException();
                break;
            }
            case TRANSACTION_finishReceiver:
            {
//                IBinder _arg0;
//                _arg0 = data.readStrongBinder();
//                int _arg1;
//                _arg1 = data.readInt();
//                String _arg2;
//                _arg2 = data.readString();
//                Bundle _arg3;
//                _arg3 = data.readTypedObject(Bundle.CREATOR);
//                boolean _arg4;
//                _arg4 = data.readBoolean();
//                int _arg5;
//                _arg5 = data.readInt();
//                //data.enforceNoDataAvail();
//                this.finishReceiver(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5);
                break;
            }
            case TRANSACTION_attachApplication:
            {Log_readStrongBinder(data);
                Log_readLong(data);
//                android.app.IApplicationThread _arg0;
//                _arg0 = android.app.IApplicationThread.Stub.asInterface(data.readStrongBinder());
//                long _arg1;
//                _arg1 = data.readLong();
//                //data.enforceNoDataAvail();
//                this.attachApplication(_arg0, _arg1);
                //reply.writeNoException();
                break;
            }
            case TRANSACTION_getTasks:
            {
                Log_readInt(data);
//                int _arg0;
//                _arg0 = data.readInt();
                //data.enforceNoDataAvail();
                //List<ActivityManager.RunningTaskInfo> _result = this.getTasks(_arg0);
                //reply.writeNoException();
                //reply.writeTypedList(_result, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
                break;
            }
//            case TRANSACTION_moveTaskToFront:
//            {
//                android.app.IApplicationThread _arg0;
//                _arg0 = android.app.IApplicationThread.Stub.asInterface(data.readStrongBinder());
//                String _arg1;
//                _arg1 = data.readString();
//                int _arg2;
//                _arg2 = data.readInt();
//                int _arg3;
//                _arg3 = data.readInt();
//                Bundle _arg4;
//                _arg4 = data.readTypedObject(Bundle.CREATOR);
//                //data.enforceNoDataAvail();
//                this.moveTaskToFront(_arg0, _arg1, _arg2, _arg3, _arg4);
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_getTaskForActivity:
//            {
//                IBinder _arg0;
//                _arg0 = data.readStrongBinder();
//                boolean _arg1;
//                _arg1 = data.readBoolean();
//                //data.enforceNoDataAvail();
//                //int _result = this.getTaskForActivity(_arg0, _arg1);
//                //reply.writeNoException();
//                //reply.writeInt(_result);
//                break;
//            }
//            case TRANSACTION_getContentProvider:
//            {
//                android.app.IApplicationThread _arg0;
//                _arg0 = android.app.IApplicationThread.Stub.asInterface(data.readStrongBinder());
//                String _arg1;
//                _arg1 = data.readString();
//                String _arg2;
//                _arg2 = data.readString();
//                int _arg3;
//                _arg3 = data.readInt();
//                boolean _arg4;
//                _arg4 = data.readBoolean();
//                //data.enforceNoDataAvail();
//                android.app.ContentProviderHolder _result = this.getContentProvider(_arg0, _arg1, _arg2, _arg3, _arg4);
//                //reply.writeNoException();
//                //reply.writeTypedObject(_result, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
//                break;
//            }
//            case TRANSACTION_publishContentProviders:
//            {
//                android.app.IApplicationThread _arg0;
//                _arg0 = android.app.IApplicationThread.Stub.asInterface(data.readStrongBinder());
//                List<android.app.ContentProviderHolder> _arg1;
//                _arg1 = data.createTypedArrayList(android.app.ContentProviderHolder.CREATOR);
//                //data.enforceNoDataAvail();
//                this.publishContentProviders(_arg0, _arg1);
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_refContentProvider:
//            {
//                IBinder _arg0;
//                _arg0 = data.readStrongBinder();
//                int _arg1;
//                _arg1 = data.readInt();
//                int _arg2;
//                _arg2 = data.readInt();
//                //data.enforceNoDataAvail();
//                boolean _result = this.refContentProvider(_arg0, _arg1, _arg2);
//                //reply.writeNoException();
//                //reply.writeBoolean(_result);
//                break;
//            }
//            case TRANSACTION_getRunningServiceControlPanel:
//            {
//                ComponentName _arg0;
//                _arg0 = data.readTypedObject(ComponentName.CREATOR);
//                //data.enforceNoDataAvail();
//                PendingIntent _result = this.getRunningServiceControlPanel(_arg0);
//                //reply.writeNoException();
//                //reply.writeTypedObject(_result, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
//                break;
//            }
//            case TRANSACTION_startService:
//            {
//                android.app.IApplicationThread _arg0;
//                _arg0 = android.app.IApplicationThread.Stub.asInterface(data.readStrongBinder());
//                Intent _arg1;
//                _arg1 = data.readTypedObject(Intent.CREATOR);
//                String _arg2;
//                _arg2 = data.readString();
//                boolean _arg3;
//                _arg3 = data.readBoolean();
//                String _arg4;
//                _arg4 = data.readString();
//                String _arg5;
//                _arg5 = data.readString();
//                int _arg6;
//                _arg6 = data.readInt();
//                //data.enforceNoDataAvail();
//                ComponentName _result = this.startService(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5, _arg6);
//                //reply.writeNoException();
//                //reply.writeTypedObject(_result, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
//                break;
//            }
//            case TRANSACTION_stopService:
//            {
//                android.app.IApplicationThread _arg0;
//                _arg0 = android.app.IApplicationThread.Stub.asInterface(data.readStrongBinder());
//                Intent _arg1;
//                _arg1 = data.readTypedObject(Intent.CREATOR);
//                String _arg2;
//                _arg2 = data.readString();
//                int _arg3;
//                _arg3 = data.readInt();
//                //data.enforceNoDataAvail();
//                //int _result = this.stopService(_arg0, _arg1, _arg2, _arg3);
//                //reply.writeNoException();
//                //reply.writeInt(_result);
//                break;
//            }
//            case TRANSACTION_bindService:
//            {
//                android.app.IApplicationThread _arg0;
//                _arg0 = android.app.IApplicationThread.Stub.asInterface(data.readStrongBinder());
//                IBinder _arg1;
//                _arg1 = data.readStrongBinder();
//                Intent _arg2;
//                _arg2 = data.readTypedObject(Intent.CREATOR);
//                String _arg3;
//                _arg3 = data.readString();
//                android.app.IServiceConnection _arg4;
//                _arg4 = android.app.IServiceConnection.Stub.asInterface(data.readStrongBinder());
//                int _arg5;
//                _arg5 = data.readInt();
//                String _arg6;
//                _arg6 = data.readString();
//                int _arg7;
//                _arg7 = data.readInt();
//                //data.enforceNoDataAvail();
//                //int _result = this.bindService(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5, _arg6, _arg7);
//                //reply.writeNoException();
//                //reply.writeInt(_result);
//                break;
//            }
//            case TRANSACTION_bindServiceInstance:
//            {
//                android.app.IApplicationThread _arg0;
//                _arg0 = android.app.IApplicationThread.Stub.asInterface(data.readStrongBinder());
//                IBinder _arg1;
//                _arg1 = data.readStrongBinder();
//                Intent _arg2;
//                _arg2 = data.readTypedObject(Intent.CREATOR);
//                String _arg3;
//                _arg3 = data.readString();
//                android.app.IServiceConnection _arg4;
//                _arg4 = android.app.IServiceConnection.Stub.asInterface(data.readStrongBinder());
//                int _arg5;
//                _arg5 = data.readInt();
//                String _arg6;
//                _arg6 = data.readString();
//                String _arg7;
//                _arg7 = data.readString();
//                int _arg8;
//                _arg8 = data.readInt();
//                //data.enforceNoDataAvail();
//                //int _result = this.bindServiceInstance(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5, _arg6, _arg7, _arg8);
//                //reply.writeNoException();
//                //reply.writeInt(_result);
//                break;
//            }
//            case TRANSACTION_updateServiceGroup:
//            {
//                android.app.IServiceConnection _arg0;
//                _arg0 = android.app.IServiceConnection.Stub.asInterface(data.readStrongBinder());
//                int _arg1;
//                _arg1 = data.readInt();
//                int _arg2;
//                _arg2 = data.readInt();
//                //data.enforceNoDataAvail();
//                this.updateServiceGroup(_arg0, _arg1, _arg2);
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_unbindService:
//            {
//                android.app.IServiceConnection _arg0;
//                _arg0 = android.app.IServiceConnection.Stub.asInterface(data.readStrongBinder());
//                //data.enforceNoDataAvail();
//                boolean _result = this.unbindService(_arg0);
//                //reply.writeNoException();
//                //reply.writeBoolean(_result);
//                break;
//            }
//            case TRANSACTION_publishService:
//            {
//                IBinder _arg0;
//                _arg0 = data.readStrongBinder();
//                Intent _arg1;
//                _arg1 = data.readTypedObject(Intent.CREATOR);
//                IBinder _arg2;
//                _arg2 = data.readStrongBinder();
//                //data.enforceNoDataAvail();
//                this.publishService(_arg0, _arg1, _arg2);
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_setDebugApp:
//            {
//                String _arg0;
//                _arg0 = data.readString();
//                boolean _arg1;
//                _arg1 = data.readBoolean();
//                boolean _arg2;
//                _arg2 = data.readBoolean();
//                //data.enforceNoDataAvail();
//                this.setDebugApp(_arg0, _arg1, _arg2);
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_setAgentApp:
//            {
//                String _arg0;
//                _arg0 = data.readString();
//                String _arg1;
//                _arg1 = data.readString();
//                //data.enforceNoDataAvail();
//                this.setAgentApp(_arg0, _arg1);
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_setAlwaysFinish:
//            {
//                boolean _arg0;
//                _arg0 = data.readBoolean();
//                //data.enforceNoDataAvail();
//                this.setAlwaysFinish(_arg0);
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_startInstrumentation:
//            {
//                ComponentName _arg0;
//                _arg0 = data.readTypedObject(ComponentName.CREATOR);
//                String _arg1;
//                _arg1 = data.readString();
//                int _arg2;
//                _arg2 = data.readInt();
//                Bundle _arg3;
//                _arg3 = data.readTypedObject(Bundle.CREATOR);
//                android.app.IInstrumentationWatcher _arg4;
//                _arg4 = android.app.IInstrumentationWatcher.Stub.asInterface(data.readStrongBinder());
//                android.app.IUiAutomationConnection _arg5;
//                _arg5 = android.app.IUiAutomationConnection.Stub.asInterface(data.readStrongBinder());
//                int _arg6;
//                _arg6 = data.readInt();
//                String _arg7;
//                _arg7 = data.readString();
//                //data.enforceNoDataAvail();
//                boolean _result = this.startInstrumentation(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5, _arg6, _arg7);
//                //reply.writeNoException();
//                //reply.writeBoolean(_result);
//                break;
//            }
//            case TRANSACTION_addInstrumentationResults:
//            {
//                android.app.IApplicationThread _arg0;
//                _arg0 = android.app.IApplicationThread.Stub.asInterface(data.readStrongBinder());
//                Bundle _arg1;
//                _arg1 = data.readTypedObject(Bundle.CREATOR);
//                //data.enforceNoDataAvail();
//                this.addInstrumentationResults(_arg0, _arg1);
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_finishInstrumentation:
//            {
//                android.app.IApplicationThread _arg0;
//                _arg0 = android.app.IApplicationThread.Stub.asInterface(data.readStrongBinder());
//                int _arg1;
//                _arg1 = data.readInt();
//                Bundle _arg2;
//                _arg2 = data.readTypedObject(Bundle.CREATOR);
//                //data.enforceNoDataAvail();
//                this.finishInstrumentation(_arg0, _arg1, _arg2);
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_getConfiguration:
//            {
//                Configuration _result = this.getConfiguration();
//                //reply.writeNoException();
//                //reply.writeTypedObject(_result, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
//                break;
//            }
//            case TRANSACTION_updateConfiguration:
//            {
//                Configuration _arg0;
//                _arg0 = data.readTypedObject(Configuration.CREATOR);
//                //data.enforceNoDataAvail();
//                boolean _result = this.updateConfiguration(_arg0);
//                //reply.writeNoException();
//                //reply.writeBoolean(_result);
//                break;
//            }
//            case TRANSACTION_updateMccMncConfiguration:
//            {
//                String _arg0;
//                _arg0 = data.readString();
//                String _arg1;
//                _arg1 = data.readString();
//                //data.enforceNoDataAvail();
//                boolean _result = this.updateMccMncConfiguration(_arg0, _arg1);
//                //reply.writeNoException();
//                //reply.writeBoolean(_result);
//                break;
//            }
//            case TRANSACTION_stopServiceToken:
//            {
//                ComponentName _arg0;
//                _arg0 = data.readTypedObject(ComponentName.CREATOR);
//                IBinder _arg1;
//                _arg1 = data.readStrongBinder();
//                int _arg2;
//                _arg2 = data.readInt();
//                //data.enforceNoDataAvail();
//                boolean _result = this.stopServiceToken(_arg0, _arg1, _arg2);
//                //reply.writeNoException();
//                //reply.writeBoolean(_result);
//                break;
//            }
//            case TRANSACTION_setProcessLimit:
//            {
//                int _arg0;
//                _arg0 = data.readInt();
//                //data.enforceNoDataAvail();
//                this.setProcessLimit(_arg0);
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_getProcessLimit:
//            {
//                //int _result = this.getProcessLimit();
//                //reply.writeNoException();
//                //reply.writeInt(_result);
//                break;
//            }
//            case TRANSACTION_checkUriPermission:
//            {
//                Uri _arg0;
//                _arg0 = data.readTypedObject(Uri.CREATOR);
//                int _arg1;
//                _arg1 = data.readInt();
//                int _arg2;
//                _arg2 = data.readInt();
//                int _arg3;
//                _arg3 = data.readInt();
//                int _arg4;
//                _arg4 = data.readInt();
//                IBinder _arg5;
//                _arg5 = data.readStrongBinder();
//                //data.enforceNoDataAvail();
//                //int _result = this.checkUriPermission(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5);
//                //reply.writeNoException();
//                //reply.writeInt(_result);
//                break;
//            }
//            case TRANSACTION_checkUriPermissions:
//            {
//                List<Uri> _arg0;
//                _arg0 = data.createTypedArrayList(Uri.CREATOR);
//                int _arg1;
//                _arg1 = data.readInt();
//                int _arg2;
//                _arg2 = data.readInt();
//                int _arg3;
//                _arg3 = data.readInt();
//                int _arg4;
//                _arg4 = data.readInt();
//                IBinder _arg5;
//                _arg5 = data.readStrongBinder();
//                //data.enforceNoDataAvail();
//                int[] _result = this.checkUriPermissions(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5);
//                //reply.writeNoException();
//                //reply.writeIntArray(_result);
//                break;
//            }
//            case TRANSACTION_grantUriPermission:
//            {
//                android.app.IApplicationThread _arg0;
//                _arg0 = android.app.IApplicationThread.Stub.asInterface(data.readStrongBinder());
//                String _arg1;
//                _arg1 = data.readString();
//                Uri _arg2;
//                _arg2 = data.readTypedObject(Uri.CREATOR);
//                int _arg3;
//                _arg3 = data.readInt();
//                int _arg4;
//                _arg4 = data.readInt();
//                //data.enforceNoDataAvail();
//                this.grantUriPermission(_arg0, _arg1, _arg2, _arg3, _arg4);
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_revokeUriPermission:
//            {
//                android.app.IApplicationThread _arg0;
//                _arg0 = android.app.IApplicationThread.Stub.asInterface(data.readStrongBinder());
//                String _arg1;
//                _arg1 = data.readString();
//                Uri _arg2;
//                _arg2 = data.readTypedObject(Uri.CREATOR);
//                int _arg3;
//                _arg3 = data.readInt();
//                int _arg4;
//                _arg4 = data.readInt();
//                //data.enforceNoDataAvail();
//                this.revokeUriPermission(_arg0, _arg1, _arg2, _arg3, _arg4);
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_setActivityController:
//            {
//                android.app.IActivityController _arg0;
//                _arg0 = android.app.IActivityController.Stub.asInterface(data.readStrongBinder());
//                boolean _arg1;
//                _arg1 = data.readBoolean();
//                //data.enforceNoDataAvail();
//                this.setActivityController(_arg0, _arg1);
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_showWaitingForDebugger:
//            {
//                android.app.IApplicationThread _arg0;
//                _arg0 = android.app.IApplicationThread.Stub.asInterface(data.readStrongBinder());
//                boolean _arg1;
//                _arg1 = data.readBoolean();
//                //data.enforceNoDataAvail();
//                this.showWaitingForDebugger(_arg0, _arg1);
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_signalPersistentProcesses:
//            {
//                int _arg0;
//                _arg0 = data.readInt();
//                //data.enforceNoDataAvail();
//                this.signalPersistentProcesses(_arg0);
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_getRecentTasks:
//            {
//                int _arg0;
//                _arg0 = data.readInt();
//                int _arg1;
//                _arg1 = data.readInt();
//                int _arg2;
//                _arg2 = data.readInt();
//                //data.enforceNoDataAvail();
//                android.content.pm.ParceledListSlice _result = this.getRecentTasks(_arg0, _arg1, _arg2);
//                //reply.writeNoException();
//                //reply.writeTypedObject(_result, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
//                break;
//            }
//            case TRANSACTION_serviceDoneExecuting:
//            {
//                IBinder _arg0;
//                _arg0 = data.readStrongBinder();
//                int _arg1;
//                _arg1 = data.readInt();
//                int _arg2;
//                _arg2 = data.readInt();
//                int _arg3;
//                _arg3 = data.readInt();
//                //data.enforceNoDataAvail();
//                this.serviceDoneExecuting(_arg0, _arg1, _arg2, _arg3);
//                break;
//            }
//            case TRANSACTION_getIntentSender:
//            {
//                int _arg0;
//                _arg0 = data.readInt();
//                String _arg1;
//                _arg1 = data.readString();
//                IBinder _arg2;
//                _arg2 = data.readStrongBinder();
//                String _arg3;
//                _arg3 = data.readString();
//                int _arg4;
//                _arg4 = data.readInt();
//                Intent[] _arg5;
//                _arg5 = data.createTypedArray(Intent.CREATOR);
//                String[] _arg6;
//                _arg6 = data.createStringArray();
//                int _arg7;
//                _arg7 = data.readInt();
//                Bundle _arg8;
//                _arg8 = data.readTypedObject(Bundle.CREATOR);
//                int _arg9;
//                _arg9 = data.readInt();
//                //data.enforceNoDataAvail();
//                android.content.IIntentSender _result = this.getIntentSender(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5, _arg6, _arg7, _arg8, _arg9);
//                //reply.writeNoException();
//                //reply.writeStrongInterface(_result);
//                break;
//            }
//            case TRANSACTION_getIntentSenderWithFeature:
//            {
//                int _arg0;
//                _arg0 = data.readInt();
//                String _arg1;
//                _arg1 = data.readString();
//                String _arg2;
//                _arg2 = data.readString();
//                IBinder _arg3;
//                _arg3 = data.readStrongBinder();
//                String _arg4;
//                _arg4 = data.readString();
//                int _arg5;
//                _arg5 = data.readInt();
//                Intent[] _arg6;
//                _arg6 = data.createTypedArray(Intent.CREATOR);
//                String[] _arg7;
//                _arg7 = data.createStringArray();
//                int _arg8;
//                _arg8 = data.readInt();
//                Bundle _arg9;
//                _arg9 = data.readTypedObject(Bundle.CREATOR);
//                int _arg10;
//                _arg10 = data.readInt();
//                //data.enforceNoDataAvail();
//                android.content.IIntentSender _result = this.getIntentSenderWithFeature(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5, _arg6, _arg7, _arg8, _arg9, _arg10);
//                //reply.writeNoException();
//                //reply.writeStrongInterface(_result);
//                break;
//            }
//            case TRANSACTION_cancelIntentSender:
//            {
//                android.content.IIntentSender _arg0;
//                _arg0 = android.content.IIntentSender.Stub.asInterface(data.readStrongBinder());
//                //data.enforceNoDataAvail();
//                this.cancelIntentSender(_arg0);
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_getInfoForIntentSender:
//            {
//                android.content.IIntentSender _arg0;
//                _arg0 = android.content.IIntentSender.Stub.asInterface(data.readStrongBinder());
//                //data.enforceNoDataAvail();
//                ActivityManager.PendingIntentInfo _result = this.getInfoForIntentSender(_arg0);
//                //reply.writeNoException();
//                //reply.writeTypedObject(_result, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
//                break;
//            }
//            case TRANSACTION_registerIntentSenderCancelListenerEx:
//            {
//                android.content.IIntentSender _arg0;
//                _arg0 = android.content.IIntentSender.Stub.asInterface(data.readStrongBinder());
//                com.android.internal.os.IResultReceiver _arg1;
//                _arg1 = com.android.internal.os.IResultReceiver.Stub.asInterface(data.readStrongBinder());
//                //data.enforceNoDataAvail();
//                boolean _result = this.registerIntentSenderCancelListenerEx(_arg0, _arg1);
//                //reply.writeNoException();
//                //reply.writeBoolean(_result);
//                break;
//            }
//            case TRANSACTION_unregisterIntentSenderCancelListener:
//            {
//                android.content.IIntentSender _arg0;
//                _arg0 = android.content.IIntentSender.Stub.asInterface(data.readStrongBinder());
//                com.android.internal.os.IResultReceiver _arg1;
//                _arg1 = com.android.internal.os.IResultReceiver.Stub.asInterface(data.readStrongBinder());
//                //data.enforceNoDataAvail();
//                this.unregisterIntentSenderCancelListener(_arg0, _arg1);
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_enterSafeMode:
//            {
//                this.enterSafeMode();
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_noteWakeupAlarm:
//            {
//                android.content.IIntentSender _arg0;
//                _arg0 = android.content.IIntentSender.Stub.asInterface(data.readStrongBinder());
//                WorkSource _arg1;
//                _arg1 = data.readTypedObject(WorkSource.CREATOR);
//                int _arg2;
//                _arg2 = data.readInt();
//                String _arg3;
//                _arg3 = data.readString();
//                String _arg4;
//                _arg4 = data.readString();
//                //data.enforceNoDataAvail();
//                this.noteWakeupAlarm(_arg0, _arg1, _arg2, _arg3, _arg4);
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_removeContentProvider:
//            {
//                IBinder _arg0;
//                _arg0 = data.readStrongBinder();
//                boolean _arg1;
//                _arg1 = data.readBoolean();
//                //data.enforceNoDataAvail();
//                this.removeContentProvider(_arg0, _arg1);
//                break;
//            }
//            case TRANSACTION_setRequestedOrientation:
//            {
//                IBinder _arg0;
//                _arg0 = data.readStrongBinder();
//                int _arg1;
//                _arg1 = data.readInt();
//                //data.enforceNoDataAvail();
//                this.setRequestedOrientation(_arg0, _arg1);
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_unbindFinished:
//            {
//                IBinder _arg0;
//                _arg0 = data.readStrongBinder();
//                Intent _arg1;
//                _arg1 = data.readTypedObject(Intent.CREATOR);
//                boolean _arg2;
//                _arg2 = data.readBoolean();
//                //data.enforceNoDataAvail();
//                this.unbindFinished(_arg0, _arg1, _arg2);
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_setProcessImportant:
//            {
//                IBinder _arg0;
//                _arg0 = data.readStrongBinder();
//                int _arg1;
//                _arg1 = data.readInt();
//                boolean _arg2;
//                _arg2 = data.readBoolean();
//                String _arg3;
//                _arg3 = data.readString();
//                //data.enforceNoDataAvail();
//                this.setProcessImportant(_arg0, _arg1, _arg2, _arg3);
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_setServiceForeground:
//            {
//                ComponentName _arg0;
//                _arg0 = data.readTypedObject(ComponentName.CREATOR);
//                IBinder _arg1;
//                _arg1 = data.readStrongBinder();
//                int _arg2;
//                _arg2 = data.readInt();
//                Notification _arg3;
//                _arg3 = data.readTypedObject(Notification.CREATOR);
//                int _arg4;
//                _arg4 = data.readInt();
//                int _arg5;
//                _arg5 = data.readInt();
//                //data.enforceNoDataAvail();
//                this.setServiceForeground(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5);
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_getForegroundServiceType:
//            {
//                ComponentName _arg0;
//                _arg0 = data.readTypedObject(ComponentName.CREATOR);
//                IBinder _arg1;
//                _arg1 = data.readStrongBinder();
//                //data.enforceNoDataAvail();
//                //int _result = this.getForegroundServiceType(_arg0, _arg1);
//                //reply.writeNoException();
//                //reply.writeInt(_result);
//                break;
//            }
//            case TRANSACTION_moveActivityTaskToBack:
//            {
//                IBinder _arg0;
//                _arg0 = data.readStrongBinder();
//                boolean _arg1;
//                _arg1 = data.readBoolean();
//                //data.enforceNoDataAvail();
//                boolean _result = this.moveActivityTaskToBack(_arg0, _arg1);
//                //reply.writeNoException();
//                //reply.writeBoolean(_result);
//                break;
//            }
//            case TRANSACTION_getMemoryInfo:
//            {
//                ActivityManager.MemoryInfo _arg0;
//                _arg0 = new ActivityManager.MemoryInfo();
//                //data.enforceNoDataAvail();
//                this.getMemoryInfo(_arg0);
//                //reply.writeNoException();
//                //reply.writeTypedObject(_arg0, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
//                break;
//            }
//            case TRANSACTION_getProcessesInErrorState:
//            {
//                List<ActivityManager.ProcessErrorStateInfo> _result = this.getProcessesInErrorState();
//                //reply.writeNoException();
//                //reply.writeTypedList(_result, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
//                break;
//            }
//            case TRANSACTION_clearApplicationUserData:
//            {
//                String _arg0;
//                _arg0 = data.readString();
//                boolean _arg1;
//                _arg1 = data.readBoolean();
//                android.content.pm.IPackageDataObserver _arg2;
//                _arg2 = android.content.pm.IPackageDataObserver.Stub.asInterface(data.readStrongBinder());
//                int _arg3;
//                _arg3 = data.readInt();
//                //data.enforceNoDataAvail();
//                boolean _result = this.clearApplicationUserData(_arg0, _arg1, _arg2, _arg3);
//                //reply.writeNoException();
//                //reply.writeBoolean(_result);
//                break;
//            }
//            case TRANSACTION_stopAppForUser:
//            {
//                String _arg0;
//                _arg0 = data.readString();
//                int _arg1;
//                _arg1 = data.readInt();
//                //data.enforceNoDataAvail();
//                this.stopAppForUser(_arg0, _arg1);
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_registerForegroundServiceObserver:
//            {
//                android.app.IForegroundServiceObserver _arg0;
//                _arg0 = android.app.IForegroundServiceObserver.Stub.asInterface(data.readStrongBinder());
//                //data.enforceNoDataAvail();
//                boolean _result = this.registerForegroundServiceObserver(_arg0);
//                //reply.writeNoException();
//                //reply.writeBoolean(_result);
//                break;
//            }
//            case TRANSACTION_forceStopPackage:
//            {
//                String _arg0;
//                _arg0 = data.readString();
//                int _arg1;
//                _arg1 = data.readInt();
//                //data.enforceNoDataAvail();
//                this.forceStopPackage(_arg0, _arg1);
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_killPids:
//            {
//                int[] _arg0;
//                _arg0 = data.createIntArray();
//                String _arg1;
//                _arg1 = data.readString();
//                boolean _arg2;
//                _arg2 = data.readBoolean();
//                //data.enforceNoDataAvail();
//                boolean _result = this.killPids(_arg0, _arg1, _arg2);
//                //reply.writeNoException();
//                //reply.writeBoolean(_result);
//                break;
//            }
//            case TRANSACTION_getServices:
//            {
//                int _arg0;
//                _arg0 = data.readInt();
//                int _arg1;
//                _arg1 = data.readInt();
//                //data.enforceNoDataAvail();
//                List<ActivityManager.RunningServiceInfo> _result = this.getServices(_arg0, _arg1);
//                //reply.writeNoException();
//                //reply.writeTypedList(_result, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
//                break;
//            }
//            case TRANSACTION_getRunningAppProcesses:
//            {
//                List<ActivityManager.RunningAppProcessInfo> _result = this.getRunningAppProcesses();
//                //reply.writeNoException();
//                //reply.writeTypedList(_result, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
//                break;
//            }
//            case TRANSACTION_peekService:
//            {
//                Intent _arg0;
//                _arg0 = data.readTypedObject(Intent.CREATOR);
//                String _arg1;
//                _arg1 = data.readString();
//                String _arg2;
//                _arg2 = data.readString();
//                //data.enforceNoDataAvail();
//                IBinder _result = this.peekService(_arg0, _arg1, _arg2);
//                //reply.writeNoException();
//                //reply.writeStrongBinder(_result);
//                break;
//            }
//            case TRANSACTION_profileControl:
//            {
//                String _arg0;
//                _arg0 = data.readString();
//                int _arg1;
//                _arg1 = data.readInt();
//                boolean _arg2;
//                _arg2 = data.readBoolean();
//                android.app.ProfilerInfo _arg3;
//                _arg3 = data.readTypedObject(android.app.ProfilerInfo.CREATOR);
//                int _arg4;
//                _arg4 = data.readInt();
//                //data.enforceNoDataAvail();
//                boolean _result = this.profileControl(_arg0, _arg1, _arg2, _arg3, _arg4);
//                //reply.writeNoException();
//                //reply.writeBoolean(_result);
//                break;
//            }
//            case TRANSACTION_shutdown:
//            {
//                int _arg0;
//                _arg0 = data.readInt();
//                //data.enforceNoDataAvail();
//                boolean _result = this.shutdown(_arg0);
//                //reply.writeNoException();
//                //reply.writeBoolean(_result);
//                break;
//            }
//            case TRANSACTION_stopAppSwitches:
//            {
//                this.stopAppSwitches();
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_resumeAppSwitches:
//            {
//                this.resumeAppSwitches();
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_bindBackupAgent:
//            {
//                String _arg0;
//                _arg0 = data.readString();
//                int _arg1;
//                _arg1 = data.readInt();
//                int _arg2;
//                _arg2 = data.readInt();
//                int _arg3;
//                _arg3 = data.readInt();
//                //data.enforceNoDataAvail();
//                boolean _result = this.bindBackupAgent(_arg0, _arg1, _arg2, _arg3);
//                //reply.writeNoException();
//                //reply.writeBoolean(_result);
//                break;
//            }
//            case TRANSACTION_backupAgentCreated:
//            {
//                String _arg0;
//                _arg0 = data.readString();
//                IBinder _arg1;
//                _arg1 = data.readStrongBinder();
//                int _arg2;
//                _arg2 = data.readInt();
//                //data.enforceNoDataAvail();
//                this.backupAgentCreated(_arg0, _arg1, _arg2);
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_unbindBackupAgent:
//            {
//                ApplicationInfo _arg0;
//                _arg0 = data.readTypedObject(ApplicationInfo.CREATOR);
//                //data.enforceNoDataAvail();
//                this.unbindBackupAgent(_arg0);
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_handleIncomingUser:
//            {
//                int _arg0;
//                _arg0 = data.readInt();
//                int _arg1;
//                _arg1 = data.readInt();
//                int _arg2;
//                _arg2 = data.readInt();
//                boolean _arg3;
//                _arg3 = data.readBoolean();
//                boolean _arg4;
//                _arg4 = data.readBoolean();
//                String _arg5;
//                _arg5 = data.readString();
//                String _arg6;
//                _arg6 = data.readString();
//                //data.enforceNoDataAvail();
//                //int _result = this.handleIncomingUser(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5, _arg6);
//                //reply.writeNoException();
//                //reply.writeInt(_result);
//                break;
//            }
//            case TRANSACTION_addPackageDependency:
//            {
//                String _arg0;
//                _arg0 = data.readString();
//                //data.enforceNoDataAvail();
//                this.addPackageDependency(_arg0);
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_killApplication:
//            {
//                String _arg0;
//                _arg0 = data.readString();
//                int _arg1;
//                _arg1 = data.readInt();
//                int _arg2;
//                _arg2 = data.readInt();
//                String _arg3;
//                _arg3 = data.readString();
//                //data.enforceNoDataAvail();
//                this.killApplication(_arg0, _arg1, _arg2, _arg3);
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_closeSystemDialogs:
//            {
//                String _arg0;
//                _arg0 = data.readString();
//                //data.enforceNoDataAvail();
//                this.closeSystemDialogs(_arg0);
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_getProcessMemoryInfo:
//            {
//                int[] _arg0;
//                _arg0 = data.createIntArray();
//                //data.enforceNoDataAvail();
//                Debug.MemoryInfo[] _result = this.getProcessMemoryInfo(_arg0);
//                //reply.writeNoException();
//                //reply.writeTypedArray(_result, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
//                break;
//            }
//            case TRANSACTION_killApplicationProcess:
//            {
//                String _arg0;
//                _arg0 = data.readString();
//                int _arg1;
//                _arg1 = data.readInt();
//                //data.enforceNoDataAvail();
//                this.killApplicationProcess(_arg0, _arg1);
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_handleApplicationWtf:
//            {
//                IBinder _arg0;
//                _arg0 = data.readStrongBinder();
//                String _arg1;
//                _arg1 = data.readString();
//                boolean _arg2;
//                _arg2 = data.readBoolean();
//                ApplicationErrorReport.ParcelableCrashInfo _arg3;
//                _arg3 = data.readTypedObject(ApplicationErrorReport.ParcelableCrashInfo.CREATOR);
//                int _arg4;
//                _arg4 = data.readInt();
//                //data.enforceNoDataAvail();
//                boolean _result = this.handleApplicationWtf(_arg0, _arg1, _arg2, _arg3, _arg4);
//                //reply.writeNoException();
//                //reply.writeBoolean(_result);
//                break;
//            }
//            case TRANSACTION_killBackgroundProcesses:
//            {
//                String _arg0;
//                _arg0 = data.readString();
//                int _arg1;
//                _arg1 = data.readInt();
//                //data.enforceNoDataAvail();
//                this.killBackgroundProcesses(_arg0, _arg1);
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_isUserAMonkey:
//            {
//                boolean _result = this.isUserAMonkey();
//                //reply.writeNoException();
//                //reply.writeBoolean(_result);
//                break;
//            }
//            case TRANSACTION_getRunningExternalApplications:
//            {
//                List<ApplicationInfo> _result = this.getRunningExternalApplications();
//                //reply.writeNoException();
//                //reply.writeTypedList(_result, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
//                break;
//            }
//            case TRANSACTION_finishHeavyWeightApp:
//            {
//                this.finishHeavyWeightApp();
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_handleApplicationStrictModeViolation:
//            {
//                IBinder _arg0;
//                _arg0 = data.readStrongBinder();
//                int _arg1;
//                _arg1 = data.readInt();
//                StrictMode.ViolationInfo _arg2;
//                _arg2 = data.readTypedObject(StrictMode.ViolationInfo.CREATOR);
//                //data.enforceNoDataAvail();
//                this.handleApplicationStrictModeViolation(_arg0, _arg1, _arg2);
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_isTopActivityImmersive:
//            {
//                boolean _result = this.isTopActivityImmersive();
//                //reply.writeNoException();
//                //reply.writeBoolean(_result);
//                break;
//            }
//            case TRANSACTION_crashApplicationWithType:
//            {
//                int _arg0;
//                _arg0 = data.readInt();
//                int _arg1;
//                _arg1 = data.readInt();
//                String _arg2;
//                _arg2 = data.readString();
//                int _arg3;
//                _arg3 = data.readInt();
//                String _arg4;
//                _arg4 = data.readString();
//                boolean _arg5;
//                _arg5 = data.readBoolean();
//                int _arg6;
//                _arg6 = data.readInt();
//                //data.enforceNoDataAvail();
//                this.crashApplicationWithType(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5, _arg6);
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_crashApplicationWithTypeWithExtras:
//            {
//                int _arg0;
//                _arg0 = data.readInt();
//                int _arg1;
//                _arg1 = data.readInt();
//                String _arg2;
//                _arg2 = data.readString();
//                int _arg3;
//                _arg3 = data.readInt();
//                String _arg4;
//                _arg4 = data.readString();
//                boolean _arg5;
//                _arg5 = data.readBoolean();
//                int _arg6;
//                _arg6 = data.readInt();
//                Bundle _arg7;
//                _arg7 = data.readTypedObject(Bundle.CREATOR);
//                //data.enforceNoDataAvail();
//                this.crashApplicationWithTypeWithExtras(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5, _arg6, _arg7);
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_getProviderMimeType:
//            {
//                Uri _arg0;
//                _arg0 = data.readTypedObject(Uri.CREATOR);
//                int _arg1;
//                _arg1 = data.readInt();
//                //data.enforceNoDataAvail();
//                String _result = this.getProviderMimeType(_arg0, _arg1);
//                //reply.writeNoException();
//                //reply.writeString(_result);
//                break;
//            }
//            case TRANSACTION_getProviderMimeTypeAsync:
//            {
//                Uri _arg0;
//                _arg0 = data.readTypedObject(Uri.CREATOR);
//                int _arg1;
//                _arg1 = data.readInt();
//                android.os.RemoteCallback _arg2;
//                _arg2 = data.readTypedObject(android.os.RemoteCallback.CREATOR);
//                //data.enforceNoDataAvail();
//                this.getProviderMimeTypeAsync(_arg0, _arg1, _arg2);
//                break;
//            }
//            case TRANSACTION_dumpHeap:
//            {
//                String _arg0;
//                _arg0 = data.readString();
//                int _arg1;
//                _arg1 = data.readInt();
//                boolean _arg2;
//                _arg2 = data.readBoolean();
//                boolean _arg3;
//                _arg3 = data.readBoolean();
//                boolean _arg4;
//                _arg4 = data.readBoolean();
//                String _arg5;
//                _arg5 = data.readString();
//                ParcelFileDescriptor _arg6;
//                _arg6 = data.readTypedObject(ParcelFileDescriptor.CREATOR);
//                android.os.RemoteCallback _arg7;
//                _arg7 = data.readTypedObject(android.os.RemoteCallback.CREATOR);
//                //data.enforceNoDataAvail();
//                boolean _result = this.dumpHeap(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5, _arg6, _arg7);
//                //reply.writeNoException();
//                //reply.writeBoolean(_result);
//                break;
//            }
//            case TRANSACTION_isUserRunning:
//            {
//                int _arg0;
//                _arg0 = data.readInt();
//                int _arg1;
//                _arg1 = data.readInt();
//                //data.enforceNoDataAvail();
//                boolean _result = this.isUserRunning(_arg0, _arg1);
//                //reply.writeNoException();
//                //reply.writeBoolean(_result);
//                break;
//            }
//            case TRANSACTION_setPackageScreenCompatMode:
//            {
//                String _arg0;
//                _arg0 = data.readString();
//                int _arg1;
//                _arg1 = data.readInt();
//                //data.enforceNoDataAvail();
//                this.setPackageScreenCompatMode(_arg0, _arg1);
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_switchUser:
//            {
//                int _arg0;
//                _arg0 = data.readInt();
//                //data.enforceNoDataAvail();
//                boolean _result = this.switchUser(_arg0);
//                //reply.writeNoException();
//                //reply.writeBoolean(_result);
//                break;
//            }
//            case TRANSACTION_getSwitchingFromUserMessage:
//            {
//                String _result = this.getSwitchingFromUserMessage();
//                //reply.writeNoException();
//                //reply.writeString(_result);
//                break;
//            }
//            case TRANSACTION_getSwitchingToUserMessage:
//            {
//                String _result = this.getSwitchingToUserMessage();
//                //reply.writeNoException();
//                //reply.writeString(_result);
//                break;
//            }
//            case TRANSACTION_setStopUserOnSwitch:
//            {
//                int _arg0;
//                _arg0 = data.readInt();
//                //data.enforceNoDataAvail();
//                this.setStopUserOnSwitch(_arg0);
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_removeTask:
//            {
//                int _arg0;
//                _arg0 = data.readInt();
//                //data.enforceNoDataAvail();
//                boolean _result = this.removeTask(_arg0);
//                //reply.writeNoException();
//                //reply.writeBoolean(_result);
//                break;
//            }
//            case TRANSACTION_registerProcessObserver:
//            {
//                android.app.IProcessObserver _arg0;
//                _arg0 = android.app.IProcessObserver.Stub.asInterface(data.readStrongBinder());
//                //data.enforceNoDataAvail();
//                this.registerProcessObserver(_arg0);
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_unregisterProcessObserver:
//            {
//                android.app.IProcessObserver _arg0;
//                _arg0 = android.app.IProcessObserver.Stub.asInterface(data.readStrongBinder());
//                //data.enforceNoDataAvail();
//                this.unregisterProcessObserver(_arg0);
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_isIntentSenderTargetedToPackage:
//            {
//                android.content.IIntentSender _arg0;
//                _arg0 = android.content.IIntentSender.Stub.asInterface(data.readStrongBinder());
//                //data.enforceNoDataAvail();
//                boolean _result = this.isIntentSenderTargetedToPackage(_arg0);
//                //reply.writeNoException();
//                //reply.writeBoolean(_result);
//                break;
//            }
//            case TRANSACTION_updatePersistentConfiguration:
//            {
//                Configuration _arg0;
//                _arg0 = data.readTypedObject(Configuration.CREATOR);
//                //data.enforceNoDataAvail();
//                this.updatePersistentConfiguration(_arg0);
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_updatePersistentConfigurationWithAttribution:
//            {
//                Configuration _arg0;
//                _arg0 = data.readTypedObject(Configuration.CREATOR);
//                String _arg1;
//                _arg1 = data.readString();
//                String _arg2;
//                _arg2 = data.readString();
//                //data.enforceNoDataAvail();
//                this.updatePersistentConfigurationWithAttribution(_arg0, _arg1, _arg2);
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_getProcessPss:
//            {
//                int[] _arg0;
//                _arg0 = data.createIntArray();
//                //data.enforceNoDataAvail();
//                long[] _result = this.getProcessPss(_arg0);
//                //reply.writeNoException();
//                //reply.writeLongArray(_result);
//                break;
//            }
//            case TRANSACTION_showBootMessage:
//            {
//                CharSequence _arg0;
//                _arg0 = data.readTypedObject(TextUtils.CHAR_SEQUENCE_CREATOR);
//                boolean _arg1;
//                _arg1 = data.readBoolean();
//                //data.enforceNoDataAvail();
//                this.showBootMessage(_arg0, _arg1);
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_killAllBackgroundProcesses:
//            {
//                this.killAllBackgroundProcesses();
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_getContentProviderExternal:
//            {
//                String _arg0;
//                _arg0 = data.readString();
//                int _arg1;
//                _arg1 = data.readInt();
//                IBinder _arg2;
//                _arg2 = data.readStrongBinder();
//                String _arg3;
//                _arg3 = data.readString();
//                //data.enforceNoDataAvail();
//                android.app.ContentProviderHolder _result = this.getContentProviderExternal(_arg0, _arg1, _arg2, _arg3);
//                //reply.writeNoException();
//                //reply.writeTypedObject(_result, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
//                break;
//            }
//            case TRANSACTION_removeContentProviderExternal:
//            {
//                String _arg0;
//                _arg0 = data.readString();
//                IBinder _arg1;
//                _arg1 = data.readStrongBinder();
//                //data.enforceNoDataAvail();
//                this.removeContentProviderExternal(_arg0, _arg1);
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_removeContentProviderExternalAsUser:
//            {
//                String _arg0;
//                _arg0 = data.readString();
//                IBinder _arg1;
//                _arg1 = data.readStrongBinder();
//                int _arg2;
//                _arg2 = data.readInt();
//                //data.enforceNoDataAvail();
//                this.removeContentProviderExternalAsUser(_arg0, _arg1, _arg2);
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_getMyMemoryState:
//            {
//                ActivityManager.RunningAppProcessInfo _arg0;
//                _arg0 = new ActivityManager.RunningAppProcessInfo();
//                //data.enforceNoDataAvail();
//                this.getMyMemoryState(_arg0);
//                //reply.writeNoException();
//                //reply.writeTypedObject(_arg0, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
//                break;
//            }
//            case TRANSACTION_killProcessesBelowForeground:
//            {
//                String _arg0;
//                _arg0 = data.readString();
//                //data.enforceNoDataAvail();
//                boolean _result = this.killProcessesBelowForeground(_arg0);
//                //reply.writeNoException();
//                //reply.writeBoolean(_result);
//                break;
//            }
//            case TRANSACTION_getCurrentUser:
//            {
//                android.content.pm.UserInfo _result = this.getCurrentUser();
//                //reply.writeNoException();
//                //reply.writeTypedObject(_result, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
//                break;
//            }
//            case TRANSACTION_getCurrentUserId:
//            {
//                //int _result = this.getCurrentUserId();
//                //reply.writeNoException();
//                //reply.writeInt(_result);
//                break;
//            }
//            case TRANSACTION_getLaunchedFromUid:
//            {
//                IBinder _arg0;
//                _arg0 = data.readStrongBinder();
//                //data.enforceNoDataAvail();
//                //int _result = this.getLaunchedFromUid(_arg0);
//                //reply.writeNoException();
//                //reply.writeInt(_result);
//                break;
//            }
//            case TRANSACTION_unstableProviderDied:
//            {
//                IBinder _arg0;
//                _arg0 = data.readStrongBinder();
//                //data.enforceNoDataAvail();
//                this.unstableProviderDied(_arg0);
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_isIntentSenderAnActivity:
//            {
//                android.content.IIntentSender _arg0;
//                _arg0 = android.content.IIntentSender.Stub.asInterface(data.readStrongBinder());
//                //data.enforceNoDataAvail();
//                boolean _result = this.isIntentSenderAnActivity(_arg0);
//                //reply.writeNoException();
//                //reply.writeBoolean(_result);
//                break;
//            }
//            case TRANSACTION_startActivityAsUser:
//            {
//                android.app.IApplicationThread _arg0;
//                _arg0 = android.app.IApplicationThread.Stub.asInterface(data.readStrongBinder());
//                String _arg1;
//                _arg1 = data.readString();
//                Intent _arg2;
//                _arg2 = data.readTypedObject(Intent.CREATOR);
//                String _arg3;
//                _arg3 = data.readString();
//                IBinder _arg4;
//                _arg4 = data.readStrongBinder();
//                String _arg5;
//                _arg5 = data.readString();
//                int _arg6;
//                _arg6 = data.readInt();
//                int _arg7;
//                _arg7 = data.readInt();
//                android.app.ProfilerInfo _arg8;
//                _arg8 = data.readTypedObject(android.app.ProfilerInfo.CREATOR);
//                Bundle _arg9;
//                _arg9 = data.readTypedObject(Bundle.CREATOR);
//                int _arg10;
//                _arg10 = data.readInt();
//                //data.enforceNoDataAvail();
//                //int _result = this.startActivityAsUser(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5, _arg6, _arg7, _arg8, _arg9, _arg10);
//                //reply.writeNoException();
//                //reply.writeInt(_result);
//                break;
//            }
//            case TRANSACTION_startActivityAsUserWithFeature:
//            {
//                android.app.IApplicationThread _arg0;
//                _arg0 = android.app.IApplicationThread.Stub.asInterface(data.readStrongBinder());
//                String _arg1;
//                _arg1 = data.readString();
//                String _arg2;
//                _arg2 = data.readString();
//                Intent _arg3;
//                _arg3 = data.readTypedObject(Intent.CREATOR);
//                String _arg4;
//                _arg4 = data.readString();
//                IBinder _arg5;
//                _arg5 = data.readStrongBinder();
//                String _arg6;
//                _arg6 = data.readString();
//                int _arg7;
//                _arg7 = data.readInt();
//                int _arg8;
//                _arg8 = data.readInt();
//                android.app.ProfilerInfo _arg9;
//                _arg9 = data.readTypedObject(android.app.ProfilerInfo.CREATOR);
//                Bundle _arg10;
//                _arg10 = data.readTypedObject(Bundle.CREATOR);
//                int _arg11;
//                _arg11 = data.readInt();
//                //data.enforceNoDataAvail();
//                //int _result = this.startActivityAsUserWithFeature(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5, _arg6, _arg7, _arg8, _arg9, _arg10, _arg11);
//                //reply.writeNoException();
//                //reply.writeInt(_result);
//                break;
//            }
//            case TRANSACTION_stopUser:
//            {
//                int _arg0;
//                _arg0 = data.readInt();
//                boolean _arg1;
//                _arg1 = data.readBoolean();
//                android.app.IStopUserCallback _arg2;
//                _arg2 = android.app.IStopUserCallback.Stub.asInterface(data.readStrongBinder());
//                //data.enforceNoDataAvail();
//                //int _result = this.stopUser(_arg0, _arg1, _arg2);
//                //reply.writeNoException();
//                //reply.writeInt(_result);
//                break;
//            }
//            case TRANSACTION_stopUserWithDelayedLocking:
//            {
//                int _arg0;
//                _arg0 = data.readInt();
//                boolean _arg1;
//                _arg1 = data.readBoolean();
//                android.app.IStopUserCallback _arg2;
//                _arg2 = android.app.IStopUserCallback.Stub.asInterface(data.readStrongBinder());
//                //data.enforceNoDataAvail();
//                //int _result = this.stopUserWithDelayedLocking(_arg0, _arg1, _arg2);
//                //reply.writeNoException();
//                //reply.writeInt(_result);
//                break;
//            }
//            case TRANSACTION_registerUserSwitchObserver:
//            {
//                android.app.IUserSwitchObserver _arg0;
//                _arg0 = android.app.IUserSwitchObserver.Stub.asInterface(data.readStrongBinder());
//                String _arg1;
//                _arg1 = data.readString();
//                //data.enforceNoDataAvail();
//                this.registerUserSwitchObserver(_arg0, _arg1);
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_unregisterUserSwitchObserver:
//            {
//                android.app.IUserSwitchObserver _arg0;
//                _arg0 = android.app.IUserSwitchObserver.Stub.asInterface(data.readStrongBinder());
//                //data.enforceNoDataAvail();
//                this.unregisterUserSwitchObserver(_arg0);
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_getRunningUserIds:
//            {
//                int[] _result = this.getRunningUserIds();
//                //reply.writeNoException();
//                //reply.writeIntArray(_result);
//                break;
//            }
//            case TRANSACTION_requestSystemServerHeapDump:
//            {
//                this.requestSystemServerHeapDump();
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_requestBugReport:
//            {
//                int _arg0;
//                _arg0 = data.readInt();
//                //data.enforceNoDataAvail();
//                this.requestBugReport(_arg0);
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_requestBugReportWithDescription:
//            {
//                String _arg0;
//                _arg0 = data.readString();
//                String _arg1;
//                _arg1 = data.readString();
//                int _arg2;
//                _arg2 = data.readInt();
//                //data.enforceNoDataAvail();
//                this.requestBugReportWithDescription(_arg0, _arg1, _arg2);
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_requestTelephonyBugReport:
//            {
//                String _arg0;
//                _arg0 = data.readString();
//                String _arg1;
//                _arg1 = data.readString();
//                //data.enforceNoDataAvail();
//                this.requestTelephonyBugReport(_arg0, _arg1);
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_requestWifiBugReport:
//            {
//                String _arg0;
//                _arg0 = data.readString();
//                String _arg1;
//                _arg1 = data.readString();
//                //data.enforceNoDataAvail();
//                this.requestWifiBugReport(_arg0, _arg1);
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_requestInteractiveBugReportWithDescription:
//            {
//                String _arg0;
//                _arg0 = data.readString();
//                String _arg1;
//                _arg1 = data.readString();
//                //data.enforceNoDataAvail();
//                this.requestInteractiveBugReportWithDescription(_arg0, _arg1);
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_requestInteractiveBugReport:
//            {
//                this.requestInteractiveBugReport();
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_requestFullBugReport:
//            {
//                this.requestFullBugReport();
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_requestRemoteBugReport:
//            {
//                long _arg0;
//                _arg0 = data.readLong();
//                //data.enforceNoDataAvail();
//                this.requestRemoteBugReport(_arg0);
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_launchBugReportHandlerApp:
//            {
//                boolean _result = this.launchBugReportHandlerApp();
//                //reply.writeNoException();
//                //reply.writeBoolean(_result);
//                break;
//            }
//            case TRANSACTION_getBugreportWhitelistedPackages:
//            {
//                List<String> _result = this.getBugreportWhitelistedPackages();
//                //reply.writeNoException();
//                //reply.writeStringList(_result);
//                break;
//            }
//            case TRANSACTION_getIntentForIntentSender:
//            {
//                android.content.IIntentSender _arg0;
//                _arg0 = android.content.IIntentSender.Stub.asInterface(data.readStrongBinder());
//                //data.enforceNoDataAvail();
//                Intent _result = this.getIntentForIntentSender(_arg0);
//                //reply.writeNoException();
//                //reply.writeTypedObject(_result, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
//                break;
//            }
//            case TRANSACTION_getLaunchedFromPackage:
//            {
//                IBinder _arg0;
//                _arg0 = data.readStrongBinder();
//                //data.enforceNoDataAvail();
//                String _result = this.getLaunchedFromPackage(_arg0);
//                //reply.writeNoException();
//                //reply.writeString(_result);
//                break;
//            }
//            case TRANSACTION_killUid:
//            {
//                int _arg0;
//                _arg0 = data.readInt();
//                int _arg1;
//                _arg1 = data.readInt();
//                String _arg2;
//                _arg2 = data.readString();
//                //data.enforceNoDataAvail();
//                this.killUid(_arg0, _arg1, _arg2);
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_setUserIsMonkey:
//            {
//                boolean _arg0;
//                _arg0 = data.readBoolean();
//                //data.enforceNoDataAvail();
//                this.setUserIsMonkey(_arg0);
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_hang:
//            {
//                IBinder _arg0;
//                _arg0 = data.readStrongBinder();
//                boolean _arg1;
//                _arg1 = data.readBoolean();
//                //data.enforceNoDataAvail();
//                this.hang(_arg0, _arg1);
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_getAllRootTaskInfos:
//            {
//                List<android.app.ActivityTaskManager.RootTaskInfo> _result = this.getAllRootTaskInfos();
//                //reply.writeNoException();
//                //reply.writeTypedList(_result, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
//                break;
//            }
//            case TRANSACTION_moveTaskToRootTask:
//            {
//                int _arg0;
//                _arg0 = data.readInt();
//                int _arg1;
//                _arg1 = data.readInt();
//                boolean _arg2;
//                _arg2 = data.readBoolean();
//                //data.enforceNoDataAvail();
//                this.moveTaskToRootTask(_arg0, _arg1, _arg2);
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_setFocusedRootTask:
//            {
//                int _arg0;
//                _arg0 = data.readInt();
//                //data.enforceNoDataAvail();
//                this.setFocusedRootTask(_arg0);
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_getFocusedRootTaskInfo:
//            {
//                android.app.ActivityTaskManager.RootTaskInfo _result = this.getFocusedRootTaskInfo();
//                //reply.writeNoException();
//                //reply.writeTypedObject(_result, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
//                break;
//            }
//            case TRANSACTION_restart:
//            {
//                this.restart();
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_performIdleMaintenance:
//            {
//                this.performIdleMaintenance();
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_appNotRespondingViaProvider:
//            {
//                IBinder _arg0;
//                _arg0 = data.readStrongBinder();
//                //data.enforceNoDataAvail();
//                this.appNotRespondingViaProvider(_arg0);
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_getTaskBounds:
//            {
//                int _arg0;
//                _arg0 = data.readInt();
//                //data.enforceNoDataAvail();
//                Rect _result = this.getTaskBounds(_arg0);
//                //reply.writeNoException();
//                //reply.writeTypedObject(_result, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
//                break;
//            }
//            case TRANSACTION_setProcessMemoryTrimLevel:
//            {
//                String _arg0;
//                _arg0 = data.readString();
//                int _arg1;
//                _arg1 = data.readInt();
//                int _arg2;
//                _arg2 = data.readInt();
//                //data.enforceNoDataAvail();
//                boolean _result = this.setProcessMemoryTrimLevel(_arg0, _arg1, _arg2);
//                //reply.writeNoException();
//                //reply.writeBoolean(_result);
//                break;
//            }
//            case TRANSACTION_getTagForIntentSender:
//            {
//                android.content.IIntentSender _arg0;
//                _arg0 = android.content.IIntentSender.Stub.asInterface(data.readStrongBinder());
//                String _arg1;
//                _arg1 = data.readString();
//                //data.enforceNoDataAvail();
//                String _result = this.getTagForIntentSender(_arg0, _arg1);
//                //reply.writeNoException();
//                //reply.writeString(_result);
//                break;
//            }
//            case TRANSACTION_startUserInBackground:
//            {
//                int _arg0;
//                _arg0 = data.readInt();
//                //data.enforceNoDataAvail();
//                boolean _result = this.startUserInBackground(_arg0);
//                //reply.writeNoException();
//                //reply.writeBoolean(_result);
//                break;
//            }
//            case TRANSACTION_isInLockTaskMode:
//            {
//                boolean _result = this.isInLockTaskMode();
//                //reply.writeNoException();
//                //reply.writeBoolean(_result);
//                break;
//            }
//            case TRANSACTION_startActivityFromRecents:
//            {
//                int _arg0;
//                _arg0 = data.readInt();
//                Bundle _arg1;
//                _arg1 = data.readTypedObject(Bundle.CREATOR);
//                //data.enforceNoDataAvail();
//                //int _result = this.startActivityFromRecents(_arg0, _arg1);
//                //reply.writeNoException();
//                //reply.writeInt(_result);
//                break;
//            }
//            case TRANSACTION_startSystemLockTaskMode:
//            {
//                int _arg0;
//                _arg0 = data.readInt();
//                //data.enforceNoDataAvail();
//                this.startSystemLockTaskMode(_arg0);
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_isTopOfTask:
//            {
//                IBinder _arg0;
//                _arg0 = data.readStrongBinder();
//                //data.enforceNoDataAvail();
//                boolean _result = this.isTopOfTask(_arg0);
//                //reply.writeNoException();
//                //reply.writeBoolean(_result);
//                break;
//            }
//            case TRANSACTION_bootAnimationComplete:
//            {
//                this.bootAnimationComplete();
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_registerTaskStackListener:
//            {
//                android.app.ITaskStackListener _arg0;
//                _arg0 = android.app.ITaskStackListener.Stub.asInterface(data.readStrongBinder());
//                //data.enforceNoDataAvail();
//                this.registerTaskStackListener(_arg0);
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_unregisterTaskStackListener:
//            {
//                android.app.ITaskStackListener _arg0;
//                _arg0 = android.app.ITaskStackListener.Stub.asInterface(data.readStrongBinder());
//                //data.enforceNoDataAvail();
//                this.unregisterTaskStackListener(_arg0);
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_notifyCleartextNetwork:
//            {
//                int _arg0;
//                _arg0 = data.readInt();
//                byte[] _arg1;
//                _arg1 = data.createByteArray();
//                //data.enforceNoDataAvail();
//                this.notifyCleartextNetwork(_arg0, _arg1);
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_setTaskResizeable:
//            {
//                int _arg0;
//                _arg0 = data.readInt();
//                int _arg1;
//                _arg1 = data.readInt();
//                //data.enforceNoDataAvail();
//                this.setTaskResizeable(_arg0, _arg1);
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_resizeTask:
//            {
//                int _arg0;
//                _arg0 = data.readInt();
//                Rect _arg1;
//                _arg1 = data.readTypedObject(Rect.CREATOR);
//                int _arg2;
//                _arg2 = data.readInt();
//                //data.enforceNoDataAvail();
//                this.resizeTask(_arg0, _arg1, _arg2);
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_getLockTaskModeState:
//            {
//                //int _result = this.getLockTaskModeState();
//                //reply.writeNoException();
//                //reply.writeInt(_result);
//                break;
//            }
//            case TRANSACTION_setDumpHeapDebugLimit:
//            {
//                String _arg0;
//                _arg0 = data.readString();
//                int _arg1;
//                _arg1 = data.readInt();
//                long _arg2;
//                _arg2 = data.readLong();
//                String _arg3;
//                _arg3 = data.readString();
//                //data.enforceNoDataAvail();
//                this.setDumpHeapDebugLimit(_arg0, _arg1, _arg2, _arg3);
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_dumpHeapFinished:
//            {
//                String _arg0;
//                _arg0 = data.readString();
//                //data.enforceNoDataAvail();
//                this.dumpHeapFinished(_arg0);
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_updateLockTaskPackages:
//            {
//                int _arg0;
//                _arg0 = data.readInt();
//                String[] _arg1;
//                _arg1 = data.createStringArray();
//                //data.enforceNoDataAvail();
//                this.updateLockTaskPackages(_arg0, _arg1);
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_noteAlarmStart:
//            {
//                android.content.IIntentSender _arg0;
//                _arg0 = android.content.IIntentSender.Stub.asInterface(data.readStrongBinder());
//                WorkSource _arg1;
//                _arg1 = data.readTypedObject(WorkSource.CREATOR);
//                int _arg2;
//                _arg2 = data.readInt();
//                String _arg3;
//                _arg3 = data.readString();
//                //data.enforceNoDataAvail();
//                this.noteAlarmStart(_arg0, _arg1, _arg2, _arg3);
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_noteAlarmFinish:
//            {
//                android.content.IIntentSender _arg0;
//                _arg0 = android.content.IIntentSender.Stub.asInterface(data.readStrongBinder());
//                WorkSource _arg1;
//                _arg1 = data.readTypedObject(WorkSource.CREATOR);
//                int _arg2;
//                _arg2 = data.readInt();
//                String _arg3;
//                _arg3 = data.readString();
//                //data.enforceNoDataAvail();
//                this.noteAlarmFinish(_arg0, _arg1, _arg2, _arg3);
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_getPackageProcessState:
//            {
//                String _arg0;
//                _arg0 = data.readString();
//                String _arg1;
//                _arg1 = data.readString();
//                //data.enforceNoDataAvail();
//                //int _result = this.getPackageProcessState(_arg0, _arg1);
//                //reply.writeNoException();
//                //reply.writeInt(_result);
//                break;
//            }
//            case TRANSACTION_startBinderTracking:
//            {
//                boolean _result = this.startBinderTracking();
//                //reply.writeNoException();
//                //reply.writeBoolean(_result);
//                break;
//            }
//            case TRANSACTION_stopBinderTrackingAndDump:
//            {
//                ParcelFileDescriptor _arg0;
//                _arg0 = data.readTypedObject(ParcelFileDescriptor.CREATOR);
//                //data.enforceNoDataAvail();
//                boolean _result = this.stopBinderTrackingAndDump(_arg0);
//                //reply.writeNoException();
//                //reply.writeBoolean(_result);
//                break;
//            }
//            case TRANSACTION_suppressResizeConfigChanges:
//            {
//                boolean _arg0;
//                _arg0 = data.readBoolean();
//                //data.enforceNoDataAvail();
//                this.suppressResizeConfigChanges(_arg0);
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_unlockUser:
//            {
//                int _arg0;
//                _arg0 = data.readInt();
//                byte[] _arg1;
//                _arg1 = data.createByteArray();
//                byte[] _arg2;
//                _arg2 = data.createByteArray();
//                android.os.IProgressListener _arg3;
//                _arg3 = android.os.IProgressListener.Stub.asInterface(data.readStrongBinder());
//                //data.enforceNoDataAvail();
//                boolean _result = this.unlockUser(_arg0, _arg1, _arg2, _arg3);
//                //reply.writeNoException();
//                //reply.writeBoolean(_result);
//                break;
//            }
//            case TRANSACTION_killPackageDependents:
//            {
//                String _arg0;
//                _arg0 = data.readString();
//                int _arg1;
//                _arg1 = data.readInt();
//                //data.enforceNoDataAvail();
//                this.killPackageDependents(_arg0, _arg1);
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_makePackageIdle:
//            {
//                String _arg0;
//                _arg0 = data.readString();
//                int _arg1;
//                _arg1 = data.readInt();
//                //data.enforceNoDataAvail();
//                this.makePackageIdle(_arg0, _arg1);
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_getMemoryTrimLevel:
//            {
//                //int _result = this.getMemoryTrimLevel();
//                //reply.writeNoException();
//                //reply.writeInt(_result);
//                break;
//            }
//            case TRANSACTION_isVrModePackageEnabled:
//            {
//                ComponentName _arg0;
//                _arg0 = data.readTypedObject(ComponentName.CREATOR);
//                //data.enforceNoDataAvail();
//                boolean _result = this.isVrModePackageEnabled(_arg0);
//                //reply.writeNoException();
//                //reply.writeBoolean(_result);
//                break;
//            }
//            case TRANSACTION_notifyLockedProfile:
//            {
//                int _arg0;
//                _arg0 = data.readInt();
//                //data.enforceNoDataAvail();
//                this.notifyLockedProfile(_arg0);
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_startConfirmDeviceCredentialIntent:
//            {
//                Intent _arg0;
//                _arg0 = data.readTypedObject(Intent.CREATOR);
//                Bundle _arg1;
//                _arg1 = data.readTypedObject(Bundle.CREATOR);
//                //data.enforceNoDataAvail();
//                this.startConfirmDeviceCredentialIntent(_arg0, _arg1);
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_sendIdleJobTrigger:
//            {
//                this.sendIdleJobTrigger();
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_sendIntentSender:
//            {
//                android.content.IIntentSender _arg0;
//                _arg0 = android.content.IIntentSender.Stub.asInterface(data.readStrongBinder());
//                IBinder _arg1;
//                _arg1 = data.readStrongBinder();
//                int _arg2;
//                _arg2 = data.readInt();
//                Intent _arg3;
//                _arg3 = data.readTypedObject(Intent.CREATOR);
//                String _arg4;
//                _arg4 = data.readString();
//                android.content.IIntentReceiver _arg5;
//                _arg5 = android.content.IIntentReceiver.Stub.asInterface(data.readStrongBinder());
//                String _arg6;
//                _arg6 = data.readString();
//                Bundle _arg7;
//                _arg7 = data.readTypedObject(Bundle.CREATOR);
//                //data.enforceNoDataAvail();
//                //int _result = this.sendIntentSender(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5, _arg6, _arg7);
//                //reply.writeNoException();
//                //reply.writeInt(_result);
//                break;
//            }
//            case TRANSACTION_isBackgroundRestricted:
//            {
//                String _arg0;
//                _arg0 = data.readString();
//                //data.enforceNoDataAvail();
//                boolean _result = this.isBackgroundRestricted(_arg0);
//                //reply.writeNoException();
//                //reply.writeBoolean(_result);
//                break;
//            }
//            case TRANSACTION_setRenderThread:
//            {
//                int _arg0;
//                _arg0 = data.readInt();
//                //data.enforceNoDataAvail();
//                this.setRenderThread(_arg0);
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_setHasTopUi:
//            {
//                boolean _arg0;
//                _arg0 = data.readBoolean();
//                //data.enforceNoDataAvail();
//                this.setHasTopUi(_arg0);
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_restartUserInBackground:
//            {
//                int _arg0;
//                _arg0 = data.readInt();
//                //data.enforceNoDataAvail();
//                //int _result = this.restartUserInBackground(_arg0);
//                //reply.writeNoException();
//                //reply.writeInt(_result);
//                break;
//            }
//            case TRANSACTION_cancelTaskWindowTransition:
//            {
//                int _arg0;
//                _arg0 = data.readInt();
//                //data.enforceNoDataAvail();
//                this.cancelTaskWindowTransition(_arg0);
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_scheduleApplicationInfoChanged:
//            {
//                List<String> _arg0;
//                _arg0 = data.createStringArrayList();
//                int _arg1;
//                _arg1 = data.readInt();
//                //data.enforceNoDataAvail();
//                this.scheduleApplicationInfoChanged(_arg0, _arg1);
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_setPersistentVrThread:
//            {
//                int _arg0;
//                _arg0 = data.readInt();
//                //data.enforceNoDataAvail();
//                this.setPersistentVrThread(_arg0);
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_waitForNetworkStateUpdate:
//            {
//                long _arg0;
//                _arg0 = data.readLong();
//                //data.enforceNoDataAvail();
//                this.waitForNetworkStateUpdate(_arg0);
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_backgroundAllowlistUid:
//            {
//                int _arg0;
//                _arg0 = data.readInt();
//                //data.enforceNoDataAvail();
//                this.backgroundAllowlistUid(_arg0);
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_startUserInBackgroundWithListener:
//            {
//                int _arg0;
//                _arg0 = data.readInt();
//                android.os.IProgressListener _arg1;
//                _arg1 = android.os.IProgressListener.Stub.asInterface(data.readStrongBinder());
//                //data.enforceNoDataAvail();
//                boolean _result = this.startUserInBackgroundWithListener(_arg0, _arg1);
//                //reply.writeNoException();
//                //reply.writeBoolean(_result);
//                break;
//            }
//            case TRANSACTION_startDelegateShellPermissionIdentity:
//            {
//                int _arg0;
//                _arg0 = data.readInt();
//                String[] _arg1;
//                _arg1 = data.createStringArray();
//                //data.enforceNoDataAvail();
//                this.startDelegateShellPermissionIdentity(_arg0, _arg1);
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_stopDelegateShellPermissionIdentity:
//            {
//                this.stopDelegateShellPermissionIdentity();
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_getDelegatedShellPermissions:
//            {
//                List<String> _result = this.getDelegatedShellPermissions();
//                //reply.writeNoException();
//                //reply.writeStringList(_result);
//                break;
//            }
//            case TRANSACTION_getLifeMonitor:
//            {
//                ParcelFileDescriptor _result = this.getLifeMonitor();
//                //reply.writeNoException();
//                //reply.writeTypedObject(_result, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
//                break;
//            }
//            case TRANSACTION_startUserInForegroundWithListener:
//            {
//                int _arg0;
//                _arg0 = data.readInt();
//                android.os.IProgressListener _arg1;
//                _arg1 = android.os.IProgressListener.Stub.asInterface(data.readStrongBinder());
//                //data.enforceNoDataAvail();
//                boolean _result = this.startUserInForegroundWithListener(_arg0, _arg1);
//                //reply.writeNoException();
//                //reply.writeBoolean(_result);
//                break;
//            }
//            case TRANSACTION_appNotResponding:
//            {
//                String _arg0;
//                _arg0 = data.readString();
//                //data.enforceNoDataAvail();
//                this.appNotResponding(_arg0);
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_getHistoricalProcessExitReasons:
//            {
//                String _arg0;
//                _arg0 = data.readString();
//                int _arg1;
//                _arg1 = data.readInt();
//                int _arg2;
//                _arg2 = data.readInt();
//                int _arg3;
//                _arg3 = data.readInt();
//                //data.enforceNoDataAvail();
//                android.content.pm.ParceledListSlice<ApplicationExitInfo> _result = this.getHistoricalProcessExitReasons(_arg0, _arg1, _arg2, _arg3);
//                //reply.writeNoException();
//                //reply.writeTypedObject(_result, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
//                break;
//            }
//            case TRANSACTION_killProcessesWhenImperceptible:
//            {
//                int[] _arg0;
//                _arg0 = data.createIntArray();
//                String _arg1;
//                _arg1 = data.readString();
//                //data.enforceNoDataAvail();
//                this.killProcessesWhenImperceptible(_arg0, _arg1);
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_setActivityLocusContext:
//            {
//                ComponentName _arg0;
//                _arg0 = data.readTypedObject(ComponentName.CREATOR);
//                LocusId _arg1;
//                _arg1 = data.readTypedObject(LocusId.CREATOR);
//                IBinder _arg2;
//                _arg2 = data.readStrongBinder();
//                //data.enforceNoDataAvail();
//                this.setActivityLocusContext(_arg0, _arg1, _arg2);
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_setProcessStateSummary:
//            {
//                byte[] _arg0;
//                _arg0 = data.createByteArray();
//                //data.enforceNoDataAvail();
//                this.setProcessStateSummary(_arg0);
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_isAppFreezerSupported:
//            {
//                boolean _result = this.isAppFreezerSupported();
//                //reply.writeNoException();
//                //reply.writeBoolean(_result);
//                break;
//            }
//            case TRANSACTION_isAppFreezerEnabled:
//            {
//                boolean _result = this.isAppFreezerEnabled();
//                //reply.writeNoException();
//                //reply.writeBoolean(_result);
//                break;
//            }
//            case TRANSACTION_killUidForPermissionChange:
//            {
//                int _arg0;
//                _arg0 = data.readInt();
//                int _arg1;
//                _arg1 = data.readInt();
//                String _arg2;
//                _arg2 = data.readString();
//                //data.enforceNoDataAvail();
//                this.killUidForPermissionChange(_arg0, _arg1, _arg2);
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_resetAppErrors:
//            {
//                this.resetAppErrors();
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_enableAppFreezer:
//            {
//                boolean _arg0;
//                _arg0 = data.readBoolean();
//                //data.enforceNoDataAvail();
//                boolean _result = this.enableAppFreezer(_arg0);
//                //reply.writeNoException();
//                //reply.writeBoolean(_result);
//                break;
//            }
//            case TRANSACTION_enableFgsNotificationRateLimit:
//            {
//                boolean _arg0;
//                _arg0 = data.readBoolean();
//                //data.enforceNoDataAvail();
//                boolean _result = this.enableFgsNotificationRateLimit(_arg0);
//                //reply.writeNoException();
//                //reply.writeBoolean(_result);
//                break;
//            }
//            case TRANSACTION_holdLock:
//            {
//                IBinder _arg0;
//                _arg0 = data.readStrongBinder();
//                int _arg1;
//                _arg1 = data.readInt();
//                //data.enforceNoDataAvail();
//                this.holdLock(_arg0, _arg1);
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_startProfile:
//            {
//                int _arg0;
//                _arg0 = data.readInt();
//                //data.enforceNoDataAvail();
//                boolean _result = this.startProfile(_arg0);
//                //reply.writeNoException();
//                //reply.writeBoolean(_result);
//                break;
//            }
//            case TRANSACTION_stopProfile:
//            {
//                int _arg0;
//                _arg0 = data.readInt();
//                //data.enforceNoDataAvail();
//                boolean _result = this.stopProfile(_arg0);
//                //reply.writeNoException();
//                //reply.writeBoolean(_result);
//                break;
//            }
//            case TRANSACTION_queryIntentComponentsForIntentSender:
//            {
//                android.content.IIntentSender _arg0;
//                _arg0 = android.content.IIntentSender.Stub.asInterface(data.readStrongBinder());
//                int _arg1;
//                _arg1 = data.readInt();
//                //data.enforceNoDataAvail();
//                android.content.pm.ParceledListSlice _result = this.queryIntentComponentsForIntentSender(_arg0, _arg1);
//                //reply.writeNoException();
//                //reply.writeTypedObject(_result, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
//                break;
//            }
//            case TRANSACTION_getUidProcessCapabilities:
//            {
//                int _arg0;
//                _arg0 = data.readInt();
//                String _arg1;
//                _arg1 = data.readString();
//                //data.enforceNoDataAvail();
//                //int _result = this.getUidProcessCapabilities(_arg0, _arg1);
//                //reply.writeNoException();
//                //reply.writeInt(_result);
//                break;
//            }
//            case TRANSACTION_waitForBroadcastIdle:
//            {
//                this.waitForBroadcastIdle();
//                //reply.writeNoException();
//                break;
//            }
//            case TRANSACTION_getBackgroundRestrictionExemptionReason:
//            {
//                int _arg0;
//                _arg0 = data.readInt();
//                //data.enforceNoDataAvail();
//                //int _result = this.getBackgroundRestrictionExemptionReason(_arg0);
//                //reply.writeNoException();
//                //reply.writeInt(_result);
//                break;
//            }
//            default:
//            {
//                return super.onTransact(code, data, reply, flags);
//            }
        }
        return ;
    }
}
