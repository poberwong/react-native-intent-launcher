# react-native-intent-launcher
call native function `startActivity` in react-native

## Description
You can call native function `startActivity` in react-native to do something with `Intent` which can only be solved with android native code

## Installation

1. `npm install react-native-intent-launcher` 
2. `react-native link react-native-intent-launcher`

## Usage
```
import IntentLauncher, { IntentConstant } from 'react-native-intent-launcher'
...
IntentLauncher.startActivity({
	action: 'android.settings.APPLICATION_DETAILS_SETTINGS',
	data: 'package:com.example'
})

// open another app by package name
IntentLauncher.startOtherApp({
  packageName: 'org.kinecosystem.kinit',
  })
  .then((result) => {
    // success
    console.log('startOtherApp');
  })
  .catch((error) => console.warn('startOtherApp could not start', error));
...
```


you can view the code in [Example](https://github.com/Bob1993/react-native-intent-launcher/blob/master/Example/index.android.js) of the Repository

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


