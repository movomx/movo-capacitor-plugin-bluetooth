export interface BluetoothPlugin {
  scan(options: { filter: Array<string> }): Promise<{ devices: Array<{ bluetooth_name: string, mac_address: string, state: string }> }>;
  onDeviceFound(): Promise<{ bluetooth_name: string, mac_address: string, state: string }>;
  echo(options: { value: string }): Promise<{ value: string }>;
}
