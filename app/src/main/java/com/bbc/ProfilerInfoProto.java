package com.bbc;

public final class ProfilerInfoProto {

    // optional string profile_file = 1;
    public static final long PROFILE_FILE = 0x0000010900000001L;

    // optional int32 profile_fd = 2;
    public static final long PROFILE_FD = 0x0000010500000002L;

    // optional int32 sampling_interval = 3;
    public static final long SAMPLING_INTERVAL = 0x0000010500000003L;

    // optional bool auto_stop_profiler = 4;
    public static final long AUTO_STOP_PROFILER = 0x0000010800000004L;

    // optional bool streaming_output = 5;
    public static final long STREAMING_OUTPUT = 0x0000010800000005L;

    // optional string agent = 6;
    public static final long AGENT = 0x0000010900000006L;

    // optional int32 clock_type = 7;
    public static final long CLOCK_TYPE = 0x0000010500000007L;

}
