package com.bbc;

import static android.os.IBinder.INTERFACE_TRANSACTION;

import android.content.pm.PermissionInfo;
import android.os.Build;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

public class IPackageManangerTranscationInput {
    private static final String TAG = "Transca";
    public static final java.lang.String DESCRIPTOR = "android.content.pm.IPackageManager";
    static final int TRANSACTION_checkPackageStartable = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
    static final int TRANSACTION_isPackageAvailable = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
    static final int TRANSACTION_getPackageInfo = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
    static final int TRANSACTION_getPackageInfoVersioned = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
    static final int TRANSACTION_getPackageUid = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
    static final int TRANSACTION_getPackageGids = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
    static final int TRANSACTION_currentToCanonicalPackageNames = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
    static final int TRANSACTION_canonicalToCurrentPackageNames = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
    static final int TRANSACTION_getApplicationInfo = (android.os.IBinder.FIRST_CALL_TRANSACTION + 8);
    static final int TRANSACTION_getTargetSdkVersion = (android.os.IBinder.FIRST_CALL_TRANSACTION + 9);
    static final int TRANSACTION_getActivityInfo = (android.os.IBinder.FIRST_CALL_TRANSACTION + 10);
    static final int TRANSACTION_activitySupportsIntent = (android.os.IBinder.FIRST_CALL_TRANSACTION + 11);
    static final int TRANSACTION_getReceiverInfo = (android.os.IBinder.FIRST_CALL_TRANSACTION + 12);
    static final int TRANSACTION_getServiceInfo = (android.os.IBinder.FIRST_CALL_TRANSACTION + 13);
    static final int TRANSACTION_getProviderInfo = (android.os.IBinder.FIRST_CALL_TRANSACTION + 14);
    static final int TRANSACTION_isProtectedBroadcast = (android.os.IBinder.FIRST_CALL_TRANSACTION + 15);
    static final int TRANSACTION_checkSignatures = (android.os.IBinder.FIRST_CALL_TRANSACTION + 16);
    static final int TRANSACTION_checkUidSignatures = (android.os.IBinder.FIRST_CALL_TRANSACTION + 17);
    static final int TRANSACTION_getAllPackages = (android.os.IBinder.FIRST_CALL_TRANSACTION + 18);
    static final int TRANSACTION_getPackagesForUid = (android.os.IBinder.FIRST_CALL_TRANSACTION + 19);
    static final int TRANSACTION_getNameForUid = (android.os.IBinder.FIRST_CALL_TRANSACTION + 20);
    static final int TRANSACTION_getNamesForUids = (android.os.IBinder.FIRST_CALL_TRANSACTION + 21);
    static final int TRANSACTION_getUidForSharedUser = (android.os.IBinder.FIRST_CALL_TRANSACTION + 22);
    static final int TRANSACTION_getFlagsForUid = (android.os.IBinder.FIRST_CALL_TRANSACTION + 23);
    static final int TRANSACTION_getPrivateFlagsForUid = (android.os.IBinder.FIRST_CALL_TRANSACTION + 24);
    static final int TRANSACTION_isUidPrivileged = (android.os.IBinder.FIRST_CALL_TRANSACTION + 25);
    static final int TRANSACTION_resolveIntent = (android.os.IBinder.FIRST_CALL_TRANSACTION + 26);
    static final int TRANSACTION_findPersistentPreferredActivity = (android.os.IBinder.FIRST_CALL_TRANSACTION + 27);
    static final int TRANSACTION_canForwardTo = (android.os.IBinder.FIRST_CALL_TRANSACTION + 28);
    static final int TRANSACTION_queryIntentActivities = (android.os.IBinder.FIRST_CALL_TRANSACTION + 29);
    static final int TRANSACTION_queryIntentActivityOptions = (android.os.IBinder.FIRST_CALL_TRANSACTION + 30);
    static final int TRANSACTION_queryIntentReceivers = (android.os.IBinder.FIRST_CALL_TRANSACTION + 31);
    static final int TRANSACTION_resolveService = (android.os.IBinder.FIRST_CALL_TRANSACTION + 32);
    static final int TRANSACTION_queryIntentServices = (android.os.IBinder.FIRST_CALL_TRANSACTION + 33);
    static final int TRANSACTION_queryIntentContentProviders = (android.os.IBinder.FIRST_CALL_TRANSACTION + 34);
    static final int TRANSACTION_getInstalledPackages = (android.os.IBinder.FIRST_CALL_TRANSACTION + 35);
    static final int TRANSACTION_getPackagesHoldingPermissions = (android.os.IBinder.FIRST_CALL_TRANSACTION + 36);
    static final int TRANSACTION_getInstalledApplications = (android.os.IBinder.FIRST_CALL_TRANSACTION + 37);
    static final int TRANSACTION_getPersistentApplications = (android.os.IBinder.FIRST_CALL_TRANSACTION + 38);
    static final int TRANSACTION_resolveContentProvider = (android.os.IBinder.FIRST_CALL_TRANSACTION + 39);
    static final int TRANSACTION_querySyncProviders = (android.os.IBinder.FIRST_CALL_TRANSACTION + 40);
    static final int TRANSACTION_queryContentProviders = (android.os.IBinder.FIRST_CALL_TRANSACTION + 41);
    static final int TRANSACTION_getInstrumentationInfo = (android.os.IBinder.FIRST_CALL_TRANSACTION + 42);
    static final int TRANSACTION_queryInstrumentation = (android.os.IBinder.FIRST_CALL_TRANSACTION + 43);
    static final int TRANSACTION_finishPackageInstall = (android.os.IBinder.FIRST_CALL_TRANSACTION + 44);
    static final int TRANSACTION_setInstallerPackageName = (android.os.IBinder.FIRST_CALL_TRANSACTION + 45);
    static final int TRANSACTION_setApplicationCategoryHint = (android.os.IBinder.FIRST_CALL_TRANSACTION + 46);
    static final int TRANSACTION_deletePackageAsUser = (android.os.IBinder.FIRST_CALL_TRANSACTION + 47);
    static final int TRANSACTION_deletePackageVersioned = (android.os.IBinder.FIRST_CALL_TRANSACTION + 48);
    static final int TRANSACTION_deleteExistingPackageAsUser = (android.os.IBinder.FIRST_CALL_TRANSACTION + 49);
    static final int TRANSACTION_getInstallerPackageName = (android.os.IBinder.FIRST_CALL_TRANSACTION + 50);
    static final int TRANSACTION_getInstallSourceInfo = (android.os.IBinder.FIRST_CALL_TRANSACTION + 51);
    static final int TRANSACTION_resetApplicationPreferences = (android.os.IBinder.FIRST_CALL_TRANSACTION + 52);
    static final int TRANSACTION_getLastChosenActivity = (android.os.IBinder.FIRST_CALL_TRANSACTION + 53);
    static final int TRANSACTION_setLastChosenActivity = (android.os.IBinder.FIRST_CALL_TRANSACTION + 54);
    static final int TRANSACTION_addPreferredActivity = (android.os.IBinder.FIRST_CALL_TRANSACTION + 55);
    static final int TRANSACTION_replacePreferredActivity = (android.os.IBinder.FIRST_CALL_TRANSACTION + 56);
    static final int TRANSACTION_clearPackagePreferredActivities = (android.os.IBinder.FIRST_CALL_TRANSACTION + 57);
    static final int TRANSACTION_getPreferredActivities = (android.os.IBinder.FIRST_CALL_TRANSACTION + 58);
    static final int TRANSACTION_addPersistentPreferredActivity = (android.os.IBinder.FIRST_CALL_TRANSACTION + 59);
    static final int TRANSACTION_clearPackagePersistentPreferredActivities = (android.os.IBinder.FIRST_CALL_TRANSACTION + 60);
    static final int TRANSACTION_addCrossProfileIntentFilter = (android.os.IBinder.FIRST_CALL_TRANSACTION + 61);
    static final int TRANSACTION_clearCrossProfileIntentFilters = (android.os.IBinder.FIRST_CALL_TRANSACTION + 62);
    static final int TRANSACTION_setDistractingPackageRestrictionsAsUser = (android.os.IBinder.FIRST_CALL_TRANSACTION + 63);
    static final int TRANSACTION_setPackagesSuspendedAsUser = (android.os.IBinder.FIRST_CALL_TRANSACTION + 64);
    static final int TRANSACTION_getUnsuspendablePackagesForUser = (android.os.IBinder.FIRST_CALL_TRANSACTION + 65);
    static final int TRANSACTION_isPackageSuspendedForUser = (android.os.IBinder.FIRST_CALL_TRANSACTION + 66);
    static final int TRANSACTION_getSuspendedPackageAppExtras = (android.os.IBinder.FIRST_CALL_TRANSACTION + 67);
    static final int TRANSACTION_getPreferredActivityBackup = (android.os.IBinder.FIRST_CALL_TRANSACTION + 68);
    static final int TRANSACTION_restorePreferredActivities = (android.os.IBinder.FIRST_CALL_TRANSACTION + 69);
    static final int TRANSACTION_getDefaultAppsBackup = (android.os.IBinder.FIRST_CALL_TRANSACTION + 70);
    static final int TRANSACTION_restoreDefaultApps = (android.os.IBinder.FIRST_CALL_TRANSACTION + 71);
    static final int TRANSACTION_getDomainVerificationBackup = (android.os.IBinder.FIRST_CALL_TRANSACTION + 72);
    static final int TRANSACTION_restoreDomainVerification = (android.os.IBinder.FIRST_CALL_TRANSACTION + 73);
    static final int TRANSACTION_getHomeActivities = (android.os.IBinder.FIRST_CALL_TRANSACTION + 74);
    static final int TRANSACTION_setHomeActivity = (android.os.IBinder.FIRST_CALL_TRANSACTION + 75);
    static final int TRANSACTION_overrideLabelAndIcon = (android.os.IBinder.FIRST_CALL_TRANSACTION + 76);
    static final int TRANSACTION_restoreLabelAndIcon = (android.os.IBinder.FIRST_CALL_TRANSACTION + 77);
    static final int TRANSACTION_setComponentEnabledSetting = (android.os.IBinder.FIRST_CALL_TRANSACTION + 78);
    static final int TRANSACTION_setComponentEnabledSettings = (android.os.IBinder.FIRST_CALL_TRANSACTION + 79);
    static final int TRANSACTION_getComponentEnabledSetting = (android.os.IBinder.FIRST_CALL_TRANSACTION + 80);
    static final int TRANSACTION_setApplicationEnabledSetting = (android.os.IBinder.FIRST_CALL_TRANSACTION + 81);
    static final int TRANSACTION_getApplicationEnabledSetting = (android.os.IBinder.FIRST_CALL_TRANSACTION + 82);
    static final int TRANSACTION_logAppProcessStartIfNeeded = (android.os.IBinder.FIRST_CALL_TRANSACTION + 83);
    static final int TRANSACTION_flushPackageRestrictionsAsUser = (android.os.IBinder.FIRST_CALL_TRANSACTION + 84);
    static final int TRANSACTION_setPackageStoppedState = (android.os.IBinder.FIRST_CALL_TRANSACTION + 85);
    static final int TRANSACTION_freeStorageAndNotify = (android.os.IBinder.FIRST_CALL_TRANSACTION + 86);
    static final int TRANSACTION_freeStorage = (android.os.IBinder.FIRST_CALL_TRANSACTION + 87);
    static final int TRANSACTION_deleteApplicationCacheFiles = (android.os.IBinder.FIRST_CALL_TRANSACTION + 88);
    static final int TRANSACTION_deleteApplicationCacheFilesAsUser = (android.os.IBinder.FIRST_CALL_TRANSACTION + 89);
    static final int TRANSACTION_clearApplicationUserData = (android.os.IBinder.FIRST_CALL_TRANSACTION + 90);
    static final int TRANSACTION_clearApplicationProfileData = (android.os.IBinder.FIRST_CALL_TRANSACTION + 91);
    static final int TRANSACTION_getPackageSizeInfo = (android.os.IBinder.FIRST_CALL_TRANSACTION + 92);
    static final int TRANSACTION_getSystemSharedLibraryNames = (android.os.IBinder.FIRST_CALL_TRANSACTION + 93);
    static final int TRANSACTION_getSystemAvailableFeatures = (android.os.IBinder.FIRST_CALL_TRANSACTION + 94);
    static final int TRANSACTION_hasSystemFeature = (android.os.IBinder.FIRST_CALL_TRANSACTION + 95);
    static final int TRANSACTION_enterSafeMode = (android.os.IBinder.FIRST_CALL_TRANSACTION + 96);
    static final int TRANSACTION_isSafeMode = (android.os.IBinder.FIRST_CALL_TRANSACTION + 97);
    static final int TRANSACTION_hasSystemUidErrors = (android.os.IBinder.FIRST_CALL_TRANSACTION + 98);
    static final int TRANSACTION_notifyPackageUse = (android.os.IBinder.FIRST_CALL_TRANSACTION + 99);
    static final int TRANSACTION_notifyDexLoad = (android.os.IBinder.FIRST_CALL_TRANSACTION + 100);
    static final int TRANSACTION_registerDexModule = (android.os.IBinder.FIRST_CALL_TRANSACTION + 101);
    static final int TRANSACTION_performDexOptMode = (android.os.IBinder.FIRST_CALL_TRANSACTION + 102);
    static final int TRANSACTION_performDexOptSecondary = (android.os.IBinder.FIRST_CALL_TRANSACTION + 103);
    static final int TRANSACTION_dumpProfiles = (android.os.IBinder.FIRST_CALL_TRANSACTION + 104);
    static final int TRANSACTION_forceDexOpt = (android.os.IBinder.FIRST_CALL_TRANSACTION + 105);
    static final int TRANSACTION_reconcileSecondaryDexFiles = (android.os.IBinder.FIRST_CALL_TRANSACTION + 106);
    static final int TRANSACTION_getMoveStatus = (android.os.IBinder.FIRST_CALL_TRANSACTION + 107);
    static final int TRANSACTION_registerMoveCallback = (android.os.IBinder.FIRST_CALL_TRANSACTION + 108);
    static final int TRANSACTION_unregisterMoveCallback = (android.os.IBinder.FIRST_CALL_TRANSACTION + 109);
    static final int TRANSACTION_movePackage = (android.os.IBinder.FIRST_CALL_TRANSACTION + 110);
    static final int TRANSACTION_movePrimaryStorage = (android.os.IBinder.FIRST_CALL_TRANSACTION + 111);
    static final int TRANSACTION_setInstallLocation = (android.os.IBinder.FIRST_CALL_TRANSACTION + 112);
    static final int TRANSACTION_getInstallLocation = (android.os.IBinder.FIRST_CALL_TRANSACTION + 113);
    static final int TRANSACTION_installExistingPackageAsUser = (android.os.IBinder.FIRST_CALL_TRANSACTION + 114);
    static final int TRANSACTION_verifyPendingInstall = (android.os.IBinder.FIRST_CALL_TRANSACTION + 115);
    static final int TRANSACTION_extendVerificationTimeout = (android.os.IBinder.FIRST_CALL_TRANSACTION + 116);
    static final int TRANSACTION_verifyIntentFilter = (android.os.IBinder.FIRST_CALL_TRANSACTION + 117);
    static final int TRANSACTION_getIntentVerificationStatus = (android.os.IBinder.FIRST_CALL_TRANSACTION + 118);
    static final int TRANSACTION_updateIntentVerificationStatus = (android.os.IBinder.FIRST_CALL_TRANSACTION + 119);
    static final int TRANSACTION_getIntentFilterVerifications = (android.os.IBinder.FIRST_CALL_TRANSACTION + 120);
    static final int TRANSACTION_getAllIntentFilters = (android.os.IBinder.FIRST_CALL_TRANSACTION + 121);
    static final int TRANSACTION_getVerifierDeviceIdentity = (android.os.IBinder.FIRST_CALL_TRANSACTION + 122);
    static final int TRANSACTION_isFirstBoot = (android.os.IBinder.FIRST_CALL_TRANSACTION + 123);
    static final int TRANSACTION_isOnlyCoreApps = (android.os.IBinder.FIRST_CALL_TRANSACTION + 124);
    static final int TRANSACTION_isDeviceUpgrading = (android.os.IBinder.FIRST_CALL_TRANSACTION + 125);
    static final int TRANSACTION_isStorageLow = (android.os.IBinder.FIRST_CALL_TRANSACTION + 126);
    static final int TRANSACTION_setApplicationHiddenSettingAsUser = (android.os.IBinder.FIRST_CALL_TRANSACTION + 127);
    static final int TRANSACTION_getApplicationHiddenSettingAsUser = (android.os.IBinder.FIRST_CALL_TRANSACTION + 128);
    static final int TRANSACTION_setSystemAppHiddenUntilInstalled = (android.os.IBinder.FIRST_CALL_TRANSACTION + 129);
    static final int TRANSACTION_setSystemAppInstallState = (android.os.IBinder.FIRST_CALL_TRANSACTION + 130);
    static final int TRANSACTION_getPackageInstaller = (android.os.IBinder.FIRST_CALL_TRANSACTION + 131);
    static final int TRANSACTION_setBlockUninstallForUser = (android.os.IBinder.FIRST_CALL_TRANSACTION + 132);
    static final int TRANSACTION_getBlockUninstallForUser = (android.os.IBinder.FIRST_CALL_TRANSACTION + 133);
    static final int TRANSACTION_getKeySetByAlias = (android.os.IBinder.FIRST_CALL_TRANSACTION + 134);
    static final int TRANSACTION_getSigningKeySet = (android.os.IBinder.FIRST_CALL_TRANSACTION + 135);
    static final int TRANSACTION_isPackageSignedByKeySet = (android.os.IBinder.FIRST_CALL_TRANSACTION + 136);
    static final int TRANSACTION_isPackageSignedByKeySetExactly = (android.os.IBinder.FIRST_CALL_TRANSACTION + 137);
    static final int TRANSACTION_getPermissionControllerPackageName = (android.os.IBinder.FIRST_CALL_TRANSACTION + 138);
    static final int TRANSACTION_getSdkSandboxPackageName = (android.os.IBinder.FIRST_CALL_TRANSACTION + 139);
    static final int TRANSACTION_getInstantApps = (android.os.IBinder.FIRST_CALL_TRANSACTION + 140);
    static final int TRANSACTION_getInstantAppCookie = (android.os.IBinder.FIRST_CALL_TRANSACTION + 141);
    static final int TRANSACTION_setInstantAppCookie = (android.os.IBinder.FIRST_CALL_TRANSACTION + 142);
    static final int TRANSACTION_getInstantAppIcon = (android.os.IBinder.FIRST_CALL_TRANSACTION + 143);
    static final int TRANSACTION_isInstantApp = (android.os.IBinder.FIRST_CALL_TRANSACTION + 144);
    static final int TRANSACTION_setRequiredForSystemUser = (android.os.IBinder.FIRST_CALL_TRANSACTION + 145);
    static final int TRANSACTION_setUpdateAvailable = (android.os.IBinder.FIRST_CALL_TRANSACTION + 146);
    static final int TRANSACTION_getServicesSystemSharedLibraryPackageName = (android.os.IBinder.FIRST_CALL_TRANSACTION + 147);
    static final int TRANSACTION_getSharedSystemSharedLibraryPackageName = (android.os.IBinder.FIRST_CALL_TRANSACTION + 148);
    static final int TRANSACTION_getChangedPackages = (android.os.IBinder.FIRST_CALL_TRANSACTION + 149);
    static final int TRANSACTION_isPackageDeviceAdminOnAnyUser = (android.os.IBinder.FIRST_CALL_TRANSACTION + 150);
    static final int TRANSACTION_getInstallReason = (android.os.IBinder.FIRST_CALL_TRANSACTION + 151);
    static final int TRANSACTION_getSharedLibraries = (android.os.IBinder.FIRST_CALL_TRANSACTION + 152);
    static final int TRANSACTION_getDeclaredSharedLibraries = (android.os.IBinder.FIRST_CALL_TRANSACTION + 153);
    static final int TRANSACTION_canRequestPackageInstalls = (android.os.IBinder.FIRST_CALL_TRANSACTION + 154);
    static final int TRANSACTION_deletePreloadsFileCache = (android.os.IBinder.FIRST_CALL_TRANSACTION + 155);
    static final int TRANSACTION_getInstantAppResolverComponent = (android.os.IBinder.FIRST_CALL_TRANSACTION + 156);
    static final int TRANSACTION_getInstantAppResolverSettingsComponent = (android.os.IBinder.FIRST_CALL_TRANSACTION + 157);
    static final int TRANSACTION_getInstantAppInstallerComponent = (android.os.IBinder.FIRST_CALL_TRANSACTION + 158);
    static final int TRANSACTION_getInstantAppAndroidId = (android.os.IBinder.FIRST_CALL_TRANSACTION + 159);
    static final int TRANSACTION_getArtManager = (android.os.IBinder.FIRST_CALL_TRANSACTION + 160);
    static final int TRANSACTION_setHarmfulAppWarning = (android.os.IBinder.FIRST_CALL_TRANSACTION + 161);
    static final int TRANSACTION_getHarmfulAppWarning = (android.os.IBinder.FIRST_CALL_TRANSACTION + 162);
    static final int TRANSACTION_hasSigningCertificate = (android.os.IBinder.FIRST_CALL_TRANSACTION + 163);
    static final int TRANSACTION_hasUidSigningCertificate = (android.os.IBinder.FIRST_CALL_TRANSACTION + 164);
    static final int TRANSACTION_getDefaultTextClassifierPackageName = (android.os.IBinder.FIRST_CALL_TRANSACTION + 165);
    static final int TRANSACTION_getSystemTextClassifierPackageName = (android.os.IBinder.FIRST_CALL_TRANSACTION + 166);
    static final int TRANSACTION_getAttentionServicePackageName = (android.os.IBinder.FIRST_CALL_TRANSACTION + 167);
    static final int TRANSACTION_getRotationResolverPackageName = (android.os.IBinder.FIRST_CALL_TRANSACTION + 168);
    static final int TRANSACTION_getWellbeingPackageName = (android.os.IBinder.FIRST_CALL_TRANSACTION + 169);
    static final int TRANSACTION_getAppPredictionServicePackageName = (android.os.IBinder.FIRST_CALL_TRANSACTION + 170);
    static final int TRANSACTION_getSystemCaptionsServicePackageName = (android.os.IBinder.FIRST_CALL_TRANSACTION + 171);
    static final int TRANSACTION_getSetupWizardPackageName = (android.os.IBinder.FIRST_CALL_TRANSACTION + 172);
    static final int TRANSACTION_getIncidentReportApproverPackageName = (android.os.IBinder.FIRST_CALL_TRANSACTION + 173);
    static final int TRANSACTION_getContentCaptureServicePackageName = (android.os.IBinder.FIRST_CALL_TRANSACTION + 174);
    static final int TRANSACTION_isPackageStateProtected = (android.os.IBinder.FIRST_CALL_TRANSACTION + 175);
    static final int TRANSACTION_sendDeviceCustomizationReadyBroadcast = (android.os.IBinder.FIRST_CALL_TRANSACTION + 176);
    static final int TRANSACTION_getInstalledModules = (android.os.IBinder.FIRST_CALL_TRANSACTION + 177);
    static final int TRANSACTION_getModuleInfo = (android.os.IBinder.FIRST_CALL_TRANSACTION + 178);
    static final int TRANSACTION_getRuntimePermissionsVersion = (android.os.IBinder.FIRST_CALL_TRANSACTION + 179);
    static final int TRANSACTION_setRuntimePermissionsVersion = (android.os.IBinder.FIRST_CALL_TRANSACTION + 180);
    static final int TRANSACTION_notifyPackagesReplacedReceived = (android.os.IBinder.FIRST_CALL_TRANSACTION + 181);
    static final int TRANSACTION_requestPackageChecksums = (android.os.IBinder.FIRST_CALL_TRANSACTION + 182);
    static final int TRANSACTION_getLaunchIntentSenderForPackage = (android.os.IBinder.FIRST_CALL_TRANSACTION + 183);
    static final int TRANSACTION_getAppOpPermissionPackages = (android.os.IBinder.FIRST_CALL_TRANSACTION + 184);
    static final int TRANSACTION_getPermissionGroupInfo = (android.os.IBinder.FIRST_CALL_TRANSACTION + 185);
    static final int TRANSACTION_addPermission = (android.os.IBinder.FIRST_CALL_TRANSACTION + 186);
    static final int TRANSACTION_addPermissionAsync = (android.os.IBinder.FIRST_CALL_TRANSACTION + 187);
    static final int TRANSACTION_removePermission = (android.os.IBinder.FIRST_CALL_TRANSACTION + 188);
    static final int TRANSACTION_checkPermission = (android.os.IBinder.FIRST_CALL_TRANSACTION + 189);
    static final int TRANSACTION_grantRuntimePermission = (android.os.IBinder.FIRST_CALL_TRANSACTION + 190);
    static final int TRANSACTION_checkUidPermission = (android.os.IBinder.FIRST_CALL_TRANSACTION + 191);
    static final int TRANSACTION_setMimeGroup = (android.os.IBinder.FIRST_CALL_TRANSACTION + 192);
    static final int TRANSACTION_getSplashScreenTheme = (android.os.IBinder.FIRST_CALL_TRANSACTION + 193);
    static final int TRANSACTION_setSplashScreenTheme = (android.os.IBinder.FIRST_CALL_TRANSACTION + 194);
    static final int TRANSACTION_getMimeGroup = (android.os.IBinder.FIRST_CALL_TRANSACTION + 195);
    static final int TRANSACTION_isAutoRevokeWhitelisted = (android.os.IBinder.FIRST_CALL_TRANSACTION + 196);
    static final int TRANSACTION_makeProviderVisible = (android.os.IBinder.FIRST_CALL_TRANSACTION + 197);
    static final int TRANSACTION_makeUidVisible = (android.os.IBinder.FIRST_CALL_TRANSACTION + 198);
    static final int TRANSACTION_getHoldLockToken = (android.os.IBinder.FIRST_CALL_TRANSACTION + 199);
    static final int TRANSACTION_holdLock = (android.os.IBinder.FIRST_CALL_TRANSACTION + 200);
    static final int TRANSACTION_getProperty = (android.os.IBinder.FIRST_CALL_TRANSACTION + 201);
    static final int TRANSACTION_queryProperty = (android.os.IBinder.FIRST_CALL_TRANSACTION + 202);
    static final int TRANSACTION_setKeepUninstalledPackages = (android.os.IBinder.FIRST_CALL_TRANSACTION + 203);
    static final int TRANSACTION_canPackageQuery = (android.os.IBinder.FIRST_CALL_TRANSACTION + 204);
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
    private static final void Log_readString(Parcel data,String msg){
        Log.d(TAG, String.format("onTransactPrintParcel(%s) called with: String_arg = [%s]",msg,data.readString()));
    }
    private static final void Log_readInt(Parcel data){
        Log.d(TAG, String.format("onTransactPrintParcel() called with: Int_arg = [%s]",data.readInt()));
    }
    private static final void Log_readLong(Parcel data){
        Log.d(TAG, String.format("onTransactPrintParcel() called with: Long_arg = [%s]",data.readLong()));
    }
    private static final void Log_readTypedObject(Parcel data, PermissionInfo.Creator creator){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Log.d(TAG, String.format("onTransactPrintParcel() called with: TypedObject_arg = [%s]",data.readTypedObject(creator)));
        }
    }

    public static void onTransactPrintParcel(int code, Parcel data) {
        Log.d(TAG, "onTransactPrintParcel() called with: code = [" + code + "], data = [" + data + "]");
        if (data == null) return;
        String descriptor = DESCRIPTOR;
        if (code >= IBinder.FIRST_CALL_TRANSACTION && code <= IBinder.LAST_CALL_TRANSACTION) {
            try {
                data.enforceInterface(descriptor);
            } catch (Exception e) {
                Log.e(TAG,e.getMessage());
            }
//            data.readInt();
//            data.readInt();
//            Log_readString(data,"data.enforceInterface");
        }
        if (code == INTERFACE_TRANSACTION) {
            //reply.writeString(descriptor);
            return ;
        }
        switch (code){
            case TRANSACTION_checkPackageStartable:
            {
                Log_readString(data);
                Log_readInt(data);
//                java.lang.String _arg0;
//                _arg0 = data.readString();
//                int _arg1;
//                _arg1 = data.readInt();
//                data.enforceNoDataAvail();
//                this.checkPackageStartable(_arg0, _arg1);
//                reply.writeNoException();
                break;
            }
            case TRANSACTION_addPermission:
            {
                Log_readTypedObject(data,android.content.pm.PermissionInfo.CREATOR);
//                android.content.pm.PermissionInfo _arg0;
//                _arg0 = data.readTypedObject(android.content.pm.PermissionInfo.CREATOR);
//                data.enforceNoDataAvail();
//                boolean _result = this.addPermission(_arg0);
//                reply.writeNoException();
//                reply.writeBoolean(_result);
                break;
            }
            case TRANSACTION_addPermissionAsync:
            {
                Log_readTypedObject(data,android.content.pm.PermissionInfo.CREATOR);
//                android.content.pm.PermissionInfo _arg0;
//                _arg0 = data.readTypedObject(android.content.pm.PermissionInfo.CREATOR);
//                data.enforceNoDataAvail();
//                boolean _result = this.addPermissionAsync(_arg0);
//                reply.writeNoException();
//                reply.writeBoolean(_result);
                break;
            }
            case TRANSACTION_removePermission:
            {
                Log_readString(data);
//                java.lang.String _arg0;
//                _arg0 = data.readString();
//                data.enforceNoDataAvail();
//                this.removePermission(_arg0);
//                reply.writeNoException();
                break;
            }
            case TRANSACTION_checkPermission:
            {
                Log_readString(data);
                Log_readString(data);
                Log_readInt(data);
//                java.lang.String _arg0;
//                _arg0 = data.readString();
//                java.lang.String _arg1;
//                _arg1 = data.readString();
//                int _arg2;
//                _arg2 = data.readInt();
//                data.enforceNoDataAvail();
//                int _result = this.checkPermission(_arg0, _arg1, _arg2);
//                reply.writeNoException();
//                reply.writeInt(_result);
                break;
            }
            case TRANSACTION_grantRuntimePermission:
            {
                Log_readString(data);
                Log_readString(data);
                Log_readInt(data);
//                java.lang.String _arg0;
//                _arg0 = data.readString();
//                java.lang.String _arg1;
//                _arg1 = data.readString();
//                int _arg2;
//                _arg2 = data.readInt();
//                data.enforceNoDataAvail();
//                this.grantRuntimePermission(_arg0, _arg1, _arg2);
//                reply.writeNoException();
                break;
            }
            case TRANSACTION_checkUidPermission:
            {
                Log_readString(data);
                Log_readInt(data);
//                java.lang.String _arg0;
//                _arg0 = data.readString();
//                int _arg1;
//                _arg1 = data.readInt();
//                data.enforceNoDataAvail();
//                int _result = this.checkUidPermission(_arg0, _arg1);
//                reply.writeNoException();
//                reply.writeInt(_result);
                break;
            }
        }

    }


}
