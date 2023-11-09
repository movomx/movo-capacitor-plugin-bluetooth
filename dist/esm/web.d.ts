import { WebPlugin } from '@capacitor/core';
import type { BluetoothPlugin } from './definitions';
export declare class BluetoothWeb extends WebPlugin implements BluetoothPlugin {
    echo(options: {
        value: string;
    }): Promise<{
        value: string;
    }>;
}
