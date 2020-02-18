# react-native-anroid-intent-launcher  
[![version](https://img.shields.io/npm/v/react-native-intent-launcher.svg)](https://www.npmjs.com/package/react-native-intent-launcher) [![downloads](https://img.shields.io/npm/dm/react-native-intent-launcher.svg?style=flat)](https://www.npmjs.com/package/react-native-intent-launcher)
[![downloads](https://img.shields.io/npm/dt/react-native-intent-launcher.svg?style=flat)](https://www.npmjs.com/package/react-native-intent-launcher)  

call native function `startActivity` in react-native

## Why Fork

Original Repository is [react-native-intent-launcher](https://github.com/poberwong/react-native-intent-launcher)

Fixes the following issues when building React Native 0.60 or later.

And

Added isPackageInstalled, openApp method

Use isPackageInstalled method when isAppInstalled method doesn't work.

Use openApp method when startAppByPackageName method doesn't work.


```
WARNING: Configuration 'compile' is obsolete and has been replaced with 'implementation' and 'api'.
It will be removed at the end of 2018. For more information see: http://d.android.com/r/tools/update-dependency-configurations.html
```

## Description
You can call native function `startActivity` in react-native to do something with `Intent` which can only be solved with android native code

## Installation

Using yarn (RN 0.60 and and above)

```console
yarn add react-native-android-intent-launcher
```

Using yarn (RN 0.59 and and below)

```console
yarn add react-native-android-intent-launcher
react-native link react-native-android-intent-launcher
```

## Usage

```javascript
import { Linking } from 'react-native'
import IntentLauncher, { IntentConstant } from 'react-native-intent-launcher'

...

IntentLauncher.startActivity({
	action: 'android.settings.APPLICATION_DETAILS_SETTINGS',
	data: 'package:com.example'
})

// check if app is installed by package name
IntentLauncher.isAppInstalled('com.your.app')
  .then((result) => {
    console.log('isAppInstalled yes');
  })
  .catch((error) => console.warn('isAppInstalled: no', error));

// open another app by package name
IntentLauncher.startAppByPackageName('com.your.app')
  .then((result) => {
    console.log('startAppByPackageName started');
  })
  .catch((error) => console.warn('startAppByPackageName: could not open', error));

const downloadURL = "https://www.your.com/download"

IntentLauncher.isPackageInstalled('com.your.app')
  .then(isInstalled => {
    if (isInstalled) 
      IntentLauncher.openApp(appInfo.package, options)
    else if (downloadURL) 
      Linking.openURL(downloadURL)
        .catch(err => console.error("An error occurred", err))
    else
      console.log("There is no path to download the app")
  })

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


