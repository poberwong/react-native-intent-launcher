# react-native-intent-launcher  
[![version](https://img.shields.io/npm/v/react-native-intent-launcher.svg)](https://www.npmjs.com/package/react-native-intent-launcher) [![downloads](https://img.shields.io/npm/dm/react-native-intent-launcher.svg?style=flat)](https://www.npmjs.com/package/react-native-intent-launcher)
[![downloads](https://img.shields.io/npm/dt/react-native-intent-launcher.svg?style=flat)](https://www.npmjs.com/package/react-native-intent-launcher)  

call native function `startActivity` in react-native

## Description
You can call native function `startActivity` in react-native to do something with `Intent` which can only be solved with android native code

## Installation

1. `npm install react-native-intent-launcher` 
2. `react-native link react-native-intent-launcher`

## Usage
```javascript
import IntentLauncher, { IntentConstant } from 'react-native-intent-launcher'
...
IntentLauncher.startActivity({
	action: 'android.settings.APPLICATION_DETAILS_SETTINGS',
	data: 'package:com.example'
})

// check if app is installed by package name
IntentLauncher.isAppInstalled('wtf.swell')
  .then((result) => {
    console.log('isAppInstalled yes');
  })
  .catch((error) => console.warn('isAppInstalled: no', error));

// open another app by package name
IntentLauncher.startAppByPackageName('wtf.swell')
  .then((result) => {
    console.log('startAppByPackageName started');
  })
  .catch((error) => console.warn('startAppByPackageName: could not open', error));
...
```

## Properties
* `action` String
* `data` String
* `category` String
* `flags` String
* `extra` Object
* `packageName` String
* `className` String
* `flags` Number

In the `IntentConstant`, we provide some constants for these properties, you can look up document provided by google to find out property we didn't support currently.

## License
*MIT*


