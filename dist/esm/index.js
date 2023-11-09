import { registerPlugin } from '@capacitor/core';
const Bluetooth = registerPlugin('Bluetooth', {
    web: () => import('./web').then(m => new m.BluetoothWeb()),
});
export * from './definitions';
export { Bluetooth };
//# sourceMappingURL=index.js.map