package com.movomx.bluetooth;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.IntentFilter;
import android.util.Log;
import com.getcapacitor.JSObject;
import com.getcapacitor.PluginCall;
import java.util.List;

public class Bluetooth {
  private Scanner scanner;
  private ScannerListener listener;
  private final Context context;
  private PluginCall scanCall;
  private PluginCall deviceFoundCall;

  public Bluetooth(Context context) {
    this.context = context;
  }

  @SuppressLint("UnspecifiedRegisterReceiverFlag")
  public void scan(List<String> filters) {
    stop();
    listener = createListener(filters);
    IntentFilter intent = ScannerIntentBuilder.create();
    context.registerReceiver(listener, intent);
    scanner = new Scanner();
    scanner.start();
  }

  public void stop() {
    context.unregisterReceiver(listener);
    scanner.stop();
  }

  public void setScanCall(PluginCall call) {
    scanCall = call;
  }

  public void setDeviceFoundCall(PluginCall call) {
    deviceFoundCall = call;
  }

  public String echo(String value) {
    Log.d("movo", value);
    return value;
  }

  private ScannerListener createListener(List<String> filters) {
    return new ScannerListener(filters) {
      @Override
      public void onDeviceFound(Device device) {
        Log.d("movo", device.toString());
        deviceFoundCall.resolve(device.toJson());
      }

      @Override
      public void scanFinished(DeviceList list) {
        Log.d("movo", list.toString());
        JSObject json = new JSObject();
        json.put("devices", list.toJson());
        scanCall.resolve(json);
      }

      @Override
      public void onError(ErrorMessage message) {
        Log.d("movo", message.toString());
        scanCall.resolve(message.toJson());
        stop();
      }
    };
  }
}
