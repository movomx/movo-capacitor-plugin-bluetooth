import { WebPlugin } from '@capacitor/core';

import type { BluetoothPlugin } from './definitions';

export class BluetoothWeb extends WebPlugin implements BluetoothPlugin {
  async scan(options: { filter: Array<string> }): Promise<{ devices: Array<{ bluetooth_name: string, mac_address: string, state: string }> }> {
    console.log('scan', options);
    return options;
  }

  async onDeviceFound(): Promise<{ bluetooth_name: string, mac_address: string, state: string }> {
    console.log('onDeviceFound');
    return null;
  }

  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
