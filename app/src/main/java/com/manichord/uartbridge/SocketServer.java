package com.manichord.uartbridge;

import com.koushikdutta.async.AsyncNetworkSocket;
import com.koushikdutta.async.AsyncServer;
import com.koushikdutta.async.AsyncServerSocket;
import com.koushikdutta.async.AsyncSocket;
import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.DataCallback;
import com.koushikdutta.async.callback.ListenCallback;

import timber.log.Timber;

public class SocketServer {

    private AsyncServer asyncServer;
    private AsyncNetworkSocket asyncClient;

    public SocketServer(int serverPort) {
        asyncServer = new AsyncServer();
        asyncServer.listen(null, serverPort, listenCallback);
    }

    private ListenCallback listenCallback = new ListenCallback() {
        @Override
        public void onAccepted(AsyncSocket socket) {
            // this example service shows only a single server <-> client communication
            if (asyncClient != null) {
                asyncClient.close();
            }
            asyncClient = (AsyncNetworkSocket) socket;
            asyncClient.setDataCallback(new DataCallback() {
                @Override
                public void onDataAvailable(DataEmitter emitter, ByteBufferList bb) {
                    Timber.i("Data received: %s", bb.readString());
                }
            });
            asyncClient.setClosedCallback(new CompletedCallback() {
                @Override
                public void onCompleted(Exception ex) {
                    asyncClient = null;
                    Timber.i("Client socket closed");
                }
            });
            Timber.i("Client socket connected");
        }

        @Override
        public void onListening(AsyncServerSocket socket) {
            Timber.i("Server listening on port %d", socket.getLocalPort());
        }

        @Override
        public void onCompleted(Exception ex) {
            Timber.i("Server socket closed");
        }
    };

    // call this method to send data to the client socket
    public void sendData(String message) {
        if (asyncClient != null) {
            asyncClient.write(new ByteBufferList(message.getBytes()));
            Timber.d("Data sent: %s", message);
        } else {
            Timber.e("cannot send data - socket not yet ready");
        }
    }

    public void stopServer() {
        if (asyncServer.isRunning()) {
            asyncServer.stop();
        }
    }
}
