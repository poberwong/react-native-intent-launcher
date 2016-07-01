import { NativeModules } from 'react-native'
import React from 'react'
let nativeCaller = NativeModules.IntentLauncher
/*payload: {intent: {}}*/
export default {
	startActivity (payload) {
		nativeCaller.startActivity(payload.intent)
	}
}

