package com.movomx.bluetooth;

import com.getcapacitor.JSObject;
import com.getcapacitor.JSArray;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;
import org.json.JSONException;
import java.util.ArrayList;
import java.util.List;

@CapacitorPlugin(name = "Bluetooth")
public class BluetoothPlugin extends Plugin {

  private final Bluetooth bluetooth = new Bluetooth(getContext());

  @PluginMethod
  public void scan(PluginCall call) {
    bluetooth.scan(toList(call));
    bluetooth.setScanCall(call);
    call.setKeepAlive(true);
  }

  @PluginMethod
  public void onDeviceFound(PluginCall call) {
    bluetooth.setDeviceFoundCall(call);
    call.setKeepAlive(true);
  }

  @PluginMethod
  public void echo(PluginCall call) {
    String value = call.getString("value");
    JSObject result = new JSObject();
    result.put("value", bluetooth.echo(value));
    call.resolve(result);
  }

  private List<String> toList(PluginCall call) {
    JSArray list = call.getArray("filter");
    try {
      return list.toList();
    } catch (JSONException e) {
      return new ArrayList<>();
    }
  }
}
