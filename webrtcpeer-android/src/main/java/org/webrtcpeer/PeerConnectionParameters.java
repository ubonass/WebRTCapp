package org.webrtcpeer;

public class PeerConnectionParameters {
    public final boolean videoCallEnabled;
    public final boolean loopback;
    public final boolean tracing;
    public final int videoWidth;
    public final int videoHeight;
    public final int videoFps;
    public final int videoMaxBitrate;
    public final String videoCodec;
    public final boolean videoCodecHwAcceleration;
    public final boolean videoFlexfecEnabled;
    public final int audioStartBitrate;
    public final String audioCodec;
    public final boolean noAudioProcessing;
    public final boolean aecDump;
    public final boolean saveInputAudioToFile;
    public final boolean useOpenSLES;
    public final boolean disableBuiltInAEC;
    public final boolean disableBuiltInAGC;
    public final boolean disableBuiltInNS;
    public final boolean disableWebRtcAGCAndHPF;
    public final boolean enableRtcEventLog;
    public final boolean useLegacyAudioDevice;
    public final DataChannelParameters dataChannelParameters;

    public PeerConnectionParameters(boolean videoCallEnabled,
                                    boolean loopback,
                                    boolean tracing,
                                    int videoWidth,
                                    int videoHeight,
                                    int videoFps,
                                    int videoMaxBitrate,
                                    String videoCodec,
                                    boolean videoCodecHwAcceleration,
                                    boolean videoFlexfecEnabled,
                                    int audioStartBitrate,
                                    String audioCodec,
                                    boolean noAudioProcessing,
                                    boolean aecDump,
                                    boolean saveInputAudioToFile,
                                    boolean useOpenSLES,
                                    boolean disableBuiltInAEC,
                                    boolean disableBuiltInAGC,
                                    boolean disableBuiltInNS,
                                    boolean disableWebRtcAGCAndHPF,
                                    boolean enableRtcEventLog,
                                    boolean useLegacyAudioDevice,
                                    DataChannelParameters dataChannelParameters) {
        this.videoCallEnabled = videoCallEnabled;
        this.loopback = loopback;
        this.tracing = tracing;
        this.videoWidth = videoWidth;
        this.videoHeight = videoHeight;
        this.videoFps = videoFps;
        this.videoMaxBitrate = videoMaxBitrate;
        this.videoCodec = videoCodec;
        this.videoFlexfecEnabled = videoFlexfecEnabled;
        this.videoCodecHwAcceleration = videoCodecHwAcceleration;
        this.audioStartBitrate = audioStartBitrate;
        this.audioCodec = audioCodec;
        this.noAudioProcessing = noAudioProcessing;
        this.aecDump = aecDump;
        this.saveInputAudioToFile = saveInputAudioToFile;
        this.useOpenSLES = useOpenSLES;
        this.disableBuiltInAEC = disableBuiltInAEC;
        this.disableBuiltInAGC = disableBuiltInAGC;
        this.disableBuiltInNS = disableBuiltInNS;
        this.disableWebRtcAGCAndHPF = disableWebRtcAGCAndHPF;
        this.enableRtcEventLog = enableRtcEventLog;
        this.useLegacyAudioDevice = useLegacyAudioDevice;
        this.dataChannelParameters = dataChannelParameters;
    }

    @Override
    public String toString() {
        return "PeerConnectionParameters{" +
                "videoCallEnabled=" + videoCallEnabled +
                ", loopback=" + loopback +
                ", tracing=" + tracing +
                ", videoWidth=" + videoWidth +
                ", videoHeight=" + videoHeight +
                ", videoFps=" + videoFps +
                ", videoMaxBitrate=" + videoMaxBitrate +
                ", videoCodec='" + videoCodec + '\'' +
                ", videoCodecHwAcceleration=" + videoCodecHwAcceleration +
                ", videoFlexfecEnabled=" + videoFlexfecEnabled +
                ", audioStartBitrate=" + audioStartBitrate +
                ", audioCodec='" + audioCodec + '\'' +
                ", noAudioProcessing=" + noAudioProcessing +
                ", aecDump=" + aecDump +
                ", saveInputAudioToFile=" + saveInputAudioToFile +
                ", useOpenSLES=" + useOpenSLES +
                ", disableBuiltInAEC=" + disableBuiltInAEC +
                ", disableBuiltInAGC=" + disableBuiltInAGC +
                ", disableBuiltInNS=" + disableBuiltInNS +
                ", disableWebRtcAGCAndHPF=" + disableWebRtcAGCAndHPF +
                ", enableRtcEventLog=" + enableRtcEventLog +
                ", useLegacyAudioDevice=" + useLegacyAudioDevice +
                ", dataChannelParameters=" + dataChannelParameters +
                '}';
    }
}
