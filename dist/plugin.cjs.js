'use strict';

Object.defineProperty(exports, '__esModule', { value: true });

var core = require('@capacitor/core');

const Bluetooth = core.registerPlugin('Bluetooth', {
    web: () => Promise.resolve().then(function () { return web; }).then(m => new m.BluetoothWeb()),
});

class BluetoothWeb extends core.WebPlugin {
    async echo(options) {
        console.log('ECHO', options);
        return options;
    }
}

var web = /*#__PURE__*/Object.freeze({
    __proto__: null,
    BluetoothWeb: BluetoothWeb
});

exports.Bluetooth = Bluetooth;
//# sourceMappingURL=plugin.cjs.js.map
