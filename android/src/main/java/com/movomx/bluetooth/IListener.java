package com.movomx.bluetooth;

public interface IListener {
  void onDeviceFound(Device device);
  void scanFinished(DeviceList list);
  void onError(ErrorMessage message);
}
