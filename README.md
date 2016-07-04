# react-native-intent-launcher
call native function `startActivity` in react-native

## Description
You can call native function `startActivity` in react-native to do something with `Intent` which can only be solved with android native code

## Installation
Run `rnpm install react-native-orientation`
> Note: rnpm will install and link the library automatically.  
> of course, you can run `npm install react-native-orientation` and then `rnpm link`

## Usage
```
import IntentLauncher, { IntentConstant } from 'react-native-intent-launcher'
...
IntentLauncher.startActivity({
	action: 'android.settings.APPLICATION_DETAILS_SETTINGS',
	data: 'package:com.example'
})
...
```
you can view the code in [Example](https://github.com/Bob1993/react-native-intent-launcher/blob/master/Example/index.android.js) of the Repository

## Properties
* `action` String
* `data` String
* `category` String
* `flags` String
* `extra` Object

In the `InstentConstant`, we provide some constants for these properties, you can look up document provided by google to find out property we didn't support currently.

## License
*MIT*


