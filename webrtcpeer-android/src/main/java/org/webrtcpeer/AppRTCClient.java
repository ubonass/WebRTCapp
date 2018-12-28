/*
 *  Copyright 2013 The WebRTC Project Authors. All rights reserved.
 *
 *  Use of this source code is governed by a BSD-style license
 *  that can be found in the LICENSE file in the root of the source
 *  tree. An additional intellectual property rights grant can be found
 *  in the file PATENTS.  All contributing project authors may
 *  be found in the AUTHORS file in the root of the source tree.
 */

package org.webrtcpeer;

import org.webrtc.IceCandidate;
import org.webrtc.PeerConnection;
import org.webrtc.SessionDescription;

import java.util.List;

/**
 * AppRTCClient is the interface representing an AppRTC client.
 */
public interface AppRTCClient {

    /**
     * Struct holding the connection parameters of an AppRTC room.
     */
    class RoomConnectionParameters {
        public final String roomUrl;
        public final String roomId;//sessionName
        public final boolean loopback;
        public final String urlParameters;
        //public String sessionName;

        public RoomConnectionParameters(
                String roomUrl,
                String roomId,
                boolean loopback,
                String urlParameters) {
            this.roomUrl = roomUrl;
            this.roomId = roomId;
            this.loopback = loopback;
            this.urlParameters = urlParameters;//for participantName
        }

        public RoomConnectionParameters(String roomUrl,
                                        String sessionName,
                                        String participantName) {
            this.roomUrl = roomUrl;
            //this.sessionName = sessionName;
            this.roomId = sessionName;
            this.loopback = false;
            this.urlParameters = participantName;
        }

        public RoomConnectionParameters(String roomUrl, String roomId, boolean loopback) {
            this(roomUrl, roomId, loopback, null /* urlParameters */);
        }

        @Override
        public String toString() {
            return "RoomConnectionParameters{" +
                    "roomUrl='" + roomUrl + '\'' +
                    ", roomId='" + roomId + '\'' +
                    ", loopback=" + loopback +
                    ", urlParameters='" + urlParameters + '\'' +
                    '}';
        }
    }

    /**
     * Asynchronously connect to an AppRTC room URL using supplied connection
     * parameters. Once connection is established onConnectedToRoom()
     * callback with room parameters is invoked.
     */
    void connectToRoom(RoomConnectionParameters connectionParameters);

    /**
     *
     * @param connectionId
     */
    //void sendPublishVideoToRoom(String connectionId);

    /**
     * Send offer SDP to the other participant.
     */
    void sendOfferSdp(final SessionDescription sdp,
                      String connectionId);

    /**
     * Send answer SDP to the other participant.
     */
    void sendAnswerSdp(final SessionDescription sdp,
                       String connectionId);

    /**
     * Send Ice candidate to the other participant.
     */
    void sendLocalIceCandidate(final IceCandidate candidate,
                               String connectionId);

    /**
     * Send removed ICE candidates to the other participant.
     */
    void sendLocalIceCandidateRemovals(final IceCandidate[] candidates,
                                       String connectionId);

    /**
     * Disconnect from room.
     */
    void disconnectFromRoom();

    /**
     * Struct holding the signaling parameters of an AppRTC room.
     */
    class SignalingParameters {
        public final List<PeerConnection.IceServer> iceServers;
        public final boolean initiator;
        public final String clientId;
        public final String wssUrl;
        public final String response;//tokenResponse
        public final SessionDescription offerSdp;
        public final List<IceCandidate> iceCandidates;

        public SignalingParameters(List<PeerConnection.IceServer> iceServers,
                                   boolean initiator,
                                   String clientId,
                                   String wssUrl,
                                   String response,
                                   SessionDescription offerSdp,
                                   List<IceCandidate> iceCandidates) {
            this.iceServers = iceServers;
            this.initiator = initiator;
            this.clientId = clientId;
            this.wssUrl = wssUrl;
            this.response = response;//http response
            this.offerSdp = offerSdp;
            this.iceCandidates = iceCandidates;
        }
    }

    /**
     * Callback interface for messages delivered on signaling channel.
     *
     * <p>Methods are guaranteed to be invoked on the UI thread of |activity|.
     */
    interface SignalingEvents {


        /**
         * Callback fired once the room's signaling parameters
         * SignalingParameters are extracted.
         */
        void onConnectedToRoom(final SignalingParameters params,
                               String connectionId);
        /**
         *
         * @param params
         * @param connectionId
         */
        //void onRegistedInRoom(final SignalingParameters params,
        //                       String connectionId);
        /**
         * when remote user publish video in room it will be called
         * @param params
         * @param connectionId
         */
        void onRemoteJoinedInRoom(final SignalingParameters params,
                                        String connectionId);
        /**
         * when remote user publish video in room it will be called
         * @param params
         * @param connectionId
         */
        void onRemotePublishVideoInRoom(final SignalingParameters params,
                                        String connectionId);

        /**
         * Callback fired once remote SDP is received.
         */
        void onRemoteDescription(final SessionDescription sdp,
                                 String connectionId);

        /**
         * Callback fired once remote Ice candidate is received.
         */
        void onRemoteIceCandidate(final IceCandidate candidate,
                                  String connectionId);

        /**
         * Callback fired once remote Ice candidate removals are received.
         */
        void onRemoteIceCandidatesRemoved(final IceCandidate[] candidates,
                                          String connectionId);

        /**
         * Callback fired once channel is closed.
         */
        void onChannelClose();

        /**
         * Callback fired once channel error happened.
         */
        void onChannelError(final String description);
    }
}
